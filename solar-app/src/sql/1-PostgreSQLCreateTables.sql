-- Indexes for primary keys have been explicitly created.

-- ---------- Table for validation queries from the connection pool. ----------

DROP TABLE IF EXISTS PingTable;
CREATE TABLE PingTable (foo CHAR(1));

-- ------------------------------ Company --------------------------------------
-- table company

DROP SEQUENCE IF EXISTS CompanySeq;
CREATE SEQUENCE CompanySeq;

DROP TABLE IF EXISTS Company CASCADE;
CREATE TABLE Company (companyId BIGINT NOT NULL, 
    companyName VARCHAR(50) NOT NULL, date TIMESTAMP NOT NULL, 
    CONSTRAINT CompanyNameU UNIQUE(companyName),
    CONSTRAINT CompanyIdPK PRIMARY KEY(companyId));

-- ------------------------------ Module ---------------------------------------
-- table module

DROP SEQUENCE IF EXISTS ModuleSeq;
CREATE SEQUENCE ModuleSeq;

DROP TABLE IF EXISTS Module CASCADE;
CREATE TABLE Module (moduleId BIGINT NOT NULL, 
    moduleName VARCHAR(50) NOT NULL, date TIMESTAMP NOT NULL, 
    CONSTRAINT ModuleNameU UNIQUE(moduleName),
    CONSTRAINT ModuleIdPK PRIMARY KEY(moduleId));

-- ------------------------------ Role -----------------------------------------
-- table role

DROP SEQUENCE IF EXISTS RoleSeq;
CREATE SEQUENCE RoleSeq;

DROP TABLE IF EXISTS Role CASCADE;
CREATE TABLE Role (roleId BIGINT NOT NULL, 
    roleName VARCHAR(30) NOT NULL, date TIMESTAMP NOT NULL, 
    loginName VARCHAR(30) NOT NULL, weight SMALLINT NOT NULL,
    CONSTRAINT RoleNameU UNIQUE(roleName),
    CONSTRAINT RoleIdPK PRIMARY KEY(roleId));

CREATE INDEX RoleIndexByLoginName ON Role (roleId, loginName);

-- ------------------------------ UserProfile ----------------------------------
-- "version" column is declared with "DEFAULT O" 

DROP SEQUENCE IF EXISTS UserProfileSeq;
CREATE SEQUENCE UserProfileSeq;

DROP TABLE IF EXISTS UserProfile CASCADE;
CREATE TABLE UserProfile (usrId BIGINT NOT NULL,
    loginName VARCHAR(30) NOT NULL, enPassword VARCHAR(13) NOT NULL, 
    firstName VARCHAR(30) NOT NULL, surname1 VARCHAR(40) NOT NULL, surname2 VARCHAR(40) DEFAULT NULL, 
    email VARCHAR(60) NOT NULL, date TIMESTAMP NOT NULL, 
    blocked BOOLEAN NOT NULL DEFAULT FALSE, erased BOOLEAN NOT NULL DEFAULT FALSE,  
    version BIGINT DEFAULT 0,
    roleId BIGINT NOT NULL, companyId BIGINT NOT NULL,
    CONSTRAINT loginNameU UNIQUE(loginName),
    CONSTRAINT RoleIdFK FOREIGN KEY(roleId)
        REFERENCES Role (roleId) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED, 
    CONSTRAINT CompanyIdFK FOREIGN KEY(companyId)
        REFERENCES Company (companyId) ON DELETE CASCADE,
    CONSTRAINT UserProfilePK PRIMARY KEY (usrId));

-- Added for cyclic dependency loop with both FK

ALTER TABLE ONLY Role
    ADD CONSTRAINT LoginNameFK FOREIGN KEY(loginName)
        REFERENCES UserProfile(loginName) ON DELETE CASCADE 
        DEFERRABLE INITIALLY DEFERRED;

-- ------------------------------ RoleModuleAccess -----------------------------
-- table rolemoduleaccess

DROP TABLE IF EXISTS RoleModuleAccess CASCADE;
CREATE TABLE RoleModuleAccess (roleId BIGINT NOT NULL, moduleId BIGINT NOT NULL, 
    accessFlag SMALLINT NOT NULL, 
    CONSTRAINT validAccessFlag CHECK ( accessFlag >= 0 AND accessFlag <=3 ),
    CONSTRAINT RoleIdFK FOREIGN KEY(roleId)
        REFERENCES Role(roleId) ON DELETE CASCADE,
    CONSTRAINT ModuleIdFK FOREIGN KEY(moduleId)
        REFERENCES Module(moduleId) ON DELETE CASCADE,
    CONSTRAINT RoleModuleAccessPK PRIMARY KEY(roleId, moduleId));

-- ------------------------------ Park -----------------------------
-- table Park

DROP TABLE IF EXISTS Park CASCADE;
CREATE TABLE Park (parkId BIGINT NOT NULL, parkName VARCHAR(30),
    startupDate TIMESTAMP NOT NULL, productionDate TIMESTAMP NOT NULL, loginName VARCHAR(30) NOT NULL,
    companyId BIGINT NOT NULL, mapPark geometry, 
    CONSTRAINT enforce_geotype_mapPark CHECK (geometrytype(mapPark) = 'MULTIPOLYGON'::text OR geom IS NULL),
  	CONSTRAINT enforce_srid_mapPark CHECK (st_srid(mapPark) = 4326)     
    CONSTRAINT loginNameU UNIQUE(loginName),
    CONSTRAINT CompanyIdFK FOREIGN KEY(companyId)
        REFERENCES Company (companyId) ON DELETE CASCADE,
    CONSTRAINT ParkIdPK PRIMARY KEY (parkId));

-- ------------------------------ Alarm -----------------------------
-- table Alarm

DROP TABLE IF EXISTS Alarm CASCADE;
CREATE TABLE Alarm (alarmId BIGINT NOT NULL, alarmTag VARCHAR(30),
    triggerDate TIMESTAMP NOT NULL, eventTskId BIGINT NOT NULL,
    CONSTRAINT EventTskIdFK FOREIGN KEY(eventTskId)
        REFERENCES EventTsk (eventTskId) ON DELETE CASCADE,
    CONSTRAINT AlarmIdPK PRIMARY KEY (alarmId));    

-- ------------------------------ EventTsk -----------------------------
-- table EventTsk

DROP TABLE IF EXISTS EventTsk CASCADE;    
CREATE TABLE EventTsk (eventTskId BIGINT NOT NULL, tagET VARCHAR(30), 
    definitionET VARCHAR(30), tvi TIMESTAMP NOT NULL, tvf TIMESTAMP NOT NULL,
    taskPrkId BIGINT NOT NULL, timetableId BIGINT NOT NULL,
    triggerAlarm BOOLEAN NOT NULL DEFAULT FALSE, triggerMessage BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT TaskPrkIdFK FOREIGN KEY(taskPrkId)
        REFERENCES TaskPrk (taskPrkId) ON DELETE CASCADE,
    CONSTRAINT TimetableIdFK FOREIGN KEY(timetableId)
        REFERENCES Timetable (timetableId) ON DELETE CASCADE,
    CONSTRAINT EventTskIdPK PRIMARY KEY (eventTskId));    
    
-- ------------------------------ MessageEvent -----------------------------
-- table MessageEvent

DROP TABLE IF EXISTS MessageEvent CASCADE;
CREATE TABLE MessageEvent (messageEventId BIGINT NOT NULL,
    tvi TIMESTAMP NOT NULL, messageText VARCHAR(30), 
    eventTskId BIGINT NOT NULL,
    CONSTRAINT EventTskIdFK FOREIGN KEY(eventTskId)
        REFERENCES EventTsk (eventTskId) ON DELETE CASCADE,
    CONSTRAINT MessageEventIdPK PRIMARY KEY (messageEventId));

-- ------------------------------ Report -----------------------------
-- table Report

DROP TABLE IF EXISTS Report CASCADE;
CREATE TABLE Report (reportId BIGINT NOT NULL,
    reportTitle VARCHAR(50), dateRequest TIMESTAMP NOT NULL, 
    dateServed TIMESTAMP NOT NULL, eventTskId BIGINT NOT NULL, urlReport VARCHAR(128), 
    CONSTRAINT LoginRequestFK FOREIGN KEY(loginRequest)
        REFERENCES UserProfile(loginName) ON DELETE CASCADE,
    CONSTRAINT ReportIdPK PRIMARY KEY (reportId)));

-- ------------------------------ State -----------------------------
-- table State

DROP TABLE IF EXISTS State CASCADE;
CREATE TABLE State (stateId BIGINT NOT NULL,
    tvi TIMESTAMP NOT NULL, tvf TIMESTAMP NOT NULL,
    parkId BIGINT NOT NULL, eventTskId BIGINT NOT NULL, 
    upkeepId BIGINT NOT NULL, stateTypeId BIGINT NOT NULL,
    CONSTRAINT ParkIdFK FOREIGN KEY(parkId)
        REFERENCES Park (parkId) ON DELETE CASCADE,
    CONSTRAINT EventTskIdFK FOREIGN KEY(eventTskId)
        REFERENCES EventTsk (eventTskId) ON DELETE CASCADE,
    CONSTRAINT UpkeepIdFK FOREIGN KEY(upkeepId)
        REFERENCES Upkeep (upkeepId) ON DELETE CASCADE,
    CONSTRAINT StateTypeIdFK FOREIGN KEY(stateTypeId)
        REFERENCES StateType (stateTypeId) ON DELETE CASCADE,
    CONSTRAINT StateIdPK PRIMARY KEY (stateId)));

-- ------------------------------ StateType -----------------------------
-- table StateType

DROP TABLE IF EXISTS StateType CASCADE;
CREATE TABLE StateType (stateTypeId BIGINT NOT NULL,
    nameST VARCHAR(30), definitionST VARCHAR(30),
    CONSTRAINT StateTypeIdPK PRIMARY KEY (stateTypeId));

-- ------------------------------ TaskPrk -----------------------------
-- table TaskPrk

DROP TABLE IF EXISTS TaskPrk CASCADE;
CREATE TABLE TaskPrk (taskPrkId BIGINT NOT NULL,
    taskName VARCHAR(30), creationDate TIMESTAMP NOT NULL, 
    parkId BIGINT NOT NULL, roleId BIGINT NOT NULL, 
    userProfileId BIGINT NOT NULL, 
    CONSTRAINT ParkIdFK FOREIGN KEY(parkId)
        REFERENCES Park (parkId) ON DELETE CASCADE,
    CONSTRAINT RoleIdFK FOREIGN KEY(roleId)
        REFERENCES Role (roleId) ON DELETE CASCADE,
    CONSTRAINT UserProfileIdFK FOREIGN KEY(userProfileId)
        REFERENCES UserProfile (userProfileId) ON DELETE CASCADE,
    CONSTRAINT TaskPrkIdPK PRIMARY KEY (taskPrkId)));

-- ------------------------------ Timetable -----------------------------
-- table Timetable

DROP TABLE IF EXISTS Timetable CASCADE;
CREATE TABLE Timetable (timetableId BIGINT NOT NULL,
    timetableTag VARCHAR(30), tvi TIMESTAMP NOT NULL, 
    userProfileId BIGINT NOT NULL, parkId BIGINT NOT NULL, 
    CONSTRAINT UserProfileIdFK FOREIGN KEY(userProfileId)
        REFERENCES UserProfile (userProfileId) ON DELETE CASCADE,
    CONSTRAINT ParkIdFK FOREIGN KEY(parkId)
        REFERENCES Park (parkId) ON DELETE CASCADE,
    CONSTRAINT TimetableIdPK PRIMARY KEY (timetableId)));

-- ------------------------------ Upkeep -----------------------------
-- table Upkeep

DROP TABLE IF EXISTS Upkeep CASCADE;
CREATE TABLE Upkeep(upkeepId BIGINT NOT NULL,
    CONSTRAINT UpkeepIdPK PRIMARY KEY (upkeepId)));


-- ------------------------------ Track -----------------------------
-- table Track

DROP TABLE IF EXISTS Track CASCADE;
CREATE TABLE Track (trackId BIGINT NOT NULL,
    tvf TIMESTAMP NOT NULL,
    userProfileId BIGINT NOT NULL, reportId BIGINT NOT NULL,
    CONSTRAINT ReportIdFK FOREIGN KEY(reportId)
        REFERENCES Report (reportId) ON DELETE CASCADE,
    CONSTRAINT UserProfileIdFK FOREIGN KEY(userProfileId)
        REFERENCES UserProfile (userProfileId) ON DELETE CASCADE,
    CONSTRAINT TrackIdPK PRIMARY KEY (trackId)));

-- ------------------------------ Monitor -----------------------------
-- table Monitor

DROP TABLE IF EXISTS Monitor CASCADE;
CREATE TABLE Upkeep(monitorId BIGINT NOT NULL,
    CONSTRAINT MonitorIdPK PRIMARY KEY (monitorId)));

-- ------------------------------ Synchronize -----------------------------
-- table Synchronize

DROP TABLE IF EXISTS Synchronize CASCADE;


-- ------------------------------ Element -----------------------------
-- table Element

DROP TABLE IF EXISTS Element CASCADE;
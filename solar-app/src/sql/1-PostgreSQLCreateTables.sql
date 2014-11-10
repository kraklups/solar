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
    userProfileId BIGINT NOT NULL, weight SMALLINT NOT NULL,
    CONSTRAINT RoleNameU UNIQUE(roleName),
    CONSTRAINT RoleIdPK PRIMARY KEY(roleId));

CREATE INDEX RoleIndexByUserProfileId ON Role (roleId, userProfileId);

-- ------------------------------ UserProfile ----------------------------------
-- "version" column is declared with "DEFAULT O" 

DROP SEQUENCE IF EXISTS UserProfileSeq;
CREATE SEQUENCE UserProfileSeq;

DROP TABLE IF EXISTS UserProfile CASCADE;
CREATE TABLE UserProfile (userProfileId BIGINT NOT NULL,
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
    CONSTRAINT UserProfilePK PRIMARY KEY (userProfileId));

-- Added for cyclic dependency loop with both FK

ALTER TABLE ONLY Role
    ADD CONSTRAINT UserProfileIdFK FOREIGN KEY(userProfileId)
        REFERENCES UserProfile (userProfileId) ON DELETE CASCADE 
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

DROP SEQUENCE IF EXISTS ParkSeq;
CREATE SEQUENCE ParkSeq;

DROP TABLE IF EXISTS Park CASCADE;
CREATE TABLE Park (parkId BIGINT NOT NULL, parkName VARCHAR(30),
    startupDate TIMESTAMP NOT NULL, productionDate TIMESTAMP NOT NULL, userProfileId BIGINT NOT NULL,
    companyId BIGINT NOT NULL, mapPark geometry, 
    CONSTRAINT enforce_geotype_mapPark CHECK (geometrytype(mapPark) = 'MULTIPOLYGON'::text OR mapPark IS NULL),
  	CONSTRAINT enforce_srid_mapPark CHECK (st_srid(mapPark) = 4326),     
    CONSTRAINT UserProfileIdFK FOREIGN KEY(userProfileId)
        REFERENCES UserProfile (userProfileId) ON DELETE CASCADE,
    CONSTRAINT CompanyIdFK FOREIGN KEY(companyId)
        REFERENCES Company (companyId) ON DELETE CASCADE,
    CONSTRAINT ParkIdPK PRIMARY KEY (parkId));

-- ------------------------------ EventTsk -----------------------------
-- table EventTsk

DROP SEQUENCE IF EXISTS EventTskSeq;
CREATE SEQUENCE EventTskSeq;

DROP TABLE IF EXISTS EventTsk CASCADE;    
CREATE TABLE EventTsk (eventTskId BIGINT NOT NULL, tagET VARCHAR(30), 
    definitionET VARCHAR(30), tvi TIMESTAMP NOT NULL, tvf TIMESTAMP NOT NULL,
    taskPrkId BIGINT NOT NULL, timetableId BIGINT NOT NULL,
    triggerAlarm BOOLEAN NOT NULL DEFAULT FALSE, triggerMessage BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT TimetableIdFK FOREIGN KEY(timetableId)
        REFERENCES Timetable (timetableId) ON DELETE CASCADE,
    CONSTRAINT EventTskIdPK PRIMARY KEY (eventTskId));    
    
-- ------------------------------ Alarm -----------------------------
-- table Alarm

DROP SEQUENCE IF EXISTS AlarmSeq;
CREATE SEQUENCE AlarmSeq;

DROP TABLE IF EXISTS Alarm CASCADE;
CREATE TABLE Alarm (alarmId BIGINT NOT NULL, alarmTag VARCHAR(30),
    triggerDate TIMESTAMP NOT NULL, eventTskId BIGINT NOT NULL,
    CONSTRAINT EventTskIdFK FOREIGN KEY(eventTskId)
        REFERENCES EventTsk (eventTskId) ON DELETE CASCADE,
    CONSTRAINT AlarmIdPK PRIMARY KEY (alarmId));        
    
-- ------------------------------ MessageEvent -----------------------------
-- table MessageEvent

DROP SEQUENCE IF EXISTS MessageEventSeq;
CREATE SEQUENCE MessageEventSeq;

DROP TABLE IF EXISTS MessageEvent CASCADE;
CREATE TABLE MessageEvent (messageEventId BIGINT NOT NULL,
    tvi TIMESTAMP NOT NULL, messageEventText VARCHAR(30), 
    eventTskId BIGINT NOT NULL,
    CONSTRAINT EventTskIdFK FOREIGN KEY(eventTskId)
        REFERENCES EventTsk (eventTskId) ON DELETE CASCADE,
    CONSTRAINT MessageEventIdPK PRIMARY KEY (messageEventId));

-- ------------------------------ Report -----------------------------
-- table Report

DROP SEQUENCE IF EXISTS ReportSeq;
CREATE SEQUENCE ReportSeq;

DROP TABLE IF EXISTS Report CASCADE;
CREATE TABLE Report (reportId BIGINT NOT NULL,
    reportTitle VARCHAR(50), dateRequest TIMESTAMP NOT NULL, 
    dateServed TIMESTAMP NOT NULL, userProfileId BIGINT NOT NULL, urlReport VARCHAR(128), 
CONSTRAINT UserProfileIdFK FOREIGN KEY(userProfileId)
        REFERENCES UserProfile (userProfileId) ON DELETE CASCADE,
    CONSTRAINT ReportIdPK PRIMARY KEY (reportId));

-- ------------------------------ State -----------------------------
-- table State

DROP SEQUENCE IF EXISTS StateSeq;
CREATE SEQUENCE StateSeq;

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
    CONSTRAINT StateIdPK PRIMARY KEY (stateId));

-- ------------------------------ StateType -----------------------------
-- table StateType

DROP SEQUENCE IF EXISTS StateTypeSeq;
CREATE SEQUENCE StateTypeSeq;

DROP TABLE IF EXISTS StateType CASCADE;
CREATE TABLE StateType (stateTypeId BIGINT NOT NULL,
    nameST VARCHAR(30), definitionST VARCHAR(30),
    CONSTRAINT StateTypeIdPK PRIMARY KEY (stateTypeId));

-- ------------------------------ TaskPrk -----------------------------
-- table TaskPrk

DROP SEQUENCE IF EXISTS TaskPrkSeq;
CREATE SEQUENCE TaskPrkSeq;

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
    CONSTRAINT TaskPrkIdPK PRIMARY KEY (taskPrkId));

-- Added for cyclic dependency loop with both FK

ALTER TABLE ONLY EventTsk
    ADD CONSTRAINT TaskPrkIdFK FOREIGN KEY(taskPrkId)
        REFERENCES TaskPrk (taskPrkId) ON DELETE CASCADE 
        DEFERRABLE INITIALLY DEFERRED;

-- ------------------------------ Timetable -----------------------------
-- table Timetable

DROP SEQUENCE IF EXISTS TimetableSeq;
CREATE SEQUENCE TimetableSeq;

DROP TABLE IF EXISTS Timetable CASCADE;
CREATE TABLE Timetable (timetableId BIGINT NOT NULL,
    timetableTag VARCHAR(30), tvi TIMESTAMP NOT NULL, 
    userProfileId BIGINT NOT NULL, parkId BIGINT NOT NULL, 
    CONSTRAINT UserProfileIdFK FOREIGN KEY(userProfileId)
        REFERENCES UserProfile (userProfileId) ON DELETE CASCADE,
    CONSTRAINT ParkIdFK FOREIGN KEY(parkId)
        REFERENCES Park (parkId) ON DELETE CASCADE,
    CONSTRAINT TimetableIdPK PRIMARY KEY (timetableId));

-- ------------------------------ Upkeep -----------------------------
-- table Upkeep

DROP TABLE IF EXISTS Upkeep CASCADE;

CREATE TABLE Upkeep(upkeepId BIGINT NOT NULL,
    CONSTRAINT UpkeepIdPK PRIMARY KEY (upkeepId));


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
    CONSTRAINT TrackIdPK PRIMARY KEY (trackId));

-- ------------------------------ Monitor -----------------------------
-- table Monitor

DROP TABLE IF EXISTS Monitor CASCADE;
CREATE TABLE Monitor(monitorId BIGINT NOT NULL,
    CONSTRAINT MonitorIdPK PRIMARY KEY (monitorId));

-- ------------------------------ Synchronize -----------------------------
-- table Synchronize 

DROP TABLE IF EXISTS Synchronize CASCADE;

CREATE TABLE Synchronize(synchronizeId BIGINT NOT NULL,
    CONSTRAINT SynchronizeIdPK PRIMARY KEY (synchronizeId));

-- ------------------------------ DataLogger -----------------------------
-- table DataLogger

DROP SEQUENCE IF EXISTS DataLoggerSeq;
CREATE SEQUENCE DataLoggerSeq;

DROP TABLE IF EXISTS DataLogger CASCADE;
CREATE TABLE DataLogger (dataLoggerId BIGINT NOT NULL,
    dataLoggerTag VARCHAR(30), dataLoggerType VARCHAR(30),
    dataLoggerFK BIGINT NOT NULL, 
    CONSTRAINT DataLoggerIdFK FOREIGN KEY(dataLoggerFK)
        REFERENCES DataLogger (dataLoggerId) ON DELETE CASCADE,    
    CONSTRAINT dataLoggerIdPK PRIMARY KEY (dataLoggerId));

-- ------------------------------ ElementPrk -----------------------------
-- table ElementPrk

DROP SEQUENCE IF EXISTS ElementPrkSeq;
CREATE SEQUENCE ElementPrkSeq;

DROP TABLE IF EXISTS ElementPrk CASCADE;
CREATE TABLE ElementPrk (elementPrkId BIGINT NOT NULL,
    elementPrkName VARCHAR(30), elementPrkTag VARCHAR(30), 
    tvi TIMESTAMP NOT NULL, lastAccess TIMESTAMP NOT NULL, 
    userProfileId BIGINT NOT NULL, dataLoggerId BIGINT NOT NULL, 
    parkId BIGINT NOT NULL, mapElement geometry, 
    CONSTRAINT enforce_geotype_mapElement CHECK (geometrytype(mapElement) = 'POINT'::text OR mapElement IS NULL),
  	CONSTRAINT enforce_srid_mapElement CHECK (st_srid(mapElement) = 4326),        
    CONSTRAINT UserProfileIdFK FOREIGN KEY(userProfileId)
        REFERENCES UserProfile (userProfileId) ON DELETE CASCADE,
    CONSTRAINT DataLoggerIdFK FOREIGN KEY(dataLoggerId)
        REFERENCES DataLogger (dataLoggerId) ON DELETE CASCADE,
    CONSTRAINT ParkIdFK FOREIGN KEY(parkId)
        REFERENCES Park (parkId) ON DELETE CASCADE,
    CONSTRAINT ElementPrkIdPK PRIMARY KEY (elementPrkId));

    
-- ------------------------------ Sensor -----------------------------
-- table Sensor

DROP SEQUENCE IF EXISTS SensorSeq;
CREATE SEQUENCE SensorSeq;

DROP TABLE IF EXISTS Sensor CASCADE;
CREATE TABLE Sensor (sensorId BIGINT NOT NULL,
    sensorTag VARCHAR(30), sensorType VARCHAR(30),
    elementPrkId BIGINT NOT NULL, 
    CONSTRAINT ElementIdFK FOREIGN KEY(elementPrkId)
        REFERENCES ElementPrk (elementPrkId) ON DELETE CASCADE,    
    CONSTRAINT sensorIdPK PRIMARY KEY (sensorId));


-- ------------------------------ ArrayBox -----------------------------
-- table ArrayBox

DROP TABLE IF EXISTS ArrayBox CASCADE;
CREATE TABLE ArrayBox(arrayBoxId BIGINT NOT NULL,
    CONSTRAINT ArrayBoxIdPK PRIMARY KEY (arrayBoxId));
    
    
-- ------------------------------ ArrayPanel -----------------------------
-- table ArrayPanel

DROP TABLE IF EXISTS ArrayPanel CASCADE;
CREATE TABLE ArrayPanel(arrayPanelId BIGINT NOT NULL,
    CONSTRAINT ArrayPanelIdPK PRIMARY KEY (arrayPanelId));


-- ------------------------------ StringLine -----------------------------
-- table StringLine

DROP TABLE IF EXISTS StringLine CASCADE;
CREATE TABLE StringLine(stringLineId BIGINT NOT NULL,
    arrayBoxId BIGINT NOT NULL, 
    CONSTRAINT ArrayBoxIdFK FOREIGN KEY(arrayBoxId)
        REFERENCES ArrayBox (arrayBoxId) ON DELETE CASCADE,
    CONSTRAINT StringLineIdPK PRIMARY KEY (stringLineId));
    
        
-- ------------------------------ Cell -----------------------------
-- table Cell

DROP TABLE IF EXISTS Cell CASCADE;
CREATE TABLE Cell(cellId BIGINT NOT NULL,
    arrayPanelId BIGINT NOT NULL, stringLineId BIGINT NOT NULL,
    CONSTRAINT ArrayPanelIdFK FOREIGN KEY(arrayPanelId)
        REFERENCES ArrayPanel (arrayPanelId) ON DELETE CASCADE,
    CONSTRAINT StringLineIdFK FOREIGN KEY(stringLineId)
        REFERENCES StringLine (stringLineId) ON DELETE CASCADE,
    CONSTRAINT CellIdPK PRIMARY KEY (cellId));    
    
    
-- ------------------------------ Counter -----------------------------
-- table Counter

DROP TABLE IF EXISTS Counter CASCADE;
CREATE TABLE Counter(counterId BIGINT NOT NULL,
    CONSTRAINT CounterIdPK PRIMARY KEY (counterId));
    
    
-- ------------------------------ ElectricalSubstation -----------------------------
-- table ElectricalSubstation

DROP TABLE IF EXISTS ElectricalSubstation CASCADE;
CREATE TABLE ElectricalSubstation(electricalSubstationId BIGINT NOT NULL,
    mediumVoltageId BIGINT NOT NULL, 
    CONSTRAINT MediumVoltageIdFK FOREIGN KEY(mediumVoltageId)
        REFERENCES MediumVoltage (mediumVoltageId) ON DELETE CASCADE,
    CONSTRAINT ElectricalSubstationIdPK PRIMARY KEY (electricalSubstationId));

    
-- ------------------------------ ExtractionPoint -----------------------------
-- table ExtractionPoint

DROP TABLE IF EXISTS ExtractionPoint CASCADE;
CREATE TABLE ExtractionPoint(extractionPointId BIGINT NOT NULL,
    CONSTRAINT ExtractionPointIdPK PRIMARY KEY (extractionPointId));
    
    
-- ------------------------------ Gps -----------------------------
-- table Gps

DROP TABLE IF EXISTS Gps CASCADE;
CREATE TABLE Gps(gpsId BIGINT NOT NULL,
    CONSTRAINT GpsIdPK PRIMARY KEY (gpsId));
    

-- ------------------------------ Inverter -----------------------------
-- table Inverter

DROP TABLE IF EXISTS Inverter CASCADE;
CREATE TABLE Inverter(inverterId BIGINT NOT NULL,
    counterId BIGINT NOT NULL, arrayBoxId BIGINT NOT NULL,
    electricalSubstationId BIGINT NOT NULL,
    CONSTRAINT CounterIdFK FOREIGN KEY(counterId)
        REFERENCES Counter (counterId) ON DELETE CASCADE,
    CONSTRAINT ArrayBoxIdFK FOREIGN KEY(arrayBoxId)
        REFERENCES ArrayBox (arrayBoxId) ON DELETE CASCADE,
    CONSTRAINT ElectricalSubstationIdFK FOREIGN KEY(electricalSubstationId)
        REFERENCES ElectricalSubstation (electricalSubstationId) ON DELETE CASCADE,
    CONSTRAINT InverterIdPK PRIMARY KEY (inverterId));
    

-- ------------------------------ MediumVoltage -----------------------------
-- table MediumVoltage

DROP TABLE IF EXISTS MediumVoltage CASCADE;
CREATE TABLE MediumVoltage(mediumVoltageId BIGINT NOT NULL,
    extractionPointId BIGINT NOT NULL, 
    CONSTRAINT ExtractionPointIdFK FOREIGN KEY(extractionPointId)
        REFERENCES ExtractionPoint (extractionPointId) ON DELETE CASCADE,
    CONSTRAINT MediumVoltageIdPK PRIMARY KEY (mediumVoltageId));
    

    
-- ------------------------------ WeatherStation -----------------------------
-- table WeatherStation

DROP TABLE IF EXISTS WeatherStation CASCADE;
CREATE TABLE WeatherStation(weatherStationId BIGINT NOT NULL,
    CONSTRAINT weatherStationIdPK PRIMARY KEY (weatherStationId));
    
    
-- ------------------------------ SolarTracker -----------------------------
-- table SolarTracker

DROP TABLE IF EXISTS SolarTracker CASCADE;
CREATE TABLE SolarTracker(solarTrackerId BIGINT NOT NULL,
    CONSTRAINT solarTrackerIdPK PRIMARY KEY (solarTrackerId));
    
-- ------------------------------ DataValue -----------------------------
-- table DataValue

DROP SEQUENCE IF EXISTS DataValueSeq;
CREATE SEQUENCE DataValueSeq;

DROP TABLE IF EXISTS DataValue CASCADE;
CREATE TABLE DataValue (dataValueId BIGINT NOT NULL,
    taskPrkId BIGINT NOT NULL, elementPrkId BIGINT NOT NULL, 
    dataLoggerId BIGINT NOT NULL, sensorId BIGINT NOT NULL,
    CONSTRAINT TaskPrkIdFK FOREIGN KEY(taskPrkId)
        REFERENCES TaskPrk (taskPrkId) ON DELETE CASCADE,    
    CONSTRAINT ElementIdFK FOREIGN KEY(elementPrkId)
        REFERENCES ElementPrk (elementPrkId) ON DELETE CASCADE,    
    CONSTRAINT DataLoggerIdFK FOREIGN KEY(dataLoggerId)
        REFERENCES DataLogger (dataLoggerId) ON DELETE CASCADE,    
    CONSTRAINT SensorIdFK FOREIGN KEY(sensorId)
        REFERENCES Sensor (sensorId) ON DELETE CASCADE,    
    CONSTRAINT dataValueIdPK PRIMARY KEY (dataValueId));

    
    
    
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
CREATE TABLE Park (parkId BIGINT NOT NULL,
    startupDate TIMESTAMP NOT NULL, productionDate TIMESTAMP NOT NULL, loginName VARCHAR(30) NOT NULL,
    mapPark geometry,
    CONSTRAINT enforce_geotype_mapPark CHECK (geometrytype(mapPark) = 'MULTIPOLYGON'::text OR geom IS NULL),
  	CONSTRAINT enforce_srid_mapPark CHECK (st_srid(mapPark) = 4326)     
    CONSTRAINT loginNameU UNIQUE(loginName),
    CONSTRAINT CompanyIdFK FOREIGN KEY(companyId)
        REFERENCES Company (companyId) ON DELETE CASCADE,
    CONSTRAINT parkIdPK PRIMARY KEY (parkId));
    
    
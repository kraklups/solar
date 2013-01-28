-- Indexes for primary keys have been explicitly created.

-- ---------- Table for validation queries from the connection pool. ----------

DROP TABLE PingTable;
CREATE TABLE PingTable (foo CHAR(1));

-- ------------------------------ Company --------------------------------------
-- table company

DROP SEQUENCE CompanySeq;
CREATE SEQUENCE CompanySeq;

DROP TABLE Company;
CREATE TABLE Company (companyId BIGINT NOT NULL, 
    companyName VARCHAR(50) NOT NULL, date TIMESTAMP NOT NULL, 
    CONSTRAINT CompanyNameU UNIQUE(companyName),
    CONSTRAINT CompanyIdPK PRIMARY KEY(companyId));

-- ------------------------------ Module ---------------------------------------
-- table module

DROP SEQUENCE ModuleSeq;
CREATE SEQUENCE ModuleSeq;

DROP TABLE Module;
CREATE TABLE Module (moduleId BIGINT NOT NULL, 
    moduleName VARCHAR(50) NOT NULL, date TIMESTAMP NOT NULL, 
    CONSTRAINT ModuleNameU UNIQUE(moduleName),
    CONSTRAINT ModuleIdPK PRIMARY KEY(moduleId));

-- ------------------------------ Role -----------------------------------------
-- table role

DROP SEQUENCE RoleSeq;
CREATE SEQUENCE RoleSeq;

DROP TABLE Role;
CREATE TABLE Role (roleId BIGINT NOT NULL, 
    roleName VARCHAR(30) NOT NULL, date TIMESTAMP NOT NULL, 
    loginName VARCHAR(30) NOT NULL, weight SMALLINT NOT NULL,
    CONSTRAINT RoleNameU UNIQUE(roleName),
    CONSTRAINT LoginNameFK FOREIGN KEY(loginName)
        REFERENCES UserProfile(loginName) ON DELETE CASCADE,
    CONSTRAINT RoleIdPK PRIMARY KEY(roleId));

CREATE INDEX RoleIndexByLoginName ON Role (roleId, loginName);

-- ------------------------------ UserProfile ----------------------------------
-- "version" column is declared with "DEFAULT O" 

DROP SEQUENCE UserProfileSeq;
CREATE SEQUENCE UserProfileSeq;

DROP TABLE UserProfile CASCADE;
CREATE TABLE UserProfile (usrId BIGINT NOT NULL,
    loginName VARCHAR(30) NOT NULL, enPassword VARCHAR(13) NOT NULL, 
    firstName VARCHAR(30) NOT NULL, surname1 VARCHAR(40) NOT NULL, surname2 VARCHAR(40) DEFAULT NULL, 
    email VARCHAR(60) NOT NULL, date TIMESTAMP NOT NULL, 
    bloqued BOOLEAN NOT NULL DEFAULT FALSE, erased BOOLEAN NOT NULL DEFAULT FALSE,  
    version BIGINT DEFAULT 0,
    roleId BIGINT NOT NULL, companyId BIGINT NOT NULL,
    CONSTRAINT loginNameU UNIQUE(loginName),
    CONSTRAINT RoleIdFK FOREIGN KEY(roleId)
        REFERENCES Role (roleId) ON DELETE CASCADE, 
    CONSTRAINT CompanyIdFK FOREIGN KEY(companyId)
        REFERENCES Company (companyId) ON DELETE CASCADE,
    CONSTRAINT UserProfilePK PRIMARY KEY (usrId));

-- ------------------------------ RoleModuleAccess -----------------------------
-- table rolemoduleaccess

DROP TABLE RoleModuleAccess;
CREATE TABLE RoleModuleAccess (roleId BIGINT NOT NULL, moduleId BIGINT NOT NULL, 
    accessFlag SMALLINT NOT NULL, 
    CONSTRAINT validAccessFlag CHECK ( accessFlag >= 0 AND accessFlag <=3 ),
    CONSTRAINT RoleIdFK FOREIGN KEY(roleId)
        REFERENCES Role(roleId) ON DELETE CASCADE,
    CONSTRAINT ModuleIdFK FOREIGN KEY(moduleId)
        REFERENCES Module(moduleId) ON DELETE CASCADE,
    CONSTRAINT RoleModuleAccessPK PRIMARY KEY(roleId, moduleId));





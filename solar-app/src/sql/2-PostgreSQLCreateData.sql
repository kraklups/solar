-- ----------------------------------------------------------------------------
-- Put here INSERT statements for inserting data required by the application
-- in the "solardb" database.
-------------------------------------------------------------------------------

INSERT into Company (companyId,companyName,date) VALUES (nextval('CompanySeq'),'[Kraklups.net]',CURRENT_TIMESTAMP);

INSERT into Company (companyId,companyName,date) VALUES (nextval('CompanySeq'),'default',CURRENT_TIMESTAMP);

INSERT into Module (moduleId,moduleName,date) VALUES (nextval('ModuleSeq'),'userprofile',CURRENT_TIMESTAMP);

BEGIN;

SET CONSTRAINTS ALL DEFERRED;

INSERT into Role (roleId,roleName,date,loginName,weight) VALUES (nextval('RoleSeq'),'admin',CURRENT_TIMESTAMP,'admin',10);

INSERT into Role (roleId,roleName,date,loginName,weight) VALUES (nextval('RoleSeq'),'default',CURRENT_TIMESTAMP,'admin',10);

INSERT into UserProfile (usrId,loginName,enpassword,firstName,surname1,surname2,email,date,blocked,erased,version,roleId,companyId) 
            VALUES (nextval('UserProfileSeq'),'admin','DLYsce016be6c','adminName','adminSurname1','adminSurname2','admin@kraklups.net',
            CURRENT_TIMESTAMP,DEFAULT,DEFAULT,DEFAULT,currval('ModuleSeq'),currval('ModuleSeq'));

COMMIT;

INSERT into RoleModuleAccess (roleId,moduleId,accessFlag) VALUES (currval('ModuleSeq'),currval('ModuleSeq'),2);

INSERT into RoleModuleAccess (roleId,moduleId,accessFlag) VALUES (currval('RoleSeq'),currval('ModuleSeq'),0);

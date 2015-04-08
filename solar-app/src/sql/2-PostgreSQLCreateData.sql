-- ----------------------------------------------------------------------------
-- Put here INSERT statements for inserting data required by the application
-- in the "solardb" database.
-------------------------------------------------------------------------------

INSERT into Company (companyId,companyName,date) VALUES (nextval('CompanySeq'),'[Kraklups.net]',CURRENT_TIMESTAMP);

INSERT into Company (companyId,companyName,date) VALUES (nextval('CompanySeq'),'default',CURRENT_TIMESTAMP);

INSERT into Module (moduleId,moduleName,date) VALUES (nextval('ModuleSeq'),'userprofile',CURRENT_TIMESTAMP);

BEGIN;

SET CONSTRAINTS ALL DEFERRED;

INSERT into Role (roleId,roleName,date,userProfileId,weight) VALUES (nextval('RoleSeq'),'admin',CURRENT_TIMESTAMP,1,10);

INSERT into UserProfile (userProfileId,loginName,encryptedPassword,firstName,surname1,surname2,email,date,enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,version,roleId,companyId) 
            VALUES (nextval('UserProfileSeq'),'admin','$2a$10$TySr.M7KjWQfQlzXtXxJkePIpuK0eN5pptThBegMVt6MZwDaYjeyi','adminName','adminSurname1','adminSurname2','admin@kraklups.net',
            CURRENT_TIMESTAMP,TRUE,TRUE,TRUE,TRUE,DEFAULT,currval('RoleSeq'),currval('CompanySeq'));

INSERT into RoleModuleAccess (roleId,moduleId,accessFlag) VALUES (currval('RoleSeq'),currval('ModuleSeq'),2);

COMMIT;

BEGIN;

SET CONSTRAINTS ALL DEFERRED;

INSERT into Role (roleId,roleName,date,userProfileId,weight) VALUES (nextval('RoleSeq'),'default',CURRENT_TIMESTAMP,2,10);

INSERT into UserProfile (userProfileId,loginName,encryptedPassword,firstName,surname1,surname2,email,date,enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,version,roleId,companyId) 
            VALUES (nextval('UserProfileSeq'),'kraklups','$2a$10$TySr.M7KjWQfQlzXtXxJkePIpuK0eN5pptThBegMVt6MZwDaYjeyi','adminName','adminSurname1','adminSurname2','admin@kraklups.net',
            CURRENT_TIMESTAMP,TRUE,TRUE,TRUE,TRUE,DEFAULT,currval('RoleSeq'),currval('CompanySeq'));

INSERT into RoleModuleAccess (roleId,moduleId,accessFlag) VALUES (currval('RoleSeq'),currval('ModuleSeq'),2);

COMMIT;
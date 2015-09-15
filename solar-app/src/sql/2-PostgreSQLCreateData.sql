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

INSERT INTO park (parkid, parkname, startupdate, productiondate, userprofileid, companyid, mappark) VALUES (nextval('ParkSeq'), 'lemerde', '2013-01-01 00:00:00', '2014-02-02 00:00:00', 1, 1, '0106000020E6100000010000000103000000010000000500000000000000002215C000000000207644400000000000B0FDBF00000000A08C44400000000000B0FDBF000000002095434000000000009E11C000000000A051434000000000002215C00000000020764440');

INSERT INTO park (parkid, parkname, startupdate, productiondate, userprofileid, companyid, mappark) VALUES (nextval('ParkSeq'), 'lemerdemerde', '2013-01-01 00:00:00', '2014-02-02 00:00:00', 1, 1, '0106000020E6100000010000000103000000010000000500000000000000002215C000000000207644400000000000B0FDBF00000000A08C44400000000000B0FDBF000000002095434000000000009E11C000000000A051434000000000002215C00000000020764440');

COMMIT;

INSERT into Timetable (timetableId,timetableTag,tvi,userProfileId,parkId) 
            VALUES (nextval('TimetableSeq'),'TimeTtableTag',CURRENT_TIMESTAMP,1,2);

INSERT into TaskPrk (taskPrkId,taskName,creationDate,parkId,roleId,userProfileId) 
            VALUES (nextval('TaskPrkSeq'),'TaskNameSynchronize',CURRENT_TIMESTAMP,2,2,1);
            
INSERT into Synchronize (synchronizeId) 
            VALUES (currval('TaskPrkSeq'));
            
INSERT into EventTsk (eventTskId,tagET,definitionET,tvi,tvf,taskPrkId,timetableId,triggerAlarm,triggerMessage) 
            VALUES (nextval('EventTskSeq'),'eventtskTag','eventskDef',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1,1,TRUE,TRUE);

COMMIT;            

INSERT into DataLogger (dataLoggerId,dataLoggerTag,dataLoggerType,dataLoggerFK) 
            VALUES (nextval('DataLoggerSeq'),'merdelemerde','merdelemerde',currval('DataLoggerSeq'));
            
INSERT into DataLogger (dataLoggerId,dataLoggerTag,dataLoggerType,dataLoggerFK) 
            VALUES (0,'No Parent','No Parent',0);    
            
INSERT into TaskPrk (taskPrkId,taskName,creationDate,parkId,roleId,userProfileId) 
            VALUES (nextval('TaskPrkSeq'),'TaskNameMerde','2013-01-01 00:00:00',1,1,1);     
            
INSERT into Monitor (monitorId) 
            VALUES (currval('TaskPrkSeq'));
            
INSERT into TaskPrk (taskPrkId,taskName,creationDate,parkId,roleId,userProfileId) 
            VALUES (nextval('TaskPrkSeq'),'UpkeepMerde','2012-01-01 00:00:00',1,1,1);     
            
INSERT into Upkeep (upkeepId) 
            VALUES (currval('TaskPrkSeq'));     
            
INSERT into TaskPrk (taskPrkId,taskName,creationDate,parkId,roleId,userProfileId) 
            VALUES (nextval('TaskPrkSeq'),'TrackMerde','2012-01-01 00:00:00',1,1,1);

INSERT into Report(reportId,reportTitle,dateRequest,dateServed,userProfileId,urlReport) 
			VALUES (nextval('ReportSeq'),'farleyofarleyo','2013-01-01 00:00:00','2013-01-01 00:00:00',1,'http://merde.org');

INSERT into Track (trackId, tvf,reportId) VALUES (currval('TaskPrkSeq'),'2013-01-01 00:00:00',1);
            
INSERT into ElementPrk (elementPrkId,elementPrkName,elementPrkTag,tvi,lastAccess,userProfileId,dataLoggerId,parkId,mapElement) 
            VALUES (nextval('ElementPrkSeq'),'ElementPrkNameMerde','ElementPrkTagMerde','2013-01-01 00:00:00','2013-02-01 00:00:00',1,1,1,ST_GeomFromText('POINT(-71.060316 48.432044)', 4326));

INSERT into Gps (gpsId) 
            VALUES (1);

INSERT into Sensor (sensorId,sensorTag,elementPrkId) 
            VALUES (nextval('SensorSeq'),'SensorTag',1);
            
INSERT into StateType (stateTypeId,nameST,definitionST) 
            VALUES (1,'Parada','Parada');  

INSERT into StateType (stateTypeId,nameST,definitionST) 
            VALUES (2,'Produccion','Produccion');

INSERT into StateType (stateTypeId,nameST,definitionST) 
            VALUES (3,'Mantenimiento','Mantenimiento');

INSERT into StateType (stateTypeId,nameST,definitionST) 
            VALUES (4,'Revision','Revision');
            
COMMIT;             
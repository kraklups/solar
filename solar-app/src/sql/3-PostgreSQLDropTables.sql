-- ---------- Table for validation queries from the connection pool. ----------

DROP TABLE IF EXISTS PingTable;

-- ------------------------------ Company --------------------------------------
-- table company

DROP SEQUENCE IF EXISTS CompanySeq;

DROP TABLE IF EXISTS Company CASCADE;

-- ------------------------------ Module ---------------------------------------
-- table module

DROP SEQUENCE IF EXISTS ModuleSeq;

DROP TABLE IF EXISTS Module CASCADE;

-- ------------------------------ Role -----------------------------------------
-- table role

DROP SEQUENCE IF EXISTS RoleSeq;

DROP TABLE IF EXISTS Role CASCADE;

-- ------------------------------ UserProfile ----------------------------------
-- "version" column is declared with "DEFAULT O" 

DROP SEQUENCE IF EXISTS UserProfileSeq;

DROP TABLE IF EXISTS UserProfile CASCADE;

-- ------------------------------ RoleModuleAccess -----------------------------
-- table rolemoduleaccess

DROP TABLE IF EXISTS RoleModuleAccess CASCADE;

-- ------------------------------ Park -----------------------------
-- table Park

DROP SEQUENCE IF EXISTS ParkSeq;

DROP TABLE IF EXISTS Park CASCADE;

-- ------------------------------ EventTsk -----------------------------
-- table EventTsk

DROP SEQUENCE IF EXISTS EventTskSeq;

DROP TABLE IF EXISTS EventTsk CASCADE;    
    
-- ------------------------------ Alarm -----------------------------
-- table Alarm

DROP SEQUENCE IF EXISTS AlarmSeq;

DROP TABLE IF EXISTS Alarm CASCADE;
    
-- ------------------------------ MessageEvent -----------------------------
-- table MessageEvent

DROP SEQUENCE IF EXISTS MessageEventSeq;

DROP TABLE IF EXISTS MessageEvent CASCADE;

-- ------------------------------ Report -----------------------------
-- table Report

DROP SEQUENCE IF EXISTS ReportSeq;

DROP TABLE IF EXISTS Report CASCADE;

-- ------------------------------ State -----------------------------
-- table State

DROP SEQUENCE IF EXISTS StateSeq;

DROP TABLE IF EXISTS State CASCADE;

-- ------------------------------ StateType -----------------------------
-- table StateType

DROP SEQUENCE IF EXISTS StateTypeSeq;

DROP TABLE IF EXISTS StateType CASCADE;

-- ------------------------------ TaskPrk -----------------------------
-- table TaskPrk

DROP SEQUENCE IF EXISTS TaskPrkSeq;

DROP TABLE IF EXISTS TaskPrk CASCADE;

-- ------------------------------ Timetable -----------------------------
-- table Timetable

DROP SEQUENCE IF EXISTS TimetableSeq;

DROP TABLE IF EXISTS Timetable CASCADE;

-- ------------------------------ Upkeep -----------------------------
-- table Upkeep

DROP TABLE IF EXISTS Upkeep CASCADE;

-- ------------------------------ Track -----------------------------
-- table Track

DROP TABLE IF EXISTS Track CASCADE;

-- ------------------------------ Monitor -----------------------------
-- table Monitor

DROP TABLE IF EXISTS Monitor CASCADE;

-- ------------------------------ Synchronize -----------------------------
-- table Synchronize 

DROP TABLE IF EXISTS Synchronize CASCADE;

-- ------------------------------ DataLogger -----------------------------
-- table DataLogger

DROP SEQUENCE IF EXISTS DataLoggerSeq;

DROP TABLE IF EXISTS DataLogger CASCADE;

-- ------------------------------ ElementPrk -----------------------------
-- table ElementPrk

DROP SEQUENCE IF EXISTS ElementPrkSeq;

DROP TABLE IF EXISTS ElementPrk CASCADE;
    
-- ------------------------------ Sensor -----------------------------
-- table Sensor

DROP SEQUENCE IF EXISTS SensorSeq;

DROP TABLE IF EXISTS Sensor CASCADE;

-- ------------------------------ ArrayBox -----------------------------
-- table ArrayBox

DROP TABLE IF EXISTS ArrayBox CASCADE;
    
-- ------------------------------ ArrayPanel -----------------------------
-- table ArrayPanel

DROP TABLE IF EXISTS ArrayPanel CASCADE;

-- ------------------------------ StringLine -----------------------------
-- table StringLine

DROP TABLE IF EXISTS StringLine CASCADE;
        
-- ------------------------------ Cell -----------------------------
-- table Cell

DROP TABLE IF EXISTS Cell CASCADE;
    
-- ------------------------------ Counter -----------------------------
-- table Counter

DROP TABLE IF EXISTS Counter CASCADE;
    
-- ------------------------------ ElectricalSubstation -----------------------------
-- table ElectricalSubstation

DROP TABLE IF EXISTS ElectricalSubstation CASCADE;
    
-- ------------------------------ ExtractionPoint -----------------------------
-- table ExtractionPoint

DROP TABLE IF EXISTS ExtractionPoint CASCADE;
    
-- ------------------------------ Gps -----------------------------
-- table Gps

DROP TABLE IF EXISTS Gps CASCADE;

-- ------------------------------ Inverter -----------------------------
-- table Inverter

DROP TABLE IF EXISTS Inverter CASCADE;

-- ------------------------------ MediumVoltage -----------------------------
-- table MediumVoltage

DROP TABLE IF EXISTS MediumVoltage CASCADE;
    
-- ------------------------------ WeatherStation -----------------------------
-- table WeatherStation

DROP TABLE IF EXISTS WeatherStation CASCADE;
    
-- ------------------------------ SolarTracker -----------------------------
-- table SolarTracker

DROP TABLE IF EXISTS SolarTracker CASCADE;
    
-- ------------------------------ DataValue -----------------------------
-- table DataValue

DROP SEQUENCE IF EXISTS DataValueSeq;

DROP TABLE IF EXISTS DataValue CASCADE;

-- ------------------------------ monitor_elementprk -----------------------------
-- table monitor_elementprk
DROP TABLE IF EXISTS monitor_elementprk CASCADE;
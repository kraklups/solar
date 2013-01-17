-- Indexes for primary keys have been explicitly created.

-- ---------- Table for validation queries from the connection pool. ----------

DROP TABLE PingTable;
CREATE TABLE PingTable (foo CHAR(1));

-- ------------------------------ UserProfile ----------------------------------

-- "version" column is declared with "DEFAULT O" since if PlainMiniPortal (which
-- does not use the "version" column) is used before EJBMiniPortal, rows in the
-- table must have a non-null value in the "version" column when EJBMiniPortal
-- be used.

DROP TABLE UserProfile;
CREATE TABLE UserProfile (loginName VARCHAR(30) NOT NULL,
    enPassword VARCHAR(13) NOT NULL, firstName VARCHAR(30) NOT NULL,
    surname VARCHAR(40) NOT NULL, email VARCHAR(60) NOT NULL,
    language VARCHAR(2) NOT NULL, country VARCHAR(2) NOT NULL,
    version BIGINT DEFAULT 0,
    CONSTRAINT UserProfile_PK PRIMARY KEY (loginName));


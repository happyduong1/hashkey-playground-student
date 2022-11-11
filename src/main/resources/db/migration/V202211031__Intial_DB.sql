CREATE TABLE IF NOT EXISTS STUDENT (
    ID BIGINT generated by default as identity,
    NAME varchar(100) NOT NULL,
    AGE INTEGER DEFAULT NULL,
    ROLE varchar(100) DEFAULT NULL,
    STATUS BOOLEAN DEFAULT FALSE,
    VERIFY VARCHAR (100) DEFAULT NULL,
    UNI_ID BIGINT DEFAULT NULL,
    PRIMARY KEY (ID, UNI_ID)
)

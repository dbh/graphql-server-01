create table IF NOT EXISTS COUNTRIES(
  ID int not null AUTO_INCREMENT,
  NAME varchar(100) not null,
  PRIMARY KEY ( ID )
);

CREATE TABLE IF NOT EXISTS  STATES(
    ID int not null AUTO_INCREMENT,
    NAME varchar(100) not null,
    COUNTRY_ID int not null,
    PRIMARY KEY ( ID )
);

ALTER TABLE STATES
    ADD FOREIGN KEY (COUNTRY_ID)
        REFERENCES COUNTRIES(ID);

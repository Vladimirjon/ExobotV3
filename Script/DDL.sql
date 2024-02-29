-- database: ../database/EXOBOT.sqlite
/*
CopyRight
autor:
fecha:
*/

DROP TABLE IF EXISTS ExaBot;
DROP TABLE IF EXISTS IABot; 

DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS PersonaTipo;

CREATE TABLE IABot (
     IdIABot        integer primary key autoincrement
    ,Nombre         TEXT NOT NULL UNIQUE
    ,Observacion    TEXT
    ,FechaCrea      datetime default current_timestamp
);
CREATE TABLE ExaBot (
     IdExaBot       integer primary key autoincrement
    ,IdIABot        integer NOT NULL
    ,Nombre         TEXT NOT NULL
    ,Serie          TEXT NOT NULL
    ,CONSTRAINT  fk_IABot
     FOREIGN KEY (IdIABot)
     REFERENCES  IABot(IdIABot)
);

CREATE TABLE PersonaTipo (
     IdPersonaTipo  INTEGER primary key autoincrement
    ,Descripcion    TEXT NOT NULL UNIQUE
    ,FechaCrea      datetime default current_timestamp
);
CREATE TABLE Persona (
     IdPersona      INTEGER primary key autoincrement
    ,IdPersonaTipo  INTEGER NOT NULL REFERENCES PersonaTipo(IdPersonaTipo)
    ,Cedula         TEXT NOT NULL UNIQUE
    ,Nombre         TEXT NOT NULL 
    ,FechaCrea      datetime default current_timestamp
);


SELECT * FROM PersonaTipo;
SELECT count(*) FROM PersonaTipo;

SELECT * FROM PersonaTipo WHERE IdPersonaTipo =2;
SELECT * FROM PersonaTipo WHERE IdPersonaTipo < 4;
SELECT Descripcion FROM PersonaTipo WHERE IdPersonaTipo < 4;
SELECT Descripcion FROM PersonaTipo WHERE Descripcion like "s%";
SELECT Descripcion FROM PersonaTipo WHERE Descripcion like "%o";
SELECT Descripcion FROM PersonaTipo WHERE Descripcion like "%o%";


--database: ../Database/Exobot.sqlite
DROP TABLE IF EXISTS Exobot;


CREATE TABLE Exobot(
    IdExobot INTEGER PRIMARY KEY AUTOINCREMENT,
    Modelo TEXT NOT NULL,
    ArmaIzquierda TEXT NOT NULL,
    ArmaDerecha TEXT NOT NULL,
    AprenderEspanol BOOLEAN,
    AprenderIngles BOOLEAN
);


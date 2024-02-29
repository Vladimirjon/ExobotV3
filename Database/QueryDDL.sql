-- database: Exobot.sqlite

CREATE TABLE Soldado(
    IdSoldado INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre TEXT NOT NULL
);

INSERT INTO Soldado(Nombre) VALUES ("Wladimir");
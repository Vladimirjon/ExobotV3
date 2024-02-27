-- database: ../Database/Soldado.sqlite
DROP TABLE IF EXISTS Soldado;
CREATE TABLE Soldado(
    IdSoldado INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre TEXT NOT NULL
);
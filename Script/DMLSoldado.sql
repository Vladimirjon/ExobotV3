-- database: ../Database/Soldado.sqlite
INSERT INTO Soldado(Nombre)
    VALUES('SOLDADO');




SELECT * FROM Soldado;

-- WITH RECURSIVE Incremento AS(
--     SELECT 1 AS i
--     UNION ALL
--     SELECT i + 1 FROM Incremento  WHERE i < 21
-- )

-- INSERT INTO Soldado(Nombre)
-- SELECT 
--     'WLADIMIR' || i,
-- FROM Incremento
-- WHERE (i-1) % 2 = 0;


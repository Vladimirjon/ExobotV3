-- database: ../database/EXOBOT.sqlite

insert INTO IABot ( Nombre   ,Observacion ) 
            VALUES("IA-RUSO" ,"" );

SELECT * FROM IABot;

INSERT INTO ExaBot(
 IdIABot   
,Nombre    
,Serie     
) VALUES(
 1
,"exabot1"
,"Sereie E1"
);

INSERT INTO ExaBot(
 IdIABot   
,Nombre    
,Serie     
) VALUES(
 1
,"exabot2"
,"Sereie E2"
);  

SELECT * FROM ExaBot;

SELECT  IdExaBot, IdIABot, Nombre, Serie FROM ExaBot;


INSERT INTO PersonaTipo 
        ( Descripcion )
VALUES  ( "Soldado" ),
        ( "Mecatronico" ),
        ( "Experto Ingles" ),
        ( "Experto Español" );
SELECT * FROM PersonaTipo;


INSERT INTO Persona  
( IdPersonaTipo, Cedula, Nombre) VALUES
( 5,  "11111", "pepe"),
( 5,  "22222", "juan"),
( 5,  "33333", "pedro"),
( 5,  "44444", "pablo"),
( 6,  "01010", "mecatro pedro"),
( 6,  "02020", "mecatro juan"),
( 7,  "03030", "experto juan"),
( 8,  "04040", "experto juan");
SELECT * FROM Persona;

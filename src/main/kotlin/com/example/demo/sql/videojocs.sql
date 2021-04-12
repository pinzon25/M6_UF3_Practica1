DROP DATABASE IF EXISTS videojocs;
CREATE DATABASE videojocs;
GRANT ALL PRIVILEGES ON videojocs.* TO administrador1 WITH GRANT OPTION;
USE videojocs;

CREATE TABLE Consola(
id_consola INTEGER AUTO_INCREMENT,
nom VARCHAR(70) NOT NULL,
logo VARCHAR(50),
PRIMARY KEY(id_consola)
);

CREATE TABLE Joc(
id_joc INTEGER AUTO_INCREMENT,
id_plataforma INTEGER NOT NULL,
nom VARCHAR(30) NOT NULL,
descripcio VARCHAR(100) NOT NULL,
portada VARCHAR(50),
PRIMARY KEY(id_joc),
FOREIGN KEY(id_plataforma) REFERENCES Consola(id_consola)
);

select * from Consola;

INSERT INTO Consola VALUES (null, "Playstation", "logo");

INSERT INTO Joc VALUES(null, 1,"Legacy of Kain: Soul reaver","Aventura d'accio on portarem a terme la venjança d'en Raziel.", "..\..\..\..\images\soul_reaver.jpg");


select * from Joc;
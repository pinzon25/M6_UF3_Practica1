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



INSERT INTO Consola VALUES (null, "Playstation", "playstation.png");
INSERT INTO Consola VALUES (null, "Super Nintendo", "snes.png");
INSERT INTO Consola VALUES (null, "Sega Dreamcast", "dreamcast.png");
INSERT INTO Consola VALUES (null, "Sega Megadrive", "megadrive.png");

INSERT INTO Joc VALUES(null, 1,"Legacy of Kain: Soul reaver","Aventura d'accio on portarem a terme la venjança d'en Raziel.", "soul_reaver.jpg");
INSERT INTO Joc VALUES(null, 1,"Metal Gear Solid","Aventura d'espionatge on ens posarem a la pell del millor espia.", "mgs.jpg");
INSERT INTO Joc VALUES(null, 1,"Crash Bandicoot","Joc de plataformes on haurem de superar nivells mentre controlem a un marsupial.", "crash_bandicoot.jpg");
INSERT INTO Joc VALUES(null, 2,"Super Mario World","Joc de plataformes de super nintendo del conegut Mario Bros.", "supermariosnes.jpg");
INSERT INTO Joc VALUES(null, 4,"Mortal Kombat 3","Tercera entrega del joc de lluita basat en el torneig entre el Mon exterior i el regne de la Terra.", "mortalkombat3.png");
INSERT INTO Joc VALUES(null, 3,"Shenmue","Aventura d'accio de mon obert ambientada al japo modern.", "shenmue.jpg");
INSERT INTO Joc VALUES(null, 3,"Shenmue 2","Cintinuacio de la primera aventura.", "shenmue2.jpg");




select * from Consola;
select * from Joc;
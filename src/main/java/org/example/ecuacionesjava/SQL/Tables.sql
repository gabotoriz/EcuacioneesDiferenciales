CREATE TABLE CUESTIONARY(
    IdCuestionary int primary key auto_increment,
    Usuario varchar(30) not null unique ,
    Pregunta varchar(100) not null,
    Respuesta varchar(100) not null,
    Puntuacion int not null
);




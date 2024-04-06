Use ecuaciones;
CREATE TABLE QUESTION
(
    idQuestion int primary key auto_increment,
    Question   varchar(80)  not null,
    Option1    varchar(100) not null,
    Option2    varchar(100) not null,
    Option3    varchar(100) not null,
    Answer     varchar(100) not null
);
CREATE TABLE USER
(
    idUser int primary key auto_increment,
    Nombre varchar(50) not null unique
);
CREATE TABLE ANSWER
(
    idAnswer   int primary key auto_increment,
    idQuestion int not null,
    idUser     int not null
);




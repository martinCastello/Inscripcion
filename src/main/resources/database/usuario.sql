use instricpcion;

CREATE TABLE usuario (
    legajo int(50) NOT NULL AUTO_INCREMENT,
    nombre varchar(50) DEFAULT NULL,
    apellido varchar(50) DEFAULT NULL,
    mail varchar(50) DEFAULT NULL,
    password varchar(50) DEFAULT NULL,
    perfil varchar(50) DEFAULT NULL,
    PRIMARY KEY (legajo)
    ) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3;
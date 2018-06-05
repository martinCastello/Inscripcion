use instricpcion;

CREATE TABLE usuario (
    id int(11) NOT NULL AUTO_INCREMENT,
    nombre varchar(50) DEFAULT NULL,
    apellido varchar(50) DEFAULT NULL,
    legajo varchar(50) DEFAULT NULL,
    perfil varchar(50) DEFAULT NULL,
    PRIMARY KEY (id)
    ) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3;
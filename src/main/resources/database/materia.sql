use instricpcion;

CREATE TABLE materia (
    id int (11) NOT NULL AUTO_INCREMENT,
    nombre varchar(50) DEFAULT NULL,
    cupo int(2) DEFAULT NULL,
    carga_horaria int(50) DEFAULT NULL,
    dias_y_horarios_de_cursadas varchar (150) DEFAULT NULL,
    nro_aula int(50) DEFAULT NULL,
    PRIMARY KEY (id)
    ) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3;
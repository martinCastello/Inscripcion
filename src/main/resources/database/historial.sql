use inscripcion;

CREATE TABLE `historial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alumno_id` int(11) NOT NULL,
  `cursada_id` int(11) NOT NULL,
  `promedio` int(11) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=0;





use instricpcion;

CREATE TABLE `cursadas` (
  `id` int(11) NOT NULL,
  `dias_y_horarios` varchar(150) NOT NULL,
  `materia_id` int(11) NOT NULL,
  `nro_aula` varchar(45) NOT NULL,
  `cupo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cursadas_materia1_idx` (`materia_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



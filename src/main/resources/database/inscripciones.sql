use instricpcion;

CREATE TABLE `inscripciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` int(11) NOT NULL,
  `cursadas_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_inscripciones_usuario1_idx` (`usuario_id`),
  KEY `fk_inscripciones_cursadas1_idx` (`cursadas_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


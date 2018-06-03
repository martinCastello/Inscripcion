USE inscripcion;

CREATE TABLE usuario (
  name VARCHAR(255) NOT NULL,
  surname VARCHAR(255) NOT NULL,
  username VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  validateCode VARCHAR(255),
  PRIMARY KEY (userName)
)
  ENGINE = InnoDB;
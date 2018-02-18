CREATE TABLE `Poliza` (
  `numero_poliza` int(11) NOT NULL AUTO_INCREMENT,
  `contratante` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`numero_poliza`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `Recibo` (
  `numero` int(11) NOT NULL AUTO_INCREMENT,
  `monto` varchar(255) DEFAULT NULL,
  `ordenante` varchar(255) DEFAULT NULL,
  `numero_poliza` int(11) DEFAULT NULL,
  PRIMARY KEY (`numero`),
  KEY `FKbyxjp2vfo11qvrhqh1itowevj` (`numero_poliza`),
  CONSTRAINT `FKbyxjp2vfo11qvrhqh1itowevj` FOREIGN KEY (`numero_poliza`) REFERENCES `Poliza` (`numero_poliza`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

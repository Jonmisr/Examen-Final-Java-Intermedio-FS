CREATE DATABASE IF NOT EXISTS supermercado;

DROP TABLE IF EXISTS Stock;
CREATE TABLE Stock (
					idStock BIGINT NOT NULL, 
					fechaDelComprobante DATETIME, 
					numeroDelComprobante NUMERIC, 
					totalEnPesosDeLaCompra DECIMAL, 
					PRIMARY KEY (idStock)
					);
					
CREATE TABLE
    hibernate_sequence
    (
        next_val BIGINT
);

INSERT INTO Stock (idStock, fechaDelComprobante, numeroDelComprobante, totalEnPesosDeLaCompra)
  VALUES (1,'2017-05-20 15:45:30', 1005, 4588);
INSERT INTO Stock (idStock, fechaDelComprobante, numeroDelComprobante, totalEnPesosDeLaCompra)
  VALUES (2,'2018-07-05 20:40:58', 2004, 7500);
INSERT INTO Stock (idStock, fechaDelComprobante, numeroDelComprobante, totalEnPesosDeLaCompra)
  VALUES (3,'2019-03-27 10:10:54', 4002, 1366);

INSERT INTO hibernate_sequence (next_val) VALUES (4);
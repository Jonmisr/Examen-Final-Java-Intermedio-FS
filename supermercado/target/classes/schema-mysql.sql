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
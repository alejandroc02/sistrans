-- Carga de datos para la tabla "adicionales"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_adicionales.csv'
APPEND INTO TABLE adicionales
FIELDS TERMINATED BY ','
(
    reunion_id,
    equipos_id,
    costo,
)
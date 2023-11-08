-- Carga de datos para la tabla "servicios_spa"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_servicios_spa.csv'
APPEND INTO TABLE servicios_spa
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    costo,
    duracion_min,
)
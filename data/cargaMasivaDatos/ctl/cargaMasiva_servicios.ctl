-- Carga de datos para la tabla "servicios"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_servicios.csv'
APPEND INTO TABLE servicios
FIELDS TERMINATED BY ','
(
    tipo,
    descripcion,
)
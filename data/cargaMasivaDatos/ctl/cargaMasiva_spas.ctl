-- Carga de datos para la tabla "spas"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_spas.csv'
APPEND INTO TABLE spas
FIELDS TERMINATED BY ','
(
    id,
    capacidad,
    servicios_tipo
)
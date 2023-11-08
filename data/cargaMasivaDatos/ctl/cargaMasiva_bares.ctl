-- Carga de datos para la tabla "bares"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_bares.csv'
APPEND INTO TABLE bares
FIELDS TERMINATED BY ','
(
    id,
    capacidad,
    estilo,
    servicios_tipo
)
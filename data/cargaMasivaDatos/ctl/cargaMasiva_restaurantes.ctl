-- Carga de datos para la tabla "restaurantes"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_restaurantes.csv'
APPEND INTO TABLE restaurantes
FIELDS TERMINATED BY ','
(
    id,
    capacidad,
    estilo,
    servicios_tipo
)
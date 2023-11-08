-- Carga de datos para la tabla "gimnasios"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_gimnasios.csv'
APPEND INTO TABLE gimnasios
FIELDS TERMINATED BY ','
(
    id,
    capacidad,
    hora_inicio,
    hora_fin,
    servicios_tipo
)
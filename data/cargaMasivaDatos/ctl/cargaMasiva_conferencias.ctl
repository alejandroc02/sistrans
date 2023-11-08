-- Carga de datos para la tabla "conferencias"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_conferencias.csv'
APPEND INTO TABLE conferencias
FIELDS TERMINATED BY ','
(
    id,
    capacidad,
    costo_hora,
    servicios_tipo
)
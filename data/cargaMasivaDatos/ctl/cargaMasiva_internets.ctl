-- Carga de datos para la tabla "internets"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_internets.csv'
APPEND INTO TABLE internets
FIELDS TERMINATED BY ','
(
    id,
    capacidad,
    costo_dia,
    servicios_tipo
)
-- Carga de datos para la tabla "piscinas"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_piscinas.csv'
APPEND INTO TABLE piscinas
FIELDS TERMINATED BY ','
(
    id,
    profundidad_m,
    capacidad,
    hora_inicio,
    hora_fin,
    servicios_tipo
)
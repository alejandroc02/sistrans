-- Carga de datos para la tabla "habitaciones"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_habitaciones.csv'
APPEND INTO TABLE habitaciones
FIELDS TERMINATED BY ','
(
    id,
    capacidad,
    precio,
    tipohab_id_tipo
)
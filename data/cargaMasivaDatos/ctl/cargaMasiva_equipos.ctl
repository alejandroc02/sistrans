-- Carga de datos para la tabla "equipos"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_equipos.csv'
APPEND INTO TABLE equipos
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    descripcion,
)
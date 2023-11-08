-- Carga de datos para la tabla "supermercados"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_supermercados.csv'
APPEND INTO TABLE supermercados
FIELDS TERMINATED BY ','
(
    id,
    servicios_tipo,
    nombre
)
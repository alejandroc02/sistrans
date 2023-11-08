-- Carga de datos para la tabla "productos_t"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_productos_t.csv'
APPEND INTO TABLE productos_t
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    precio
)
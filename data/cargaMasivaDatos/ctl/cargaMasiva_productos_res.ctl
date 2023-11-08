-- Carga de datos para la tabla "productos_res"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_productos_res.csv'
APPEND INTO TABLE productos_res
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    precio
)
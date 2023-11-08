-- Carga de datos para la tabla "productos_bar"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_productos_bar.csv'
APPEND INTO TABLE productos_bar
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    precio
)
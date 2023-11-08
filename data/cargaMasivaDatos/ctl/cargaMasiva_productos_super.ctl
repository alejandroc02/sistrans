-- Carga de datos para la tabla "productos_super"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_productos_super.csv'
APPEND INTO TABLE productos_super
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    precio,
)
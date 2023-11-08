-- Carga de datos para la tabla "tiendas"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_tiendas.csv'
APPEND INTO TABLE tiendas
FIELDS TERMINATED BY ','
(
    id,
    tipo_tienda,
    servicios_tipo
)
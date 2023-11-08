-- Carga de datos para la tabla "venden_super"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_venden_super.csv'
APPEND INTO TABLE venden_super
FIELDS TERMINATED BY ','
(
    supermercados_id,
    productossuper_id
)
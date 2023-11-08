-- Carga de datos para la tabla "venden_t"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_venden_t.csv'
APPEND INTO TABLE venden_t
FIELDS TERMINATED BY ','
(
    tiendas_id,
    productost_id
)
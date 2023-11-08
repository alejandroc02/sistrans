-- Carga de datos para la tabla "sirven_bares"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_sirven_bares.csv'
APPEND INTO TABLE sirven_bares
FIELDS TERMINATED BY ','
(
    bares_id,
    productosbar_id
)
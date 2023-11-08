-- Carga de datos para la tabla "sirven_res"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_sirven_res.csv'
APPEND INTO TABLE sirven_res
FIELDS TERMINATED BY ','
(
    restaurantes_id,
    productosres_id,
)
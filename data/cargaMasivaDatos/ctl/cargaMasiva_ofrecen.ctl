-- Carga de datos para la tabla "ofrecen"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_ofrecen.csv'
APPEND INTO TABLE ofrecen
FIELDS TERMINATED BY ','
(
    spas_id,
    serviciosspa_id,
)
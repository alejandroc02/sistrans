-- Carga de datos para la tabla "reservas_spa"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_reservas_spa.csv'
APPEND INTO TABLE reservas_spa
FIELDS TERMINATED BY ','
(
    reservaserv_id,
    spas_id
)
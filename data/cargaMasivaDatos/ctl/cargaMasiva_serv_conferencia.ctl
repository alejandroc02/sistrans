-- Carga de datos para la tabla "serv_conferencia"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_serv_conferencia.csv'
APPEND INTO TABLE serv_conferencia
FIELDS TERMINATED BY ','
(
    reservaserv_id,
    conferencia_id,
)
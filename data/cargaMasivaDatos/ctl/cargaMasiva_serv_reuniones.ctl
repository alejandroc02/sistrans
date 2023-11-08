-- Carga de datos para la tabla "serv_reuniones"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_serv_reuniones.csv'
APPEND INTO TABLE serv_reuniones
FIELDS TERMINATED BY ','
(
    reservaserv_id,
    reunion_id,
)
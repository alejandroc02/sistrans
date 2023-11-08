-- Carga de datos para la tabla "reservan"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_reservan.csv'
APPEND INTO TABLE reservan
FIELDS TERMINATED BY ','
(
    habitacion_id,
    reservas_id
)
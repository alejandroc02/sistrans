-- Carga de datos para la tabla "reservas_serv"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_reservas_serv.csv'
APPEND INTO TABLE reservas_serv
FIELDS TERMINATED BY ','
(
    id,
    duracion_hora,
    dia,
    hora,
    habitacion_id
)
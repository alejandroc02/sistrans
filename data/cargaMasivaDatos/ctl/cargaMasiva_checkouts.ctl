-- Carga de datos para la tabla "checkouts"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_checkouts.csv'
APPEND INTO TABLE checkouts
FIELDS TERMINATED BY ','
(
    reservas_id,
    habitacion_id,
    fecha_salida,
)
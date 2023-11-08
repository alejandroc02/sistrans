-- Carga de datos para la tabla "consumos"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_consumos.csv'
APPEND INTO TABLE consumos
FIELDS TERMINATED BY ','
(
    habitacion_id,
    servicios_tipo,
    descripcion,
    costo,
)
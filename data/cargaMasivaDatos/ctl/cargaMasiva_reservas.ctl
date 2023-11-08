-- Carga de datos para la tabla "reservas"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_reservas.csv'
APPEND INTO TABLE reservas
FIELDS TERMINATED BY ','
(
    id,
    fecha_inicio,
    fecha_salida,
    num_personas,
    planesconsumo_id,
    usuarios_num_documento,
)
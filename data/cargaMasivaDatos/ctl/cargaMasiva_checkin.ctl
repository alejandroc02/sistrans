-- Carga de datos para la tabla "checkin"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_checkin.csv'
APPEND INTO TABLE checkin
FIELDS TERMINATED BY ','
(
    reservas_id,
    clientes_num_documento,
    fecha_ingreso
)
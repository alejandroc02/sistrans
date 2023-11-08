-- Carga de datos para la tabla "servicios_prestamo"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_servicios_prestamo.csv'
APPEND INTO TABLE servicios_prestamo
FIELDS TERMINATED BY ','
(
    id,
    cantidad,
    devuelto,
    servicios_tipo
)
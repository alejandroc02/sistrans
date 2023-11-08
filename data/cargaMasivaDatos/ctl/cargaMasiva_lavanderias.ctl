-- Carga de datos para la tabla "lavanderias"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_lavanderias.csv'
APPEND INTO TABLE lavanderias
FIELDS TERMINATED BY ','
(
    id,
    tipo_prenda,
    cantidad_prendas,
    costo,
    servicios_tipo
)
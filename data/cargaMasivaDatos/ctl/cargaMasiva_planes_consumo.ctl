-- Carga de datos para la tabla "planes_consumo"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_planes_consumo.csv'
APPEND INTO TABLE planes_consumo
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    estadia_min,
    costo,
    desc_reserva,
    desc_bar,
    desc_rest,
    desc_servicio
)
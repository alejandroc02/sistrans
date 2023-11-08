-- Carga de datos para la tabla "reuniones"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_reuniones.csv'
APPEND INTO TABLE reuniones
FIELDS TERMINATED BY ','
(
    id,
    capacidad,
    costo_hora,
    servicios_tipo,
)
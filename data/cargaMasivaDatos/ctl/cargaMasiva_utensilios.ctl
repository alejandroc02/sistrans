-- Carga de datos para la tabla "utensilios"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_utensilios.csv'
APPEND INTO TABLE utensilios
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    costo,
)
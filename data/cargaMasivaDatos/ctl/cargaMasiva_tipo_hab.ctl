-- Carga de datos para la tabla "tipo_hab"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_tipo_hab.csv'
APPEND INTO TABLE tipo_hab
FIELDS TERMINATED BY ','
(
    tipo,
    id_tipo
)
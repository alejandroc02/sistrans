-- Carga de datos para la tabla "tipo_usuarios"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_tipo_usuarios.csv'
APPEND INTO TABLE tipo_usuarios
FIELDS TERMINATED BY ','
(
    tipo,
)
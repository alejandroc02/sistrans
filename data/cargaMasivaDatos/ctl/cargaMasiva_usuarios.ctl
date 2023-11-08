-- Carga de datos para la tabla "usuarios"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_usuarios.csv'
APPEND INTO TABLE usuarios
FIELDS TERMINATED BY ','
(
    tipo_documento,
    num_documento,
    nombre,
    correo,
    tiposusuario_tipo,
)
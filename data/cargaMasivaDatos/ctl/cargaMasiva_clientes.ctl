-- Carga de datos para la tabla "clientes"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_clientes.csv'
APPEND INTO TABLE clientes
FIELDS TERMINATED BY ','
(
    tipo_documento,
    num_documento,
    nombre,
    correo
)
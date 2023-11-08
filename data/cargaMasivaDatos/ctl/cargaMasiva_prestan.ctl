-- Carga de datos para la tabla "prestan"
LOAD DATA
INFILE 'data\cargaMasivaDatos\csv\data_prestan.csv'
APPEND INTO TABLE prestan
FIELDS TERMINATED BY ','
(
    serviciosprestamo_id,
    utensilios_id,
)
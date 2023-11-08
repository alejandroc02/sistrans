LOAD DATA
INFILE 'data.csv'            -- Nombre del archivo de datos
APPEND                      -- Agregar datos a la tabla
INTO TABLE mi_tabla         -- Nombre de la tabla
FIELDS TERMINATED BY ','   -- Delimitador de campos en el archivo (en este caso, coma)
TRAILING NULLCOLS           -- Ignorar columnas nulas al final de las filas
(
  id        INTEGER EXTERNAL, -- El tipo de datos de la columna "id"
  nombre    CHAR(255),       -- El tipo de datos de la columna "nombre"
  edad      INTEGER EXTERNAL  -- El tipo de datos de la columna "edad"
)

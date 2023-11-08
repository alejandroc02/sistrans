-- Carga de datos para la tabla "tipo_usuarios"
LOAD DATA
INFILE 'data_tipo_usuarios.csv'
APPEND INTO TABLE tipo_usuarios
FIELDS TERMINATED BY ','
(
    id,
    nombre
)

-- Carga de datos para la tabla "usuarios"
LOAD DATA
INFILE 'data_usuarios.csv'
APPEND INTO TABLE usuarios
FIELDS TERMINATED BY ','
(
    tipo_documento,
    num_documento,
    nombre,
    correo,
    tiposusuario_tipo
)

-- Carga de datos para la tabla "tipo_hab"
LOAD DATA
INFILE 'data_tipo_hab.csv'
APPEND INTO TABLE tipo_hab
FIELDS TERMINATED BY ','
(
    id_tipo,
    descripcion
)

-- Carga de datos para la tabla "habitaciones"
LOAD DATA
INFILE 'data_habitaciones.csv'
APPEND INTO TABLE habitaciones
FIELDS TERMINATED BY ','
(
    id,
    capacidad,
    precio,
    tipohab_id_tipo
)

-- Carga de datos para la tabla "planes_consumo"
LOAD DATA
INFILE 'data_planes_consumo.csv'
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

-- Carga de datos para la tabla "reservas"
LOAD DATA
INFILE 'data_reservas.csv'
APPEND INTO TABLE reservas
FIELDS TERMINATED BY ','
(
    id,
    fecha_inicio DATE 'YYYY-MM-DD',
    fecha_salida DATE 'YYYY-MM-DD',
    num_personas,
    planesconsumo_id,
    usuarios_num_documento
)

-- Carga de datos para la tabla "servicios"
LOAD DATA
INFILE 'data_servicios.csv'
APPEND INTO TABLE servicios
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    descripcion
)

-- Carga de datos para la tabla "bares"
LOAD DATA
INFILE 'data_bares.csv'
APPEND INTO TABLE bares
FIELDS TERMINATED BY ','
(
    id,
    capacidad,
    estilo,
    servicios_tipo
)

-- Carga de datos para la tabla "gimnasios"
LOAD DATA
INFILE 'data_gimnasios.csv'
APPEND INTO TABLE gimnasios
FIELDS TERMINATED BY ','
(
    id,
    capacidad,
    hora_inicio,
    hora_fin,
    servicios_tipo
)

-- Carga de datos para la tabla "internets"
LOAD DATA
INFILE 'data_internets.csv'
APPEND INTO TABLE internets
FIELDS TERMINATED BY ','
(
    id,
    capacidad,
    costo_dia,
    servicios_tipo
)

-- Carga de datos para la tabla "lavanderias"
LOAD DATA
INFILE 'data_lavanderias.csv'
APPEND INTO TABLE lavanderias
FIELDS TERMINATED BY ','
(
    id,
    tipo_prenda,
    cantidad_prendas,
    costo,
    servicios_tipo
)

-- Carga de datos para la tabla "piscinas"
LOAD DATA
INFILE 'data_piscinas.csv'
APPEND INTO TABLE piscinas
FIELDS TERMINATED BY ','
(
    id,
    profundidad_m,
    capacidad,
    hora_inicio,
    hora_fin,
    servicios_tipo
)

-- Carga de datos para la tabla "servicios_prestamo"
LOAD DATA
INFILE 'data_servicios_prestamo.csv'
APPEND INTO TABLE servicios_prestamo
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    descripcion
)

-- Carga de datos para la tabla "restaurantes"
LOAD DATA
INFILE 'data_restaurantes.csv'
APPEND INTO TABLE restaurantes
FIELDS TERMINATED BY ','
(
    id,
    capacidad,
    estilo,
    servicios_tipo
)

-- Carga de datos para la tabla "conferencias"
LOAD DATA
INFILE 'data_conferencias.csv'
APPEND INTO TABLE conferencias
FIELDS TERMINATED BY ','
(
    id,
    capacidad,
    costo_hora,
    servicios_tipo
)

-- Carga de datos para la tabla "reuniones"
LOAD DATA
INFILE 'data_reuniones.csv'
APPEND INTO TABLE reuniones
FIELDS TERMINATED BY ','
(
    id,
    capacidad,
    costo_hora,
    servicios_tipo
)

-- Carga de datos para la tabla "spas"
LOAD DATA
INFILE 'data_spas.csv'
APPEND INTO TABLE spas
FIELDS TERMINATED BY ','
(
    id,
    capacidad,
    estilo,
    servicios_tipo
)

-- Carga de datos para la tabla "reservas_serv"
LOAD DATA
INFILE 'data_reservas_serv.csv'
APPEND INTO TABLE reservas_serv
FIELDS TERMINATED BY ','
(
    id,
    duracion_hora,
    dia DATE 'YYYY-MM-DD',
    hora DATE 'HH24:MI:SS',
    habitacion_id
)

-- Carga de datos para la tabla "reservas_spa"
LOAD DATA
INFILE 'data_reservas_spa.csv'
APPEND INTO TABLE reservas_spa
FIELDS TERMINATED BY ','
(
    id,
    duracion_hora,
    dia DATE 'YYYY-MM-DD',
    hora DATE 'HH24:MI:SS',
    habitacion_id
)

-- Carga de datos para la tabla "servicios_spa"
LOAD DATA
INFILE 'data_servicios_spa.csv'
APPEND INTO TABLE servicios_spa
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    descripcion
)

-- Carga de datos para la tabla "ofrecen"
LOAD DATA
INFILE 'data_ofrecen.csv'
APPEND INTO TABLE ofrecen
FIELDS TERMINATED BY ','
(
    spas_id,
    serviciosspa_id
)

-- Carga de datos para la tabla "supermercados"
LOAD DATA
INFILE 'data_supermercados.csv'
APPEND INTO TABLE supermercados
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    direccion
)

-- Carga de datos para la tabla "tiendas"
LOAD DATA
INFILE 'data_tiendas.csv'
APPEND INTO TABLE tiendas
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    direccion
)

-- Carga de datos para la tabla "consumos"
LOAD DATA
INFILE 'data_consumos.csv'
APPEND INTO TABLE consumos
FIELDS TERMINATED BY ','
(
    habitacion_id,
    servicios_tipo,
    descripcion CHAR(510),
    costo
)

-- Carga de datos para la tabla "clientes"
LOAD DATA
INFILE 'data_clientes.csv'
APPEND INTO TABLE clientes
FIELDS TERMINATED BY ','
(
    tipo_documento,
    num_documento,
    nombre,
    correo
)

-- Carga de datos para la tabla "checkin"
LOAD DATA
INFILE 'data_checkin.csv'
APPEND INTO TABLE checkin
FIELDS TERMINATED BY ','
(
    reservas_id,
    clientes_num_documento,
    fecha_ingreso
)

-- Carga de datos para la tabla "reservan"
LOAD DATA
INFILE 'data_reservan.csv'
APPEND INTO TABLE reservan
FIELDS TERMINATED BY ','
(
    habitacion_id,
    reservas_id
)

-- Carga de datos para la tabla "serv_conferencia"
LOAD DATA
INFILE 'data_serv_conferencia.csv'
APPEND INTO TABLE serv_conferencia
FIELDS TERMINATED BY ','
(
    conferencia_id,
    servicios_conferencia_id
)

-- Carga de datos para la tabla "serv_reuniones"
LOAD DATA
INFILE 'data_serv_reuniones.csv'
APPEND INTO TABLE serv_reuniones
FIELDS TERMINATED BY ','
(
    reunion_id,
    servicios_reuniones_id
)

-- Carga de datos para la tabla "equipos"
LOAD DATA
INFILE 'data_equipos.csv'
APPEND INTO TABLE equipos
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    descripcion
)

-- Carga de datos para la tabla "adicionales"
LOAD DATA
INFILE 'data_adicionales.csv'
APPEND INTO TABLE adicionales
FIELDS TERMINATED BY ','
(
    reunion_id,
    equipos_id,
    costo
)

-- Carga de datos para la tabla "checkouts"
LOAD DATA
INFILE 'data_checkouts.csv'
APPEND INTO TABLE checkouts
FIELDS TERMINATED BY ','
(
    reservas_id,
    habitacion_id,
    fecha_salida
)

-- Carga de datos para la tabla "utensilios"
LOAD DATA
INFILE 'data_utensilios.csv'
APPEND INTO TABLE utensilios
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    descripcion
)

-- Carga de datos para la tabla "productos_bar"
LOAD DATA
INFILE 'data_productos_bar.csv'
APPEND INTO TABLE productos_bar
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    precio
)

-- Carga de datos para la tabla "productos_res"
LOAD DATA
INFILE 'data_productos_res.csv'
APPEND INTO TABLE productos_res
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    precio
)

-- Carga de datos para la tabla "productos_t"
LOAD DATA
INFILE 'data_productos_t.csv'
APPEND INTO TABLE productos_t
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    precio
)

-- Carga de datos para la tabla "productos_super"
LOAD DATA
INFILE 'data_productos_super.csv'
APPEND INTO TABLE productos_super
FIELDS TERMINATED BY ','
(
    id,
    nombre,
    precio
)

-- Carga de datos para la tabla "venden_super"
LOAD DATA
INFILE 'data_venden_super.csv'
APPEND INTO TABLE venden_super
FIELDS TERMINATED BY ','
(
    supermercados_id,
    productosuper_id
)

-- Carga de datos para la tabla "venden_t"
LOAD DATA
INFILE 'data_venden_t.csv'
APPEND INTO TABLE venden_t
FIELDS TERMINATED BY ','
(
    tiendas_id,
    productost_id
)

-- Carga de datos para la tabla "prestan"
LOAD DATA
INFILE 'data_prestan.csv'
APPEND INTO TABLE prestan
FIELDS TERMINATED BY ','
(
    serviciosprestamo_id,
    utensilios_id
)

-- Carga de datos para la tabla "sirven_bares"
LOAD DATA
INFILE 'data_sirven_bares.csv'
APPEND INTO TABLE sirven_bares
FIELDS TERMINATED BY ','
(
    bares_id,
    productos_bar_id
)

-- Carga de datos para la tabla "sirven_res"
LOAD DATA
INFILE 'data_sirven_res.csv'
APPEND INTO TABLE sirven_res
FIELDS TERMINATED BY ','
(
    restaurantes_id,
    productos_res_id
)

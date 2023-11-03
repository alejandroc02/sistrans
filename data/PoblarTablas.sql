-- Poblar tabla tipo_usuarios
INSERT INTO tipo_usuarios (tipo) VALUES ('Cliente');
INSERT INTO tipo_usuarios (tipo) VALUES ('Administrador');

-- Poblar tabla usuarios
INSERT INTO usuarios (tipo_documento, num_documento, nombre, correo, tiposusuario_tipo) VALUES ('CC', 1001, 'Juan Perez', 'juan@example.com', 'Cliente');
INSERT INTO usuarios (tipo_documento, num_documento, nombre, correo, tiposusuario_tipo) VALUES ('CE', 1002, 'Maria Gomez', 'maria@example.com', 'Cliente');

-- Poblar tabla tipo_hab
INSERT INTO tipo_hab (tipo, id_tipo) VALUES ('Habitacion Estandar', 1);
INSERT INTO tipo_hab (tipo, id_tipo) VALUES ('Suite de Lujo', 2);

-- Poblar tabla habitaciones
INSERT INTO habitaciones (id, capacidad, precio, tipohab_id_tipo) VALUES (101, 1, 100, 1);
INSERT INTO habitaciones (id, capacidad, precio, tipohab_id_tipo) VALUES (102, 2, 150, 2);
INSERT INTO habitaciones (id, capacidad, precio, tipohab_id_tipo) VALUES (103, 1, 100, 1);
INSERT INTO habitaciones (id, capacidad, precio, tipohab_id_tipo) VALUES (104, 2, 150, 2);

-- Poblar tabla planes_consumo
INSERT INTO planes_consumo (id, nombre, estadia_min, costo, desc_reserva, desc_bar, desc_rest, desc_servicio) VALUES (1, 'Plan Basico', 50, 100, 0, 0, 0, 0);
INSERT INTO planes_consumo (id, nombre, estadia_min, costo, desc_reserva, desc_bar, desc_rest, desc_servicio) VALUES (2, 'Plan Premium', 200, 200, 0.1, 0.1, 0.1, 0.1);
INSERT INTO planes_consumo (id, nombre, estadia_min, costo, desc_reserva, desc_bar, desc_rest, desc_servicio) VALUES (3, 'Plan Estandar', 100, 200, 0.1, 0.05, 0.1, 0.1);
INSERT INTO planes_consumo (id, nombre, estadia_min, costo, desc_reserva, desc_bar, desc_rest, desc_servicio) VALUES (4, 'Plan Premium', 200, 300, 0.15, 0.1, 0.2, 0.15);

-- Poblar tabla reservas
INSERT INTO reservas (id, fecha_inicio, fecha_salida, num_personas, planesconsumo_id, usuarios_num_documento) VALUES (1, TO_DATE('2023-11-01', 'YYYY-MM-DD'), TO_DATE('2023-11-05', 'YYYY-MM-DD'), 2, 1, 1001);
INSERT INTO reservas (id, fecha_inicio, fecha_salida, num_personas, planesconsumo_id, usuarios_num_documento) VALUES (2, TO_DATE('2023-11-02', 'YYYY-MM-DD'), TO_DATE('2023-11-06', 'YYYY-MM-DD'), 4, 2, 1002);

-- Poblar tabla servicios
INSERT INTO servicios (tipo, descripcion) VALUES ('bar', 'Bar con bebidas y cocteles');
INSERT INTO servicios (tipo, descripcion) VALUES ('gimnasio', 'Gimnasio con equipo moderno');
INSERT INTO servicios (tipo, descripcion) VALUES ('internet', 'internet inalambrico');
INSERT INTO servicios (tipo, descripcion) VALUES ('lavadoSecadoEmbolado', 'lavadoSecadoEmbolado');
INSERT INTO servicios (tipo, descripcion) VALUES ('piscina', 'piscina adultos');
INSERT INTO servicios (tipo, descripcion) VALUES ('prestamo', 'prestamo utensilios');
INSERT INTO servicios (tipo, descripcion) VALUES ('restaurante', 'restaurante');
INSERT INTO servicios (tipo, descripcion) VALUES ('salon', 'salon conferencia');
INSERT INTO servicios (tipo, descripcion) VALUES ('spa', 'spa');
INSERT INTO servicios (tipo, descripcion) VALUES ('supermercado', 'supermercado');
INSERT INTO servicios (tipo, descripcion) VALUES ('tienda', 'tienda');

-- Poblar tabla bares
INSERT INTO bares (id, capacidad, estilo, servicios_tipo) VALUES (1, 20, 'Jazz', 'bar');
INSERT INTO bares (id, capacidad, estilo, servicios_tipo) VALUES (2, 15, 'Salsa', 'bar');

-- Poblar tabla gimnasios
INSERT INTO gimnasios (id, capacidad, hora_inicio, hora_fin, servicios_tipo) VALUES (1, 20, TO_DATE('2023-11-01 08:00', 'YYYY-MM-DD HH24:MI'), TO_DATE('2023-11-01 20:00', 'YYYY-MM-DD HH24:MI'), 'gimnasio');
INSERT INTO gimnasios (id, capacidad, hora_inicio, hora_fin, servicios_tipo) VALUES (2, 15, TO_DATE('2023-11-02 07:00', 'YYYY-MM-DD HH24:MI'), TO_DATE('2023-11-02 19:00', 'YYYY-MM-DD HH24:MI'), 'gimnasio');

-- Poblar tabla internets
INSERT INTO internets (id, capacidad, costo_dia, servicios_tipo) VALUES (1, 50, 5, 'internet');
INSERT INTO internets (id, capacidad, costo_dia, servicios_tipo) VALUES (2, 30, 7, 'internet');

-- Poblar tabla lavanderias
INSERT INTO lavanderias (id, tipo_prenda, cantidad_prendas, costo, servicios_tipo) VALUES (1, 'Ropa', 5, 20, 'lavadoSecadoEmbolado');
INSERT INTO lavanderias (id, tipo_prenda, cantidad_prendas, costo, servicios_tipo) VALUES (2, 'Sabanas', 10, 30, 'lavadoSecadoEmbolado');

-- Poblar tabla piscinas
INSERT INTO piscinas (id, profundidad_m, capacidad, hora_inicio, hora_fin, servicios_tipo) VALUES (1, 5, 50, TO_DATE('2023-11-01 09:00', 'YYYY-MM-DD HH24:MI'), TO_DATE('2023-11-01 18:00', 'YYYY-MM-DD HH24:MI'), 'piscina');
INSERT INTO piscinas (id, profundidad_m, capacidad, hora_inicio, hora_fin, servicios_tipo) VALUES (2, 4, 40, TO_DATE('2023-11-02 10:00', 'YYYY-MM-DD HH24:MI'), TO_DATE('2023-11-02 17:00', 'YYYY-MM-DD HH24:MI'), 'piscina');

-- Poblar tabla servicios_prestramo
INSERT INTO servicios_prestamo (id, cantidad, devuelto, servicios_tipo) VALUES (1, 20, 0, 'prestamo');
INSERT INTO servicios_prestamo (id, cantidad, devuelto, servicios_tipo) VALUES (2, 30, 5, 'prestamo');

-- Poblar tabla restaurantes
INSERT INTO restaurantes (id, capacidad, estilo, servicios_tipo) VALUES (1, 50, 'Restaurante Buffet', 'restaurante');
INSERT INTO restaurantes (id, capacidad, estilo, servicios_tipo) VALUES (2, 30, 'Restaurante a la Carta', 'restaurante');

-- Poblar tabla conferencias
INSERT INTO conferencias (id, capacidad, costo_hora, servicios_tipo) VALUES (1, 50, 75, 'salon');
INSERT INTO conferencias (id, capacidad, costo_hora, servicios_tipo) VALUES (2, 30, 60, 'salon');

-- Poblar tabla reuniones
INSERT INTO reuniones (id, capacidad, costo_hora, servicios_tipo) VALUES (1, 7, 50, 'salon');
INSERT INTO reuniones (id, capacidad, costo_hora, servicios_tipo) VALUES (2, 10, 30, 'salon');

-- Poblar tabla spas
INSERT INTO spas (id, capacidad, servicios_tipo) VALUES (1, 15, 'spa');
INSERT INTO spas (id, capacidad, servicios_tipo) VALUES (2, 20, 'spa');

-- Poblar tabla reservas_serv
INSERT INTO reservas_serv (id, duracion_hora, dia, hora, habitacion_id) VALUES (1, 2, TO_DATE('2023-11-02', 'YYYY-MM-DD'), TO_DATE('10:00', 'HH24:MI'), 101);
INSERT INTO reservas_serv (id, duracion_hora, dia, hora, habitacion_id) VALUES (2, 3, TO_DATE('2023-11-06', 'YYYY-MM-DD'), TO_DATE('14:00', 'HH24:MI'), 102);
INSERT INTO reservas_serv (id, duracion_hora, dia, hora, habitacion_id) VALUES (3, 2, TO_DATE('2023-11-02', 'YYYY-MM-DD'), TO_DATE('14:00', 'HH24:MI'), 103);
INSERT INTO reservas_serv (id, duracion_hora, dia, hora, habitacion_id) VALUES (4, 1, TO_DATE('2023-11-03', 'YYYY-MM-DD'), TO_DATE('14:00', 'HH24:MI'), 104);

-- Poblar tabla reservas_spa
INSERT INTO reservas_spa (reservaserv_id, spas_id) VALUES (1, 1);
INSERT INTO reservas_spa (reservaserv_id, spas_id) VALUES (2, 2);

-- Poblar tabla servicios_spa
INSERT INTO servicios_spa (id, nombre, costo, duracion_min) VALUES (1, 'Masaje relajante', 50, 60);
INSERT INTO servicios_spa (id, nombre, costo, duracion_min) VALUES (2, 'Tratamiento facial', 70, 90);

-- Poblar tabla ofrecen
INSERT INTO ofrecen (spas_id, serviciosspa_id) VALUES (1, 1);
INSERT INTO ofrecen (spas_id, serviciosspa_id) VALUES (1, 2);
INSERT INTO ofrecen (spas_id, serviciosspa_id) VALUES (2, 1);
INSERT INTO ofrecen (spas_id, serviciosspa_id) VALUES (2, 2);

-- Poblar tabla supermercados
INSERT INTO supermercados (id, servicios_tipo, nombre) VALUES (1, 'supermercado', 'Mini Mercado');
INSERT INTO supermercados (id, servicios_tipo, nombre) VALUES (2, 'supermercado', 'Super Mart');

-- Poblar tabla tiendas
INSERT INTO tiendas (id, tipo_tienda, servicios_tipo) VALUES (1, 'Ropa', 'tienda');
INSERT INTO tiendas (id, tipo_tienda, servicios_tipo) VALUES (2, 'Souvenirs', 'tienda');

-- Poblar tabla consumos
INSERT INTO consumos (habitacion_id, servicios_tipo, descripcion, costo) VALUES (101, 'bar', 'Cerveza', 5);
INSERT INTO consumos (habitacion_id, servicios_tipo, descripcion, costo) VALUES (102, 'restaurante', 'Cena', 40);
INSERT INTO consumos (habitacion_id, servicios_tipo, descripcion, costo) VALUES (103, 'bar', 'Coctel', 10);

-- Poblar tabla clientes
INSERT INTO clientes (tipo_documento, num_documento, nombre, correo) VALUES ('cc', 1001, 'Juan Perez', 'juan.perez@example.com');
INSERT INTO clientes (tipo_documento, num_documento, nombre, correo) VALUES ('ce', 1002, 'Maria Lopez', 'maria.lopez@example.com');
INSERT INTO clientes (tipo_documento, num_documento, nombre, correo) VALUES ('cc', 1003, 'Pedro Gomez', 'pedro.gomez@example.com');
INSERT INTO clientes (tipo_documento, num_documento, nombre, correo) VALUES ('ce', 1004, 'Ana Lopez', 'ana.lopez@example.com');

-- Poblar tabla checkin
INSERT INTO checkin (reservas_id, clientes_num_documento, fecha_ingreso) VALUES (1, 1001, TO_DATE('2023-11-01', 'YYYY-MM-DD'));
INSERT INTO checkin (reservas_id, clientes_num_documento, fecha_ingreso) VALUES (2, 1002, TO_DATE('2023-11-02', 'YYYY-MM-DD'));

-- Poblar tabla reservan
INSERT INTO reservan (habitacion_id, reservas_id) VALUES (101, 1);
INSERT INTO reservan (habitacion_id, reservas_id) VALUES (102, 2);


-- Poblar tabla serv_conferencia
INSERT INTO serv_conferencia (reservaserv_id, conferencia_id) VALUES (3, 1);
INSERT INTO serv_conferencia (reservaserv_id, conferencia_id) VALUES (4, 2);

-- Poblar tabla serv_reuniones
INSERT INTO serv_reuniones (reservaserv_id, reunion_id) VALUES (3, 1);
INSERT INTO serv_reuniones (reservaserv_id, reunion_id) VALUES (4, 2);

-- Poblar tabla equipos
INSERT INTO equipos (id, nombre, descripcion) VALUES (1, 'Proyector', 'Proyector de alta definicion');
INSERT INTO equipos (id, nombre, descripcion) VALUES (2, 'Pantalla', 'Pantalla grande LED');

-- Poblar tabla adicionales
INSERT INTO adicionales (reunion_id, equipos_id, costo) VALUES (1, 1, 50);
INSERT INTO adicionales (reunion_id, equipos_id, costo) VALUES (2, 2, 60);

-- Poblar tabla checkouts
INSERT INTO checkouts (reservas_id, habitacion_id, fecha_salida) VALUES (1, 101, TO_DATE('2023-11-05', 'YYYY-MM-DD'));
INSERT INTO checkouts (reservas_id, habitacion_id, fecha_salida) VALUES (2, 102, TO_DATE('2023-11-06', 'YYYY-MM-DD'));

-- Poblar tabla utensilios
INSERT INTO utensilios (id, nombre, costo) VALUES (1, 'Toallas de playa', 5);
INSERT INTO utensilios (id, nombre, costo) VALUES (2, 'Sombrilla de playa', 10);

-- Poblar tabla productos_bar
INSERT INTO productos_bar (id, nombre, precio) VALUES (1, 'Cerveza', 5);
INSERT INTO productos_bar (id, nombre, precio) VALUES (2, 'Vino tinto', 8);

-- Poblar tabla productos_res
INSERT INTO productos_res (id, nombre, precio) VALUES (1, 'Pasta', 7);
INSERT INTO productos_res (id, nombre, precio) VALUES (2, 'Pollo a la brasa', 15);

-- Poblar tabla productos_t
INSERT INTO productos_t (id, nombre, precio) VALUES (1, 'Ropa', 30);
INSERT INTO productos_t (id, nombre, precio) VALUES (2, 'Zapatos', 50);

-- Poblar tabla productos_super
INSERT INTO productos_super (id, nombre, precio) VALUES (1, 'Cerveza', 5);
INSERT INTO productos_super (id, nombre,precio) VALUES (2, 'Vino tinto', 8);
INSERT INTO productos_super (id, nombre,precio) VALUES (3, 'Leche', 5);
INSERT INTO productos_super (id, nombre,precio) VALUES (4, 'Arroz', 8);

-- Poblar tabla venden_super
INSERT INTO venden_super (supermercados_id, productossuper_id) VALUES (1, 1);
INSERT INTO venden_super (supermercados_id, productossuper_id) VALUES (2, 2);

-- Poblar tabla venden_t
INSERT INTO venden_t (tiendas_id, productost_id) VALUES (1, 1);
INSERT INTO venden_t (tiendas_id, productost_id) VALUES (2, 2);

-- Poblar tabla prestan
INSERT INTO prestan (serviciosprestamo_id, utensilios_id) VALUES (1, 1);
INSERT INTO prestan (serviciosprestamo_id, utensilios_id) VALUES (2, 2);

-- Poblar tabla sirven_bares
INSERT INTO sirven_bares (bares_id, productosbar_id) VALUES (1, 1);
INSERT INTO sirven_bares (bares_id, productosbar_id) VALUES (2, 2);

-- Poblar tabla sirven_res
INSERT INTO sirven_res (restaurantes_id, productosres_id) VALUES (1, 1);
INSERT INTO sirven_res (restaurantes_id, productosres_id) VALUES (2, 2)
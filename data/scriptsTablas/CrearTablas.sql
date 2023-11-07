--TABLA ADICIONALES ---------------------------------------------------------------------------------------------------------------------------
CREATE TABLE adicionales (
    reunion_id INTEGER NOT NULL,
    equipos_id INTEGER NOT NULL,
    costo      NUMBER NOT NULL
);

ALTER TABLE adicionales ADD CONSTRAINT adicional_pk PRIMARY KEY ( reunion_id,
                                                                equipos_id );
--TABLA BARES ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE bares (
    id             INTEGER NOT NULL,
    capacidad      INTEGER NOT NULL,
    estilo         VARCHAR2(255 BYTE) NOT NULL,
    servicios_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE bares ADD CONSTRAINT bares_pk PRIMARY KEY ( id );

--TABLA CHECKIN ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE checkin (
    reservas_id            INTEGER NOT NULL,
    clientes_num_documento INTEGER NOT NULL,
    fecha_ingreso          DATE NOT NULL
);

ALTER TABLE checkin ADD CONSTRAINT checkin_pk PRIMARY KEY ( reservas_id,
                                                            clientes_num_documento );
                                                            
--TABLA CHECKOUTS ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE checkouts (
    reservas_id   INTEGER NOT NULL,
    habitacion_id INTEGER NOT NULL,
    fecha_salida  DATE NOT NULL
);

ALTER TABLE checkouts ADD CONSTRAINT checkouts_pk PRIMARY KEY ( reservas_id,
                                                                habitacion_id );
--TABLA CLIENTES ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE clientes (
    tipo_documento VARCHAR2(255 BYTE) NOT NULL,
    num_documento  INTEGER NOT NULL,
    nombre         VARCHAR2(255 BYTE) NOT NULL,
    correo         VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE clientes ADD CONSTRAINT ck_tipo CHECK ( tipo_documento IN ( 'cc', 'ce', 'cif', 'ti', 'pasaporte' ) ); 

ALTER TABLE clientes ADD CONSTRAINT clientes_pk PRIMARY KEY ( num_documento );

--TABLA CONFERENCIAS ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE conferencias (
    id             INTEGER NOT NULL,
    capacidad      INTEGER NOT NULL,
    costo_hora     NUMBER NOT NULL,
    servicios_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE conferencias ADD CONSTRAINT conferencias_pk PRIMARY KEY ( id );

--TABLA CONSUMOS ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE consumos (
    habitacion_id  INTEGER NOT NULL,
    servicios_tipo VARCHAR2(255 BYTE) NOT NULL,
    descripcion    VARCHAR2(510) DEFAULT '""',
    costo          NUMBER DEFAULT 0 NOT NULL
);

ALTER TABLE consumos ADD CONSTRAINT consumos_pk PRIMARY KEY ( habitacion_id,
                                                              servicios_tipo );

--TABLA EQUIPOS ---------------------------------------------------------------------------------------------------------------------------
                                                      
CREATE TABLE equipos (
    id          INTEGER NOT NULL,
    nombre      VARCHAR2(255 BYTE) NOT NULL,
    descripcion VARCHAR2(255) NOT NULL
);

ALTER TABLE equipos ADD CONSTRAINT equipos_pk PRIMARY KEY ( id );

--TABLA GIMNASIOS ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE gimnasios (
    id             INTEGER NOT NULL,
    capacidad      INTEGER NOT NULL,
    hora_inicio    DATE NOT NULL,
    hora_fin       DATE NOT NULL,
    servicios_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE gimnasios ADD CONSTRAINT gimnasios_pk PRIMARY KEY ( id );

--TABLA GRATIS ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE gratis (
    conferencia_id INTEGER NOT NULL,
    equipos_id     INTEGER NOT NULL
);

ALTER TABLE gratis ADD CONSTRAINT gratis_pk PRIMARY KEY ( conferencia_id,
                                                          equipos_id );
                                                          
--TABLA HABITACIONES ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE habitaciones (
    id              INTEGER NOT NULL,
    capacidad       INTEGER NOT NULL,
    precio          NUMBER NOT NULL,
    tipohab_id_tipo INTEGER NOT NULL
);

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( id );

--TABLA INTERNETS ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE internets (
    id             INTEGER NOT NULL,
    capacidad      INTEGER NOT NULL,
    costo_dia      NUMBER,
    servicios_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE internets ADD CONSTRAINT internets_pk PRIMARY KEY ( id );

--TABLA LAVANDERIAS ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE lavanderias (
    id               INTEGER NOT NULL,
    tipo_prenda      VARCHAR2(255 BYTE) NOT NULL,
    cantidad_prendas INTEGER NOT NULL,
    costo            NUMBER NOT NULL,
    servicios_tipo   VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE lavanderias ADD CONSTRAINT lavanderias_pk PRIMARY KEY ( id );

--TABLA OFRECEN ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE ofrecen (
    spas_id         INTEGER NOT NULL,
    serviciosspa_id INTEGER NOT NULL
);

ALTER TABLE ofrecen ADD CONSTRAINT ofrecen_pk PRIMARY KEY ( spas_id,
                                                          serviciosspa_id );

--TABLA PISCINAS ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE piscinas (
    id             INTEGER NOT NULL,
    profundidad_m  INTEGER NOT NULL,
    capacidad      INTEGER NOT NULL,
    hora_inicio    DATE NOT NULL,
    hora_fin       DATE NOT NULL,
    servicios_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE piscinas ADD CONSTRAINT piscinas_pk PRIMARY KEY ( id );

--TABLA PLANES_CONSUMO ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE planes_consumo (
    id            INTEGER NOT NULL,
    nombre        VARCHAR2(255 BYTE) NOT NULL,
    estadia_min   INTEGER DEFAULT 0 NOT NULL,
    costo         NUMBER NOT NULL,
    desc_reserva  NUMBER DEFAULT 0 NOT NULL,
    desc_bar      NUMBER DEFAULT 0 NOT NULL,
    desc_rest     NUMBER DEFAULT 0 NOT NULL,
    desc_servicio NUMBER DEFAULT 0 NOT NULL
);

ALTER TABLE planes_consumo ADD CHECK ( desc_reserva BETWEEN 0 AND 1 );

ALTER TABLE planes_consumo ADD CHECK ( desc_bar BETWEEN 0 AND 1 );

ALTER TABLE planes_consumo ADD CHECK ( desc_rest BETWEEN 0 AND 1 );

ALTER TABLE planes_consumo ADD CHECK ( desc_servicio BETWEEN 0 AND 1 );

ALTER TABLE planes_consumo ADD CONSTRAINT planes_consumo_pk PRIMARY KEY ( id );

--TABLA PRESTAN ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE prestan (
    serviciosprestamo_id INTEGER NOT NULL,
    utensilios_id        INTEGER NOT NULL
);

ALTER TABLE prestan ADD CONSTRAINT prestan_pk PRIMARY KEY ( serviciosprestamo_id,
                                                          utensilios_id );
                                                          
--TABLA PRODUCTOS_BAR ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE productos_bar (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(255 BYTE) NOT NULL,
    precio NUMBER NOT NULL
);

ALTER TABLE productos_bar ADD CONSTRAINT productos_bar_pk PRIMARY KEY ( id );

--TABLA PRODUCTOS_RES ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE productos_res (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(255 BYTE) NOT NULL,
    precio NUMBER NOT NULL
);

ALTER TABLE productos_res ADD CONSTRAINT productos_res_pk PRIMARY KEY ( id );

--TABLA PRODUCTOS_SUPER ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE productos_super (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(255 BYTE) NOT NULL,
    precio NUMBER NOT NULL
);

ALTER TABLE productos_super ADD CONSTRAINT productos_super_pk PRIMARY KEY ( id );

--TABLA PRODUCTOS_T ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE productos_t (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(255 BYTE) NOT NULL,
    precio NUMBER NOT NULL
);

ALTER TABLE productos_t ADD CONSTRAINT productos_t_pk PRIMARY KEY ( id );

--TABLA RESERVAN ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE reservan (
    habitacion_id INTEGER NOT NULL,
    reservas_id   INTEGER NOT NULL
);

ALTER TABLE reservan ADD CONSTRAINT reservan_pk PRIMARY KEY ( habitacion_id,
                                                              reservas_id );
                                                              
--TABLA RESERVAS ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE reservas (
    id                      INTEGER NOT NULL,
    fecha_inicio            DATE NOT NULL,
    fecha_salida            DATE NOT NULL,
    num_personas            INTEGER NOT NULL,
    planesconsumo_id        INTEGER NOT NULL,
    usuarios_num_documento  INTEGER NOT NULL
);

ALTER TABLE reservas ADD CHECK ( num_personas BETWEEN 1 AND 100 );

ALTER TABLE reservas ADD CONSTRAINT reservas_pk PRIMARY KEY ( id );

--TABLA RESERVAS_SERV ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE reservas_serv (
    id            INTEGER NOT NULL,
    duracion_hora INTEGER NOT NULL,
    dia           DATE NOT NULL,
    hora          DATE NOT NULL,
    habitacion_id INTEGER NOT NULL
);

ALTER TABLE reservas_serv ADD CONSTRAINT reservas_serv_pk PRIMARY KEY ( id );

--TABLA RESERVAS_SPA ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE reservas_spa (
    reservaserv_id INTEGER NOT NULL,
    spas_id        INTEGER NOT NULL
);

ALTER TABLE reservas_spa ADD CONSTRAINT reservas_spa_pk PRIMARY KEY ( reservaserv_id,
                                                                    spas_id );
                                                                    
--TABLA RESTAURANTES ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE restaurantes (
    id             INTEGER NOT NULL,
    capacidad      INTEGER NOT NULL,
    estilo         VARCHAR2(255 BYTE) NOT NULL,
    servicios_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE restaurantes ADD CONSTRAINT restaurantes_pk PRIMARY KEY ( id );

--TABLA REUNIONES ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE reuniones (
    id             INTEGER NOT NULL,
    capacidad      INTEGER NOT NULL,
    costo_hora     NUMBER NOT NULL,
    servicios_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE reuniones ADD CONSTRAINT ck_capacidad CHECK ( capacidad BETWEEN 0 AND 12 );

ALTER TABLE reuniones ADD CONSTRAINT reunion_pk PRIMARY KEY ( id );

--TABLA REUNIONES ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE serv_conferencia (
    reservaserv_id INTEGER NOT NULL,
    conferencia_id INTEGER NOT NULL
);

ALTER TABLE serv_conferencia ADD CONSTRAINT serv_conferencia_pk PRIMARY KEY ( reservaserv_id,
                                                                            conferencia_id );
                                                                            
--TABLA SERVICIOS ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE servicios (
    tipo           VARCHAR2(255 BYTE) NOT NULL,
    descripcion    VARCHAR2(510) NOT NULL
);

ALTER TABLE servicios ADD CONSTRAINT ck_tipo_servicio CHECK ( tipo IN ( 'bar', 'gimnasio', 'internet', 'lavadoSecadoEmbolado', 'piscina',
                                                      'prestamo', 'restaurante', 'salon', 'spa', 'supermercado',
                                                      'tienda' ) );

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( tipo );

--TABLA SERVICIOS_PRESTAMO ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE servicios_prestamo (
    id             INTEGER NOT NULL,
    cantidad       INTEGER NOT NULL,
    devuelto       NUMBER,
    servicios_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE servicios_prestamo ADD CONSTRAINT servicios_prestamo_pk PRIMARY KEY ( id );

--TABLA SERVICIOS_SPA ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE servicios_spa (
    id           INTEGER NOT NULL,
    nombre       VARCHAR2(255 BYTE) NOT NULL,
    costo        NUMBER NOT NULL,
    duracion_min INTEGER NOT NULL
);

ALTER TABLE servicios_spa ADD CONSTRAINT servicios_spa_pk PRIMARY KEY ( id );

--TABLA SERV_REUNIONES ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE serv_reuniones (
    reservaserv_id INTEGER NOT NULL,
    reunion_id     INTEGER NOT NULL
);

ALTER TABLE serv_reuniones ADD CONSTRAINT serv_reunion_pk PRIMARY KEY ( reservaserv_id,
                                                                    reunion_id );
                                                                    
--TABLA SIRVEN_BARES ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE sirven_bares (
    bares_id        INTEGER NOT NULL,
    productosbar_id INTEGER NOT NULL
);

ALTER TABLE sirven_bares ADD CONSTRAINT sirven_bares_pk PRIMARY KEY ( bares_id,
                                                                  productosbar_id );
                                                                  
--TABLA SIRVEN_RES ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE sirven_res (
    restaurantes_id INTEGER NOT NULL,
    productosres_id INTEGER NOT NULL
);

ALTER TABLE sirven_res ADD CONSTRAINT sirven_res_pk PRIMARY KEY ( restaurantes_id,
                                                              productosres_id );
                                                              
--TABLA SPAS ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE spas (
    id             INTEGER NOT NULL,
    capacidad      INTEGER NOT NULL,
    servicios_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE spas ADD CONSTRAINT spas_pk PRIMARY KEY ( id );

--TABLA SUPERMERCADOS ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE supermercados (
    id             INTEGER NOT NULL,
    servicios_tipo VARCHAR2(255 BYTE) NOT NULL,
    nombre         VARCHAR2(255 BYTE)
);

ALTER TABLE supermercados ADD CONSTRAINT supermercados_pk PRIMARY KEY ( id );

--TABLA TIENDAS ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE tiendas (
    id             INTEGER NOT NULL,
    tipo_tienda    VARCHAR2(255 BYTE) NOT NULL,
    servicios_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE tiendas ADD CONSTRAINT tiendas_pk PRIMARY KEY ( id );

--TABLA TIPO_HAB ---------------------------------------------------------------------------------------------------------------------------


CREATE TABLE tipo_hab (
    tipo    VARCHAR2(255 BYTE) NOT NULL,
    id_tipo INTEGER NOT NULL
);

ALTER TABLE tipo_hab ADD CONSTRAINT tipo_hab_pk PRIMARY KEY ( id_tipo );

--TABLA TIPOS_USUARIOS ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE tipo_usuarios (
    tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE tipo_usuarios ADD CONSTRAINT tipo_usuarios_pk PRIMARY KEY ( tipo );

--TABLA USUARIOS ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE usuarios (
    tipo_documento    VARCHAR2(255 BYTE) DEFAULT 'CC' NOT NULL,
    num_documento     NUMBER NOT NULL,
    nombre            VARCHAR2(255 BYTE) NOT NULL,
    correo            VARCHAR2(255 BYTE) NOT NULL,
    tiposusuario_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE usuarios ADD CONSTRAINT ck_tipo_documento CHECK ( tipo_documento IN ( 'CC', 'CE', 'CIF', 'TI', 'pasaporte' ) );

ALTER TABLE usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( num_documento );

--TABLA UTENSILIOS ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE utensilios (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(255 BYTE) NOT NULL,
    costo  NUMBER NOT NULL
);

ALTER TABLE utensilios ADD CONSTRAINT utensilios_pk PRIMARY KEY ( id );

--TABLA VENDEN_SUPER ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE venden_super (
    supermercados_id  INTEGER NOT NULL,
    productossuper_id INTEGER NOT NULL
);

ALTER TABLE venden_super ADD CONSTRAINT venden_super_pk PRIMARY KEY ( supermercados_id,
                                                                    productossuper_id );

--TABLA VENDEN_T ---------------------------------------------------------------------------------------------------------------------------

CREATE TABLE venden_t (
    tiendas_id    INTEGER NOT NULL,
    productost_id INTEGER NOT NULL
);

ALTER TABLE venden_t ADD CONSTRAINT venden_t_pk PRIMARY KEY ( tiendas_id,
                                                            productost_id );

--TABLA ADICIONALES ---------------------------------------------------------------------------------------------------------------------------

ALTER TABLE adicionales
    ADD CONSTRAINT adicionales_equipos_fk FOREIGN KEY ( equipos_id )
        REFERENCES equipos ( id );

ALTER TABLE adicionales
    ADD CONSTRAINT adicionales_reunion_fk FOREIGN KEY ( reunion_id )
        REFERENCES reuniones ( id );
        
--CONSTRAINTs ---------------------------------------------------------------------------------------------------------------------------

ALTER TABLE bares
    ADD CONSTRAINT bares_servicios_fk FOREIGN KEY ( servicios_tipo )
        REFERENCES servicios ( tipo );

ALTER TABLE checkin
    ADD CONSTRAINT checkin_clientes_fk FOREIGN KEY ( clientes_num_documento )
        REFERENCES clientes ( num_documento );

ALTER TABLE checkin
    ADD CONSTRAINT checkin_reservas_fk FOREIGN KEY ( reservas_id )
        REFERENCES reservas ( id );

ALTER TABLE checkouts
    ADD CONSTRAINT checkouts_habitacion_fk FOREIGN KEY ( habitacion_id )
        REFERENCES habitaciones ( id );

ALTER TABLE checkouts
    ADD CONSTRAINT checkouts_reservas_fk FOREIGN KEY ( reservas_id )
        REFERENCES reservas ( id );

ALTER TABLE conferencias
    ADD CONSTRAINT conferencia_servicios_fk FOREIGN KEY ( servicios_tipo )
        REFERENCES servicios ( tipo );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_habitacion_fk FOREIGN KEY ( habitacion_id )
        REFERENCES habitaciones ( id );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_servicios_fk FOREIGN KEY ( servicios_tipo )
        REFERENCES servicios ( tipo );

ALTER TABLE gimnasios
    ADD CONSTRAINT gimnasios_servicios_fk FOREIGN KEY ( servicios_tipo )
        REFERENCES servicios ( tipo );

ALTER TABLE gratis
    ADD CONSTRAINT gratis_conferencia_fk FOREIGN KEY ( conferencia_id )
        REFERENCES conferencias ( id );

ALTER TABLE gratis
    ADD CONSTRAINT gratis_equipos_fk FOREIGN KEY ( equipos_id )
        REFERENCES equipos ( id );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitacion_tipohab_fk FOREIGN KEY ( tipohab_id_tipo )
        REFERENCES tipo_hab ( id_tipo );

ALTER TABLE internets
    ADD CONSTRAINT internets_servicios_fk FOREIGN KEY ( servicios_tipo )
        REFERENCES servicios ( tipo );

ALTER TABLE lavanderias
    ADD CONSTRAINT lavanderia_servicios_fk FOREIGN KEY ( servicios_tipo )
        REFERENCES servicios ( tipo );

ALTER TABLE ofrecen
    ADD CONSTRAINT ofrece_serviciosspa_fk FOREIGN KEY ( serviciosspa_id )
        REFERENCES servicios_spa ( id );

ALTER TABLE ofrecen
    ADD CONSTRAINT ofrece_spas_fk FOREIGN KEY ( spas_id )
        REFERENCES spas ( id );

ALTER TABLE piscinas
    ADD CONSTRAINT piscinas_servicios_fk FOREIGN KEY ( servicios_tipo )
        REFERENCES servicios ( tipo );

ALTER TABLE prestan
    ADD CONSTRAINT presta_serviciosprestamo_fk FOREIGN KEY ( serviciosprestamo_id )
        REFERENCES servicios_prestamo ( id );

ALTER TABLE prestan
    ADD CONSTRAINT presta_utensilios_fk FOREIGN KEY ( utensilios_id )
        REFERENCES utensilios ( id );

ALTER TABLE reservan
    ADD CONSTRAINT reservan_habitacion_fk FOREIGN KEY ( habitacion_id )
        REFERENCES habitaciones ( id );

ALTER TABLE reservan
    ADD CONSTRAINT reservan_reservas_fk FOREIGN KEY ( reservas_id )
        REFERENCES reservas ( id );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_planesconsumo_fk FOREIGN KEY ( planesconsumo_id )
        REFERENCES planes_consumo ( id );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_usuarios_fk FOREIGN KEY ( usuarios_num_documento )
        REFERENCES usuarios ( num_documento );

ALTER TABLE reservas_serv
    ADD CONSTRAINT reservaserv_habitacion_fk FOREIGN KEY ( habitacion_id )
        REFERENCES habitaciones ( id );

ALTER TABLE reservas_spa
    ADD CONSTRAINT reservasspa_reservaserv_fk FOREIGN KEY ( reservaserv_id )
        REFERENCES reservas_serv ( id );

ALTER TABLE reservas_spa
    ADD CONSTRAINT reservasspa_spas_fk FOREIGN KEY ( spas_id )
        REFERENCES spas ( id );

ALTER TABLE restaurantes
    ADD CONSTRAINT restaurantes_servicios_fk FOREIGN KEY ( servicios_tipo )
        REFERENCES servicios ( tipo );

ALTER TABLE reuniones
    ADD CONSTRAINT reunion_servicios_fk FOREIGN KEY ( servicios_tipo )
        REFERENCES servicios ( tipo );

ALTER TABLE serv_conferencia
    ADD CONSTRAINT servconferencia_conferencia_fk FOREIGN KEY ( conferencia_id )
        REFERENCES conferencias ( id );

ALTER TABLE serv_conferencia
    ADD CONSTRAINT servconferencia_reservaserv_fk FOREIGN KEY ( reservaserv_id )
        REFERENCES reservas_serv ( id );

ALTER TABLE servicios_prestamo
    ADD CONSTRAINT serviciosprestamo_servicios_fk FOREIGN KEY ( servicios_tipo )
        REFERENCES servicios ( tipo );

ALTER TABLE serv_reuniones
    ADD CONSTRAINT servreunion_reservaserv_fk FOREIGN KEY ( reservaserv_id )
        REFERENCES reservas_serv ( id );

ALTER TABLE serv_reuniones
    ADD CONSTRAINT servreunion_reunion_fk FOREIGN KEY ( reunion_id )
        REFERENCES reuniones ( id );

ALTER TABLE sirven_bares
    ADD CONSTRAINT sirven_bar_bares_fk FOREIGN KEY ( bares_id )
        REFERENCES bares ( id );

ALTER TABLE sirven_bares
    ADD CONSTRAINT sirven_bar_productosbar_fk FOREIGN KEY ( productosbar_id )
        REFERENCES productos_bar ( id );

ALTER TABLE sirven_res
    ADD CONSTRAINT sirveres_productosres_fk FOREIGN KEY ( productosres_id )
        REFERENCES productos_res ( id );

ALTER TABLE sirven_res
    ADD CONSTRAINT sirveres_restaurantes_fk FOREIGN KEY ( restaurantes_id )
        REFERENCES restaurantes ( id );

ALTER TABLE spas
    ADD CONSTRAINT spas_servicios_fk FOREIGN KEY ( servicios_tipo )
        REFERENCES servicios ( tipo );

ALTER TABLE supermercados
    ADD CONSTRAINT supermercados_servicios_fk FOREIGN KEY ( servicios_tipo )
        REFERENCES servicios ( tipo );

ALTER TABLE tiendas
    ADD CONSTRAINT tiendas_servicios_fk FOREIGN KEY ( servicios_tipo )
        REFERENCES servicios ( tipo );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_tiposusuario_fk FOREIGN KEY ( tiposusuario_tipo )
        REFERENCES tipo_usuarios ( tipo );

ALTER TABLE venden_super
    ADD CONSTRAINT vendensuper_productossuper_fk FOREIGN KEY ( productossuper_id )
        REFERENCES productos_super ( id );

ALTER TABLE venden_super
    ADD CONSTRAINT vendensuper_supermercados_fk FOREIGN KEY ( supermercados_id )
        REFERENCES supermercados ( id );

ALTER TABLE venden_t
    ADD CONSTRAINT vendent_productost_fk FOREIGN KEY ( productost_id )
        REFERENCES productos_t ( id );

ALTER TABLE venden_t
    ADD CONSTRAINT vendent_tiendas_fk FOREIGN KEY ( tiendas_id )
        REFERENCES tiendas ( id );


-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            43
-- CREATE INDEX                            28
-- ALTER TABLE                            113
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0

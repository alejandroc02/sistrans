--RFC12 - CONSULTAR LOS CLIENTES EXCELENTES
SELECT DISTINCT
    clientes.num_documento AS numero_documento,
    clientes.nombre AS nombre_cliente,
    clientes.correo AS correo_cliente,
    consumos.costo as gastos
FROM clientes
inner JOIN reservas ON clientes.num_documento = reservas.usuarios_num_documento
inner JOIN reservan ON reservas.id = reservan.reservas_id
inner JOIN reservas_serv ON reservan.habitacion_id = reservas_serv.habitacion_id
inner JOIN reservas_spa on reservas_spa.reservaserv_id = reservas_serv.id
inner JOIN consumos ON consumos.habitacion_id = reservan.habitacion_id
WHERE
    (
        
       (TRUNC(reservas.fecha_salida) - TRUNC(reservas.fecha_inicio)) <= 90
    )
    OR
    (
   
        consumos.costo > 300000
    )
    OR
    (
        
        (
            consumos.servicios_tipo IN ('SPA', 'Salones de Reuniones')
            AND reservas_serv.duracion_hora > 4
        )
   
    )
    order by consumos.costo
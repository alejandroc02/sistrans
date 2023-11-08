
--RFC9 - CONSULTAR CONSUMO EN HOTELANDES
SELECT clientes.nombre AS nombre_cliente, clientes.num_documento AS num_documento_cliente, servicios.tipo AS servicio_consumido,
COUNT(consumos.habitacion_id) AS cantidad_consumos, reservas.fecha_inicio as fecha
FROM clientes
INNER JOIN reservas ON clientes.num_documento = reservas.usuarios_num_documento
INNER JOIN reservan ON reservas.id = reservan.reservas_id
INNER JOIN consumos ON reservan.habitacion_id = consumos.habitacion_id
INNER JOIN servicios ON consumos.servicios_tipo = servicios.tipo
WHERE
    reservas.fecha_inicio BETWEEN TO_DATE(:fecha_inicial, 'YYYY-MM-DD') AND TO_DATE(:fecha_final, 'YYYY-MM-DD')
    and servicios.tipo= : servicio --Este tambien varia
GROUP BY
    clientes.nombre,clientes.num_documento,servicios.tipo, reservas.fecha_inicio
ORDER BY
    --nombre_cliente
    --cantidas_consumos
    fecha;
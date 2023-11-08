--RFC5 - MOSTRAR EL CONSUMO EN HOTELANDES POR UN USUARIO DADO, EN UN RANGO DE FECHAS INDICADO
SELECT
    clientes.nombre AS nombre_cliente,
    reservas.id AS reserva_id,
    SUM(consumos.costo) AS total_consumo
FROM
    clientes
    JOIN reservas ON clientes.num_documento = reservas.usuarios_num_documento
    JOIN reservan ON reservas.id = reservan.reservas_id
    JOIN consumos ON reservan.habitacion_id = consumos.habitacion_id
WHERE
    clientes.num_documento = : id_usuario 
    AND reservas.fecha_inicio BETWEEN TO_DATE(:fecha_inicial, 'YYYY-MM-DD') AND TO_DATE(:fecha_final, 'YYYY-MM-DD')
GROUP BY
    clientes.nombre,
    reservas.id,
    reservas.fecha_inicio,
    reservas.fecha_salida
ORDER BY
    reservas.fecha_inicio;
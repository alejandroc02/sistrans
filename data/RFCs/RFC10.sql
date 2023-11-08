--RFC10 - CONSULTAR CONSUMO EN HOTELANDES � RFC9-V2
SELECT clientes.nombre AS nombre_cliente,clientes.num_documento AS num_documento_cliente
FROM clientes
WHERE clientes.num_documento NOT IN (
    SELECT DISTINCT reservas.usuarios_num_documento
    FROM reservas
    INNER JOIN reservan ON reservas.id = reservan.reservas_id
    INNER JOIN consumos ON reservan.habitacion_id = consumos.habitacion_id
    WHERE
        reservas.fecha_inicio BETWEEN TO_DATE(:fecha_inicial, 'YYYY-MM-DD') AND TO_DATE(:fecha_final, 'YYYY-MM-DD')
      
)
ORDER BY
    nombre_cliente;
    

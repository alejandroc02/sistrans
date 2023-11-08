--RFC1 - MOSTRAR EL DINERO RECOLECTADO POR SERVICIOS EN CADA HABITACION EN EL ULTIMO AÑO CORRIDO(2023).
SELECT habitaciones.id as habitacion_id , servicios.tipo as servicio, SUM(consumos.costo)dinero_recolectado 
FROM consumos
INNER JOIN habitaciones ON consumos.habitacion_id = habitaciones.id
INNER JOIN reservan ON habitaciones.id = reservan.habitacion_id
INNER JOIN servicios ON consumos.servicios_tipo = servicios.tipo
INNER JOIN reservas ON reservan.reservas_id = reservas.id
where reservas.fecha_inicio between TO_DATE('2023-01-01', 'YYYY-MM-DD') AND TO_DATE('2023-12-31', 'YYYY-MM-DD') 
GROUP BY habitaciones.id, servicios.tipo;

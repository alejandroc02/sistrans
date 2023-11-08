--RFC2 - MOSTRAR LOS 20 SERVICIOS M�S POPULARES.
SELECT servicios.tipo AS servicio_tipo, COUNT(consumos.servicios_tipo) AS cantidad_consumos
FROM consumos
INNER JOIN habitaciones ON consumos.habitacion_id = habitaciones.id
INNER JOIN reservan ON habitaciones.id = reservan.habitacion_id
INNER JOIN servicios ON consumos.servicios_tipo = servicios.tipo
INNER JOIN reservas ON reservan.reservas_id = reservas.id
where reservas.fecha_inicio between TO_DATE(:fecha_inicial, 'YYYY-MM-DD') AND TO_DATE(:fecha_final, 'YYYY-MM-DD') 
GROUP BY servicios.tipo
ORDER BY cantidad_consumos DESC
FETCH FIRST 20 ROWS ONLY;
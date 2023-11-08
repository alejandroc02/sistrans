--RFC8 - ENCONTRAR LOS SERVICIOS QUE NO TIENEN MUCHA DEMANDA

SELECT servicios.tipo AS tipo_servicio, COUNT(DISTINCT TO_DATE(reservas_serv.dia, 'YYYY-MM-DD')) / 7 AS solicitudes_semanales
FROM servicios
LEFT JOIN consumos ON servicios.tipo = consumos.servicios_tipo
left join habitaciones on consumos.habitacion_id=habitaciones.id
left join reservas_serv on reservas_serv.habitacion_id = habitaciones.id

WHERE reservas_serv.dia between TO_DATE('2023-01-01', 'YYYY-MM-DD') AND TO_DATE('2023-12-31', 'YYYY-MM-DD')
GROUP BY servicios.tipo
HAVING (COUNT(DISTINCT reservas_serv.dia) / 7) < 3;

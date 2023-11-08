 --RFC6 - ANALIZAR LA OPERACI�N DE HOTELANDES

--Mayor ocupacion
SELECT checkin.fecha_ingreso AS fecha, COUNT(distinct checkin.reservas_id) AS habitaciones_ocupadas
FROM checkin
GROUP BY checkin.fecha_ingreso
ORDER BY habitaciones_ocupadas DESC;

--Mayores ingresos
SELECT checkin.fecha_ingreso AS fecha, SUM(consumos.costo) AS ingresos
FROM checkin
JOIN reservan ON checkin.reservas_id = reservan.reservas_id
JOIN consumos ON consumos.habitacion_id = reservan.habitacion_id
GROUP BY checkin.fecha_ingreso
ORDER BY ingresos DESC;

--Menor ocupacion
SELECT checkin.fecha_ingreso AS fecha, COUNT(distinct checkin.reservas_id) AS habitaciones_ocupadas
FROM checkin
GROUP BY checkin.fecha_ingreso
ORDER BY habitaciones_ocupadas ASC;

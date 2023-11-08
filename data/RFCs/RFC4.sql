--RFC4 - MOSTRAR LOS SERVICIOS QUE CUMPLEN CON CIERTA CARACTER�STICA
SELECT *
FROM servicios
INNER JOIN consumos ON consumos.servicios_tipo = servicios.tipo
INNER JOIN habitaciones ON consumos.habitacion_id = habitaciones.id
INNER JOIN reservan ON habitaciones.id = reservan.habitacion_id
INNER JOIN reservas ON reservan.reservas_id = reservas.id
WHERE 
  consumos.costo BETWEEN : costo_minimo AND : costo_maximo
  AND reservas.fecha_inicio BETWEEN TO_DATE(:fecha_inicial, 'YYYY-MM-DD') AND TO_DATE(:fecha_final, 'YYYY-MM-DD')
  AND servicios.tipo = : tipo_servicio;
 
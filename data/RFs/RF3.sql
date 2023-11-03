--Actualizar/Registrar

UPDATE Habitaciones
SET tipo_habitacion = 'NuevoTipoHabitacion'
WHERE id_habitacion = id_habitacion_a_actualizar;

UPDATE Habitaciones
SET tipo_habitacion = 'doble'
WHERE id_habitacion = 305;
select * from habitaciones;
--Eliminar

DELETE FROM Habitaciones
WHERE tipo_habitacion = 'tipo_habitacion';

DELETE FROM Habitaciones
WHERE tipo_habitacion = 'suite';


--Consultar#

SELECT * FROM Habitaciones
WHERE tipo_habitacion = 'TipoHabitacion';

SELECT * FROM Habitaciones
WHERE tipo_habitacion = 'doble';
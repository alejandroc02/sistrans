--Instertar

INSERT INTO Servicios (id, nombre, horario_inicio, horario_cierre, hotel_NIT)
VALUES (id, 'nombre_servicio', 'horario_inicio', 'horario_cierre', hotel_NIT);

INSERT INTO Servicios (id, nombre, horario_inicio, horario_cierre, hotel_NIT)
VALUES (23, 'Servicio A', '7:00', '4:00', 104);

select * from servicios;
--Actualizar

UPDATE Servicios
SET nombre = 'NuevoNombreServicio', 
    horario_inicio = 'horario_inicio', 
    horario_cierre = 'horario_cierre', 
    hotel_NIT = 'NuevoNITHotel'
WHERE id = id_Servicio_a_actualizar;

UPDATE Servicios
SET nombre = 'Serivico abc', 
    horario_inicio = '8:00', 
    horario_cierre = '22:00', 
    hotel_NIT = 104
WHERE id = 5;

--Eliminar

DELETE FROM Servicios
WHERE id = id_Servicio_a_eliminar;

DELETE FROM Servicio
WHERE id = 10;

--Consultar

SELECT * FROM Servicios
WHERE id = id_Servicio_a_consultar;

SELECT * FROM Servicio
WHERE id = 4;

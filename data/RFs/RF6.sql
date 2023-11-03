--Registrar

INSERT INTO Planes_consumo (id_plan, nombre, descuento, hotel_NIT)
        VALUES (id_plan_a_registrar, 'NuevoNombre', valor_Descuento, hotel_nit);

INSERT INTO Planes_consumo (id_plan, nombre, descuento, hotel_NIT)
        VALUES (6, 'nuevoPlanjej', 10, 104);

select * from planes_consumo;
--Actualizar

UPDATE Planes_consumo
SET nombre = 'NuevoPlan', descuento = valor_Descuento, hotel_NIT = hotel_nit
WHERE id_plan = id_plan_a_actualizar;

UPDATE Planes_consumo
SET nombre = 'plan 8', descuento = 5, hotel_NIT = 104
WHERE id_plan = 3;

--Eliminar

DELETE FROM Planes_consumo
WHERE id_plan = id_plan_a_eliminar;

DELETE FROM Planes_consumo
WHERE id_plan = 4;

--Consultar

SELECT * FROM Planes_consumo
WHERE id_plan = id_plan_a_consultar;

SELECT * FROM Planes_consumo
WHERE id_plan = 5;
--registrar

INSERT INTO Habitaciones (
            id_habitacion, tipo_habitacion, capacidad, costo_noche,
            television, minibar, cafetera, comedor, cocina, jacuzzi,
            Reserva_id, Hotel_nit)
VALUES (id_habitacion_a_registar, 'NuevoTipoHabitacion', NuevaCapacidad,
            NuevoCosto_Noche, 'NuevaTelevision', 'NuevoMinibar', 'NuevaCafetera',
            'NuevoComedor', 'NuevaCocina', 'NuevoJacuzzi', NuevoReservaID, NuevoNITHotel);

INSERT INTO Habitaciones (
            id_habitacion, tipo_habitacion, capacidad, costo_noche,
            television, minibar, cafetera, comedor, cocina, jacuzzi,
            Reserva_id, Hotel_nit)
VALUES (307, 'suite', 10,
            1000, 'true', 'true', 'true',
            'false', 'true', 'false', 001, 104);

select * from habitaciones;

--Actualizar

UPDATE Habitaciones
SET tipo_habitacion = 'NuevoTipoHabitacion',
    capacidad = NuevaCapacidad,
    costo_noche = NuevoCosto_Noche,
    television = 'NuevaTelevision',
    minibar = 'NuevoMinibar',
    cafetera = 'NuevaCafetera',
    comedor = 'NuevoComedor',
    cocina = 'NuevaCocina',
    jacuzzi = 'NuevoJacuzzi',
    Reserva_id = NuevoReservaID,
    Hotel_nit = NuevoNITHotel
WHERE id_habitacion = id_habitacion_a_actualizar;

UPDATE Habitaciones
SET tipo_habitacion = 'suite',
    capacidad = 10,
    costo_noche = 1000,
    television = 'ture',
    minibar = 'true',
    cafetera = 'false',
    comedor = 'false',
    cocina = 'false',
    jacuzzi = 'false',
    Reserva_id = 004,
    Hotel_nit = 104
WHERE id_habitacion = 305;


--Eliminar

DELETE FROM Habitaciones
WHERE id_habitacion = id_habitacion_a_eliminar;

DELETE FROM Habitaciones
WHERE id_habitacion = 304;

--Consultar#

SELECT * FROM Habitaciones
WHERE id_habitacion = id_habitacion_a_consultar;


SELECT * FROM Habitaciones
WHERE id_habitacion = 301;

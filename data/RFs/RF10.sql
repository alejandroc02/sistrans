--Registrar 

INSERT INTO ReservaS_Servicio (id_reserva,fecha_inicio, fecha_fin, Factura_num, Servicio_id)
SELECT 6,'2023-10-01', '2023-10-23', 5, 5
FROM Reservas
WHERE ClienteS_cedula = 123456;

select * from reservas_servicio;
--Actualizar

DECLARE
   clientes_cedula NUMERIC := 456789; 
   servicio_id NUMERIC := 3;         
   fecha_inicio DATE := '2023-10-01';
   fecha_fin DATE := '2023-10-03';    
   factura_num NUMERIC := 3;     
BEGIN
   UPDATE Reservas_Servicio
   SET fecha_inicio = nueva_fecha_inicio, fecha_fin = nueva_fecha_fin
   WHERE Servicio_id = servicio_id
   AND id_reserva IN (
      SELECT id_reserva
      FROM Reservas
      WHERE Clientes_cedula = clientes_cedula
   );
END;

--Eliminar

DECLARE
   clientes_cedula NUMERIC := 5678923; 
   servicio_id NUMERIC := 6;        
BEGIN
   DELETE FROM Reservas_Servicio
   WHERE Servicio_id = servicio_id
   AND id_reserva IN (
      SELECT id_reserva
      FROM Reservas
      WHERE Clientes_cedula = clientes_cedula
   );
END;

--Consultar


SELECT RS.id_reserva, S.nombre AS nombre_servicio, RS.fecha_inicio, RS.fecha_fin
FROM Reservas_Servicio RS
INNER JOIN Servicio S ON RS.Servicio_id = S.id
WHERE id_reserva IN (
   SELECT id_reserva
   FROM Reservas
   WHERE Clientes_cedula = clientes_cedula
);

------------------

SELECT *
FROM RESERVAS
    INNER JOIN FACTURAS
    ON RESERVAS.ID_RESERVA = FACTURAS.ID_RESERVA
    INNER JOIN RESERVAS_SERVICIO
    ON FACTURA.NUM_FACTURA = RESERVAS_SERVICIO.FACTURA_NUM
    INNER JOIN SERVICIOS
    ON RESERVAS_SERVICIO.SERVICIO.ID = SERVICIOS.ID
WHERE RESERVAS.CLIENTEs_CEDULA = 1 AND SERVICIOS.ID = 1;

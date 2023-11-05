
--Actualizar y registrar

UPDATE Usuarios
SET tipo_usuario = 'nuevo_tipo_usuario'
WHERE cedula = valor_de_cedula;

UPDATE Usuarios
SET tipo_usuario = 'gerente'
WHERE cedula = 5;

select * from usuarios;
--Eliminar

DELETE FROM Usuarios
WHERE tipo_usuario = 'tipo_usuario';


DELETE FROM Usuarios
WHERE tipo_usuario = 'empleado';

--Consultar

SELECT tipo_usuario
FROM Usuarios
WHERE cedula = valor_de_cedula;

SELECT tipo_usuario
FROM Usuarios
WHERE cedula = 1;

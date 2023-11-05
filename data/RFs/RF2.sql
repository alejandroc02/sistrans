--registrar
INSERT INTO Usuarios (cedula, nombre, apellido,usuario_login, clave_login, tipo_usuario,hotel_NIT)
        VALUES (nueva_cedula, nuevo_nombre, nuevo_apellido,nuevo_usuario_login,nuevo_clave_login, nuevo_tipo_usuario,hotel_NIT);

INSERT INTO Usuarios (cedula, nombre, apellido,usuario_login, clave_login, tipo_usuario,hotel_NIT)
        VALUES (10, 'pedro', 'murillo', 'holausuario','holacontra','administrador',104);

--Actualizar

select * from usuarios;

UPDATE Usuarios
SET cedula = nueva_cedula, 
    nombre = 'nuevo_nombre', 
    apellido = 'nuevo_apellido', 
    usuario_login='nuevo_usuario_login',
    clave_login='nuevo_clave_login',
    tipo_usuario = 'nuevo_tipo_usuario',
    hotel_NIT='hotel_NIT'
WHERE cedula = valor_cedula_actual;

UPDATE Usuarios
SET nombre = 'nombrenuevo', 
    apellido = 'nuevoapellido', 
    usuario_login='nuevousuario123',
    clave_login='nuevoclavelogin1244',
    tipo_usuario = 'empleado',
    hotel_NIT=104
WHERE cedula = 4;

--Eliminar

DELETE FROM Usuarios
WHERE cedula = valor_cedula;

DELETE FROM Usuarios
WHERE cedula = 1;

--Consultar#

SELECT *
FROM Usuarios
WHERE cedula = valor_cedula;

SELECT *
FROM Usuarios
WHERE cedula = 4;
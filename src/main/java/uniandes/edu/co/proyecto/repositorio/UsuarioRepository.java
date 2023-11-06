package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TiposUsuario;
import uniandes.edu.co.proyecto.modelo.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, String> {

    // Obtener todos los usuarios
    @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
    Collection<Usuarios> findAllUsuarios();

    // Obtener un usuario por ID
    @Query(value = "SELECT * FROM usuarios WHERE id = :id", nativeQuery = true)
    Usuarios findUsuarioById(@Param("id") Long id);

    // Insertar un nuevo usuario
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (tipo_documento, num_documento, nombre, correo, tiposusuario_tipo) VALUES (:tipoDocumento, :numDocumento, :nombre, :correo, :tipoUsuarioTipo)", nativeQuery = true)
    void insertUsuario(@Param("tipoDocumento") int i, @Param("numDocumento") String string, @Param("nombre") String nombre, @Param("correo") String correo, @Param("tipoUsuarioTipo") TiposUsuario tiposUsuario);

    // Actualizar un usuario por ID
    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET tipo_documento = :tipoDocumento, num_documento = :numDocumento, nombre = :nombre, correo = :correo, tiposusuario_tipo = :tipoUsuarioTipo WHERE id = :id", nativeQuery = true)
    void updateUsuario(@Param("id") Long id, @Param("tipoDocumento") String tipoDocumento, @Param("numDocumento") int i, @Param("nombre") String nombre, @Param("correo") String correo, @Param("tipoUsuarioTipo") TiposUsuario tiposUsuario);

    // Eliminar un usuario por ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE id = :id", nativeQuery = true)
    void deleteUsuario(@Param("id") Long id);
}

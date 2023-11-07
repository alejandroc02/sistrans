package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TiposUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TiposUsuario, String> {

    // Obtener todos los tipos de usuarios
    @Query(value = "SELECT * FROM TIPO_USUARIOS", nativeQuery = true)
    Collection<TiposUsuario> darTiposUsuarios();

    // Obtener un tipo de usuario con un tipo específico
    @Query(value = "SELECT * FROM TIPO_USUARIOS WHERE tipo = :tipo", nativeQuery = true)
    TiposUsuario darTipoUsuario(@Param("tipo") String tipo);

    // Insertar un nuevo tipo de usuario
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tipo_usuarios (tipo) VALUES (:tipo)", nativeQuery = true)
    void insertarTipoUsuario(@Param("tipo") String tipo);

    // Actualizar un tipo de usuario
    @Modifying
    @Transactional
    @Query(value = "UPDATE tipo_usuarios SET tipo = :tipo WHERE tipo = :tipoActual", nativeQuery = true)
    void actualizarTipoUsuario(@Param("tipoActual") String tipoActual, @Param("tipo") String tipo);

    // Eliminar un tipo de usuario
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tipo_usuarios WHERE tipo = :tipo", nativeQuery = true)
    void eliminarTipoUsuario(@Param("tipo") String tipo);
}

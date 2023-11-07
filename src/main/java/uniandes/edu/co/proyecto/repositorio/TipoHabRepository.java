package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Tipohab;

public interface TipoHabRepository extends JpaRepository<Tipohab, Integer> {

    // Obtener todos los tipos de habitación
    @Query(value = "SELECT * FROM TIPO_HAB", nativeQuery = true)
    Collection<Tipohab> darTiposHabitacion();

    // Obtener un tipo de habitación con un ID específico
    @Query(value = "SELECT * FROM TIPO_HAB WHERE id_tipo = :id", nativeQuery = true)
    Tipohab darTipoHabitacion(@Param("id") int id);

    // Insertar un nuevo tipo de habitación
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tipo_hab (tipo, id_tipo) VALUES (:tipo, :id_tipo)", nativeQuery = true)
    void insertarTipoHabitacion(@Param("tipo") String tipo, @Param("id_tipo") Integer id_tipo);

    // Actualizar un tipo de habitación
    @Modifying
    @Transactional
    @Query(value = "UPDATE tipo_hab SET tipo = :tipo WHERE id_tipo = :id_tipo", nativeQuery = true)
    void actualizarTipoHabitacion(@Param("id_tipo") Integer id_tipo, @Param("tipo") String tipo);

    // Eliminar un tipo de habitación
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tipo_hab WHERE id_tipo = :id_tipo", nativeQuery = true)
    void eliminarTipoHabitacion(@Param("id_tipo") Integer id_tipo);
}

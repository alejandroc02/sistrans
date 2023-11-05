package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Servicios;

public interface ServiciosRepository extends JpaRepository<Servicios, String> {
    
    // Consulta personalizada para obtener todos los servicios de un tipo específico
    @Query(value = "SELECT * FROM servicios WHERE tipo = :tipo", nativeQuery = true)
    List<Servicios> findServiciosByTipo(@Param("tipo") String tipo);

    // Insertar un nuevo servicio
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicios (tipo, descripcion) VALUES (:tipo, :descripcion)", nativeQuery = true)
    void insertarServicio(@Param("tipo") String tipo, @Param("descripcion") String descripcion);

    // Actualizar un servicio por tipo
    @Modifying
    @Transactional
    @Query(value = "UPDATE servicios SET descripcion = :descripcion WHERE tipo = :tipo", nativeQuery = true)
    void actualizarServicio(@Param("tipo") String tipo, @Param("descripcion") String descripcion);

    // Eliminar un servicio por tipo
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicios WHERE tipo = :tipo", nativeQuery = true)
    void eliminarServicio(@Param("tipo") String tipo);
}

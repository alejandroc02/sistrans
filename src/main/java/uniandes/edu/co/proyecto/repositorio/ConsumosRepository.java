package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Consumos;

import java.util.Collection;

public interface ConsumosRepository extends JpaRepository<Consumos, Integer> {

    // Obtener todos los consumos
    @Query(value = "SELECT * FROM consumos", nativeQuery = true)
    Collection<Consumos> darConsumos();

    // Obtener un consumo por habitacion_id y servicios_tipo
    @Query(value = "SELECT * FROM consumos WHERE habitacion_id = :habitacion_id AND servicios_tipo = :servicios_tipo", nativeQuery = true)
    Consumos darConsumoPorHabitacionYServicio(@Param("habitacion_id") Integer habitacionId, @Param("servicios_tipo") String serviciosTipo);

    // Insertar un nuevo consumo
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO consumos (habitacion_id, servicios_tipo, descripcion, costo) VALUES (:habitacion_id, :servicios_tipo, :descripcion, :costo)", nativeQuery = true)
    void insertarConsumo(@Param("habitacion_id") Integer habitacionId, @Param("servicios_tipo") String serviciosTipo, @Param("descripcion") String descripcion, @Param("costo") Number costo);

    // Actualizar un consumo
    @Modifying
    @Transactional
    @Query(value = "UPDATE consumos SET descripcion = :descripcion, costo = :costo WHERE habitacion_id = :habitacion_id AND servicios_tipo = :servicios_tipo", nativeQuery = true)
    void actualizarConsumo(@Param("habitacion_id") Integer habitacionId, @Param("servicios_tipo") String serviciosTipo, @Param("descripcion") String descripcion, @Param("costo") Number costo);

    // Eliminar un consumo por habitacion_id y servicios_tipo
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumos WHERE habitacion_id = :habitacion_id AND servicios_tipo = :servicios_tipo", nativeQuery = true)
    void eliminarConsumo(@Param("habitacion_id") Integer habitacionId, @Param("servicios_tipo") String serviciosTipo);
}

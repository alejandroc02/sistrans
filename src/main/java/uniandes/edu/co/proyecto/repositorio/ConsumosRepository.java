package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Consumos;
import uniandes.edu.co.proyecto.modelo.ConsumosPK;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Servicios;

import java.util.Collection;

public interface ConsumosRepository extends JpaRepository<Consumos, Integer> {

    // Obtener todos los consumos
    @Query(value = "SELECT * FROM consumos", nativeQuery = true)
    Collection<Consumos> darConsumos();

    // Obtener un consumo por habitacion_id y servicios_tipo
    @Query(value = "SELECT * FROM consumos WHERE habitacion_id = :habitacion_id AND servicios_tipo = :servicios_tipo", nativeQuery = true)
    Consumos darConsumoPorHabitacionYServicio(@Param("habitacion_id") int i, @Param("servicios_tipo") String string);

    // Insertar un nuevo consumo
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO consumos (habitacion_id, servicios_tipo, descripcion, costo) VALUES (:habitacion_id, :servicios_tipo, :descripcion, :costo)", nativeQuery = true)
    void insertarConsumo(@Param("habitacion_id") Habitacion habitacion, @Param("servicios_tipo") Servicios servicios, @Param("descripcion") String descripcion, @Param("costo") Number costo);

    // Actualizar un consumo
    @Modifying
    @Transactional
    @Query(value = "UPDATE consumos SET descripcion = :descripcion, costo = :costo WHERE habitacion_id = :habitacion_id AND servicios_tipo = :servicios_tipo", nativeQuery = true)
    void actualizarConsumo(@Param("habitacion_id") int i, @Param("servicios_tipo") String string, @Param("descripcion") String descripcion, @Param("costo") Number costo);

    // Eliminar un consumo por habitacion_id y servicios_tipo
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumos WHERE habitacion_id = :habitacion_id AND servicios_tipo = :servicios_tipo", nativeQuery = true)
    void eliminarConsumo(@Param("habitacion_id") int i, @Param("servicios_tipo") String string);
}

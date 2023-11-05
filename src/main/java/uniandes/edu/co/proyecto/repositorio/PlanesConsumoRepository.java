package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.PlanesConsumo;

import java.util.Collection;

public interface PlanesConsumoRepository extends JpaRepository<PlanesConsumo, Integer> {

    // Obtener todos los planes de consumo
    @Query(value = "SELECT * FROM planes_consumo", nativeQuery = true)
    Collection<PlanesConsumo> darPlanesConsumo();

    // Obtener un plan de consumo por ID
    @Query(value = "SELECT * FROM planes_consumo WHERE id = :id", nativeQuery = true)
    PlanesConsumo darPlanConsumoPorId(@Param("id") Integer id);

    // Insertar un nuevo plan de consumo
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO planes_consumo (id, nombre, estadia_min, costo, desc_reserva, desc_bar, desc_rest, desc_servicio) " +
            "VALUES (:id, :nombre, :estadia_min, :costo, :desc_reserva, :desc_bar, :desc_rest, :desc_servicio)", nativeQuery = true)
    void insertarPlanConsumo(@Param("id") Integer id, @Param("nombre") String nombre, @Param("estadia_min") Integer estadiaMin,
                            @Param("costo") Number costo, @Param("desc_reserva") Number descReserva,
                            @Param("desc_bar") Number descBar, @Param("desc_rest") Number descRest,
                            @Param("desc_servicio") Number descServicio);

    // Actualizar un plan de consumo
    @Modifying
    @Transactional
    @Query(value = "UPDATE planes_consumo SET nombre = :nombre, estadia_min = :estadia_min, costo = :costo, " +
            "desc_reserva = :desc_reserva, desc_bar = :desc_bar, desc_rest = :desc_rest, desc_servicio = :desc_servicio " +
            "WHERE id = :id", nativeQuery = true)
    void actualizarPlanConsumo(@Param("id") Integer id, @Param("nombre") String nombre, @Param("estadia_min") Integer estadiaMin,
                              @Param("costo") Number costo, @Param("desc_reserva") Number descReserva,
                              @Param("desc_bar") Number descBar, @Param("desc_rest") Number descRest,
                              @Param("desc_servicio") Number descServicio);

    // Eliminar un plan de consumo por ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planes_consumo WHERE id = :id", nativeQuery = true)
    void eliminarPlanConsumoPorId(@Param("id") Integer id);
}

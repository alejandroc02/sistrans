package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Reservas;

import java.util.Collection;

public interface ReservasRepository extends JpaRepository<Reservas, Integer> {

    // Obtener todas las reservas
    @Query(value = "SELECT * FROM reservas", nativeQuery = true)
    Collection<Reservas> darReservas();

    // Obtener una reserva con ID específico
    @Query(value = "SELECT * FROM reservas WHERE id = :id", nativeQuery = true)
    Reservas darReserva(@Param("id") int id);

    // Insertar una nueva reserva
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservas (id, fecha_inicio, fecha_salida, num_personas, planesconsumo_id, usuarios_num_documento) VALUES (:id, :fecha_inicio, :fecha_salida, :num_personas, :planesconsumo_id, :usuarios_num_documento)", nativeQuery = true)
    void insertarReserva(@Param("id") Integer id, @Param("fecha_inicio") java.sql.Date fechaInicio, @Param("fecha_salida") java.sql.Date fechaSalida, @Param("num_personas") Integer numPersonas, @Param("planesconsumo_id") Integer planesConsumoId, @Param("usuarios_num_documento") Integer usuariosNumDocumento);

    // Actualizar una reserva por ID
    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas SET fecha_inicio = :fecha_inicio, fecha_salida = :fecha_salida, num_personas = :num_personas, planesconsumo_id = :planesconsumo_id, usuarios_num_documento = :usuarios_num_documento WHERE id = :id", nativeQuery = true)
    void actualizarReserva(@Param("id") Integer id, @Param("fecha_inicio") java.sql.Date fechaInicio, @Param("fecha_salida") java.sql.Date fechaSalida, @Param("num_personas") Integer numPersonas, @Param("planesconsumo_id") Integer planesConsumoId, @Param("usuarios_num_documento") Integer usuariosNumDocumento);

    // Eliminar una reserva por ID
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservas WHERE id = :id", nativeQuery = true)
    void eliminarReserva(@Param("id") Integer id);
}

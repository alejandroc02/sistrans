package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CheckIn;

import java.util.Collection;

public interface CheckInRepository extends JpaRepository<CheckIn, Integer> {

    // Obtener todos los check-ins
    @Query(value = "SELECT * FROM checkin", nativeQuery = true)
    Collection<CheckIn> darCheckIns();

    // Obtener un check-in por reserva_id
    @Query(value = "SELECT * FROM checkin WHERE reservas_id = :reservas_id", nativeQuery = true)
    CheckIn darCheckInPorReserva(@Param("reservas_id") Integer reservasId);

    // Insertar un nuevo check-in
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO checkin (reservas_id, clientes_num_documento, fecha_ingreso) VALUES (:reservas_id, :clientes_num_documento, :fecha_ingreso)", nativeQuery = true)
    void insertarCheckIn(@Param("reservas_id") Integer reservasId, @Param("clientes_num_documento") Integer clientesNumDocumento, @Param("fecha_ingreso") java.sql.Date fechaIngreso);

    // Actualizar la fecha de ingreso en un check-in por reserva_id
    @Modifying
    @Transactional
    @Query(value = "UPDATE checkin SET fecha_ingreso = :fecha_ingreso WHERE reservas_id = :reservas_id", nativeQuery = true)
    void actualizarFechaIngreso(@Param("reservas_id") Integer reservasId, @Param("fecha_ingreso") java.sql.Date fechaIngreso);

    // Eliminar un check-in por reserva_id
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM checkin WHERE reservas_id = :reservas_id", nativeQuery = true)
    void eliminarCheckInPorReserva(@Param("reservas_id") Integer reservasId);
}

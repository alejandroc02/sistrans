package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CheckOuts;

import java.util.Collection;

public interface CheckOutRepository extends JpaRepository<CheckOuts, Integer> {

    // Obtener todos los check-outs
    @Query(value = "SELECT * FROM checkout", nativeQuery = true)
    Collection<CheckOuts> darCheckOuts();

    // Obtener un check-out por reserva_id
    @Query(value = "SELECT * FROM checkout WHERE reservas_id = :reservas_id", nativeQuery = true)
    CheckOuts darCheckOutPorReserva(@Param("reservas_id") Integer reservasId);

    // Insertar un nuevo check-out
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO checkout (reservas_id, clientes_num_documento, fecha_salida) VALUES (:reservas_id, :clientes_num_documento, :fecha_salida)", nativeQuery = true)
    void insertarCheckOut(@Param("reservas_id") Integer reservasId, @Param("clientes_num_documento") Integer clientesNumDocumento, @Param("fecha_salida") java.sql.Date fechaSalida);

    // Actualizar la fecha de salida en un check-out por reserva_id
    @Modifying
    @Transactional
    @Query(value = "UPDATE checkout SET fecha_salida = :fecha_salida WHERE reservas_id = :reservas_id", nativeQuery = true)
    void actualizarFechaSalida(@Param("reservas_id") Integer reservasId, @Param("fecha_salida") java.sql.Date fechaSalida);

    // Eliminar un check-out por reserva_id
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM checkout WHERE reservas_id = :reservas_id", nativeQuery = true)
    void eliminarCheckOutPorReserva(@Param("reservas_id") Integer reservasId);
}

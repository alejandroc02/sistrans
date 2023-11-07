package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.RFC5Result;

import java.util.Collection;

public interface RFC5Repository extends JpaRepository<RFC5Result, String> {

    @Query(value = "SELECT clientes.nombre AS nombre_cliente, " +
            "reservas.id AS reserva_id, " +
            "SUM(consumos.costo) AS total_consumo " +
            "FROM clientes " +
            "JOIN reservas ON clientes.num_documento = reservas.usuarios_num_documento " +
            "JOIN reservan ON reservas.id = reservan.reservas_id " +
            "JOIN consumos ON reservan.habitacion_id = consumos.habitacion_id " +
            "WHERE clientes.num_documento = :id_usuario " +
            "AND reservas.fecha_inicio BETWEEN TO_DATE(:fecha_inicial, 'YYYY-MM-DD') " +
            "AND TO_DATE(:fecha_final, 'YYYY-MM-DD') " +
            "GROUP BY clientes.nombre, reservas.id, reservas.fecha_inicio, reservas.fecha_salida " +
            "ORDER BY reservas.fecha_inicio", nativeQuery = true)
    Collection<RFC5Result> darRespuesta(
            @Param("id_usuario") Integer idUsuario,
            @Param("fecha_inicial") String fechaInicial,
            @Param("fecha_final") String fechaFinal
    );
}

package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uniandes.edu.co.proyecto.modelo.Clientes;
import uniandes.edu.co.proyecto.modelo.RFC7Result;

public interface RFC7Repository extends JpaRepository<RFC7Result, String> {

    @Query(value = "SELECT " +
            "clientes.nombre AS nombre_cliente, " +
            "clientes.correo AS correo_cliente, " +
            "SUM(DISTINCT (reservas.fecha_salida - reservas.fecha_inicio)) AS total_dias_estadia, " +
            "SUM(consumos.costo) AS total_consumos " +
            "FROM clientes " +
            "INNER JOIN reservas ON clientes.num_documento = reservas.usuarios_num_documento " +
            "INNER JOIN checkin ON clientes.num_documento = checkin.clientes_num_documento " +
            "INNER JOIN reservan ON reservan.reservas_id = reservas.id " +
            "INNER JOIN habitaciones ON habitaciones.id = reservan.habitacion_id " +
            "INNER JOIN consumos ON consumos.habitacion_id = habitaciones.id " +
            "WHERE reservas.fecha_inicio BETWEEN TO_DATE('2023-01-01', 'YYYY-MM-DD') " +
            "AND TO_DATE('2023-12-31', 'YYYY-MM-DD') " +
            "GROUP BY clientes.num_documento, clientes.nombre, clientes.correo " +
            "HAVING SUM(DISTINCT (reservas.fecha_salida - reservas.fecha_inicio)) >= 14 " +
            "OR SUM(consumos.costo) > 15000000", nativeQuery = true)
    Collection<RFC7Result> encontrarBuenosClientes();
}

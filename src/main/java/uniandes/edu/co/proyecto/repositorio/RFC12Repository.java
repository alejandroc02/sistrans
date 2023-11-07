package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uniandes.edu.co.proyecto.modelo.Clientes;
import uniandes.edu.co.proyecto.modelo.RFC12Result;

public interface RFC12Repository extends JpaRepository<Clientes, Integer> {

    @Query(value = "SELECT DISTINCT " +
            "clientes.num_documento AS numero_documento, " +
            "clientes.nombre AS nombre_cliente, " +
            "clientes.correo AS correo_cliente, " +
            "consumos.costo AS gastos " +
            "FROM clientes " +
            "INNER JOIN reservas ON clientes.num_documento = reservas.usuarios_num_documento " +
            "INNER JOIN reservan ON reservas.id = reservan.reservas_id " +
            "INNER JOIN reservas_serv ON reservan.habitacion_id = reservas_serv.habitacion_id " +
            "INNER JOIN reservas_spa ON reservas_spa.reservaserv_id = reservas_serv.id " +
            "INNER JOIN consumos ON consumos.habitacion_id = reservan.habitacion_id " +
            "WHERE " +
            "((TRUNC(reservas.fecha_salida) - TRUNC(reservas.fecha_inicio)) <= 90) " +
            "OR (consumos.costo > 300000) " +
            "OR ((consumos.servicios_tipo IN ('SPA', 'Salones de Reuniones') " +
            "AND reservas_serv.duracion_hora > 4)) " +
            "ORDER BY consumos.costo", nativeQuery = true)
    Collection<RFC12Result> consultarClientesConGastosElevados();
}

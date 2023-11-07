package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.RFC1;

import java.util.Collection;

public interface RFC1Repository extends JpaRepository<RFC1, Integer> {

    @Query(value = "SELECT habitaciones.id as habitacion_id, servicios.tipo as servicio, SUM(consumos.costo) as dinero_recolectado " +
            "FROM consumos " +
            "INNER JOIN habitaciones ON consumos.habitacion_id = habitaciones.id " +
            "INNER JOIN reservan ON habitaciones.id = reservan.habitacion_id " +
            "INNER JOIN servicios ON consumos.servicios_tipo = servicios.tipo " +
            "INNER JOIN reservas ON reservan.reservas_id = reservas.id " +
            "WHERE reservas.fecha_inicio BETWEEN TO_DATE('2023-01-01', 'YYYY-MM-DD') AND TO_DATE('2023-12-31', 'YYYY-MM-DD') " +
            "GROUP BY habitaciones.id, servicios.tipo", nativeQuery = true)
    Collection<RFC1> darR();
}

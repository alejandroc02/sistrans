package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.RFC8Result;
import uniandes.edu.co.proyecto.modelo.Servicios;

public interface RFC8Repository extends JpaRepository<Servicios, String> {

    @Query(value = "SELECT " +
            "servicios.tipo AS tipo_servicio, " +
            "COUNT(DISTINCT TO_DATE(reservas_serv.dia, 'YYYY-MM-DD')) / 7 AS solicitudes_semanales " +
            "FROM servicios " +
            "LEFT JOIN consumos ON servicios.tipo = consumos.servicios_tipo " +
            "LEFT JOIN habitaciones ON consumos.habitacion_id = habitaciones.id " +
            "LEFT JOIN reservas_serv ON reservas_serv.habitacion_id = habitaciones.id " +
            "WHERE reservas_serv.dia BETWEEN TO_DATE('2023-01-01', 'YYYY-MM-DD') " +
            "AND TO_DATE('2023-12-31', 'YYYY-MM-DD') " +
            "GROUP BY servicios.tipo " +
            "HAVING (COUNT(DISTINCT reservas_serv.dia) / 7) < 3", nativeQuery = true)
    Collection<RFC8Result> encontrarServiciosConPocaDemanda();
}

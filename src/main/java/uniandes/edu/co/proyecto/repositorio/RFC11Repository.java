package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uniandes.edu.co.proyecto.modelo.Reservas;

public interface RFC11Repository extends JpaRepository<Reservas, Integer> {

    @Query(value = "SELECT TO_CHAR(reservas.fecha_inicio, 'IYYY-IW') AS semana, " +
            "MAX(servicios.tipo) AS servicio_mas_consumido, " +
            "MIN(servicios.tipo) AS servicio_menos_consumido, " +
            "MAX(habitaciones.id) AS habitacion_mas_solicitada, " +
            "MIN(habitaciones.id) AS habitacion_menos_solicitada " +
            "FROM reservas " +
            "JOIN reservan ON reservas.id = reservan.reservas_id " +
            "JOIN consumos ON reservan.habitacion_id = consumos.habitacion_id " +
            "JOIN servicios ON consumos.servicios_tipo = servicios.tipo " +
            "JOIN habitaciones ON reservan.habitacion_id = habitaciones.id " +
            "WHERE reservas.fecha_inicio >= TO_DATE('2023-01-01', 'YYYY-MM-DD') " +
            "AND reservas.fecha_inicio <= TO_DATE('2023-12-31', 'YYYY-MM-DD') " +
            "GROUP BY TO_CHAR(reservas.fecha_inicio, 'IYYY-IW') " +
            "ORDER BY semana", nativeQuery = true)
    Collection<Object[]> consultarFuncionamiento();
}

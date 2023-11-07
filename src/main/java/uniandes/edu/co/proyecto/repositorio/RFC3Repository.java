package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface RFC3Repository extends JpaRepository<Object[], Integer> {

    @Query(value = "SELECT habitaciones.id AS habitacion_id, " +
            "habitaciones.capacidad AS capacidad_habitacion, " +
            "COUNT(reservan.reservas_id) AS total_reservas, " +
            "SUM(reservas.fecha_salida - reservas.fecha_inicio) AS total_dias_ocupados, " +
            "(SUM(reservas.fecha_salida - reservas.fecha_inicio) / 365) * 100 AS porcentaje_ocupacion " +
            "FROM habitaciones " +
            "LEFT JOIN reservan ON habitaciones.id = reservan.habitacion_id " +
            "LEFT JOIN reservas ON reservan.reservas_id = reservas.id " +
            "WHERE reservas.fecha_inicio BETWEEN TO_DATE('2023-01-01', 'YYYY-MM-DD') " +
            "AND TO_DATE('2023-12-31', 'YYYY-MM-DD') " +
            "AND reservas.fecha_salida BETWEEN TO_DATE('2023-01-01', 'YYYY-MM-DD') " +
            "AND TO_DATE('2023-12-31', 'YYYY-MM-DD') " +
            "GROUP BY habitaciones.id, habitaciones.capacidad", nativeQuery = true)
    Collection<Object[]> darRespuesta();
}

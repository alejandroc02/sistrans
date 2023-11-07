package uniandes.edu.co.proyecto.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.RFC3Result;

import java.util.Collection;
/* 
 * MOSTRAR EL ÍNDICE DE OCUPACIÓN DE CADA UNA DE LAS 
 * HABITACIONES DEL HOTEL
 */
public interface RFC3Repository extends JpaRepository<RFC3Result, Integer> {

    @Query(value = "SELECT habitaciones.id AS habitacionId, " +
            "habitaciones.capacidad AS capacidadHabitacion, " +
            "COUNT(reservan.reservas_id) AS totalReservas, " +
            "SUM(reservas.fecha_salida - reservas.fecha_inicio) AS totalDiasOcupados, " +
            "(SUM(reservas.fecha_salida - reservas.fecha_inicio) / 365) * 100 AS porcentajeOcupacion " +
            "FROM habitaciones " +
            "LEFT JOIN reservan ON habitaciones.id = reservan.habitacion_id " +
            "LEFT JOIN reservas ON reservan.reservas_id = reservas.id " +
            "WHERE reservas.fecha_inicio BETWEEN TO_DATE('2023-01-01', 'YYYY-MM-DD') " +
            "AND TO_DATE('2023-12-31', 'YYYY-MM-DD') " +
            "AND reservas.fecha_salida BETWEEN TO_DATE('2023-01-01', 'YYYY-MM-DD') " +
            "AND TO_DATE('2023-12-31', 'YYYY-MM-DD') " +
            "GROUP BY habitaciones.id, habitaciones.capacidad", nativeQuery = true)
    Collection<RFC3Result> indiceOcupacionHabitacionesHotel();
}

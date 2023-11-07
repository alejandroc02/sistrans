package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RFC6Repository extends JpaRepository<Object[], Integer> {

    @Query(value = "SELECT checkin.fecha_ingreso AS fecha, " +
            "COUNT(distinct checkin.reservas_id) AS habitaciones_ocupadas " +
            "FROM checkin " +
            "GROUP BY checkin.fecha_ingreso " +
            "ORDER BY habitaciones_ocupadas DESC", nativeQuery = true)
    Collection<Object[]> obtenerMayorOcupacion();

    @Query(value = "SELECT checkin.fecha_ingreso AS fecha, " +
    "SUM(consumos.costo) AS ingresos " +
    "FROM checkin " +
    "JOIN reservan ON checkin.reservas_id = reservan.reservas_id " +
    "JOIN consumos ON consumos.habitacion_id = reservan.habitacion_id " +
    "GROUP BY checkin.fecha_ingreso " +
    "ORDER BY ingresos DESC", nativeQuery = true)
    Collection<Object[]> obtenerMayoresIngresos();

    @Query(value = "SELECT checkin.fecha_ingreso AS fecha, " +
    "COUNT(distinct checkin.reservas_id) AS habitaciones_ocupadas " +
    "FROM checkin " +
    "GROUP BY checkin.fecha_ingreso " +
    "ORDER BY habitaciones_ocupadas ASC", nativeQuery = true)
    Collection<Object[]> obtenerMenorOcupacion();
}

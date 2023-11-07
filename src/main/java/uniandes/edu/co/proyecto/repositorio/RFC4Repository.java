package uniandes.edu.co.proyecto.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.RFC4Result;

import java.util.Collection;
/* 
 * MOSTRAR LOS SERVICIOS QUE CUMPLEN CON CIERTA CARACTERÍSTICA
 */
public interface RFC4Repository extends JpaRepository<RFC4Result, Integer> {

    @Query(value = "SELECT servicios.tipo AS servicio, consumos.costo, habitaciones.id AS habitacion, " +
            "reservas.fecha_inicio, reservas.fecha_salida " +
            "FROM servicios " +
            "INNER JOIN consumos ON consumos.servicios_tipo = servicios.tipo " +
            "INNER JOIN habitaciones ON consumos.habitacion_id = habitaciones.id " +
            "INNER JOIN reservan ON habitaciones.id = reservan.habitacion_id " +
            "INNER JOIN reservas ON reservan.reservas_id = reservas.id " +
            "WHERE consumos.costo BETWEEN :costo_minimo AND :costo_maximo " +
            "AND reservas.fecha_inicio BETWEEN TO_DATE(:fecha_inicial, 'YYYY-MM-DD') AND TO_DATE(:fecha_final, 'YYYY-MM-DD') " +
            "AND servicios.tipo = :tipo_servicio", nativeQuery = true)
    Collection<RFC4Result> darServicioCiertaCaracteristica(
            @Param("costo_minimo") Double costoMinimo,
            @Param("costo_maximo") Double costoMaximo,
            @Param("fecha_inicial") String fechaInicial,
            @Param("fecha_final") String fechaFinal,
            @Param("tipo_servicio") String tipoServicio
    );
}

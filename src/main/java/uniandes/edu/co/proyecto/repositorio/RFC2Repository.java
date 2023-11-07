package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RFC2Repository extends JpaRepository<Object[], Integer> {

    @Query(value = "SELECT servicios.tipo AS servicio_tipo, COUNT(consumos.servicios_tipo) AS cantidad_consumos " +
            "FROM consumos " +
            "INNER JOIN habitaciones ON consumos.habitacion_id = habitaciones.id " +
            "INNER JOIN reservan ON habitaciones.id = reservan.habitacion_id " +
            "INNER JOIN servicios ON consumos.servicios_tipo = servicios.tipo " +
            "INNER JOIN reservas ON reservan.reservas_id = reservas.id " +
            "WHERE reservas.fecha_inicio BETWEEN TO_DATE(:fecha_inicial, 'YYYY-MM-DD') AND TO_DATE(:fecha_final, 'YYYY-MM-DD') " +
            "GROUP BY servicios.tipo " +
            "ORDER BY cantidad_consumos DESC " +
            "FETCH FIRST 20 ROWS ONLY", nativeQuery = true)
    Collection<Object[]> darRespuesta(@Param("fecha_inicial") String fechaInicial, @Param("fecha_final") String fechaFinal);
}

package uniandes.edu.co.proyecto.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.RFC2Result;

import java.util.Collection;
/*
    RFC2: MOSTRAR LOS 20 SERVICIOS MÁS POPULARES.
*/
public interface RFC2Repository extends JpaRepository<RFC2Result, String> {

    @Query(value = "SELECT servicios.tipo AS servicioTipo, COUNT(consumos.servicios_tipo) AS cantidadConsumos " +
            "FROM consumos " +
            "INNER JOIN habitaciones ON consumos.habitacion_id = habitaciones.id " +
            "INNER JOIN reservan ON habitaciones.id = reservan.habitacion_id " +
            "INNER JOIN servicios ON consumos.servicios_tipo = servicios.tipo " +
            "INNER JOIN reservas ON reservan.reservas_id = reservas.id " +
            "WHERE reservas.fecha_inicio BETWEEN TO_DATE(:fecha_inicial, 'YYYY-MM-DD') AND TO_DATE(:fecha_final, 'YYYY-MM-DD') " +
            "GROUP BY servicios.tipo " +
            "ORDER BY cantidadConsumos DESC " +
            "FETCH FIRST 20 ROWS ONLY", nativeQuery = true)
    Collection<RFC2Result> ServiciosMasPopulares(@Param("fecha_inicial") String fechaInicial, @Param("fecha_final") String fechaFinal);
}

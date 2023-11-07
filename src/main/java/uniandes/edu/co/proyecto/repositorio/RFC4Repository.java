package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RFC4Repository extends JpaRepository<Object[], Integer> {

    @Query(value = "SELECT * " +
            "FROM servicios " +
            "INNER JOIN consumos ON consumos.servicios_tipo = servicios.tipo " +
            "INNER JOIN habitaciones ON consumos.habitacion_id = habitaciones.id " +
            "INNER JOIN reservan ON habitaciones.id = reservan.habitacion_id " +
            "INNER JOIN reservas ON reservan.reservas_id = reservas.id " +
            "WHERE consumos.costo BETWEEN :costo_minimo AND :costo_maximo " +
            "AND reservas.fecha_inicio BETWEEN TO_DATE(:fecha_inicial, 'YYYY-MM-DD') AND TO_DATE(:fecha_final, 'YYYY-MM-DD') " +
            "AND servicios.tipo = :tipo_servicio", nativeQuery = true)
    Collection<Object[]> darRespuesta(
            @Param("costo_minimo") Double costoMinimo,
            @Param("costo_maximo") Double costoMaximo,
            @Param("fecha_inicial") String fechaInicial,
            @Param("fecha_final") String fechaFinal,
            @Param("tipo_servicio") String tipoServicio
    );
}

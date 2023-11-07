package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.Clientes;

public interface RFC10Repository extends JpaRepository<Clientes, Integer> {

    @Query(value = "SELECT clientes.nombre AS nombre_cliente, clientes.num_documento AS num_documento_cliente " +
            "FROM clientes " +
            "WHERE clientes.num_documento NOT IN (" +
            "SELECT DISTINCT reservas.usuarios_num_documento " +
            "FROM reservas " +
            "INNER JOIN reservan ON reservas.id = reservan.reservas_id " +
            "INNER JOIN consumos ON reservan.habitacion_id = consumos.habitacion_id " +
            "WHERE reservas.fecha_inicio BETWEEN TO_DATE(:fecha_inicial, 'YYYY-MM-DD') " +
            "AND TO_DATE(:fecha_final, 'YYYY-MM-DD')) " +
            "ORDER BY nombre_cliente", nativeQuery = true)
    Collection<Object[]> consultarConsumoHotelAndes(@Param("fecha_inicial") String fechaInicial, @Param("fecha_final") String fechaFinal);
}

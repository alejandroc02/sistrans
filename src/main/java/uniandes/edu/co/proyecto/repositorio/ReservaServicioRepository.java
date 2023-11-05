package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.ReservasServ;

import java.util.Collection;

public interface ReservaServicioRepository extends JpaRepository<ReservasServ, Integer> {

    // Obtener todas las reservas de servicio
    @Query(value = "SELECT * FROM reservas_serv", nativeQuery = true)
    Collection<ReservasServ> darReservasServicio();

    // Obtener una reserva de servicio con ID específico
    @Query(value = "SELECT * FROM reservas_serv WHERE id = :id", nativeQuery = true)
    ReservasServ darReservaServicio(@Param("id") int id);
    
    
}

package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ReservanPK {

    @ManyToOne
    @JoinColumn(name = "Reservas_id", referencedColumnName = "id")
    private Reservas Reservas_id;

    @ManyToOne
    @JoinColumn(name = "Habitaciones_id", referencedColumnName = "id")
    private Habitacion Habitacion_id;

    public ReservanPK(Reservas reservas_id, Habitacion habitacion_id) {
        super();
        Reservas_id = reservas_id;
        Habitacion_id = habitacion_id;
    }
    
    public ReservanPK() {
        super();
    }

    public Reservas getReservas_id() {
        return Reservas_id;
    }

    public void setReservas_id(Reservas reservas_id) {
        Reservas_id = reservas_id;
    }

    public Habitacion getHabitaciones_id() {
        return Habitacion_id;
    }

    public void setHabitaciones_id(Habitacion habitaciones_id) {
        Habitacion_id = habitaciones_id;
    }
    
}

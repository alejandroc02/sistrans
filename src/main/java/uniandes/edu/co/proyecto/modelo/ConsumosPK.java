package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ConsumosPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Habitaciones_id", referencedColumnName = "id")
    private Habitacion Habitacion_id;
    
    @ManyToOne
    @JoinColumn(name = "TIPOSSERVICIO_TIPO", referencedColumnName = "tipo")
    private Servicios servicioss_tipo;

    public ConsumosPK() {
        super();
    }

    public ConsumosPK(Habitacion habitacion_id, Servicios servicios_tipo) {
        super();
        Habitacion_id = habitacion_id;
        servicioss_tipo = servicios_tipo;
    }

    public Habitacion getHabitacion_id() {
        return Habitacion_id;
    }

    public void setHabitaciones_id(Habitacion habitacion_id) {
        Habitacion_id = habitacion_id;
    }

    public Servicios getservicios_tipo() {
        return servicioss_tipo;
    }

    public void settiposservicio_tipo(Servicios servicios_tipo) {
        servicioss_tipo = servicios_tipo;
    }

    

    

}

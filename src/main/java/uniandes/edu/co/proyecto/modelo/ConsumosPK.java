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
    @JoinColumn(name = "SERVICIOS_TIPO", referencedColumnName = "tipo")
    private Servicios servicios_tipo;


    public ConsumosPK(Habitacion habitacion_id, Servicios servicios_tipo) {
        super();
        this.Habitacion_id = habitacion_id;
        this.servicios_tipo = servicios_tipo;
    }


    public Habitacion getHabitacion_id() {
        return Habitacion_id;
    }


    public void setHabitacion_id(Habitacion habitacion_id) {
        Habitacion_id = habitacion_id;
    }


    public void setServicios_tipo(Servicios servicios_tipo) {
        this.servicios_tipo = servicios_tipo;
    }


    public Servicios getServicios_tipo() {
        return servicios_tipo;
    }


    

}

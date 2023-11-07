package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CheckOutsPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Reservas_id", referencedColumnName = "id")
    private Reservas Reservas_id;

    @ManyToOne
    @JoinColumn(name = "Habitaciones_id", referencedColumnName = "id")
    private Habitacion Habitacion_id;

    public CheckOutsPK(Reservas reservas_id, Habitacion habitacion_id) {
        super();
        Reservas_id = reservas_id;
        Habitacion_id = habitacion_id;
    }

    public CheckOutsPK() {
        super();
    }

    public Reservas getReservas_id() {
        return Reservas_id;
    }

    public void setReservas_id(Reservas reservas_id) {
        Reservas_id = reservas_id;
    }

    public Habitacion getHabitacion_id() {
        return Habitacion_id;
    }

    public void setHabitacion_id(Habitacion habitacion_id) {
        Habitacion_id = habitacion_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckOutsPK that = (CheckOutsPK) o;
        return Objects.equals(Reservas_id, that.Reservas_id) &&
                Objects.equals(Habitacion_id, that.Habitacion_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Reservas_id, Habitacion_id);
    }
}

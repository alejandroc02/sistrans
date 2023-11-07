package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Embeddable
public class ReservasSpaPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "Spas_id", referencedColumnName = "id")
    private Spas Spas_id;
    
    @ManyToOne
    @JoinColumn(name = "ReservasServ_id", referencedColumnName = "id")
    private ReservasServ ReservasServicio_id;

    public ReservasSpaPK() {
        super();
    }

    public ReservasSpaPK(Spas spas_id, ReservasServ reservasServicio_id) {
        super();
        this.Spas_id = spas_id;
        this.ReservasServicio_id = reservasServicio_id;
    }

    public Spas getSpas_id() {
        return Spas_id;
    }

    public void setSpas_id(Spas spas_id) {
        Spas_id = spas_id;
    }

    public ReservasServ getReservasServicio_id() {
        return ReservasServicio_id;
    }

    public void setReservasServicio_id(ReservasServ reservasServicio_id) {
        ReservasServicio_id = reservasServicio_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservasSpaPK that = (ReservasSpaPK) o;
        return Objects.equals(Spas_id, that.Spas_id) && Objects.equals(ReservasServicio_id, that.ReservasServicio_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Spas_id, ReservasServicio_id);
    }
}

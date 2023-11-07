package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ServReunionPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "Reservas_Serv_id", referencedColumnName = "id")
    private ReservasServ ReservasServicio_id;
    
    @ManyToOne
    @JoinColumn(name = "reuniones_id", referencedColumnName = "id")
    private Reunion reuniones_id;

    public ServReunionPK() {
        super();
    }

    public ServReunionPK(ReservasServ ReservasServico_id, Reunion reuniones_id) {
        super();
        this.ReservasServicio_id = ReservasServico_id;
        this.reuniones_id = reuniones_id;
    }

    public ReservasServ getReservasServicio_id() {
        return ReservasServicio_id;
    }

    public void setReservasServicio_id(ReservasServ reservasServicio_id) {
        this.ReservasServicio_id = reservasServicio_id;
    }

    public Reunion getreuniones_id() {
        return reuniones_id;
    }

    public void setreuniones_id(Reunion reuniones_id) {
        this.reuniones_id = reuniones_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServReunionPK that = (ServReunionPK) o;
        return Objects.equals(ReservasServicio_id, that.ReservasServicio_id) &&
               Objects.equals(reuniones_id, that.reuniones_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ReservasServicio_id, reuniones_id);
    }
}

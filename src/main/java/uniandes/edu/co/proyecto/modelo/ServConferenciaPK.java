package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Embeddable
public class ServConferenciaPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "ReservasSer_id", referencedColumnName = "id")
    private ReservasServ ReservasServicio_id;
    
    @ManyToOne
    @JoinColumn(name = "Conferencia_id", referencedColumnName = "id")
    private Conferencia SalonesConferencia_id;

    public ServConferenciaPK() {
        super();
    }

    public ServConferenciaPK(ReservasServ ReservasServico_id, Conferencia SalonesConferencia_id) {
        super();
        this.ReservasServicio_id = ReservasServico_id;
        this.SalonesConferencia_id = SalonesConferencia_id;
    }

    public ReservasServ getReservasServicio_id() {
        return ReservasServicio_id;
    }

    public void setReservasServicio_id(ReservasServ reservasServicio_id) {
        ReservasServicio_id = reservasServicio_id;
    }

    public Conferencia getSalonesConferencia_id() {
        return SalonesConferencia_id;
    }

    public void setSalonesConferencia_id(Conferencia salonesConferencia_id) {
        SalonesConferencia_id = salonesConferencia_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServConferenciaPK that = (ServConferenciaPK) o;
        return Objects.equals(ReservasServicio_id, that.ReservasServicio_id) && Objects.equals(SalonesConferencia_id, that.SalonesConferencia_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ReservasServicio_id, SalonesConferencia_id);
    }
}

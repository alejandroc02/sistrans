package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ServReunionPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "ReservasServicio_id", referencedColumnName = "id")
    private ReservasServ ReservasServicio_id;
    
    @ManyToOne
    @JoinColumn(name = "SalonesReunion_id", referencedColumnName = "id")
    private Reunion SalonesReunion_id;

    public ServReunionPK() {
        super();
    }

    public ServReunionPK(ReservasServ ReservasServico_id, Reunion SalonesReunion_id) {
        super();
        this.ReservasServicio_id = ReservasServico_id;
        this.SalonesReunion_id = SalonesReunion_id;
    }

    public ReservasServ getReservasServicio_id() {
        return ReservasServicio_id;
    }

    public void setReservasServicio_id(ReservasServ reservasServicio_id) {
        ReservasServicio_id = reservasServicio_id;
    }

    public Reunion getSalonesReunion_id() {
        return SalonesReunion_id;
    }

    public void setSalonesReunion_id(Reunion salonesReunion_id) {
        SalonesReunion_id = salonesReunion_id;
    }



}
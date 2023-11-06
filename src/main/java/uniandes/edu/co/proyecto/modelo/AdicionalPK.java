package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class AdicionalPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "Reuniones_id", referencedColumnName = "id")
    private Reunion Reunion_id;
    
    @ManyToOne
    @JoinColumn(name = "Equipos_id", referencedColumnName = "id")
    private Equipos Equipos_id;


    public AdicionalPK() {
        super();
    }


    public AdicionalPK(Reunion reunion_id, Equipos equipos_id) {
        super();
        Reunion_id = reunion_id;
        Equipos_id = equipos_id;
    }


    public Reunion getReunion_id() {
        return Reunion_id;
    }


    public void setReunion_id(Reunion reunion_id) {
        Reunion_id = reunion_id;
    }


    public Equipos getEquipos_id() {
        return Equipos_id;
    }


    public void setEquipos_id(Equipos equipos_id) {
        Equipos_id = equipos_id;
    }

    

}

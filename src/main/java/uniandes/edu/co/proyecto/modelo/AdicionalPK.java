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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdicionalPK that = (AdicionalPK) o;

        if (Reunion_id != null ? !Reunion_id.equals(that.Reunion_id) : that.Reunion_id != null) return false;
        return Equipos_id != null ? Equipos_id.equals(that.Equipos_id) : that.Equipos_id == null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Reunion_id == null) ? 0 : Reunion_id.hashCode());
        result = prime * result + ((Equipos_id == null) ? 0 : Equipos_id.hashCode());
        return result;
    }
}

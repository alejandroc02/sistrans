package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GratisPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Conferencia_id", referencedColumnName = "id")
    private Conferencia conferencia_id;

    @ManyToOne
    @JoinColumn(name = "Equipos_id", referencedColumnName = "id")
    private Equipos Equipos_id;

    public GratisPK() {
        super();
    }

    public GratisPK(Conferencia conferencia_id, Equipos equipos_id) {
        super();
        this.conferencia_id = conferencia_id;
        this.Equipos_id = equipos_id;
    }

    public Conferencia getConferencia_id() {
        return conferencia_id;
    }

    public void setConferencia_id(Conferencia conferencia_id) {
        this.conferencia_id = conferencia_id;
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
        GratisPK gratisPK = (GratisPK) o;
        return Objects.equals(conferencia_id, gratisPK.conferencia_id) &&
                Objects.equals(Equipos_id, gratisPK.Equipos_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conferencia_id, Equipos_id);
    }
}

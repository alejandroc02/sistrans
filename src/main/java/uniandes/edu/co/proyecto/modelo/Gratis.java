package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "gratis")
public class Gratis {
    @EmbeddedId
    private GratisPK pk;

    public Gratis() {
        ;
    }

    public Gratis(Conferencia salonesConferencia_id, Equipos equipos_id) {
        this.pk = new GratisPK(salonesConferencia_id, equipos_id);
    }

    public GratisPK getPk() {
        return pk;
    }

    public void setPk(GratisPK pk) {
        this.pk = pk;
    }
    
}

package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservassalonreunion")
public class ServReunion {

    @EmbeddedId
    private ServReunionPK pk;

    public ServReunion() {
        ;
    }

    public ServReunion(ReservasServ ReservasServico_id, Reunion SalonesReunion_id) {
        this.pk = new ServReunionPK(ReservasServico_id, SalonesReunion_id);
    }

    public ServReunionPK getPk() {
        return pk;
    }

    public void setPk(ServReunionPK pk) {
        this.pk = pk;
    }
    
}

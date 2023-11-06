package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "serv_conferencia")
public class ServConferencia {

    @EmbeddedId
    private ServConferenciaPK pk;

    public ServConferencia() {
        ;
    }

    public ServConferencia(ReservasServ ReservasServico_id, Conferencia SalonesConferencia_id) {
        this.pk = new ServConferenciaPK(ReservasServico_id, SalonesConferencia_id);
    }

    public ServConferenciaPK getPk() {
        return pk;
    }

    public void setPk(ServConferenciaPK pk) {
        this.pk = pk;
    }
    
}

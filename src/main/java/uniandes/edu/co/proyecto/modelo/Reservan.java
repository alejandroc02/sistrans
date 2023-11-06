package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservan")
public class Reservan {
    
    @EmbeddedId
    private ReservanPK pk;

    

    public Reservan(Habitacion Habitacion_id, Reservas Reservas_id) {
        this.pk = new ReservanPK(Reservas_id, Habitacion_id);
       
    }

    public Reservan() {
        ;
    }

    public ReservanPK getPk() {
        return pk;
    }

    public void setPk(ReservanPK pk) {
        this.pk = pk;
    }

    

    
    
}
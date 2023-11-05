package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "adicional")
public class Adicional {

    @EmbeddedId
    private AdicionalPK pk;

    private double costo;

    public Adicional() {
        ;
    }

    public Adicional(Reunion salonesReunion_id, Equipos equipos_id, double costo) {
        this.pk = new AdicionalPK(salonesReunion_id, equipos_id);
        this.costo = costo;
    }

    public AdicionalPK getPk() {
        return pk;
    }

    public void setPk(AdicionalPK pk) {
        this.pk = pk;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    
    
}

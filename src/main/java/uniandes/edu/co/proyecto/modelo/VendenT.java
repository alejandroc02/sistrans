package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendent")
public class VendenT {

    @EmbeddedId
    private VendenTPK pk;

    public VendenT() {
        ;
    }

    public VendenT(Tiendas tiendas_id, ProductosT productosTienda_id) {
        this.pk = new VendenTPK(tiendas_id, productosTienda_id);
    }

    public VendenTPK getPk() {
        return pk;
    }

    public void setPk(VendenTPK pk) {
        this.pk = pk;
    }
    
}

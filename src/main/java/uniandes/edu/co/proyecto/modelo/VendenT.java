package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendentienda")
public class VendenT {

    @EmbeddedId
    private VendenTiendaPK pk;

    public VendenT() {
        ;
    }

    public VendenT(Tiendas tiendas_id, ProductosTienda productosTienda_id) {
        this.pk = new VendenTiendaPK(tiendas_id, productosTienda_id);
    }

    public VendenTiendaPK getPk() {
        return pk;
    }

    public void setPk(VendenTiendaPK pk) {
        this.pk = pk;
    }
    
}

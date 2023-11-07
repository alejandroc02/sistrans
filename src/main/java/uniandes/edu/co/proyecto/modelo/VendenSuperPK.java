package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Embeddable
public class VendenSuperPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "Supermercados_id", referencedColumnName = "id")
    private Supermercados Supermercados_id;
    
    @ManyToOne
    @JoinColumn(name = "Productos_Super_id", referencedColumnName = "id")
    private ProductosSuper ProductosSuper_id;

    public VendenSuperPK() {
        super();
    }

    public VendenSuperPK(Supermercados supermercados_id, ProductosSuper productosSuper_id) {
        super();
        Supermercados_id = supermercados_id;
        ProductosSuper_id = productosSuper_id;
    }

    public Supermercados getSupermercados_id() {
        return Supermercados_id;
    }

    public void setSupermercados_id(Supermercados supermercados_id) {
        Supermercados_id = supermercados_id;
    }

    public ProductosSuper getProductosSuper_id() {
        return ProductosSuper_id;
    }

    public void setProductosSuper_id(ProductosSuper productosSuper_id) {
        ProductosSuper_id = productosSuper_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendenSuperPK that = (VendenSuperPK) o;
        return Objects.equals(Supermercados_id, that.Supermercados_id) && Objects.equals(ProductosSuper_id, that.ProductosSuper_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Supermercados_id, ProductosSuper_id);
    }
}

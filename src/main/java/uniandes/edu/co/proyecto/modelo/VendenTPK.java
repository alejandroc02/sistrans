package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Embeddable
public class VendenTPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "Tiendas_id", referencedColumnName = "id")
    private Tiendas Tiendas_id;
    
    @ManyToOne
    @JoinColumn(name = "Productos_T_id", referencedColumnName = "id")
    private ProductosT ProductosTienda_id;

    public VendenTPK() {
        super();
    }

    public VendenTPK(Tiendas tiendas_id, ProductosT productosTienda_id) {
        super();
        Tiendas_id = tiendas_id;
        ProductosTienda_id = productosTienda_id;
    }

    public Tiendas getTiendas_id() {
        return Tiendas_id;
    }

    public void setTiendas_id(Tiendas tiendas_id) {
        Tiendas_id = tiendas_id;
    }

    public ProductosT getProductosTienda_id() {
        return ProductosTienda_id;
    }

    public void setProductosTienda_id(ProductosT productosTienda_id) {
        ProductosTienda_id = productosTienda_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendenTPK that = (VendenTPK) o;
        return Objects.equals(Tiendas_id, that.Tiendas_id) && Objects.equals(ProductosTienda_id, that.ProductosTienda_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Tiendas_id, ProductosTienda_id);
    }
}

package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Embeddable
public class Sirven_resPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "Restaurantes_id", referencedColumnName = "id")
    private Restaurantes Restaurantes_id;
    
    @ManyToOne
    @JoinColumn(name = "ProductosRes_id", referencedColumnName = "id")
    private ProductosRes ProductosRestaurante_id;

    public Sirven_resPK() {
        super();
    }

    public Sirven_resPK(Restaurantes restaurantes_id, ProductosRes productosRestaurante_id) {
        super();
        Restaurantes_id = restaurantes_id;
        ProductosRestaurante_id = productosRestaurante_id;
    }

    public Restaurantes getRestaurantes_id() {
        return Restaurantes_id;
    }

    public void setRestaurantes_id(Restaurantes restaurantes_id) {
        Restaurantes_id = restaurantes_id;
    }

    public ProductosRes getProductosRestaurante_id() {
        return ProductosRestaurante_id;
    }

    public void setProductosRestaurante_id(ProductosRes productosRestaurante_id) {
        ProductosRestaurante_id = productosRestaurante_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sirven_resPK that = (Sirven_resPK) o;
        return Objects.equals(Restaurantes_id, that.Restaurantes_id) && Objects.equals(ProductosRestaurante_id, that.ProductosRestaurante_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Restaurantes_id, ProductosRestaurante_id);
    }
}

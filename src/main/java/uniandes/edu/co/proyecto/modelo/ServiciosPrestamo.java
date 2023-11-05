package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "serviciosprestamo")
public class ServiciosPrestamo {
    @Id
    private int id;

    private int cantidad;
    private boolean devuelto;

    @ManyToOne
    @JoinColumn(name = "Servicios_tipo", referencedColumnName = "tipo")
    private Servicios Servicios_tipo;

    public ServiciosPrestamo() {
        ;
    }

    public ServiciosPrestamo(int id, int cantidad, boolean devuelto, Servicios servicios_tipo) {
        this.id = id;
        this.cantidad = cantidad;
        this.devuelto = devuelto;
        Servicios_tipo = servicios_tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    public Servicios getServicios_tipo() {
        return Servicios_tipo;
    }

    public void setTiposServicio_tipo(Servicios servicios_tipo) {
        Servicios_tipo= servicios_tipo;
    }

    

    
}

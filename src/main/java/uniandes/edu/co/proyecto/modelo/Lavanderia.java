package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lavanderia")
public class Lavanderia {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "Servicios_tipo", referencedColumnName = "tipo")
    private Servicios Servicios_tipo;

    private String tipo_prenda;
    private int cantidad_prendas;
    private double costo;

    public Lavanderia() {
        ;
    }

    public Lavanderia(int id, Servicios servicios_tipo, String tipo_prenda, int cantidad_prendas,
            double costo) {
        this.id = id;
        Servicios_tipo = servicios_tipo;
        this.tipo_prenda = tipo_prenda;
        this.cantidad_prendas = cantidad_prendas;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Servicios getServiciostipo() {
        return Servicios_tipo;
    }

    public void setTiposServicio_tipo(Servicios servicios_tipo) {
        Servicios_tipo = servicios_tipo;
    }

    public String getTipo_prenda() {
        return tipo_prenda;
    }

    public void setTipo_prenda(String tipo_prenda) {
        this.tipo_prenda = tipo_prenda;
    }

    public int getCantidad_prendas() {
        return cantidad_prendas;
    }

    public void setCantidad_prendas(int cantidad_prendas) {
        this.cantidad_prendas = cantidad_prendas;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }



    

}
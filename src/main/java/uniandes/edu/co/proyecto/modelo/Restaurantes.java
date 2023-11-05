package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurantes")
public class Restaurantes {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "TiposServicio_tipo", referencedColumnName = "tipo")
    private Servicios Servicios_tipo;

    private String estilo;
    private int capacidad;

    public Restaurantes() {
        ;
    }

    public Restaurantes(int id, Servicios servicios_tipo, String estilo, int capacidad) {
        this.id = id;
        Servicios_tipo = servicios_tipo;
        this.estilo = estilo;
        this.capacidad = capacidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Servicios getServicios_tipo() {
        return Servicios_tipo;
    }

    public void setTiposServicio_tipo(Servicios servicios_tipo) {
        Servicios_tipo = servicios_tipo;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    

}
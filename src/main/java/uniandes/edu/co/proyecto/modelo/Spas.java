package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "spas")
public class Spas {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Servicios_tipo", referencedColumnName = "tipo")
    private Servicios Servicios_tipo;

    private int capacidad;

    public Spas() {
        ;
    }

    public Spas(int id, Servicios servicios_tipo, int capacidad) {
        this.id = id;
        this.Servicios_tipo = servicios_tipo;
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
        this.Servicios_tipo= servicios_tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }


}
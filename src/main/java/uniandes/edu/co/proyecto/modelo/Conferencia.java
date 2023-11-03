package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "conferencia")
public class Conferencia {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "Servicios_tipo", referencedColumnName = "tipo")
    private Servicios Servicios_tipo;

    private int capacidad;
    private double costo_hora;

    public Conferencia() {
        ;
    }

    public Conferencia(int id, Servicios servicios_tipo, int capacidad, double costo_hora) {
        this.id = id;
        Servicios_tipo = servicios_tipo;
        this.capacidad = capacidad;
        this.costo_hora = costo_hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Servicios getTiposServicio_tipo() {
        return Servicios_tipo;
    }

    public void setTiposServicio_tipo(Servicios servicios_tipo) {
       Servicios_tipo = servicios_tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getCosto_hora() {
        return costo_hora;
    }

    public void setCosto_hora(double costo_hora) {
        this.costo_hora = costo_hora;
    }



    

}

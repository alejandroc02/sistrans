package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "internets")
public class Internets {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ManyToOne
    @JoinColumn(name = "Servicios_tipo", referencedColumnName = "tipo")
    private Servicios Servicios_tipo;
    private int id;
    private int capacidad;
    private double costo_dia;

    public Internets() {
        ;
    }

    public Internets(int id, Servicios servicios_tipo, int capacidad, double costo_dia) {
        this.id = id;
        this.Servicios_tipo = servicios_tipo;
        this.capacidad = capacidad;
        this.costo_dia = costo_dia;
    }

    public Servicios getServicios_tipo() {
        return Servicios_tipo;
    }

    public int getId() {
        return id;
    }

    public void setServicios_tipo(Servicios servicios_tipo) {
        Servicios_tipo = servicios_tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setCosto_dia(double costo_dia) {
        this.costo_dia = costo_dia;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getCosto_dia() {
        return costo_dia;
    }


    

}
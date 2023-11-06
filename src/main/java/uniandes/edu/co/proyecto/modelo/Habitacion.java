package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitacion")
public class Habitacion {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private int capacidad;
    private double costo;

    @ManyToOne
    @JoinColumn(name = "TIPOHAB_TIPO", referencedColumnName = "tipo")
    private Tipohab tipohab_tipo;

    public Habitacion() {
        ;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setTipohab_tipo(Tipohab tipohab_tipo) {
        this.tipohab_tipo = tipohab_tipo;
    }

    public Habitacion(int id, int capacidad, double costo, Tipohab tipohab_tipo) {
        this.id = id;
        this.capacidad = capacidad;
        this.costo = costo;
        this.tipohab_tipo = tipohab_tipo;
    }

    public int getId() {
        return id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getCosto() {
        return costo;
    }

    public Tipohab getTipohab_tipo() {
        return tipohab_tipo;
    }

  

}

package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "conferencia")
public class Conferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @ManyToOne
    @JoinColumn(name = "Servicios", referencedColumnName = "tipo")
    private Servicios Servicios;

    private int id;
    private int capacidad;
    private double costo_hora;

    public Conferencia(int id, Servicios servicios, int capacidad, double costo_hora) {
        this.id = id;
        this.Servicios = servicios;
        this.capacidad = capacidad;
        this.costo_hora = costo_hora;
    }

    public int getId() {
        return id;
    }

    public Servicios getServicios() {
        return Servicios;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setServicios(Servicios servicios) {
        Servicios = servicios;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setCosto_hora(double costo_hora) {
        this.costo_hora = costo_hora;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getCosto_hora() {
        return costo_hora;
    }

    public Conferencia() {
        ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conferencia that = (Conferencia) o;
        return id == that.id &&
                capacidad == that.capacidad &&
                Double.compare(that.costo_hora, costo_hora) == 0 &&
                Objects.equals(Servicios, that.Servicios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Servicios, id, capacidad, costo_hora);
    }
}

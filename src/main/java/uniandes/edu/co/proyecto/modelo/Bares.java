package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bares")
public abstract class Bares {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "Servicios", referencedColumnName = "tipo")
    private Servicios servicios;
    private int capacidad;
    private String estilo;

    public Bares() {
        ;
    }

    public Bares(int id, Servicios servicios, int capacidad, String estilo) {
        this.id = id;
        this.servicios= servicios;
        this.capacidad = capacidad;
        this.estilo = estilo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public Servicios getServicios() {
        return servicios;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getEstilo() {
        return estilo;
    }

 
    

}
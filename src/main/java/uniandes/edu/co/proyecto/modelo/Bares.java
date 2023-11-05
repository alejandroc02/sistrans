package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bares")
public class Bares {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "Servicios_tipo", referencedColumnName = "tipo")
    private Servicios Servicios_tipo;

    private int capacidad;
    private String estilo;

    public Bares() {
        ;
    }

    public Bares(int id, Servicios servicios_tipo, int capacidad, String estilo) {
        this.id = id;
        Servicios_tipo = servicios_tipo;
        this.capacidad = capacidad;
        this.estilo = estilo;
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

    public void setServicios_tipo(Servicios servicios_tipo) {
        Servicios_tipo = servicios_tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }



    

}
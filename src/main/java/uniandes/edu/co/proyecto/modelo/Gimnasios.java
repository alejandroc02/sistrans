package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gimnasios")
public class Gimnasios {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Servicios_tipo", referencedColumnName = "tipo")
    private Servicios Servicios_tipo;

    private int capacidad;
    private String hora_inicio;
    private String hora_fin;

    public Gimnasios() {
        ;
    }

    public Gimnasios(int id, Servicios Servicios_tipo, int capacidad, String hora_inicio, String hora_fin) {
        this.id = id;
        this.Servicios_tipo = Servicios_tipo;
        this.capacidad = capacidad;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setServicios_tipo(Servicios servicios_tipo) {
        Servicios_tipo = servicios_tipo;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public int getId() {
        return id;
    }

    public Servicios getServicios_tipo() {
        return Servicios_tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }


}

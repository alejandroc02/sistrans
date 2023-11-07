package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RFC8Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String tipoServicio;
    private Double solicitudesSemanales;

    public RFC8Result(String tipoServicio, Double solicitudesSemanales) {
        this.tipoServicio = tipoServicio;
        this.solicitudesSemanales = solicitudesSemanales;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public Double getSolicitudesSemanales() {
        return solicitudesSemanales;
    }
}

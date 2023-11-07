package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RFC2Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String servicioTipo;
    private Long cantidadConsumos;


    public RFC2Result(String servicioTipo, Long cantidadConsumos) {
        this.servicioTipo = servicioTipo;
        this.cantidadConsumos = cantidadConsumos;
    }


    public String getServicioTipo() {
        return servicioTipo;
    }

    public void setServicioTipo(String servicioTipo) {
        this.servicioTipo = servicioTipo;
    }

    public Long getCantidadConsumos() {
        return cantidadConsumos;
    }

    public void setCantidadConsumos(Long cantidadConsumos) {
        this.cantidadConsumos = cantidadConsumos;
    }
}

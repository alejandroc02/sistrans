package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RFC5Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nombreCliente;
    private Integer reservaId;
    private Double totalConsumo;

    public RFC5Result(String nombreCliente, Integer reservaId, Double totalConsumo) {
        this.nombreCliente = nombreCliente;
        this.reservaId = reservaId;
        this.totalConsumo = totalConsumo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Integer getReservaId() {
        return reservaId;
    }

    public void setReservaId(Integer reservaId) {
        this.reservaId = reservaId;
    }

    public Double getTotalConsumo() {
        return totalConsumo;
    }

    public void setTotalConsumo(Double totalConsumo) {
        this.totalConsumo = totalConsumo;
    }
}

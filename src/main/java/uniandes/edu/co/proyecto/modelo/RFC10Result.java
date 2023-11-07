package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RFC10Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nombreCliente;
    private Integer numDocumentoCliente;

    public RFC10Result(String nombreCliente, Integer numDocumentoCliente) {
        this.nombreCliente = nombreCliente;
        this.numDocumentoCliente = numDocumentoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public Integer getNumDocumentoCliente() {
        return numDocumentoCliente;
    }
}

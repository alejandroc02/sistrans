package uniandes.edu.co.proyecto.modelo;

public class RFC10Result {
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

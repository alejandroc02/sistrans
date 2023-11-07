package uniandes.edu.co.proyecto.modelo;

public class RFC7Result {
    private String nombreCliente;
    private String correoCliente;
    private Long totalDiasEstadia;
    private Double totalConsumos;

    public RFC7Result(String nombreCliente, String correoCliente, Long totalDiasEstadia, Double totalConsumos) {
        this.nombreCliente = nombreCliente;
        this.correoCliente = correoCliente;
        this.totalDiasEstadia = totalDiasEstadia;
        this.totalConsumos = totalConsumos;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public Long getTotalDiasEstadia() {
        return totalDiasEstadia;
    }

    public Double getTotalConsumos() {
        return totalConsumos;
    }
}

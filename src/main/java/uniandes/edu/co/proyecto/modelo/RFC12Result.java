package uniandes.edu.co.proyecto.modelo;

public class RFC12Result {
    private Integer numeroDocumento;
    private String nombreCliente;
    private String correoCliente;
    private Double gastos;

    public RFC12Result(Integer numeroDocumento, String nombreCliente, String correoCliente, Double gastos) {
        this.numeroDocumento = numeroDocumento;
        this.nombreCliente = nombreCliente;
        this.correoCliente = correoCliente;
        this.gastos = gastos;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public Double getGastos() {
        return gastos;
    }
}

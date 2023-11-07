package uniandes.edu.co.proyecto.modelo;

public class RFC8Result {
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

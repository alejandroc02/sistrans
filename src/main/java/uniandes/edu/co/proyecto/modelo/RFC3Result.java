package uniandes.edu.co.proyecto.modelo;

public class RFC3Result {
    private Long habitacionId;
    private Long capacidadHabitacion;
    private Long totalReservas;
    private Long totalDiasOcupados;
    private Double porcentajeOcupacion;

    public Long getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(Long habitacionId) {
        this.habitacionId = habitacionId;
    }

    public Long getCapacidadHabitacion() {
        return capacidadHabitacion;
    }

    public void setCapacidadHabitacion(Long capacidadHabitacion) {
        this.capacidadHabitacion = capacidadHabitacion;
    }

    public Long getTotalReservas() {
        return totalReservas;
    }

    public void setTotalReservas(Long totalReservas) {
        this.totalReservas = totalReservas;
    }

    public Long getTotalDiasOcupados() {
        return totalDiasOcupados;
    }

    public void setTotalDiasOcupados(Long totalDiasOcupados) {
        this.totalDiasOcupados = totalDiasOcupados;
    }

    public Double getPorcentajeOcupacion() {
        return porcentajeOcupacion;
    }

    public void setPorcentajeOcupacion(Double porcentajeOcupacion) {
        this.porcentajeOcupacion = porcentajeOcupacion;
    }
}

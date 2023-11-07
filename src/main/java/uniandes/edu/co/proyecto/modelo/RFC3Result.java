package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RFC3Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long habitacionId;
    private Long capacidadHabitacion;
    private Long totalReservas;
    private Long totalDiasOcupados;
    private Double porcentajeOcupacion;


    public RFC3Result(
        Long habitacionId,
        Long capacidadHabitacion,
        Long totalReservas,
        Long totalDiasOcupados,
        Double porcentajeOcupacion
    ) {
        this.habitacionId = habitacionId;
        this.capacidadHabitacion = capacidadHabitacion;
        this.totalReservas = totalReservas;
        this.totalDiasOcupados = totalDiasOcupados;
        this.porcentajeOcupacion = porcentajeOcupacion;
    }

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

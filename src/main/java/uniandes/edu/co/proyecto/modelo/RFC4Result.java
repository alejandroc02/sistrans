package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RFC4Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String servicio;
    private Double costo;
    private String habitacion;
    private String fechaInicio;
    private String fechaFinal;

    public RFC4Result(
        String servicio,
        Double costo,
        String habitacion,
        String fechaInicio,
        String fechaFinal
    ) {
        this.servicio = servicio;
        this.costo = costo;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
}

package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RFC11Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String semana;
    private String servicioMasConsumido;
    private String servicioMenosConsumido;
    private Integer habitacionMasSolicitada;
    private Integer habitacionMenosSolicitada;

    public RFC11Result(String semana, String servicioMasConsumido, String servicioMenosConsumido, Integer habitacionMasSolicitada, Integer habitacionMenosSolicitada) {
        this.semana = semana;
        this.servicioMasConsumido = servicioMasConsumido;
        this.servicioMenosConsumido = servicioMenosConsumido;
        this.habitacionMasSolicitada = habitacionMasSolicitada;
        this.habitacionMenosSolicitada = habitacionMenosSolicitada;
    }

    public String getSemana() {
        return semana;
    }

    public String getServicioMasConsumido() {
        return servicioMasConsumido;
    }

    public String getServicioMenosConsumido() {
        return servicioMenosConsumido;
    }

    public Integer getHabitacionMasSolicitada() {
        return habitacionMasSolicitada;
    }

    public Integer getHabitacionMenosSolicitada() {
        return habitacionMenosSolicitada;
    }
}

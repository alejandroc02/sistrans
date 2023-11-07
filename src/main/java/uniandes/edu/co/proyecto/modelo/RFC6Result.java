package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RFC6Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date fecha;
    private Long habitacionesOcupadas;
    private long ingresos;

    public RFC6Result(Date fecha, Long habitacionesOcupadas, long ingresos) {
        this.fecha = fecha;
        this.habitacionesOcupadas = habitacionesOcupadas;
        this.ingresos = ingresos;
    }

    public Date getFecha() {
        return fecha;
    }

    public Long getHabitacionesOcupadas() {
        return habitacionesOcupadas;
    }

    public long getIngresos() {
        return ingresos;
    }
}

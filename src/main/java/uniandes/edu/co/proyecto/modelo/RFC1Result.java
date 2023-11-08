package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RFC1Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long habitacionId;
    private String servicio;
    private long dineroRecolectado;

    public RFC1Result(long habitacionId, String servicio, long dineroRecolectado) {
        this.habitacionId = habitacionId;
        this.servicio = servicio;
        this.dineroRecolectado = dineroRecolectado;
    }

    public Long getHabitacionId() {
        return habitacionId;
    }
    public String getServicio() {
        return servicio;
    }
    public long getDineroRecolectado() {
        return dineroRecolectado;
    }
    public void setHabitacionId(Long habitacionId) {
        this.habitacionId = habitacionId;
    }
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    public void setDineroRecolectado(long dineroRecolectado) {
        this.dineroRecolectado = dineroRecolectado;
    }
}

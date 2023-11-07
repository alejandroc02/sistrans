package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RFC1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long habitacionId;

    private String servicio;
    
    private long dineroRecolectado;

    public RFC1(long habitacionId, String servicio, long dineroRecolectado) {
        this.habitacionId = habitacionId;
        this.servicio = servicio;
        this.dineroRecolectado = dineroRecolectado;
    }

    public long getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(long habitacionId) {
        this.habitacionId = habitacionId;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public long getDineroRecolectado() {
        return dineroRecolectado;
    }

    public void setDineroRecolectado(long dineroRecolectado) {
        this.dineroRecolectado = dineroRecolectado;
    }

    

    
}

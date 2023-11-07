package uniandes.edu.co.proyecto.modelo;

import java.math.BigDecimal;

public class RFC1Result {
    private Long habitacionId;
    private String servicio;
    private BigDecimal dineroRecolectado;
    public Long getHabitacionId() {
        return habitacionId;
    }
    public String getServicio() {
        return servicio;
    }
    public BigDecimal getDineroRecolectado() {
        return dineroRecolectado;
    }
    public void setHabitacionId(Long habitacionId) {
        this.habitacionId = habitacionId;
    }
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    public void setDineroRecolectado(BigDecimal dineroRecolectado) {
        this.dineroRecolectado = dineroRecolectado;
    }
}

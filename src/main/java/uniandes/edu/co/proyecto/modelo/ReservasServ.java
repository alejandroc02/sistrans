package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservasServ")
public class ReservasServ {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private int duracion_hora;
    private Date dia;
    private String hora;
    @ManyToOne
    @JoinColumn(name = "habitacion_id", referencedColumnName = "id")
    private Habitacion Habitacion_id;

    public ReservasServ() {
        ;
    }

    public ReservasServ(int id, int duracion_hora, Date dia, String hora, Habitacion habitacion_id) {
        this.id = id;
        this.duracion_hora = duracion_hora;
        this.dia = dia;
        this.hora = hora;
        this.Habitacion_id = habitacion_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuracion_hora() {
        return duracion_hora;
    }

    public void setDuracion_hora(int duracion_hora) {
        this.duracion_hora = duracion_hora;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Habitacion getHabitacion_id() {
        return Habitacion_id;
    }

    public void setHabitaciones_id(Habitacion habitacion_id) {
        this.Habitacion_id = habitacion_id;
    }

    

    

}

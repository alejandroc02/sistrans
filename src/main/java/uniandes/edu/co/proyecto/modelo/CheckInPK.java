package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;

@Embeddable
public class CheckInPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Reservas_id", referencedColumnName = "id")
    private Reservas Reservas_id;

    @ManyToOne
    
    @JoinColumn(name = "Usuarios_num_documento", referencedColumnName = "num_documento")
    private Clientes clientes_num_documento;


    public CheckInPK(Reservas reservas_id, Clientes clientes_num_documento2 ) {
        super();
        this.Reservas_id = reservas_id;
        this.clientes_num_documento = clientes_num_documento2;
    }

    public Reservas getReservas_id() {
        return Reservas_id;
    }

    public void setReservas_id(Reservas reservas_id) {
        Reservas_id = reservas_id;
    }

    public Clientes getclientesPK() {
        return clientes_num_documento;
    }

    public void setclientesPK(Clientes clientes_num_documento) {
        this.clientes_num_documento = clientes_num_documento;
    } 

}

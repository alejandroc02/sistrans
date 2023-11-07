package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CheckInPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Reservas_id", referencedColumnName = "id")
    private Reservas Reservas_id;

    @ManyToOne
    @JoinColumn(name = "Usuarios_num_documento", referencedColumnName = "num_documento")
    private Clientes clientes_num_documento;

    public CheckInPK() {
        super();
    }

    public CheckInPK(Reservas reservas_id, Clientes clientes_num_documento2) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckInPK checkInPK = (CheckInPK) o;
        return Objects.equals(Reservas_id, checkInPK.Reservas_id) &&
               Objects.equals(clientes_num_documento, checkInPK.clientes_num_documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Reservas_id, clientes_num_documento);
    }
}

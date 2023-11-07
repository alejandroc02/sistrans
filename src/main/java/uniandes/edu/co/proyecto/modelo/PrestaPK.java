package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PrestaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ServiciosPrestamo_id", referencedColumnName = "id")
    private ServiciosPrestamo ServiciosPrestamo_id;

    @ManyToOne
    @JoinColumn(name = "Utensilios_id", referencedColumnName = "id")
    private Utensilios Utensilios_id;

    public PrestaPK() {
        super();
    }

    public PrestaPK(ServiciosPrestamo serviciosPrestamo_id, Utensilios utensilios_id) {
        ServiciosPrestamo_id = serviciosPrestamo_id;
        Utensilios_id = utensilios_id;
    }

    public ServiciosPrestamo getServiciosPrestamo_id() {
        return ServiciosPrestamo_id;
    }

    public void setServiciosPrestamo_id(ServiciosPrestamo serviciosPrestamo_id) {
        ServiciosPrestamo_id = serviciosPrestamo_id;
    }

    public Utensilios getUtensilios_id() {
        return Utensilios_id;
    }

    public void setUtensilios_id(Utensilios utensilios_id) {
        Utensilios_id = utensilios_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrestaPK prestaPK = (PrestaPK) o;
        return Objects.equals(ServiciosPrestamo_id, prestaPK.ServiciosPrestamo_id) &&
                Objects.equals(Utensilios_id, prestaPK.Utensilios_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ServiciosPrestamo_id, Utensilios_id);
    }
}

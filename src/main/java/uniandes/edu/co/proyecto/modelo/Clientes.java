package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Clientes {

    @EmbeddedId
    private ClientesPK pk;

    private String nombre;
    private String correo;

    public Clientes(String tipo_documento, int num_documento, String nombre, String correo) {
        this.pk = new ClientesPK(tipo_documento, num_documento);
        this.nombre = nombre;
        this.correo = correo;
    }

    public Clientes() {
        ;
    }

    public ClientesPK getPk() {
        return pk;
    }

    public void setPk(ClientesPK pk) {
        this.pk = pk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoDocumento() {
        return null;
    }

}

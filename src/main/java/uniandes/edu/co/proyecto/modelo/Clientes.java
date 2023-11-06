package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private int num_documento;
    private String nombre;
    private String correo;
    private String tipo_documento;
    
    public Clientes(int num_documento,String tipo_documento , String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
        this.tipo_documento=tipo_documento;
        this.num_documento=num_documento;
    }

    public Clientes() {
        ;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public void setNum_documento(int num_documento) {
        this.num_documento = num_documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public int getNum_documento() {
        return num_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }
    

}

package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String tipo_documento;
    private int num_documento;
    private String nombre;
    private String correo;
    @ManyToOne
    @JoinColumn(name = "TIPOSUSUARIO_TIPO", referencedColumnName = "tipo")
    private TiposUsuario TiposUsuario_tipo;

    public Usuarios(String tipo_documento, int num_documento, String nombre, String correo,
            TiposUsuario TiposUsuario_tipo) {
        this.tipo_documento=tipo_documento;
        this.num_documento=num_documento;
        this.nombre=nombre;
        this.correo=correo;
        this.TiposUsuario_tipo = TiposUsuario_tipo;
    }

    public Usuarios() {
     ;
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

    public void setTiposUsuario_tipo(TiposUsuario tiposUsuario_tipo) {
        TiposUsuario_tipo = tiposUsuario_tipo;
    }

    public TiposUsuario getTiposUsuario_tipo() {
        return TiposUsuario_tipo;
    }   

    

    

}

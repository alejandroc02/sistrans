package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicios")
public class Servicios {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String tipo;

    private String descripcion;

    public Servicios() {
        ;
    }

    public Servicios(String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    



}

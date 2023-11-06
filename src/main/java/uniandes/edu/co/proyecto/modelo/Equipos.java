package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipos")
public class Equipos {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String nombre;
    private String descripcion;

 

    public Equipos(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion=descripcion;
    }
    public Equipos() {
        ;
    }



    public void setId(int id) {
        this.id = id;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public int getId() {
        return id;
    }



    public String getNombre() {
        return nombre;
    }



    public String getDescripcion() {
        return descripcion;
    }   
   

    
}

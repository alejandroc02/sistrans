package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_hab")
public class Tipohab {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String tipo;

    
    
    public Tipohab(int id,String tipo) {
        this.id=id;
        this.tipo = tipo;
        
    }

    public Tipohab() {
        ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }


    

    
    
}

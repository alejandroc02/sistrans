package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiendas")
public class Tiendas {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Servicios_tipo", referencedColumnName = "tipo")
    private Servicios Servicios_tipo; 

    private String tipo_tienda;

    public Tiendas() {
        ;
    }

    public Tiendas(int id, Servicios servicios_tipo, String tipo_tienda) {
        this.id = id;
        this.Servicios_tipo = servicios_tipo;
        this.tipo_tienda = tipo_tienda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Servicios getTiposServicio_tipo() {
        return Servicios_tipo;
    }

    public void setTiposServicio_tipo(Servicios servicios_tipo) {
        this.Servicios_tipo = servicios_tipo;
    }

    public String getTipo_tienda() {
        return tipo_tienda;
    }

    public void setTipo_tienda(String tipo_tienda) {
        this.tipo_tienda = tipo_tienda;
    }



    

}

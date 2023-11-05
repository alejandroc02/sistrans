package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitaciones;
import uniandes.edu.co.proyecto.modelo.TiposHabitacion;

public interface HabitacionRepository extends JpaRepository<Habitaciones, Integer>{
    
    //Obtener todas las habitaciones
    @Query(value = "SELECT * FROM HABITACIONES",nativeQuery = true)
    Collection<Habitaciones> darHabitaciones();


    //Obtener una habtiacion con id especifico
    @Query(value = "SELECT * FROM HABITACIONES WHERE id=:id",nativeQuery = true)
    Habitaciones darHabitacion (@Param("id") int id);


    //insertar Habitacion
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (id, capacidad, precio, tipohab_id_tipo ) VALUES (placeholdferBDP,:id,:capacidad,:precio,:tipohab_id_tipo)", nativeQuery = true)
    void insertarHabitacion(@Param("id") Integer id,@Param("capacidad") Integer capacidad,@Param("precio") Number precio,@Param("tipohab_id_tipo") TiposHabitacion tiposHabitacion);


    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET  capacidad:=capacidad,precio=:precio,tipohab_id_tipo:=tipohab_id_tipo",nativeQuery = true)
    void actualizarHabitacion(@Param("id") Integer id,@Param("capacidad") Integer capacidad,@Param("precio") Number precio,@Param("tipohab_id_tipo") TiposHabitacion tiposHabitacion);


    @Modifying
    @Transactional
    @Query(value = "DELET FROM habitaciones WHERE id=:id",nativeQuery=true)
    void eliminarHabitacion(@Param("id") Integer id);
}

package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Clientes;

import java.util.Collection;

public interface ClientesRepository extends JpaRepository<Clientes, Integer> {

    // Obtener todos los clientes
    @Query(value = "SELECT * FROM clientes", nativeQuery = true)
    Collection<Clientes> darClientes();

    // Obtener un cliente por num_documento
    @Query(value = "SELECT * FROM clientes WHERE num_documento = :num_documento", nativeQuery = true)
    Clientes darClientePorNumDocumento(@Param("num_documento") Integer numDocumento);

    // Insertar un nuevo cliente
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO clientes (tipo_documento, num_documento, nombre, correo) VALUES (:tipo_documento, :num_documento, :nombre, :correo)", nativeQuery = true)
    void insertarCliente(@Param("tipo_documento") int i, @Param("num_documento") int j, @Param("nombre") String nombre, @Param("correo") String correo);

    // Actualizar un cliente
    @Modifying
    @Transactional
    @Query(value = "UPDATE clientes SET nombre = :nombre, correo = :correo WHERE num_documento = :num_documento", nativeQuery = true)
    void actualizarCliente(@Param("num_documento") Integer numDocumento, @Param("nombre") String nombre, @Param("correo") String correo);

    // Eliminar un cliente por num_documento
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM clientes WHERE num_documento = :num_documento", nativeQuery = true)
    void eliminarClientePorNumDocumento(@Param("num_documento") Integer numDocumento);
}

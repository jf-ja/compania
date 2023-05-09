package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Cliente;
import co.edu.uniquindio.compania.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente,Integer> {

    //Esta consulta validad si existe un cliente ingresando la cedula
    Optional<Cliente> findByCodigo(Integer codigo);
}

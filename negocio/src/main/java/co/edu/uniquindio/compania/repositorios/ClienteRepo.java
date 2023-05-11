package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente,Integer> {

    //Esta consulta validad si existe un cliente ingresando la cedula
    Optional<Cliente> findByCodigo(Integer codigo);

    @Query("SELECT cl FROM Cliente cl WHERE cl.cedula =:cedula")
    Cliente obtenerClienteCedula(String cedula);
}

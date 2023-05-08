package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DireccionRepo extends JpaRepository<Direccion,Integer> {

    //Esta consulta validad si existe una direccion ingresando el codigo
    Optional<Direccion> findByCodigo(Integer codigo);
}

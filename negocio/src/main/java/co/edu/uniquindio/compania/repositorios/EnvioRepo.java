package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnvioRepo extends JpaRepository<Envio,Integer> {

    //Esta consulta validad si existe un envio ingresando el codigo
    Optional<Envio> findByCodigo(Integer codigo);
}

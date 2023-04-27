package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvioRepo extends JpaRepository<Envio,Integer> {
}

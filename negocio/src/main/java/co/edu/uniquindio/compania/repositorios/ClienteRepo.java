package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente,Integer> {
}

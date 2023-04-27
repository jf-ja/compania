package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Transportador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportadorRepo extends JpaRepository<Transportador,Integer> {
}

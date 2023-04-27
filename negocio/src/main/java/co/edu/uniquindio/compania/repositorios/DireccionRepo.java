package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepo extends JpaRepository<Direccion,Integer> {
}

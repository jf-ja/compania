package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad,Integer> {
}

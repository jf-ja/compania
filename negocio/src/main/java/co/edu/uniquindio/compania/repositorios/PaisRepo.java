package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaisRepo extends JpaRepository<Pais,Integer> {


}

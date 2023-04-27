package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Afiliacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfiliacionRepo extends JpaRepository<Afiliacion,Integer> {
}

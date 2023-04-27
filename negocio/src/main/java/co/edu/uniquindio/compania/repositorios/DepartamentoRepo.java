package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepo extends JpaRepository<Departamento,Integer> {
}

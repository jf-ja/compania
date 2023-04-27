package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepo extends JpaRepository<Categoria,Integer> {
}

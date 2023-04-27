package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Subcategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoriaRepo extends JpaRepository<Subcategoria,Integer> {
}

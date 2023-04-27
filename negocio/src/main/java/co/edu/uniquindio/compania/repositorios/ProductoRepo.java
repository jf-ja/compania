package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,Integer> {
}

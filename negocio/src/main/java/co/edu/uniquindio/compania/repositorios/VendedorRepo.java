package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepo extends JpaRepository<Vendedor,Integer> {
}

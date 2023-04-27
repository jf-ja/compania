package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.InventarioEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioEntradaRepo extends JpaRepository<InventarioEntrada,Integer> {
}

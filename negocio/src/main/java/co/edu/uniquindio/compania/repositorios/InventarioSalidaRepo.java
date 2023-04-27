package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.InventarioSalida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioSalidaRepo extends JpaRepository<InventarioSalida,Integer> {
}

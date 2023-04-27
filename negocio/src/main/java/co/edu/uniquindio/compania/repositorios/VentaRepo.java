package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepo extends JpaRepository<Venta,Integer> {
}

package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.InventarioSalida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioSalidaRepo extends JpaRepository<InventarioSalida,Integer> {

    //Esta consulta muestra los inventarios de salida que ha realizado un vendedor
    @Query("SELECT ine FROM InventarioSalida ine WHERE ine.vendedor.codigo = :codigo")
    List<InventarioSalida> mostrarInventarioSalidaVendedor(Integer codigo);

}

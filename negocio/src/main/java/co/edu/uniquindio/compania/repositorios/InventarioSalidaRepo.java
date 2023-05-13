package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.InventarioSalida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventarioSalidaRepo extends JpaRepository<InventarioSalida,Integer> {

    //Esta consulta muestra los inventarios de salida que ha realizado un vendedor
    @Query("SELECT ine FROM InventarioSalida ine WHERE ine.vendedor.codigo = :codigo")
    List<InventarioSalida> mostrarInventarioSalidaVendedor(Integer codigo);

    //Esta consulta validad si existe un inventario salida ingresando el codigo
    Optional<InventarioSalida> findByCodigo(Integer codigo);

}

package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.InventarioEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventarioEntradaRepo extends JpaRepository<InventarioEntrada,Integer> {

    //Esta consulta muestra los inventarios de entrada que ha realizado un vendedor
    @Query("SELECT ine FROM InventarioEntrada ine WHERE ine.vendedor.codigo = :codigo")
    List<InventarioEntrada> mostrarInventarioEntradaVendedor(Integer codigo);

    //Esta consulta validad si existe un inventario salida ingresando el codigo
    Optional<InventarioEntrada> findByCodigo(Integer codigo);
}

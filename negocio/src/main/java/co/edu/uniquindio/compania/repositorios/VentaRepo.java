package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Cliente;
import co.edu.uniquindio.compania.entidades.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VentaRepo extends JpaRepository<Venta,Integer> {


    //consulta para saber las ventas realizadas por un vendedor
    @Query("SELECT vn FROM Venta vn WHERE vn.vendedor.codigo = :codigo")
    List<Venta> ventasRealizadasPorVendedor(Integer codigo);


    //Esta consulta validad si existe una venta ingresando el codigo
    Optional<Venta> findByCodigo(Integer codigo);
}

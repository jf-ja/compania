package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepo extends JpaRepository<Venta,Integer> {


    //consulta para saber las ventas realizadas por un vendedor
    @Query("SELECT vn FROM Venta vn WHERE vn.vendedor.codigo = :codigo")
    List<Venta> ventasRealizadasPorVendedor(Integer codigo);
}

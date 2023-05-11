package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetalleVentaRepo extends JpaRepository<DetalleVenta,Integer> {

    //Consulta que obtiene las facturas o los detalles de venta de un vendedor

    @Query("SELECT dv FROM DetalleVenta dv WHERE dv.venta.vendedor.codigo =:codigo")
    List<DetalleVenta> obtenerDetallesVentasVendedor(Integer codigo);

    //Esta consulta validad si existe un detalle venta ingresando el codigo
    Optional<DetalleVenta> findByCodigo(Integer codigo);
}

package co.edu.uniquindio.compania.test;

import co.edu.uniquindio.compania.entidades.Venta;
import co.edu.uniquindio.compania.repositorios.VentaRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VentaTest {

    @Autowired
    private VentaRepo ventaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    private void listarVentasPorVendedor(){
        List<Venta> ventas = ventaRepo.ventasRealizadasPorVendedor(1);
        ventas.forEach(System.out::println);
    }
}

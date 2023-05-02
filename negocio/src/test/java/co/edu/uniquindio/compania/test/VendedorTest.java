package co.edu.uniquindio.compania.test;

import co.edu.uniquindio.compania.entidades.Vendedor;
import co.edu.uniquindio.compania.repositorios.VendedorRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VendedorTest {

    @Autowired
    private VendedorRepo vendedorRepo;
//si
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerVendedoresDeJefeVendedor(){
        List<Vendedor> vendedores = vendedorRepo.obtenerVendedoresJefeVendedor(1);
        for (Vendedor vendedor: vendedores){
            System.out.println(vendedor.getNombre());
        };
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerVendedores(){
        List<Vendedor> vendedores = vendedorRepo.findAll();
        for (Vendedor vendedor: vendedores){
            System.out.println(vendedor.getNombre());
        };
    }

}

package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,Integer> {


    // Esta consulta devuelve un producto buscado por el nombre
    @Query("SELECT pd FROM Producto pd Where pd.nombre like concat('%', :nombre, '%')")
    List<Producto> productoPorNombre(String nombre);

}

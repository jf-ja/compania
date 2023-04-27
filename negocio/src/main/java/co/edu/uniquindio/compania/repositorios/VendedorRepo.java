package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendedorRepo extends JpaRepository<Vendedor,Integer> {

    //----------------------------------------------GESTIONAR LOGIN------------------------------------
    @Query("SELECT vd FROM Vendedor vd WHERE vd.correo = :correo and vd.contrasena = :contrasena")
    Vendedor comprobarAutentificacion(String correo, String contrasena);

    //----------------------------------------GESTIONAR VENDEDOR---------------------------------------

    //Esta consulta validad si existe un vendedor ingresando la cedula
    Optional<Vendedor> findByCodigo(Integer codigo);

    //Esta consulta validad si existe un vendedor ingresando el correo
    Optional<Vendedor> findByCorreo(String correo);
}

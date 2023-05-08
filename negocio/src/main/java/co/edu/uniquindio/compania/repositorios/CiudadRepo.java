package co.edu.uniquindio.compania.repositorios;

import co.edu.uniquindio.compania.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad,Integer> {

    //Metodo para obtener la ciudad por el codigo
    @Query("SELECT ciudad FROM Ciudad ciudad WHERE ciudad.codigo =:codigo")
    Ciudad obtenerCiudad(Integer codigo);


    //Consulta para obtener ciuddes por codigo de pais
    @Query("SELECT cds FROM Ciudad cds WHERE cds.departamento.pais.codigo =:codigo")
    List<Ciudad> obtenerCiudadesPorPais(Integer codigo);
}

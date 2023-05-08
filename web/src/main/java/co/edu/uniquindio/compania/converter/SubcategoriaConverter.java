package co.edu.uniquindio.compania.converter;

import co.edu.uniquindio.compania.entidades.Ciudad;
import co.edu.uniquindio.compania.entidades.Subcategoria;
import co.edu.uniquindio.compania.servicios.VendedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


@Component
public class SubcategoriaConverter implements Converter<Subcategoria> {

    @Autowired
    private VendedorServicio vendedorServicio;

    @Override
    public Subcategoria getAsObject(FacesContext context, UIComponent component, String value) {

        Subcategoria subcategoria ;
        try {
            subcategoria = vendedorServicio.obtenerSubcategoria(Integer.parseInt(value));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return subcategoria;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Subcategoria value) {
        if(value != null){
            return ""+value.getCodigo();
        }
        return "";
    }
}

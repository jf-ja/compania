package co.edu.uniquindio.compania.converter;

import co.edu.uniquindio.compania.entidades.Pais;
import co.edu.uniquindio.compania.servicios.VendedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component
public class PaisConverter implements Converter<Pais> {

    @Autowired
    private VendedorServicio vendedorServicio;

    @Override
    public Pais getAsObject(FacesContext context, UIComponent component, String value) {

        Pais pais ;
        try {
            pais = vendedorServicio.obtenerPais(Integer.parseInt(value));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return pais;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Pais value) {
        if(value != null){
            return ""+value.getCodigo();
        }
        return "";
    }
}

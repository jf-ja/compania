package co.edu.uniquindio.compania.converter;

import co.edu.uniquindio.compania.entidades.Afiliacion;
import co.edu.uniquindio.compania.servicios.VendedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component
public class AfiliacionConverter implements Converter<Afiliacion> {

    @Autowired
    private VendedorServicio vendedorServicio;

    @Override
    public Afiliacion getAsObject(FacesContext context, UIComponent component, String value) {

        Afiliacion afiliacion ;
        try {
            afiliacion = vendedorServicio.obtenerAfiliacion(Integer.parseInt(value));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return afiliacion;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Afiliacion value) {
        if(value != null){
            return ""+value.getCodigo();
        }
        return "";
    }
}

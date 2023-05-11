package co.edu.uniquindio.compania.converter;

import co.edu.uniquindio.compania.entidades.Producto;
import co.edu.uniquindio.compania.servicios.VendedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component
public class ProductoConverter implements Converter<Producto> {

    @Autowired
    private VendedorServicio vendedorServicio;

    @Override
    public Producto getAsObject(FacesContext context, UIComponent component, String value) {

        Producto producto ;
        try {
            producto = vendedorServicio.obtenerProducto(Integer.parseInt(value));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return producto;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Producto value) {
        if(value != null){
            return ""+value.getCodigo();
        }
        return "";
    }
}

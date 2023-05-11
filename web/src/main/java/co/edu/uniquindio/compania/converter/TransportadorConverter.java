package co.edu.uniquindio.compania.converter;

import co.edu.uniquindio.compania.entidades.Transportador;
import co.edu.uniquindio.compania.servicios.VendedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component
public class TransportadorConverter implements Converter<Transportador> {


    @Autowired
    private VendedorServicio vendedorServicio;

    @Override
    public Transportador getAsObject(FacesContext context, UIComponent component, String value) {

        Transportador transportador ;
        try {
            transportador = vendedorServicio.obtenerTransportador(Integer.parseInt(value));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return transportador;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Transportador value) {
        if(value != null){
            return ""+value.getCodigo();
        }
        return "";
    }
}

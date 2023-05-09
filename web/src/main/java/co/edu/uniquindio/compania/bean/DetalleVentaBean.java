package co.edu.uniquindio.compania.bean;

import co.edu.uniquindio.compania.entidades.DetalleVenta;
import co.edu.uniquindio.compania.entidades.Direccion;
import co.edu.uniquindio.compania.entidades.Vendedor;
import co.edu.uniquindio.compania.servicios.VendedorServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class DetalleVentaBean {

    @Value("#{seguridadBean.vendedor}")
    private Vendedor vendedorSesion;

    @Autowired
    private VendedorServicio vendedorServicio;

    @Getter
    @Setter
    private List<DetalleVenta> detalleVentas;

    @Getter
    @Setter
    private List<DetalleVenta> detalleVentasSeleccionados;



    @PostConstruct
    public void init(){
        detalleVentas = vendedorServicio.obtenerDetalleVentasVendedor(vendedorSesion.getCodigo());
    }



}

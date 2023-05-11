package co.edu.uniquindio.compania.bean;

import co.edu.uniquindio.compania.entidades.*;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class VentaBean {

    @Autowired
    private VendedorServicio vendedorServicio;

    @Getter @Setter
    private Venta venta;

    @Getter @Setter
    private Cliente cliente;

    @Value("#{seguridadBean.vendedor}")
    private Vendedor vendedorSesion;

    @Getter @Setter
    private List<Venta> ventasSeleccionados;

    @Getter @Setter
    private List<Venta> ventasVendedor;

    @Getter @Setter
    private List<Producto> productos;

    @Getter @Setter
    private Direccion direccion;

    @Getter @Setter
    private DetalleVenta detalleVenta;

    @Getter @Setter
    private Transportador transportador;

    @Getter @Setter
    private List<Transportador> trasnportadores;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @Getter @Setter
    private Envio envio;

    @Getter @Setter
    private Producto producto;

    @Getter @Setter
    private boolean editar;

    @Getter @Setter
    private String cedulaCliente;

    @PostConstruct
    public void init(){

        venta = new Venta();
        cliente = new Cliente();
        direccion = new Direccion();
        detalleVenta = new DetalleVenta();
        envio = new Envio();
        productos = vendedorServicio.listarProducto();

        ventasSeleccionados = new ArrayList<>();
        ventasVendedor = vendedorServicio.obtenerVentasVendedor(vendedorSesion.getCodigo());
        trasnportadores = vendedorServicio.listarTransportador();
        ciudades = vendedorServicio.listarCiudades();

        editar = false;
    }


    public void registrarVenta(){

        try {

            if(!editar) {

                cliente = vendedorServicio.obtenerClienteCedula(cedulaCliente);
                Direccion direccionRegistro = vendedorServicio.crearDireccion(direccion);
                envio.setDireccion(direccionRegistro);
                envio.setTransportador(transportador);
                Envio envioRegistro = vendedorServicio.crearEnvio(envio);
                venta.setCliente(cliente);
                venta.setFecha(LocalDate.now());
                venta.setEnvio(envioRegistro);
                venta.setVendedor(vendedorSesion);
                venta.setDescripcion("Venta Pendiente");
                Venta ventaRegistro = vendedorServicio.crearVenta(venta);
                detalleVenta.setVenta(ventaRegistro);

                detalleVenta.setPrecioTotal(detalleVenta.getCantidad()*detalleVenta.getProducto().getPrecio());
                DetalleVenta detalleVentaRegistro = vendedorServicio.crearDetalleVenta(detalleVenta);



                cliente = new Cliente();
                direccion = new Direccion();
                venta = new Venta();
                detalleVenta = new DetalleVenta();
                envio = new Envio();
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro Exitoso");
                FacesContext.getCurrentInstance().addMessage("mensaje_registro_venta", facesMessage);
            }else {

                vendedorServicio.actualizarVenta(venta);
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Actualizacion Exitosa");
                FacesContext.getCurrentInstance().addMessage("mensaje_registro_venta", facesMessage);
            }
        }catch (Exception e){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_registro_venta", facesMessage);
        }
    }


    public void eliminarVenta(){

        try {
            for (Venta venta : ventasSeleccionados){
                vendedorServicio.eliminarVenta(venta.getCodigo());
                ventasVendedor.remove(venta);
            }
            ventasSeleccionados.clear();
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_eliminar_ventas", fm);
        }
    }


    public String getMensajeBorrar(){

        if(ventasSeleccionados.isEmpty()){
            return "Borrar";
        }else{
            return "Borrar (" + ventasSeleccionados.size() + ")" ;
        }

    }

    public String getMensajeCrearEditar(){
        if(editar){
            return "EDITAR VENTA";
        }
        return "CREAR VENTA" ;
    }


    public void seleccionarVentas(Venta ventaSelec){
        this.venta = ventaSelec;
        editar=true;
    }

    public void crearVentaDialog(){
        this.venta= new Venta();
        editar=false;
    }



}

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
    private List<Transportador> trasnportadores;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @Getter @Setter
    private Envio envio;

    @Getter @Setter
    private Producto producto;

    @Getter @Setter
    private InventarioSalida inventarioSalida;

    @Getter @Setter
    private boolean editar;

    @Getter @Setter
    private String cedulaCliente;

    @Getter @Setter
    private Integer cantidad;

    @PostConstruct
    public void init(){

        venta = new Venta();
        cliente = new Cliente();
        direccion = new Direccion();
        detalleVenta = new DetalleVenta();
        envio = new Envio();
        inventarioSalida = new InventarioSalida();
        producto = new Producto();
        productos = vendedorServicio.obtenerProductosVendedor(vendedorSesion.getCodigo());
        cantidad = 0;

        ventasSeleccionados = new ArrayList<>();
        ventasVendedor = vendedorServicio.obtenerVentasVendedor(vendedorSesion.getCodigo());
        trasnportadores = vendedorServicio.listarTransportador();
        ciudades = vendedorServicio.listarCiudades();

        editar = false;
    }


    public void registrarVenta(){

        try {

            if(!editar) {

                for (Producto productoL : productos){
                    if(producto.getCodigo().equals(productoL.getCodigo())){
                        producto = productoL;
                    }
                }
                System.out.println("cant detv: " + detalleVenta.getCantidad());
                System.out.println("cant prod: " + producto.getStock());


               if(detalleVenta.getCantidad()<= producto.getStock()){

                    cliente = vendedorServicio.obtenerClienteCedula(cedulaCliente);
                    Direccion direccionRegistro = vendedorServicio.crearDireccion(direccion);
                    envio.setDireccion(direccionRegistro);
                    Envio envioRegistro = vendedorServicio.crearEnvio(envio);
                    venta.setCliente(cliente);
                    venta.setFecha(LocalDate.now());
                    venta.setEnvio(envioRegistro);
                    venta.setVendedor(vendedorSesion);
                    venta.setDescripcion("Venta Pendiente");
                    Venta ventaRegistro = vendedorServicio.crearVenta(venta);
                    detalleVenta.setVenta(ventaRegistro);
                    detalleVenta.setProducto(producto);


                    detalleVenta.setPrecioTotal(detalleVenta.getCantidad()*detalleVenta.getProducto().getPrecio());
                    DetalleVenta detalleVentaRegistro = vendedorServicio.crearDetalleVenta(detalleVenta);

                    inventarioSalida.setCantidad(detalleVenta.getCantidad());
                    inventarioSalida.setFechaSalida(LocalDate.now());
                    inventarioSalida.setProducto(detalleVenta.getProducto());
                    inventarioSalida.setVendedor(vendedorSesion);

                    InventarioSalida inventarioSalidaRegistro = vendedorServicio.crearInventarioSalida(inventarioSalida);

                    ventasVendedor.add(ventaRegistro);
                    productos = vendedorServicio.obtenerProductosVendedor(vendedorSesion.getCodigo());

                    cliente = new Cliente();
                    direccion = new Direccion();
                    venta = new Venta();
                    detalleVenta = new DetalleVenta();
                    envio = new Envio();
                    inventarioSalida = new InventarioSalida();
                    cantidad = 0;

                    FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro Exitoso");
                    FacesContext.getCurrentInstance().addMessage("mensaje_registro_venta", facesMessage);
                }else{
                    System.out.println("PAILAS PROBLEMAS CON LA CANTIDAD");
                    FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "NO E PUEDE REALIZAR LA COMPRA, NO HAY LA CANTIDAD");
                    FacesContext.getCurrentInstance().addMessage("mensaje_registro_venta", facesMessage);
                }

            }else {
                System.out.println("Modificado envio: " + venta.getEnvio().getTransportador().getNombre());
                Venta ventaActualizada = vendedorServicio.actualizarVenta(venta);
                System.out.println("Actualziado ya envio: " + ventaActualizada.getEnvio().getTransportador().getNombre());
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

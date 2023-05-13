package co.edu.uniquindio.compania.bean;

import co.edu.uniquindio.compania.entidades.InventarioEntrada;
import co.edu.uniquindio.compania.entidades.Producto;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class InventarioEntradaBean {

    @Autowired
    private VendedorServicio vendedorServicio;

    @Value("#{seguridadBean.vendedor}")
    private Vendedor vendedorSesion;

    @Setter @Getter
    private InventarioEntrada inventarioEntrada;

    @Setter @Getter
    private Producto producto;

    @Getter @Setter
    private List<Producto> productos;

    @Getter @Setter
    private List<InventarioEntrada> inventarioEntradas;
    @Getter @Setter
    private List<InventarioEntrada> inventarioEntradasSeleccionados;

    private boolean editar;

    @PostConstruct
    public void init(){

        inventarioEntrada = new InventarioEntrada();
        producto = new Producto();
        productos = vendedorServicio.listarProducto();
        inventarioEntradasSeleccionados= new ArrayList<>();
        inventarioEntradas = vendedorServicio.obtenerInventarioEntradaVendedor(vendedorSesion.getCodigo());

        editar = false;
    }


    public void registrarInventarioEntrada(){

        try {

            if(!editar) {

                inventarioEntrada.setVendedor(vendedorSesion);
                inventarioEntrada.setDescripcion("Entrega en Proceso");
                inventarioEntrada.setFechaEntrada(LocalDate.now());
                InventarioEntrada inventarioEntradaRegistro = vendedorServicio.crearInventarioEntrada(inventarioEntrada);
                inventarioEntradas.add(inventarioEntradaRegistro);
                inventarioEntrada= new InventarioEntrada();
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro Exitoso");
                FacesContext.getCurrentInstance().addMessage("mensaje_registro_inventarioEntrada", facesMessage);
            }else {

                vendedorServicio.actualizarInventarioEntrada(inventarioEntrada);
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Actualizacion Exitosa");
                FacesContext.getCurrentInstance().addMessage("mensaje_registro_inventarioEntrada", facesMessage);
            }
        }catch (Exception e){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_registro_inventarioEntrada", facesMessage);
        }
    }


    public void eliminarInventarioEntrada(){

        try {
            for (InventarioEntrada inventarioEntrada: inventarioEntradasSeleccionados){
                vendedorServicio.eliminarInventarioEntrada(inventarioEntrada.getCodigo());
                inventarioEntradas.remove(inventarioEntrada);
            }
            inventarioEntradasSeleccionados.clear();
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_eliminar_inventarioEntrada", fm);
        }
    }


    public String getMensajeBorrar(){

        if(inventarioEntradasSeleccionados.isEmpty()){
            return "Borrar";
        }else{
            return "Borrar (" + inventarioEntradasSeleccionados.size() + ")" ;
        }

    }

    public String getMensajeCrearEditar(){
        if(editar){
            return "EDITAR INVENTARIO";
        }
        return "CREAR INVENTARIO" ;
    }


    public void seleccionarInventarioEntrada(InventarioEntrada inventarioEntradaSelec){
        this.inventarioEntrada = inventarioEntradaSelec;
        editar=true;
    }

    public void crearInventarioEntradaDialog(){
        this.inventarioEntrada= new InventarioEntrada();
        editar=false;
    }
}

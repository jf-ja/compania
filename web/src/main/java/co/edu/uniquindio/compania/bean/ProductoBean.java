package co.edu.uniquindio.compania.bean;

import co.edu.uniquindio.compania.entidades.Producto;
import co.edu.uniquindio.compania.entidades.Subcategoria;
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
public class ProductoBean {

    @Autowired
    private VendedorServicio vendedorServicio;

    @Value("#{seguridadBean.vendedor}")
    private Vendedor vendedorSesion;
    
    @Getter @Setter
    private Producto producto;

    @Getter @Setter
    private List<Producto> productos;

    @Getter @Setter
    private List<Producto> productosSeleccionados;
    @Getter @Setter
    private List<Subcategoria> subcategorias;

    private boolean editar;

    @PostConstruct
    public void init(){
        producto = new Producto();
        productos = vendedorServicio.listarProducto();
        productosSeleccionados = new ArrayList<>();
        subcategorias = vendedorServicio.listarSubcategorias();
        editar=false;
    }




    public void registrarProducto(){

        try {

            if(!editar) {

                producto.setStock(0);
                Producto registro = vendedorServicio.crearProducto(producto);
                productos.add(registro);
                producto = new Producto();
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro Exitoso");
                FacesContext.getCurrentInstance().addMessage("mensaje_registro_producto", facesMessage);
            }else {

                vendedorServicio.actualizarProducto(producto);
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Actualizacion Exitosa");
                FacesContext.getCurrentInstance().addMessage("mensaje_registro_producto", facesMessage);
            }
        }catch (Exception e){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_registro_producto", facesMessage);
        }
    }


    public void eliminarProducto(){

        try {
            for (Producto producto : productosSeleccionados){
                vendedorServicio.eliminarProducto(producto.getCodigo());
                productos.remove(producto);
            }
            productosSeleccionados.clear();
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_eliminar_productos", fm);
        }
    }


    public String getMensajeBorrar(){

        if(productosSeleccionados.isEmpty()){
            return "Borrar";
        }else{
            return "Borrar (" + productosSeleccionados.size() + ")" ;
        }

    }

    public String getMensajeCrearEditar(){
        if(editar){
            return "EDITAR PRODUCTO";
        }
        return "CREAR PRODUCTO" ;
    }


    public void seleccionarProductos(Producto productoSelec){
        this.producto = productoSelec;
        editar=true;
    }

    public void crearProductoDialog(){
        this.producto= new Producto();
        editar=false;
    }
}

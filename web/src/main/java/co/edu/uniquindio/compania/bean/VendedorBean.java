package co.edu.uniquindio.compania.bean;

import co.edu.uniquindio.compania.entidades.Ciudad;
import co.edu.uniquindio.compania.entidades.Direccion;
import co.edu.uniquindio.compania.entidades.Pais;
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
public class VendedorBean {

    @Getter
    @Setter
    private Vendedor vendedor;

    @Getter
    @Setter
    private List<Vendedor> vendedoresVendedor;


    @Getter
    @Setter
    private List<Vendedor> vendedoresSeleccionados;

    private boolean editar;

    @Autowired
    private VendedorServicio vendedorServicio;

    @Value("#{seguridadBean.vendedor}")
    private Vendedor vendedorSesion;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @Getter @Setter
    private List<Pais> paises;

    @Getter
    @Setter
    private Direccion direccion;

    @PostConstruct
    public void init(){
        vendedor = new Vendedor();
        direccion = new Direccion();
        vendedoresSeleccionados = new ArrayList<>();
        ciudades = vendedorServicio.listarCiudades();
        vendedoresVendedor= vendedorServicio.listarVendedoresVendedor(vendedorSesion.getCodigo());
        editar=false;
    }





    public void registrarVendedor(){

        try {

            if(!editar) {


                Direccion direccionRegistro = vendedorServicio.crearDireccion(direccion);

                vendedor.setVendedorJefe(vendedorSesion);
                vendedor.setEstado_afiliacion(false);
                vendedor.setAfiliacion(null);
                vendedor.setDireccion(direccionRegistro);

                Vendedor registro = vendedorServicio.crearVendedor(vendedor);

                vendedoresVendedor.add(registro);

                vendedor = new Vendedor();
                direccion = new Direccion();

                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro Exitoso");
                FacesContext.getCurrentInstance().addMessage("mensaje_registro_vendedor", facesMessage);
            }else {

                vendedorServicio.actualizarVendedor(vendedor);
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Actualizacion Exitosa");
                FacesContext.getCurrentInstance().addMessage("mensaje_registro_vendedor", facesMessage);
            }
        }catch (Exception e){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_registro_vendedor", facesMessage);
        }
    }


    public void eliminarVendedor(){

        try {
            for (Vendedor vendedor : vendedoresSeleccionados){
                vendedorServicio.eliminarVendedor(vendedor.getCodigo());
                vendedoresVendedor.remove(vendedor);
            }
            vendedoresSeleccionados.clear();
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_eliminar_vendedores", fm);
        }
    }


    public String getMensajeBorrar(){

        if(vendedoresSeleccionados.isEmpty()){
            return "Borrar";
        }else{
            return "Borrar (" + vendedoresSeleccionados.size() + ")" ;
        }

    }

    public String getMensajeCrearEditar(){
        if(editar){
            return "EDITAR VENDEDOR";
        }
        return "CREAR VENDEDOR" ;
    }


    public void seleccionarVendedores(Vendedor vendedorSelec){
        this.vendedor = vendedorSelec;
        editar=true;
    }

    public void crearVendedorDialog(){
        this.vendedor= new Vendedor();
        editar=false;
    }
}

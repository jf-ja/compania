package co.edu.uniquindio.compania.bean;

import co.edu.uniquindio.compania.entidades.Ciudad;
import co.edu.uniquindio.compania.entidades.Cliente;
import co.edu.uniquindio.compania.entidades.Direccion;
import co.edu.uniquindio.compania.entidades.Producto;
import co.edu.uniquindio.compania.servicios.VendedorServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class ClienteBean {

    @Autowired
    private VendedorServicio vendedorServicio;

    @Getter @Setter
    private Cliente cliente;

    @Getter @Setter
    private List<Cliente> clientes;

    @Getter @Setter
    private List<Cliente> clientesSeleccionados;

    @Getter @Setter
    private boolean editar;

    @Getter
    @Setter
    private Direccion direccion;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @PostConstruct
    public void init(){

        direccion = new Direccion();
        ciudades = vendedorServicio.listarCiudades();
        cliente = new Cliente();
        clientes = vendedorServicio.listarCliente();
        clientesSeleccionados = new ArrayList<>();
        editar=false;
    }


        public void registrarCliente(){

        try {

            if(!editar) {

                Direccion direccionRegistro = vendedorServicio.crearDireccion(direccion);
                cliente.setDireccion(direccionRegistro);

                Cliente registro = vendedorServicio.crearCliente(cliente);
                clientes.add(registro);

                cliente = new Cliente();
                direccion = new Direccion();
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro Exitoso");
                FacesContext.getCurrentInstance().addMessage("mensaje_registro_cliente", facesMessage);
            }else {

                vendedorServicio.actualizarCliente(cliente);
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Actualizacion Exitosa");
                FacesContext.getCurrentInstance().addMessage("mensaje_registro_cliente", facesMessage);
            }
        }catch (Exception e){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_registro_cliente", facesMessage);
        }
    }


    public void eliminarCliente(){

        try {
            for (Cliente cliente : clientesSeleccionados){
                vendedorServicio.eliminarCliente(cliente.getCodigo());
                clientes.remove(cliente);
            }
            clientesSeleccionados.clear();
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_eliminar_clientes", fm);
        }
    }


    public String getMensajeBorrar(){

        if(clientesSeleccionados.isEmpty()){
            return "Borrar";
        }else{
            return "Borrar (" + clientesSeleccionados.size() + ")" ;
        }

    }

    public String getMensajeCrearEditar(){
        if(editar){
            return "EDITAR CLIENTE";
        }
        return "CREAR CLIENTE" ;
    }


    public void seleccionarClientes(Cliente clienteSelec){
        this.cliente = clienteSelec;
        editar=true;
    }

    public void crearClienteDialog(){
        this.cliente= new Cliente();
        editar=false;
    }
}

package co.edu.uniquindio.compania.bean;

import co.edu.uniquindio.compania.entidades.InventarioEntrada;
import co.edu.uniquindio.compania.entidades.Vendedor;
import co.edu.uniquindio.compania.entidades.Venta;
import co.edu.uniquindio.compania.servicios.VendedorServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@Component
@Scope("session")
public class SeguridadBean implements Serializable {

    @Autowired
    private VendedorServicio vendedorServicio;

    @Getter @Setter
    private List<Vendedor> vendedoresVendedor;

    @Getter @Setter
    private List<Venta> ventasVendedor;

    @Getter @Setter
    private List<InventarioEntrada> inventarioEntradaVendedor;
    @Getter
    @Setter
    private boolean autenticado;

    @Getter
    @Setter
    private String email, password;

    @Getter
    @Setter
    private Vendedor vendedor;

    @Getter
    @Setter
    private String tipoSesion;



    @PostConstruct
    public void inicializar() {

    }

    public String iniciarSesion() {

        if (!email.isEmpty() && !password.isEmpty()) {
            try {
                vendedor = vendedorServicio.login(email, password);

                if (vendedor != null) {
                    tipoSesion = "admin";
                    autenticado = true;
                    vendedoresVendedor = vendedorServicio.listarVendedoresVendedor(vendedor.getCodigo());
                    ventasVendedor = vendedorServicio.obtenerVentasVendedor(vendedor.getCodigo());
                    inventarioEntradaVendedor= vendedorServicio.obtenerInventarioEntradaVendedor(vendedor.getCodigo());

                    return "/menuVendedor?faces-redirect=true";
                }else{
                    return "/index.xhtml?faces-redirect=true";
                }



            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("login-bean", fm);
            }
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "El correo y la contrasena son obligatorios");
            FacesContext.getCurrentInstance().addMessage("login-bean", fm);
        }
        return null;
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";

    }
}

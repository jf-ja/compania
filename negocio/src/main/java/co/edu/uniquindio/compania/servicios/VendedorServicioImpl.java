package co.edu.uniquindio.compania.servicios;

import co.edu.uniquindio.compania.entidades.*;
import co.edu.uniquindio.compania.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorServicioImpl implements VendedorServicio{

    @Autowired
    private final VendedorRepo vendedorRepo;

    private final ProductoRepo productoRepo;

    private final InventarioEntradaRepo inventarioEntradaRepo;

    private final ClienteRepo clienteRepo;

    private final TransportadorRepo transportadorRepo;

    private final VentaRepo ventaRepo;

    private final DetalleVentaRepo detalleVentaRepo;

    private final EnvioRepo envioRepo;

    private final AfiliacionRepo afiliacionRepo;


    public VendedorServicioImpl(VendedorRepo vendedorRepo, ProductoRepo productoRepo, InventarioEntradaRepo inventarioEntradaRepo, ClienteRepo clienteRepo, TransportadorRepo transportadorRepo, VentaRepo ventaRepo, DetalleVentaRepo detalleVentaRepo, EnvioRepo envioRepo, AfiliacionRepo afiliacionRepo) {
        this.vendedorRepo = vendedorRepo;
        this.productoRepo = productoRepo;
        this.inventarioEntradaRepo = inventarioEntradaRepo;
        this.clienteRepo = clienteRepo;
        this.transportadorRepo = transportadorRepo;
        this.ventaRepo = ventaRepo;
        this.detalleVentaRepo = detalleVentaRepo;
        this.envioRepo = envioRepo;
        this.afiliacionRepo = afiliacionRepo;
    }

    //----------------------------------- LOGIN------------------------------------------

    @Override
    public Vendedor login(String correo, String password) throws Exception {
        return null;
    }

    //----------------------------------- GESTIONAR VENDEDORES ------------------------------------

    @Override
    public Vendedor crearVendedor(Vendedor vendedor) throws Exception {
        return null;
    }

    @Override
    public Vendedor obtenerVendedor(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Vendedor actualizarVendedor(Vendedor vendedor) throws Exception {
        return null;
    }

    @Override
    public void eliminarVendedor(Integer codigo) throws Exception {

    }

    @Override
    public List<Vendedor> listarVendedor() {
        return null;
    }

    //-----------------------------------GESTIONAR PRODUCTOS------------------------------------

    @Override
    public Producto crearProducto(Producto producto) throws Exception {
        return null;
    }

    @Override
    public Producto obtenerProducto(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Producto actualizarProducto(Producto producto) throws Exception {
        return null;
    }

    @Override
    public void eliminarProducto(Integer codigo) throws Exception {

    }

    @Override
    public List<Producto> listarProducto() {
        return null;
    }

    //-----------------------------GESTIONAR INVENTARIOS ENTRADA-----------------------------------


    @Override
    public InventarioEntrada crearInventarioEntrada(InventarioEntrada inventarioEntrada) throws Exception {
        return null;
    }

    @Override
    public InventarioEntrada obtenerInventarioEntrada(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public InventarioEntrada actualizarInventarioEntrada(InventarioEntrada inventarioEntrada) throws Exception {
        return null;
    }

    @Override
    public void eliminarInventarioEntrada(Integer codigo) throws Exception {

    }

    @Override
    public List<InventarioEntrada> listarInventarioEntrada() {
        return null;
    }

    //------------------------------------ GESTIONAR CLIENTES------------------------------------


    @Override
    public Cliente crearCliente(Cliente ciudad) throws Exception {
        return null;
    }

    @Override
    public Cliente obtenerCliente(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Cliente actualizarCliente(Cliente ciudad) throws Exception {
        return null;
    }

    @Override
    public void eliminarCliente(Integer codigo) throws Exception {

    }

    @Override
    public List<Cliente> listarCliente() {
        return null;
    }

    //-------------------------------------GESTIONAR TRANSORTADORES------------------------------


    @Override
    public Transportador crearTransportador(Transportador transportador) throws Exception {
        return null;
    }

    @Override
    public Transportador obtenerTransportador(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Transportador actualizarTransportador(Transportador transportador) throws Exception {
        return null;
    }

    @Override
    public void eliminarTransportador(Integer codigo) throws Exception {

    }

    @Override
    public List<Transportador> listarTransportador() {
        return null;
    }


    //------------------------------------- GESTIONAR VENTAS -----------------------------------

    @Override
    public Venta crearVenta(Venta venta) throws Exception {
        return null;
    }

    @Override
    public Venta obtenerVenta(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Venta actualizarVenta(Venta venta) throws Exception {
        return null;
    }

    @Override
    public void eliminarVenta(Integer codigo) throws Exception {

    }

    @Override
    public List<Venta> listarVenta() {
        return null;
    }

    //-----------------------------------GESTIONAR DETALLE VENTAS --------------------------------


    @Override
    public DetalleVenta crearDetalleVenta(DetalleVenta detalleVenta) throws Exception {
        return null;
    }

    @Override
    public DetalleVenta obtenerDetalleVenta(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public DetalleVenta actualizarDetalleVenta(DetalleVenta detalleVenta) throws Exception {
        return null;
    }

    @Override
    public void eliminarDetalleVenta(Integer codigo) throws Exception {

    }

    @Override
    public List<DetalleVenta> listarDetalleVenta() {
        return null;
    }

    //----------------------------------- GESTIONAR ENVIOS -------------------------------------


    @Override
    public Envio crearEnvio(Envio envio) throws Exception {
        return null;
    }

    @Override
    public Envio obtenerEnvio(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Envio actualizarEnvio(Envio envio) throws Exception {
        return null;
    }

    @Override
    public void eliminarEnvio(Integer codigo) throws Exception {

    }

    @Override
    public List<Envio> listarEnvio() {
        return null;
    }

    //-------------------------------------GESTIONAR AFILIACIONES------------------------------


    @Override
    public Afiliacion crearAfiliacion(Afiliacion afiliacion) throws Exception {
        return null;
    }

    @Override
    public Afiliacion obtenerAfiliacion(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Afiliacion actualizarAfiliacion(Afiliacion afiliacion) throws Exception {
        return null;
    }

    @Override
    public void eliminarAfiliacion(Integer codigo) throws Exception {

    }

    @Override
    public List<Afiliacion> listarAfiliacion() {
        return null;
    }
}

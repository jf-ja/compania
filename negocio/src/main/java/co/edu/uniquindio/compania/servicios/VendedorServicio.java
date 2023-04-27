package co.edu.uniquindio.compania.servicios;

import co.edu.uniquindio.compania.entidades.*;

import java.util.List;

public interface VendedorServicio {

    //----------------------------------- LOGIN------------------------------------------

    Vendedor login(String correo, String password) throws Exception;


    //----------------------------------- GESTIONAR VENDEDORES ------------------------------------

    Vendedor crearVendedor(Vendedor vendedor) throws Exception;

    Vendedor obtenerVendedor(Integer codigo)throws Exception;

    Vendedor actualizarVendedor(Vendedor vendedor) throws Exception;

    void eliminarVendedor(Integer codigo) throws Exception;

    List<Vendedor> listarVendedor();


    //-----------------------------------GESTIONAR PRODUCTOS------------------------------------

    Producto crearProducto(Producto producto) throws Exception;

    Producto obtenerProducto(Integer codigo)throws Exception;

    Producto actualizarProducto(Producto producto) throws Exception;

    void eliminarProducto(Integer codigo) throws Exception;

    List<Producto> listarProducto();


    //-----------------------------GESTIONAR INVENTARIOS ENTRADA-----------------------------------

    InventarioEntrada crearInventarioEntrada(InventarioEntrada inventarioEntrada) throws Exception;

    InventarioEntrada obtenerInventarioEntrada(Integer codigo)throws Exception;

    InventarioEntrada actualizarInventarioEntrada(InventarioEntrada inventarioEntrada) throws Exception;

    void eliminarInventarioEntrada(Integer codigo) throws Exception;

    List<InventarioEntrada> listarInventarioEntrada();


    //------------------------------------ GESTIONAR CLIENTES------------------------------------

    Cliente crearCliente(Cliente ciudad) throws Exception;

    Cliente obtenerCliente(Integer codigo)throws Exception;

    Cliente actualizarCliente(Cliente ciudad) throws Exception;

    void eliminarCliente(Integer codigo) throws Exception;

    List<Cliente> listarCliente();


    //-------------------------------------GESTIONAR TRANSORTADORES------------------------------

    Transportador crearTransportador(Transportador transportador) throws Exception;

    Transportador obtenerTransportador(Integer codigo)throws Exception;

    Transportador actualizarTransportador(Transportador transportador) throws Exception;

    void eliminarTransportador(Integer codigo) throws Exception;

    List<Transportador> listarTransportador();


    //------------------------------------- GESTIONAR VENTAS -----------------------------------

    Venta crearVenta(Venta venta) throws Exception;

    Venta obtenerVenta(Integer codigo)throws Exception;

    Venta actualizarVenta(Venta venta) throws Exception;

    void eliminarVenta(Integer codigo) throws Exception;

    List<Venta> listarVenta();

    //-----------------------------------GESTIONAR DETALLE VENTAS --------------------------------

    DetalleVenta crearDetalleVenta(DetalleVenta detalleVenta) throws Exception;

    DetalleVenta obtenerDetalleVenta(Integer codigo)throws Exception;

    DetalleVenta actualizarDetalleVenta(DetalleVenta detalleVenta) throws Exception;

    void eliminarDetalleVenta(Integer codigo) throws Exception;

    List<DetalleVenta> listarDetalleVenta();

    //----------------------------------- GESTIONAR ENVIOS -------------------------------------

    Envio crearEnvio(Envio envio) throws Exception;

    Envio obtenerEnvio(Integer codigo)throws Exception;

    Envio actualizarEnvio(Envio envio) throws Exception;

    void eliminarEnvio(Integer codigo) throws Exception;

    List<Envio> listarEnvio();

    //-------------------------------------GESTIONAR AFILIACIONES------------------------------

    Afiliacion crearAfiliacion(Afiliacion afiliacion) throws Exception;

    Afiliacion obtenerAfiliacion(Integer codigo)throws Exception;

    Afiliacion actualizarAfiliacion(Afiliacion afiliacion) throws Exception;

    void eliminarAfiliacion(Integer codigo) throws Exception;

    List<Afiliacion> listarAfiliacion();




}

package co.edu.uniquindio.compania.servicios;

import co.edu.uniquindio.compania.entidades.*;
import co.edu.uniquindio.compania.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorServicioImpl implements VendedorServicio{

    @Autowired
    private final VendedorRepo vendedorRepo;
    @Autowired
    private final ProductoRepo productoRepo;
    @Autowired
    private final InventarioEntradaRepo inventarioEntradaRepo;
    @Autowired
    private final ClienteRepo clienteRepo;
    @Autowired
    private final TransportadorRepo transportadorRepo;
    @Autowired
    private final VentaRepo ventaRepo;
    @Autowired
    private final DetalleVentaRepo detalleVentaRepo;
    @Autowired
    private final EnvioRepo envioRepo;
    @Autowired
    private final AfiliacionRepo afiliacionRepo;
    @Autowired
    private final CiudadRepo ciudadRepo;
    @Autowired
    private final PaisRepo paisRepo;
    @Autowired
    private final DireccionRepo direccionRepo;

    @Autowired
    private final SubcategoriaRepo subcategoriaRepo;


    public VendedorServicioImpl(VendedorRepo vendedorRepo, ProductoRepo productoRepo, InventarioEntradaRepo inventarioEntradaRepo, ClienteRepo clienteRepo, TransportadorRepo transportadorRepo, VentaRepo ventaRepo, DetalleVentaRepo detalleVentaRepo, EnvioRepo envioRepo, AfiliacionRepo afiliacionRepo, CiudadRepo ciudadRepo, PaisRepo paisRepo, DireccionRepo direccionRepo, SubcategoriaRepo subcategoriaRepo) {
        this.vendedorRepo = vendedorRepo;
        this.productoRepo = productoRepo;
        this.inventarioEntradaRepo = inventarioEntradaRepo;
        this.clienteRepo = clienteRepo;
        this.transportadorRepo = transportadorRepo;
        this.ventaRepo = ventaRepo;
        this.detalleVentaRepo = detalleVentaRepo;
        this.envioRepo = envioRepo;
        this.afiliacionRepo = afiliacionRepo;
        this.ciudadRepo = ciudadRepo;
        this.paisRepo = paisRepo;
        this.direccionRepo = direccionRepo;
        this.subcategoriaRepo = subcategoriaRepo;
    }

    //----------------------------------- LOGIN------------------------------------------

    @Override
    public Vendedor login(String correo, String contrasena) throws Exception {
        Vendedor vendedor = vendedorRepo.comprobarAutentificacion(correo, contrasena);
        return vendedor;
    }

    //----------------------------------- GESTIONAR VENDEDORES ------------------------------------

    //Cuano un objto se va crear con un codigo de incremento el metodo de crear es asi
    @Override
    public Vendedor crearVendedor(Vendedor vendedor) throws Exception {
        boolean vendedorExiste = VendedorRepetido(vendedor.getCodigo());
        if(vendedorExiste){
            throw new Exception("La cedula para el vendedor ya Existe");
        }
        boolean vendedorExisteCorreo = VendedorRepetidoCorreo(vendedor.getCorreo()) ;
        if(vendedorExisteCorreo){
            throw new Exception("El correo para el vendedor ya Existe");
        }
        return vendedorRepo.save(vendedor);
    }

    @Override
    public Vendedor obtenerVendedor(Integer codigo) throws Exception {
        Optional<Vendedor> vendedor = vendedorRepo.findById(codigo);
        if(vendedor.isEmpty()){
            throw new Exception("No existe un vendedor con ese codigo");
        }
        return vendedor.get();
    }

    private boolean VendedorRepetidoCorreo(String correo){
        return vendedorRepo.findByCorreo(correo).orElse(null)!=null;
    }

    private boolean VendedorRepetido(Integer codigo){
        return vendedorRepo.findByCodigo(codigo).orElse(null)!=null;
    }

    @Override
    public Vendedor actualizarVendedor(Vendedor vendedor) throws Exception {
        Optional<Vendedor> vendedorGuardado = vendedorRepo.findById(vendedor.getCodigo());
        if(vendedorGuardado.isEmpty()){
            throw new Exception("El vendedor NO EXISTE");
        }
        return vendedorRepo.save(vendedor);
    }

    @Override
    public void eliminarVendedor(Integer codigo) throws Exception {

        Optional<Vendedor> vendedorGuardado = vendedorRepo.findById(codigo);
        if(vendedorGuardado.isEmpty()){
            throw new Exception("El vendedor NO EXISTE");
        }
        vendedorRepo.delete(vendedorGuardado.get());
    }

    @Override
    public List<Vendedor> listarVendedor() {
        return vendedorRepo.findAll();
    }


    @Override
    public List<Vendedor> listarVendedoresVendedor(Integer codigo) {
        List<Vendedor> vendedores = vendedorRepo.obtenerVendedoresJefeVendedor(codigo);
        return vendedores;
    }

    //-----------------------------------GESTIONAR PRODUCTOS------------------------------------

    @Override
    public Producto crearProducto(Producto producto) throws Exception {
        boolean productoExiste = productoRepetido(producto.getCodigo());
        if(productoExiste){
            throw new Exception("La cedula para el vendedor ya Existe");
        }
        return productoRepo.save(producto);
    }

    private boolean productoRepetido(Integer codigo){
        return productoRepo.findByCodigo(codigo).orElse(null)!=null;
    }

    @Override
    public Producto obtenerProducto(Integer codigo) throws Exception {
        Optional<Producto> producto = productoRepo.findById(codigo);
        if(producto.isEmpty()){
            throw new Exception("No existe el producto con ese codigo");
        }
        return producto.get();
    }

    @Override
    public Producto actualizarProducto(Producto producto) throws Exception {
        Optional<Producto> productoGuardado = productoRepo.findById(producto.getCodigo());
        if (productoGuardado.isEmpty()){
            throw new Exception("El producto NO EXISTE");
        }
        return productoRepo.save(producto);
    }

    @Override
    public void eliminarProducto(Integer codigo) throws Exception {
        Optional<Producto> productoGuardado = productoRepo.findById(codigo);
        if (productoGuardado.isEmpty()){
            throw new Exception("El producto NO EXISTE");
        }
        productoRepo.delete(productoGuardado.get());
    }

    @Override
    public List<Producto> listarProducto() {
        return productoRepo.findAll();
    }

    //-----------------------------GESTIONAR INVENTARIOS ENTRADA-----------------------------------


    @Override
    public InventarioEntrada crearInventarioEntrada(InventarioEntrada inventarioEntrada) throws Exception {
        InventarioEntrada inventarioEntradaExiste = inventarioEntradaRepo.findById(inventarioEntrada.getCodigo()).orElse(null);
        if(inventarioEntradaExiste != null){
            throw new Exception("Ya existe el inventario de entrada con ese codigo ");
        }
        return inventarioEntradaRepo.save(inventarioEntrada);
    }

    @Override
    public InventarioEntrada obtenerInventarioEntrada(Integer codigo) throws Exception {
        Optional<InventarioEntrada> inventarioEntrada = inventarioEntradaRepo.findById(codigo);
        if (inventarioEntrada.isEmpty()){
            throw new Exception("No existe el inventarioEntrada con ese codigo");
        }
        return inventarioEntrada.get();
    }

    @Override
    public InventarioEntrada actualizarInventarioEntrada(InventarioEntrada inventarioEntrada) throws Exception {
        Optional<InventarioEntrada> inventarioEntradaGuardado = inventarioEntradaRepo.findById(inventarioEntrada.getCodigo());
        if (inventarioEntradaGuardado.isEmpty()){
            throw new Exception("El Inventario Entrada NO EXISTE");
        }
        return inventarioEntradaRepo.save(inventarioEntrada);
    }

    @Override
    public void eliminarInventarioEntrada(Integer codigo) throws Exception {
        Optional<InventarioEntrada> inventarioEntradaGuardado = inventarioEntradaRepo.findById(codigo);
        if (inventarioEntradaGuardado.isEmpty()){
            throw new Exception("El inventario entrada NO EXISTE");
        }
        inventarioEntradaRepo.delete(inventarioEntradaGuardado.get());
    }

    @Override
    public List<InventarioEntrada> listarInventarioEntrada() {
        return inventarioEntradaRepo.findAll();
    }

    @Override
    public List<InventarioEntrada> obtenerInventarioEntradaVendedor(Integer codigo) {
        List<InventarioEntrada> inventarioEntradas = inventarioEntradaRepo.mostrarInventarioEntradaVendedor(codigo);
        return inventarioEntradas;
    }

    //------------------------------------ GESTIONAR CLIENTES------------------------------------



    @Override
    public Cliente crearCliente(Cliente cliente) throws Exception {
        boolean clienteExiste = clienteRepetido(cliente.getCodigo());
        if(clienteExiste){
            throw new Exception("La cedula para el cliente ya Existe");
        }
        return clienteRepo.save(cliente);
    }

    private boolean clienteRepetido(Integer codigo){
        return clienteRepo.findByCodigo(codigo).orElse(null)!=null;
    }


    @Override
    public Cliente obtenerCliente(Integer codigo) throws Exception {
        Optional<Cliente> cliente = clienteRepo.findById(codigo);
        if(cliente.isEmpty()){
            throw new Exception("No se encontro el cliente");
        }
        return cliente.get();
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws Exception {
        Optional<Cliente> clienteGuardado = clienteRepo.findById(cliente.getCodigo());
        if (clienteGuardado.isEmpty()){
            throw new Exception("El cliente con este codigo no existe");
        }
        return clienteRepo.save(cliente);
    }

    @Override
    public void eliminarCliente(Integer codigo) throws Exception {
        Optional<Cliente> clienteGuardado = clienteRepo.findById(codigo);
        if (clienteGuardado.isEmpty()){
            throw new Exception("El cliente con este codigo no existe");
        }
        clienteRepo.delete(clienteGuardado.get());
    }

    @Override
    public List<Cliente> listarCliente() {
        return clienteRepo.findAll();
    }

    //-------------------------------------GESTIONAR TRANSORTADORES------------------------------


    @Override
    public Transportador crearTransportador(Transportador transportador) throws Exception {
        Transportador transportadorExiste = transportadorRepo.findById(transportador.getCodigo()).orElse(null);
        if(transportadorExiste != null){
            throw new Exception("Ya existe el transportador con ese codigo ");
        }
        return transportadorRepo.save(transportador);
    }

    @Override
    public Transportador obtenerTransportador(Integer codigo) throws Exception {
        Optional<Transportador> transportador = transportadorRepo.findById(codigo);
        if (transportador.isEmpty()){
            throw new Exception("No se encontro el transportador con este codigo");
        }
        return transportador.get();
    }

    @Override
    public Transportador actualizarTransportador(Transportador transportador) throws Exception {
        Optional<Transportador> trasportadorGuardado = transportadorRepo.findById(transportador.getCodigo());
        if (trasportadorGuardado.isEmpty()){
            throw new Exception("No se encontro el transportador con este codigo");
        }
        return transportadorRepo.save(transportador);
    }

    @Override
    public void eliminarTransportador(Integer codigo) throws Exception {
        Optional<Transportador> trasportadorGuardado = transportadorRepo.findById(codigo);
        if (trasportadorGuardado.isEmpty()){
            throw new Exception("No se encontro el transportador con este codigo");
        }
        transportadorRepo.delete(trasportadorGuardado.get());
    }

    @Override
    public List<Transportador> listarTransportador() {
        return transportadorRepo.findAll();
    }


    //------------------------------------- GESTIONAR VENTAS -----------------------------------

    @Override
    public Venta crearVenta(Venta venta) throws Exception {
        Venta ventaExiste = ventaRepo.findById(venta.getCodigo()).orElse(null);
        if(ventaExiste != null){
            throw new Exception("Ya existe la venta con ese codigo ");
        }
        return ventaRepo.save(venta);
    }

    @Override
    public Venta obtenerVenta(Integer codigo) throws Exception {
        Optional<Venta> venta = ventaRepo.findById(codigo);
        if (venta.isEmpty()){
            throw new Exception("No se encontro la venta con este codigo");
        }
        return venta.get();
    }

    @Override
    public Venta actualizarVenta(Venta venta) throws Exception {
        Optional<Venta> ventaGuardada = ventaRepo.findById(venta.getCodigo());
        if (ventaGuardada.isEmpty()){
            throw new Exception("No se encontro la venta con este codigo");
        }
        return ventaRepo.save(venta);
    }

    @Override
    public void eliminarVenta(Integer codigo) throws Exception {
        Optional<Venta> ventaGuardada = ventaRepo.findById(codigo);
        if (ventaGuardada.isEmpty()){
            throw new Exception("No se encontro la venta con este codigo");
        }
        ventaRepo.delete(ventaGuardada.get());
    }

    @Override
    public List<Venta> listarVenta() {
        return ventaRepo.findAll();
    }

    @Override
    public List<Venta> obtenerVentasVendedor(Integer codigo) {
        List<Venta> ventas = ventaRepo.ventasRealizadasPorVendedor(codigo);
        return ventas;
    }

    //-----------------------------------GESTIONAR DETALLE VENTAS --------------------------------


    @Override
    public DetalleVenta crearDetalleVenta(DetalleVenta detalleVenta) throws Exception {
        DetalleVenta detalleVentaExiste = detalleVentaRepo.findById(detalleVenta.getCodigo()).orElse(null);
        if(detalleVentaExiste != null){
            throw new Exception("Ya existe el detalle de venta con ese codigo ");
        }
        return detalleVentaRepo.save(detalleVenta);
    }

    @Override
    public DetalleVenta obtenerDetalleVenta(Integer codigo) throws Exception {
        Optional<DetalleVenta> detalleVenta = detalleVentaRepo.findById(codigo);
        if (detalleVenta.isEmpty()){
            throw new Exception("No se encontro la el detalle venta con este codigo");
        }
        return detalleVenta.get();
    }

    @Override
    public DetalleVenta actualizarDetalleVenta(DetalleVenta detalleVenta) throws Exception {
        Optional<DetalleVenta> detalleVentaGuardada = detalleVentaRepo.findById(detalleVenta.getCodigo());
        if (detalleVentaGuardada.isEmpty()){
            throw new Exception("No se encontro la el detalle venta con este codigo");
        }
        return detalleVentaRepo.save(detalleVenta);
    }

    @Override
    public void eliminarDetalleVenta(Integer codigo) throws Exception {
        Optional<DetalleVenta> detalleVenta = detalleVentaRepo.findById(codigo);
        if (detalleVenta.isEmpty()){
            throw new Exception("No se encontro la el detalle venta con este codigo");
        }
        detalleVentaRepo.delete(detalleVenta.get());
    }

    @Override
    public List<DetalleVenta> listarDetalleVenta() {
        return detalleVentaRepo.findAll();
    }

    @Override
    public List<DetalleVenta> obtenerDetalleVentasVendedor(Integer codigo){
        List<DetalleVenta> detalleVentas = detalleVentaRepo.obtenerDetallesVentasVendedor(codigo);
        return detalleVentas;
    }

    //----------------------------------- GESTIONAR ENVIOS -------------------------------------


    @Override
    public Envio crearEnvio(Envio envio) throws Exception {
        Envio envioExiste = envioRepo.findById(envio.getCodigo()).orElse(null);
        if(envioExiste != null){
            throw new Exception("Ya existe el envio con ese codigo ");
        }
        return envioRepo.save(envio);
    }

    @Override
    public Envio obtenerEnvio(Integer codigo) throws Exception {
        Optional<Envio> envioGuardado = envioRepo.findById(codigo);
        if(envioGuardado.isEmpty()){
            throw new Exception("No se encontro el envio con este codigo");
        }
        return envioGuardado.get();
    }

    @Override
    public Envio actualizarEnvio(Envio envio) throws Exception {
        Optional<Envio> envioGuardado = envioRepo.findById(envio.getCodigo());
        if(envioGuardado.isEmpty()){
            throw new Exception("No se encontro el envio con este codigo");
        }
        return envioRepo.save(envio);
    }

    @Override
    public void eliminarEnvio(Integer codigo) throws Exception {
        Optional<Envio> envioGuardado = envioRepo.findById(codigo);
        if(envioGuardado.isEmpty()){
            throw new Exception("No se encontro el envio con este codigo");
        }
        envioRepo.delete(envioGuardado.get());
    }

    @Override
    public List<Envio> listarEnvio() {
        return envioRepo.findAll();
    }

    //-------------------------------------GESTIONAR AFILIACIONES------------------------------


    @Override
    public Afiliacion crearAfiliacion(Afiliacion afiliacion) throws Exception {
        Afiliacion afiliacionExiste = afiliacionRepo.findById(afiliacion.getCodigo()).orElse(null);
        if(afiliacionExiste != null){
            throw new Exception("Ya existe la afiliacion con ese codigo ");
        }
        return afiliacionRepo.save(afiliacion);
    }

    @Override
    public Afiliacion obtenerAfiliacion(Integer codigo) throws Exception {
        Optional<Afiliacion> afiliacionGuardada = afiliacionRepo.findById(codigo);
        if(afiliacionGuardada.isEmpty()){
            throw new Exception("No se encontro la afiliacion con este codigo");
        }
        return afiliacionGuardada.get();
    }

    @Override
    public Afiliacion actualizarAfiliacion(Afiliacion afiliacion) throws Exception {
        Optional<Afiliacion> afiliacionGuardada = afiliacionRepo.findById(afiliacion.getCodigo());
        if(afiliacionGuardada.isEmpty()){
            throw new Exception("No se encontro la afiliacion con este codigo");
        }
        return afiliacionRepo.save(afiliacion);
    }

    @Override
    public void eliminarAfiliacion(Integer codigo) throws Exception {
        Optional<Afiliacion> afiliacionGuardada = afiliacionRepo.findById(codigo);
        if(afiliacionGuardada.isEmpty()){
            throw new Exception("No se encontro la afiliacion con este codigo");
        }
        afiliacionRepo.delete(afiliacionGuardada.get());
    }

    @Override
    public List<Afiliacion> listarAfiliacion() {
        return afiliacionRepo.findAll();
    }


    //-----------------------------------CIUDAD--------------------------------------


    @Override
    public Ciudad obtenerCiudad(Integer codigo) throws Exception {
        Optional<Ciudad> ciudad = ciudadRepo.findById(codigo);
        if(ciudad.isEmpty()){
            throw new Exception("No existe la ciudad con ese codigo postal");
        }
        return ciudad.get();
    }

    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepo.findAll();
    }

    @Override
    public List<Ciudad> listarCiudadesPorPais(Integer codigo) throws Exception{
        List<Ciudad> ciudades = ciudadRepo.obtenerCiudadesPorPais(codigo);
        if (ciudades.isEmpty()){
            throw new Exception("Existe este pais con ese codigo");
        }
        return ciudades;
    }

    //-------------------------------------------GESTIONAR PAIS------------------------
    @Override
    public Pais obtenerPais(Integer codigo) throws Exception {
        Optional<Pais> pais = paisRepo.findById(codigo);
        if(pais.isEmpty()){
            throw new Exception("No existe el pais con ese codigo ");
        }
        return pais.get();
    }

    @Override
    public List<Pais> listarPaises() {
        return paisRepo.findAll();
    }

    //-----------------------------------------GESTIONAR DIRECCIONES---------------------------
    @Override
    public Direccion crearDireccion(Direccion direccion) throws Exception {
        boolean direccionExiste = DireccionRepetido(direccion.getCodigo());
        if(direccionExiste){
            throw new Exception("El codigo de direccion ya Existe");
        }
        return direccionRepo.save(direccion);
    }

    private boolean DireccionRepetido(Integer codigo){
        return direccionRepo.findByCodigo(codigo).orElse(null)!=null;
    }

    //----------------------------------------GESTIONAR SUBCATEGORIAS--------------------

    @Override
    public Subcategoria obtenerSubcategoria(Integer codigo) throws Exception {
        Optional<Subcategoria> subcategoria = subcategoriaRepo.findById(codigo);
        if(subcategoria.isEmpty()){
            throw new Exception("No existe la subcategoria con ese codigo");
        }
        return subcategoria.get();
    }

    @Override
    public List<Subcategoria> listarSubcategorias() {
        return subcategoriaRepo.findAll();
    }

}

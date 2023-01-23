package grupo9.proyectogrupo9;



import java.util.ArrayList;

public class DataBase {

    public static ArrayList<Cliente> listaClientes = new ArrayList<>();
    public static ArrayList<Proveedor> listaProveedores = new ArrayList<>();;
    public static ArrayList<Servicio> listaServicios = new ArrayList<>();;
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();;
    public static ArrayList<Orden> listaOrdenes = new ArrayList<>();;

    public void agregarCliente(Cliente c) {
        listaClientes.add(c);
    }

    public void agregarProveedor(Proveedor p) {
        listaProveedores.add(p);
    }

    public void agregarServicio(Servicio s) {
        listaServicios.add(s);
    }

    public void agregarUsuario(Usuario u) {
        listaUsuarios.add(u);
    }

    public void agregarOrden(Orden o) {
        listaOrdenes.add(o);
    }

    public ArrayList<Cliente> accederClientes() {
        return listaClientes;
    }

    public ArrayList<Proveedor> accederProveedores() {
        return listaProveedores;
    }

    public ArrayList<Servicio> accederServicios() {
        return listaServicios;
    }

    public ArrayList<Usuario> accederUsuarios() {
        return listaUsuarios;
    }

    public ArrayList<Orden> accederOrdenes() {
        return listaOrdenes;
    }

    public static void init() {

        //se crean los objetos correspondientes
        //Usuarios
        Usuario u0 = new Usuario("a", "a", "Administrador", TipoUsuario.Admin);
        Usuario u1 = new Usuario("admin1", "12345678", "Administrador", TipoUsuario.Admin);
        Usuario u2 = new Usuario("alopez", "al123456", "Alvaro Lopez", TipoUsuario.Tecnico);
        Usuario u3 = new Usuario("mcastro", "mc123456", "Maria Castro", TipoUsuario.Cobranzas);
        Usuario u4 = new Usuario("mbarcos", "mb123456", "Mario Barcos", TipoUsuario.Tecnico);
        listaUsuarios.add(u0);
        listaUsuarios.add(u1);
        listaUsuarios.add(u2);
        listaUsuarios.add(u3);
        listaUsuarios.add(u4);
        //Clientes
        
        Cliente c0 = new Cliente("1234", "Nombre0", "Direccion0", "Telefono0", TipoCliente.Empresarial);
        Cliente c1 = new Cliente("4321", "Nombre1", "Direccion1", "Telefono1", TipoCliente.Personal);
        Cliente c2 = new Cliente("5678", "Nombre2", "Direccion2", "Telefono2", TipoCliente.Empresarial);
        Cliente c3 = new Cliente("8765", "Nombre3", "Direccion3", "Telefono3", TipoCliente.Personal);
        listaClientes.add(c0);
        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);

        //Servicios
        Servicio s0=new Servicio("1234","Nombre0",1234);
        Servicio s1=new Servicio("1234","Nombre1",1234);
        Servicio s2=new Servicio("1234","Nombre2",1234);
        Servicio s3=new Servicio("1234","Nombre3",1234);
        listaServicios.add(s0);
        listaServicios.add(s1);
        listaServicios.add(s2);
        listaServicios.add(s3);

        //Proveedores
        Proveedor p0=new Proveedor("1234","Nombre0","Direccion0","1234");
        Proveedor p1=new Proveedor("1234","Nombre1","Direccion1","1234");
        Proveedor p2=new Proveedor("1234","Nombre2","Direccion2","1234");
        Proveedor p3=new Proveedor("1234","Nombre3","Direccion3","1234");
        listaProveedores.add(p0);
        listaProveedores.add(p1);
        listaProveedores.add(p2);
        listaProveedores.add(p3);

        //Ordenes

    }
}

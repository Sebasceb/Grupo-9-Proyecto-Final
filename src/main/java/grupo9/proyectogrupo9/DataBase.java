package grupo9.proyectogrupo9;



import java.util.ArrayList;

public class DataBase {

    public ArrayList<Cliente> listaClientes = new ArrayList<>();
    public ArrayList<Proveedor> listaProveedores = new ArrayList<>();;
    public ArrayList<Servicio> listaServicios = new ArrayList<>();;
    public ArrayList<Usuario> listaUsuarios = new ArrayList<>();;
    public ArrayList<Orden> listaOrdenes = new ArrayList<>();;

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

    public void init() {

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

        //Servicios

        //Proveedores

        //Ordenes

    }
}

package grupo9.proyectogrupo9;

import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class Usuario {
    //atributos
    public String usuario;
    public String contrasena;
    public String nombre;
    public TipoUsuario nivel;
    public static ArrayList<Usuario> listaUsuarios;

    public String getNombre() {
        return nombre;
    }

    public TipoUsuario getNivel() {
        return nivel;
    }

    public static ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
    
    //getterssetters
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public String getUsuario(){
        return usuario;
    }
    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }
    public String getContrasena(){
        return contrasena;
    }
    
    //constructor
    public Usuario(String usuario, String contrasena){
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    
    public Usuario(String usuario, String contrasena, String nombre, TipoUsuario nivel){
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.nivel = nivel;
    }
    
    @Override
    public boolean equals (Object u) {
        return (this.usuario.equals(((Usuario)u).usuario) && this.contrasena==((Usuario)u).contrasena);    
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grupo9.proyectogrupo9;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class JuegoMemoriaController implements Initializable{
    public ArrayList<Integer> codigos;
    public ArrayList<int[]> posiciones;
    public ArrayList<Tarjetas> listaTarjetas;
    public ArrayList<Tarjetas> Selecciones;
    public boolean bandera;
    
    @FXML
    private GridPane tarjetasPane;
    
    int columnas= 6;
    int filas= 4;
    
    @FXML
    private void regresarInicio() throws IOException {
        App.setRoot("MenuInicio");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        codigos=new ArrayList();
        posiciones=new ArrayList();
        listaTarjetas=new ArrayList();
        Selecciones=new ArrayList();
        bandera=true;
      
        System.out.println("Hello World");
        llenarGridPane();/*
        Runnable task2 = () -> { llenarGridPane(); };
        new Thread(task2).start();*/
        
    }
   
    
    public void llenarGridPane(){
        
        tarjetasPane.getChildren().clear();
        limpiaListas();
        
        for(int c:codigos){
            
            Tarjetas btn1= new Tarjetas(c);
            listaTarjetas.add(btn1);
            Tarjetas btn2= new Tarjetas(c);
            listaTarjetas.add(btn2);
          
        }
        Collections.shuffle(listaTarjetas);
        
        for(int i=0;i<posiciones.size(); i++){
           int[] posi=posiciones.get(i);
           Tarjetas tarjeta=listaTarjetas.get(i);
           tarjeta.setPosicion(posi);
           tarjetasPane.add(tarjeta,posi[0],posi[1]);
            
        }   
    }
    
    public void limpiaListas(){
        if(codigos!=null)
            codigos.clear();
        if(posiciones!=null)
            posiciones.clear();
        
        for(int i=0; i<(columnas*filas/2); i++){
            codigos.add(i);
        }
        for(int c=0; c<columnas; c++){
            for(int f=0; f<filas; f++){
                int[] posi={c,f};
                posiciones.add(posi);
            }
        }
        
        Collections.shuffle(codigos);
        Collections.shuffle(posiciones);
        
    } 
    
    public void verificador(Tarjetas t){
        if (bandera){
            t.bocaArriba();
            Selecciones.add(t);

            if(Selecciones.size()>1){


                Tarjetas seleccion1=Selecciones.get(0);
                Tarjetas seleccion2=Selecciones.get(1);
                if(seleccion1.getCodigo()==seleccion2.getCodigo()){
                    for(Tarjetas carta: listaTarjetas){
                            if(seleccion1.getCodigo()==carta.getCodigo()){
                                carta.setEstado(Estado.OUT);

                            }
                            if(seleccion2.getCodigo()==carta.getCodigo()){
                                carta.setEstado(Estado.OUT);
                            }  
                        }
                }else{

                    Thread hilo = new Thread(() -> {
                        bandera=false;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }


                        Platform.runLater(new Runnable() {
                            public void run() {
                                for(Tarjetas carta: listaTarjetas){
                                    if(seleccion1.getCodigo()==carta.getCodigo())
                                        carta.bocaAbajo();
                                    if(seleccion2.getCodigo()==carta.getCodigo())
                                        carta.bocaAbajo();
                                }
                            }
                        });
                        bandera=true;
                    });
                    hilo.start();

                }
                Selecciones.clear();
            }
        }   
    }
    
    
    
    public final class Tarjetas extends Button {
        private String ruta;
        private int codigo;
        private static final String cardBack="files/cardback.jpg";
        private Estado estado;
        private int[] posicion;

        public Tarjetas(int c){
            super();

            ruta="files/"+c+".jpeg";
            codigo=c;
            this.prefHeight(50);
            this.prefWidth(50);
            this.setText("");
            this.bocaAbajo();
            this.setOnAction(eh -> {manejaBoton();});
        }

        public int[] getPosicion() {
            return posicion;
        }

        public void setPosicion(int[] posicion) {
            this.posicion = posicion;
        }

        public Estado getEstado() {
            return estado;
        }

        public void setEstado(Estado estado) {
            this.estado = estado;
        }


        public String getRuta() {
            return ruta;
        }

        public void setRuta(String ruta) {
            this.ruta = ruta;
        }

        public int getCodigo() {
            return codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

        public void bocaAbajo(){
            if(this.estado==Estado.OUT)
                return;

            this.estado=Estado.OFF;
            ImageView imgv = new ImageView();
             try ( FileInputStream input = new FileInputStream(Tarjetas.cardBack)){
                 Image image = new Image(input);
                 imgv.setImage(image);
                 this.setGraphic(imgv);
             }catch(IOException e){
                 System.out.println(e.getMessage());
             }
        }

        public void bocaArriba(){
            if(this.estado==Estado.OUT)
                return;
            
            this.estado=Estado.ON;
            ImageView imgv = new ImageView();
             try ( FileInputStream input = new FileInputStream(this.ruta)){
                 Image image = new Image(input);
                 imgv.setImage(image);
                 this.setGraphic(imgv);
             }catch(IOException e){
                 System.out.println(e.getMessage());
             }
        }

        public void manejaBoton(){
            
        
            if(this.estado==Estado.OFF){
                
                verificador(this);
            }else
                return;
        }

    }
}


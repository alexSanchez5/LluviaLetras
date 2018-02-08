/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluvialetras;


import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author alejandro sanchez
 */
public class Vista extends JFrame{
    
    private Controlador c;
    private Barra barra;
    private Letra letra;
    private MenuBar menu;
    private Menu archivo;
    private Menu nivel;
    private JPanel barraPerder;
    private JLabel gameover,puntuacion,nivelPant;
    private int velocidadCreacion=500;
    private Timer timer;
    ArrayList<Letra>arrayletras=new ArrayList();
    
    public Vista(Controlador c){
        this.c=c;
        crearVentana();
        //crear Timer
        timer=new Timer(velocidadCreacion, c);
        timer.start();
    }
    
    public void crearBarra(){
        barra=new Barra();
        add(barra);
    }
    
    public void crearLetra(String let){
        if(!let.equals("1")){
            letra=new Letra(let,this);
            letra.addKeyListener(c);
            arrayletras.add(letra);
            add(letra);
        }
        
    }
    
    /**
     * Crea el menu
     */
    public void crearMenu(){
        menu=new MenuBar();
        
        archivo=new Menu("Archivo");
        MenuItem guardar=new MenuItem("Guardar");
        guardar.addActionListener(c);
        archivo.add(guardar);
        MenuItem cargar=new MenuItem("Cargar");
        cargar.addActionListener(c);
        archivo.add(cargar);
        MenuItem salir=new MenuItem("Salir");
        salir.addActionListener(c);
        archivo.add(salir);
       
        nivel=new Menu("Nivel");
        for (int i = 1; i < 6; i++) {
            MenuItem nNivel=new MenuItem("Nivel "+i);
            nivel.add(nNivel);
        }
        
        menu.add(archivo);
        menu.add(nivel);
        this.setMenuBar(menu);
    }
    
    public void crearVentana(){
        setLayout(null);
        crearBarra();
        crearMenu();
        barraPerder=new JPanel();
        barraPerder.setBounds(0, 480, 400, 20);
        barraPerder.setBackground(Color.yellow);
        add(barraPerder);
        this.addKeyListener(c);
        //creo el label de puntuacion y el nivel en el que esta
        puntuacion=new JLabel("Puntuacion: ");
        puntuacion.setFont(puntuacion.getFont().deriveFont(25.0f));
        puntuacion.setBounds(10, 495, 200, 50);
        add(puntuacion);
        nivelPant=new JLabel("Nivel 1");
        nivelPant.setBounds(300, 0, 100, 50);
        nivelPant.setFont(nivelPant.getFont().deriveFont(20.0f));
        add(nivelPant);
        //general
        this.getContentPane().setBackground(Color.CYAN);
        this.setBounds(100, 100, 400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void moverBarra(int d){
        if(barra.getX()<10){
            barra.setDireccion(0);
            barra.setX(10);
            barra.mover();
        }else if(barra.getX()>380-barra.getANCHO()){
            barra.setDireccion(0);
            barra.setX(310);
            barra.mover();
        }else{
            barra.setDireccion(d);
            barra.mover();
        }
        repaint();
    }
    
    public void eliminar(char le){
        for (int i = 0; i < arrayletras.size(); i++) {
            if(arrayletras.get(i).getText().charAt(0)==le){
                this.remove(arrayletras.get(i));
                arrayletras.remove(i);
            }
        }
    }
    
    public void chocar(){
        boolean choca=false;
        for (int i = 0; i < arrayletras.size()-1; i++) {
            if(arrayletras.get(i).getY()==barraPerder.getY()){
                choca=true;
                c.setPerder(true);
                timer.stop();
            }
        }
        if(choca){
            for (int i = 0; i < arrayletras.size(); i++) {
                this.remove(arrayletras.get(i));
            }
            arrayletras.clear();
            gameOver();
        }
    }
    
    public void gameOver(){
        gameover=new JLabel("HAS PERDIDO, SIGUE PRACTICANDO");
        gameover.setBounds(50, 250, 300, 50);
        add(gameover);
    }
    
    public void aumentarVelocidad() {
        new Timer(velocidadCreacion, c).start();
    }
    /**
     * modifica la puntuacion que va haciendo el jugador
     * @param n - la puntuacion que recoge del controlador
     */
    public void modificarPuntuacion(int n){
        puntuacion.setText("Puntuacion: "+n);
    }
    /**
     * modifica el nivel en el que se encuentra el jugador
     * @param n - el nivel que recoge del controlador
     */
    public void modificarNivel(int n){
        nivelPant.setText("Nivel "+n);
    }
}
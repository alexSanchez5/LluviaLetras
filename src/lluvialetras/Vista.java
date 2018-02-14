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
import java.awt.MenuShortcut;
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
    ArrayList<Timer> arrayTimers=new ArrayList();
    
    public Vista(Controlador c){
        this.c=c;
        jugar();
    }
    /**
     * Empieza el juego
     */
    public void jugar(){
        crearVentana();
        //crear Timer
        timer=new Timer(velocidadCreacion, c);
        timer.start();
        arrayTimers.add(timer);
    }
    
    /**
     * Crea la barra en la que rebotan las letras
     */
    public void crearBarra(){
        barra=new Barra();
        add(barra);
    }
    
    /**
     * Si el parámetro es distinto de uno, se crea la letra que se le mande y se añade al array
     * @param let - La letra que haya que crear. Si es igual a 1 no se hace nada
     */
    public void crearLetra(String let){
        if(!let.equals("1")){
            letra=new Letra(let,this);
            letra.addKeyListener(c);
            letra.setFont(new java.awt.Font("Tahoma", 0, 20));
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
        MenuItem reiniciar=new MenuItem("Reiniciar");
        reiniciar.addActionListener(c);
        archivo.add(reiniciar);
        MenuItem salir=new MenuItem("Salir");
        salir.addActionListener(c);
        archivo.add(salir);
       
        nivel=new Menu("Nivel");
        for (int i = 1; i < 10; i++) {
            MenuItem nNivel=new MenuItem("Nivel "+i);
            nNivel.setShortcut(new MenuShortcut(48+i,false));
            nNivel.addActionListener(c);
            nivel.add(nNivel);
        }
        
        menu.add(archivo);
        menu.add(nivel);
        this.setMenuBar(menu);
    }
    
    /**
     * Crea la ventana
     */
    public void crearVentana(){
        setLayout(null);
        crearBarra();
        crearMenu();
        barraPerder=new JPanel();
        barraPerder.setBounds(0, 580, 400, 20);
        barraPerder.setBackground(Color.yellow);
        add(barraPerder);
        this.addKeyListener(c);
        //creo el label de puntuacion y el nivel en el que esta
        puntuacion=new JLabel("Puntuacion: ");
        puntuacion.setFont(puntuacion.getFont().deriveFont(25.0f));
        puntuacion.setBounds(10, 600, 200, 50);
        add(puntuacion);
        nivelPant=new JLabel("Nivel 1");
        nivelPant.setBounds(300, 0, 100, 50);
        nivelPant.setFont(nivelPant.getFont().deriveFont(20.0f));
        add(nivelPant);
        this.getContentPane().setBackground(Color.CYAN);
        this.setBounds(100, 0, 400, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    /**
     * Cambia la direccion y la posicion de la barra en función del número que le mandes
     * @param d - la dirección en la que se va a mover
     */
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
    
    /**
     * Elimina la letra que le mandes de la pantalla y del arraylist de letras
     * @param le - la letra que se va a eliminar
     */
    public void eliminar(char le){
        for (int i = 0; i < arrayletras.size(); i++) {
            if(arrayletras.get(i).getText().charAt(0)==le){
                this.remove(arrayletras.get(i));
                arrayletras.remove(i);
            }
        }
    }
    
    /**
     * Primero comprueba si choca con la barra de abajo, y después si choca con la barra pequeña. Si 
     * choca con la barra pequeña, se cambia la dirección de movimiento de la letra. Si no, pierde y se 
     * limpia la pantalla
     */
    public void chocar(){
        boolean choca=false;
        for (int i = 0; i < arrayletras.size()-1; i++) {
            if(arrayletras.get(i).getBounds().intersects(barraPerder.getBounds()) || arrayletras.get(i).getY()<0){
                if(arrayletras.get(i).getBounds().intersects(barra.getBounds())){
                    arrayletras.get(i).setBajar(false);
                }else {
                    choca=true;
                    c.setPerder(true);
                }
                

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
    
    /**
     * Crea el texto que aparece cuando pierdes
     */
    public void gameOver(){
        gameover=new JLabel("HAS PERDIDO, SIGUE PRACTICANDO");
        gameover.setBounds(50, 250, 300, 50);
        add(gameover);
    }
    
    /**
     * Crea un nuevo timer para aumentar la velocidad de creación de las letras
     */
    public void aumentarVelocidad() {
        Timer timer=new Timer(velocidadCreacion, c);
        timer.start();
        arrayTimers.add(timer);
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
    
    /**
     * Elimina todos los timers de generación de letras que haya y crea tantos como se le pase por parámetro
     * @param nivel - el numero de timers que se va a generar
     */
    public void cambiarNivel(int nivel){
        for (int i = 0; i < arrayTimers.size(); i++) {
            arrayTimers.get(i).stop();
        }
        arrayTimers.clear();
        for (int i = 0; i < nivel; i++) {
            Timer timer=new Timer(velocidadCreacion, c);
            timer.start();
            arrayTimers.add(timer);
        }
    }
}
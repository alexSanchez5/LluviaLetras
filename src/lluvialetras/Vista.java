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
    private Barra barra1,barra2;
    private Letra letra;
    private MenuBar menu;
    private Menu archivo;
    private Menu nivel;
    private JPanel barraPerder1,barraPerder2;
    private JLabel gameover,puntuacion,nivelPant,nombre;
    private int velocidadCreacion=500;
    private Timer timer;
    ArrayList<Letra>arrayletras=new ArrayList();
    ArrayList<Timer> arrayTimers=new ArrayList();
    
    public Vista(Controlador c){
        this.c=c;
        jugar();
    }
    /**
     * Empieza el juego, crea la ventana de juego, y el timer que va creando letras aleatorias
     */
    public void jugar(){
        crearVentana();
        //crear Timer
        timer=new Timer(velocidadCreacion, c);
        timer.start();
        arrayTimers.add(timer);
    }
    
    /**
     * Crea la barra1 en la que rebotan las letras
     */
    public void crearBarras(){
        barra1=new Barra(0);
        add(barra1);
        barra2=new Barra(580);
        add(barra2);
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
     * Crea el menu, con todas sus opciones y sus aceleradores
     */
    public void crearMenu(){
        menu=new MenuBar();
        
        archivo=new Menu("Archivo");
        MenuItem pausar=new MenuItem("Pausar/Reanudar");
        pausar.addActionListener(c);
        archivo.add(pausar);
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
        crearBarras();
        crearMenu();
        barraPerder2=new JPanel();
        barraPerder2.setBounds(0, 580, 400, 20);
        barraPerder2.setBackground(Color.yellow);
        add(barraPerder2);
        barraPerder1=new JPanel();
        barraPerder1.setBounds(0, 0, 400, 20);
        barraPerder1.setBackground(Color.yellow);
        add(barraPerder1);
        this.addKeyListener(c);
        //creo el label de puntuacion y el nivel en el que esta
        puntuacion=new JLabel("Puntuacion: ");
        puntuacion.setFont(puntuacion.getFont().deriveFont(25.0f));
        puntuacion.setBounds(10, 600, 200, 50);
        add(puntuacion);
        nivelPant=new JLabel("Nivel 1");
        nivelPant.setBounds(300, 20, 100, 50);
        nivelPant.setFont(nivelPant.getFont().deriveFont(20.0f));
        add(nivelPant);
        nombre=new JLabel("");
        nombre.setBounds(10, 20, 150, 50);
        nombre.setFont(nombre.getFont().deriveFont(20.0f));
        add(nombre);
        this.getContentPane().setBackground(Color.CYAN);
        this.setBounds(100, 0, 400, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    /**
     * Cambia la direccion y la posicion de la barra1 en función del número que le mandes
     * @param d - la dirección en la que se va a mover
     */
    public void moverBarra(int d){
        if(barra1.getX()<10){
            barra1.setDireccion(0);
            barra1.setX(10);
            barra1.mover();
            barra2.setDireccion(0);
            barra2.setX(barra2.getX()+10);
            barra2.mover();
        }else if(barra2.getX()>380-barra2.getANCHO()){
            barra1.setDireccion(0);
            barra1.setX(barra2.getX()-10);
            barra1.mover();
            barra2.setDireccion(0);
            barra2.setX(310);
            barra2.mover();
        }else{
            barra1.setDireccion(d);
            barra1.mover();
            barra2.setDireccion(d);
            barra2.mover();
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
     * Primero comprueba si choca con la barra1 de abajo, y después si choca con la barra1 pequeña. Si 
 choca con la barra1 pequeña, se cambia la dirección de movimiento de la letra. Si no, pierde y se 
 limpia la pantalla
     */
    public void chocar(){
        boolean choca=false;
        for (int i = 0; i < arrayletras.size()-1; i++) {
            if(arrayletras.get(i).getBounds().intersects(barraPerder2.getBounds()) || arrayletras.get(i).getBounds().intersects(barraPerder1.getBounds())){
                if(arrayletras.get(i).getBounds().intersects(barra2.getBounds()) ){
                    arrayletras.get(i).setBajar(false);
                }else if(arrayletras.get(i).getBounds().intersects(barra1.getBounds())){
                    arrayletras.get(i).setBajar(true);
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
        gameover=new JLabel("HAS PERDIDO SIGUE PRACTICANDO");
        gameover.setFont(new java.awt.Font("Tahoma", 0, 15));
        gameover.setBounds(75, 250, 300, 50);
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
        letra.setNivel(n);
        barra1.aumentarNivel();
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
    /**
     * este metodo cambia las veces que le faltan por pulsar a la tecla.
     */
    public void modificarCont(char le){
        for (int i = 0; i < arrayletras.size(); i++) {
            if(arrayletras.get(i).getText().charAt(0)==le){
                arrayletras.get(i).setContadorPulsado(arrayletras.get(i).getContadorPulsado()-1);
                ponerColor(arrayletras.get(i).getContadorPulsado(),arrayletras.get(i));
            }
        }
    }
    /**
     * @return - retorna el contador de veces pulsadas que le faltan a la tecla
     */
    public int darCont(char l){
        for (int i = 0; i < arrayletras.size(); i++) {
            if(arrayletras.get(i).getText().charAt(0)==l){
                return arrayletras.get(i).getContadorPulsado();
            }
        }
        return 0;
    }
    /**
     * pinta la letra del color que le corresponde
     */
    public void ponerColor(int n, Letra l){
        switch(n){
            case 1:
                l.setForeground(Color.blue);
                break;
            case 2:
                l.setForeground(Color.red);
                break;
            case 3:
                l.setForeground(Color.black);
                break;
        }
        repaint();
    }
    
    public void pausar (){
        for (int i = 0; i < arrayletras.size(); i++) {
                this.remove(arrayletras.get(i));
            }
        arrayletras.clear();
        for (int i = 0; i < arrayTimers.size(); i++) {
            arrayTimers.get(i).stop();
        }
        arrayTimers.clear();
        c.limpiarComprobar();
    }
    
    public void reanudar(int n){
        for (int i = 0; i < n; i++) {
            timer=new Timer(velocidadCreacion, c);
            timer.start();
            arrayTimers.add(timer);
        }
    }

    public JLabel getNombre() {
        return nombre;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluvialetras;


import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
    
    public Vista(Controlador c){
        this.c=c;
        crearVentana();
    }
    
    public void crearBarra(){
        barra=new Barra();
        add(barra);
    }
    
    /**
     * Crea el menu
     */
    public void crearMenu(){
        menu=new MenuBar();
        
        archivo=new Menu("Archivo");
        MenuItem guardar=new MenuItem("Guardar");
        archivo.add(guardar);
        MenuItem cargar=new MenuItem("Cargar");
        archivo.add(cargar);
        MenuItem salir=new MenuItem("Salir");
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
        barraPerder.setBounds(0, 500, 400, 20);
        barraPerder.setBackground(Color.yellow);
        add(barraPerder);
        //general
        this.setBounds(100, 100, 400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
}
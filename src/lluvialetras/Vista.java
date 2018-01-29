/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluvialetras;

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
    private JPanel barraPerder;
    
    public Vista(Controlador c){
        this.c=c;
        crearVentana();
    }
    
    public void crearBarra(){
        barra=new Barra();
        add(barra);
    }
    
    public void crearMenu(){
        
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
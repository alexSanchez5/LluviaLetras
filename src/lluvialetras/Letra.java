/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluvialetras;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author alejandro sanchez
 */
public class Letra extends JLabel{
    
    private int velocidad=50;
    private int x,y=0;
    private boolean bajar=true;
    ControladorLetra c;
    private Vista v;

    /**
     * Crea la letra con los parámetros que se le manden
     * @param let - La letra que va a ser
     * @param v - La vista en la que se genera
     */
    public Letra(String let,Vista v) {
        this.v=v;
        setText(let);
        x=aleatorio(380,5);
        setBounds(x,y,30,30);
        c=new ControladorLetra(this);
        new Timer(velocidad, c).start();
    }
    
    /**
     * Retorna un número aleatorio que se encuentre entre los dos parámetros
     * @param max - El máximo 
     * @param min - El mínimo
     * @return 
     */
    public int aleatorio(int max, int min){
        return (int)Math.floor(Math.random()*(max-min)+min);
    }
    
    /**
     * Llama a l método chocar de la vista
     */
    public void chocar(){
        v.chocar();
    }
    
    /**
     * Mueve la letra en la direccion que le corresponda y actualiza la vista
     */
    public void mover(){
        if(bajar){
            y=y+5;
        }else{
            y=y-5;
        }
        setBounds(x,y,20,20);
        actualizar();
    }
    
    /** 
     * Actualiza la vista
     */
    public void actualizar(){
        v.repaint();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setBajar(boolean bajar) {
        this.bajar = bajar;
    }
    
    public int getVelocidad() {
        return velocidad;
    }
    
    
    
}

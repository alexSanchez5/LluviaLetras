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

    public Letra(String let,Vista v) {
        this.v=v;
        setText(let);
        setBackground(Color.blue);
        x=aleatorio(380,5);
        setBounds(x,y,20,20);
        c=new ControladorLetra(this);
        new Timer(velocidad, c).start();
    }
    
    public int aleatorio(int max, int min){
        return (int)Math.floor(Math.random()*(max-min)+min);
    }
    
    public void chocar(){
        v.chocar();
    }
    
    public void mover(){
        if(bajar){
            y=y+5;
        }else{
            y=y-5;
        }
        setBounds(x,y,20,20);
        actualizar();
    }

    public int getVelocidad() {
        return velocidad;
    }
    
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
    
    
    
}

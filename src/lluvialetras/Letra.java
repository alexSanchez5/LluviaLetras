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

    public Letra() {
        setBackground(Color.blue);
        x=aleatorio(200,5);
        setBounds(x,y,20,20);
        c=new ControladorLetra(this);
        new Timer(velocidad, c).start();

    }
    
    public int aleatorio(int max, int min){
        return (int)Math.floor(Math.random()*(max-min)+min);
    }
    
    public void chocar(){
        
    }
    
    public void mover(){
        System.out.println(x+"-"+y);
        if(bajar){
            if (y < 285) {
                y=y+5;
            }
        }else{
            if(y>0){
                y=y-5;
            }
        }
        setBounds(x,y,20,20);
    }

    public int getVelocidad() {
        return velocidad;
    }
    
    
}

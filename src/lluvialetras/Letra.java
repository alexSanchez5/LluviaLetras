/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluvialetras;

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

    public Letra() {
        x=aleatorio(400,5);
        new Timer(velocidad, c).start();

    }
    
    public int aleatorio(int max, int min){
        return (int)Math.floor(Math.random()*(max-min)+min);
    }
    
    public void chocar(){
        
    }
    
    public void mover(){
        if(bajar){
            if (y < 285) {
                y=y+5;
            }
        }else{
            if(y>0){
                y=y-5;
            }
        }

    }

    public int getVelocidad() {
        return velocidad;
    }
    
    
}

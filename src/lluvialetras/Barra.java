/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluvialetras;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author alejandro sanchez
 */
public class Barra extends JPanel{
    
    private int x=200,y=500;
    private int direccion;
    private final int PARADO=0;
    private final int IZDA=1;
    private final int DCHA=2;

    public Barra() {
        setBounds(x,y,70,20);
        setBackground(Color.red);
    }
    
    /**
     * Mueve la barra 10 hacia la dir que se le mande
     * 
     */
    public void mover(){
        if(direccion==IZDA){
            x+=10;
        }else if(direccion==DCHA){
            x-=10;
        }
        setBounds(x,y,70,20);
    }
    
    /**
     * Cambiar la direccion
     * @param dir 
     */
    public void setDireccion(int dir){
        direccion=dir;
    }

    public int getX() {
        return x;
    }
    
    
    
}
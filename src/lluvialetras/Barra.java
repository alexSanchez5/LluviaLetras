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
    
    private int x=200,y;
    private final int ANCHO=70,ALTO=20;
    private int direccion;
    private final int PARADO=0;
    private final int IZDA=1;
    private final int DCHA=2;

    public Barra(int y) {
        this.y=y;
        setBounds(x,y,ANCHO,ALTO);
        setBackground(Color.GREEN);
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
     * Separa las barras en las que rebotan las letras
     */
    public void aumentarNivel(){
        x-=10;
        this.setBounds(x, y, ANCHO, ALTO);
       
    }
    
    /**
     * Cambiar la direccion
     * @param dir - direccion a la que cambia
     */
    public void setDireccion(int dir){
        direccion=dir;
    }

    public int getX() {
        return x;
    }

    public int getANCHO() {
        return ANCHO;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    
    
    
    
}
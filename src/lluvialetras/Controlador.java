/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluvialetras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 *
 * @author alejandro sanchez
 */
public class Controlador implements KeyListener, ActionListener{
    
    Vista v=new Vista(this);
    Modelo m=new Modelo(this);
    
    
    public Controlador(){
        
    }
//keyListener
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()){
            case 40:
                v.moverBarra(0);
                break;
            case 37:
                v.moverBarra(2);
                break;
            case 39:
                v.moverBarra(1);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
//Action Listener
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand()==null){
            v.crearLetra(""+m.DarLetra());
        }else if(ae.getActionCommand().equals("salir")){
            System.exit(0);
        }
        v.repaint();
    }

}
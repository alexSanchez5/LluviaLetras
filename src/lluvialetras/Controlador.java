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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//Action Listener
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand()==null){
            v.crearLetra();
        }else if(ae.getActionCommand().equals("salir")){
            System.exit(0);
        }
        v.repaint();
    }

}
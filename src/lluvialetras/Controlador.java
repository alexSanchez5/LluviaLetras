/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluvialetras;

import java.awt.Color;
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
    boolean perder=false;
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }
/**
 * este metodo genera un evento cuando presionas una tecla, y nos servira para saber que tecla esta pulsando y comprobar, si
 * es una flecha para mover la barra o es una letra para comprobar.
 * @param ke  - es el evento generado.
 */
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
            default:
                comprobarLetra(ke.getKeyChar());
                
        }
        
    }
/**
 * este metodo sirve para que cuando suelte una tecla fallida el color de la pantalla vuelva a ser el mismo,
 * y no se quede en rojo por fallida.
 * @param ke - evento que genera al soltar la tecla
 */
    @Override
    public void keyReleased(KeyEvent ke) {
        v.getContentPane().setBackground(Color.CYAN);
    }
/**
 * este metodo ejecuta un evento o accion, comprueba si la ha generado algun boton como puede ser el salir,
 * o cualquiera de los niveles, o por el contrario se ha ejecutado automaticamente (null).
 * @param ae - es el evento generado.
 */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand()==null){
            if(!perder){
                v.crearLetra(""+m.darLetra());
            }
        }else if(ae.getActionCommand().equals("Salir")){
            System.exit(0);
        }else{
            switch (ae.getActionCommand()) {
                case "Nivel 1":
                    v.cambiarNivel(1);
                    m.setNivel(1);
                    break;

                case "Nivel 2":
                    v.cambiarNivel(2);
                    m.setNivel(2);
                    break;

                case "Nivel 3":
                    v.cambiarNivel(3);
                    m.setNivel(3);
                    break;

                case "Nivel 4":
                    v.cambiarNivel(4);
                    m.setNivel(4);
                    break;

                case "Nivel 5":
                    v.cambiarNivel(5);
                    m.setNivel(5);
                    break;
                    
                    case "Nivel 6":
                    v.cambiarNivel(6);
                    m.setNivel(6);
                    break;
                    
                    case "Nivel 7":
                    v.cambiarNivel(7);
                    m.setNivel(7);
                    break;
                    
                    case "Nivel 8":
                    v.cambiarNivel(8);
                    m.setNivel(8);
                    break;
                    
                    case "Nivel 9":
                    v.cambiarNivel(9);
                    m.setNivel(9);
                    break;

            }
            mandarNivel();
        }
        v.repaint();
    }

    /**
     * este metodo manda al modelo que compruebe si esta la letra a eliminar y si es asi la elimina tambien de la pantalla, 
     * ademas modifica la puntuacion y modifica el color de la pantalla.
     * @param letra - es la letra pulsada por el usuario
     */
    public void comprobarLetra(char letra){
        letra=java.lang.Character.toUpperCase(letra);
        if(!perder){
            if(m.eliminar(letra)){
                v.eliminar(letra);
                m.sumarContador(true);
            }else{
                v.getContentPane().setBackground(Color.red);
                m.sumarContador(false);
            }
        }
        mandarPuntuacion();       
    }

    public void setPerder(boolean perder) {
        this.perder = perder;
    }
    /**
     * este metodo como su propio nombre indica aumenta el nivel de juego en el modelo
     */
    public void aumentarNivel() {
        v.aumentarVelocidad();
        mandarNivel();
    }
    /**
     * este metodo modifica la puntuacion del usuario
     */
    public void mandarPuntuacion(){
        v.modificarPuntuacion(m.getContadorAciertos());
    }
    /**
     * este metodo cambia el nivel de la pantalla para que el usuario lo vea
     */
    public void mandarNivel(){
        v.modificarNivel(m.getNivel());
    }
}
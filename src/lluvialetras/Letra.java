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
    
    private final int VEL1=70;
    private final int VEL2=60;
    private final int VEL3=50;
    private final int VEL4=40;
    private final int VEL5=30;
    private int contadorPulsado;
    private int x,y=20;
    private int nivel=1;
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
        x=aleatorio(370,5);
        setBounds(x,y,30,30);
        c=new ControladorLetra(this);
        contadorPulsado=aleatorio(4,1);
        v.ponerColor(contadorPulsado,this);
        crearTimer();
    }
    
    /**
     * crea el timer de caida dependiendo del nivel en el que te encuentras
     */
    public void crearTimer(){
        System.out.println(nivel);
        switch(aleatorio(nivel+1,1)){
            case 1:
                new Timer(VEL1, c).start();
                break;
            case 2:
                new Timer(VEL2, c).start();
                break;
            case 3:
                new Timer(VEL3, c).start();
                break;
            case 4:
                new Timer(VEL4, c).start();
                break;
            default:
                new Timer(VEL5, c).start();
                break;
        }
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

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getContadorPulsado() {
        return contadorPulsado;
    }

    public void setContadorPulsado(int contadorPulsado) {
        this.contadorPulsado = contadorPulsado;
    }
    
}
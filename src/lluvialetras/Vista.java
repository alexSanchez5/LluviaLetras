/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluvialetras;

/**
 *
 * @author alejandro sanchez
 */
public class Vista {
    
    private Controlador c;
    private Barra barra;
    private Letra letra;
    
    public Vista(Controlador c){
        this.c=c;
    }
    
    public void crearBarra(){
        barra=new Barra();
    }
    
    public void crearMenu(){
        
    }
    
    public void crearVentana(){
        
    }
    
    
}
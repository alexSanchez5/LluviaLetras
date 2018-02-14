/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluvialetras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Trinitarios
 */
public class ControladorLetra implements ActionListener{
    
    private Letra l;

    public ControladorLetra(Letra l) {
        this.l=l;
    }

    /**
     * Mueve la letra, actualiza la vista y comprueba si se ha chocado
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        l.mover();
        l.actualizar();
        l.chocar();
    }
   
}
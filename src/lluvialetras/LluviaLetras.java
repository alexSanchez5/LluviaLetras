/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluvialetras;
/**
 * van a aparecer letras que van cayendo, y no podra tocar una barra que hay en la parte inferior.
 * si toca esa letra en el teclado y se le suma un punto. si toca otra letra le quitan un punto.
 * si se aceiertan 10 letras aumenta el nivel(pestaña en la ventana de nivel).
 * aumenta la velocidad y la cantidad de letras al subir de nivel.
 * 
 * en la barrita habra un bloque que se mueve con las flechas de izquierda a derecha. si la tecla da en el bloque revota y vuelve a subir
 * si toca arriba tambien se acaba el juego
 * 
 * menu: archivo( salir, "guardar y cargar(opcional)"), level(minimo 5 niveles, si pulso control + el numero del nivel cambia a ese nivel directamente)
 */
/**
 *
 * @author alejandro sanchez
 */
public class LluviaLetras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Controlador();
    }
    
}
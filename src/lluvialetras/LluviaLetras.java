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
public class LluviaLetras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Controlador();
    }
    
}

/**
 * cada letra va a tener una velocidad diferente, hay cinco velocidades diferentes, se van añadiendo con cada nivel
 * Que aparezca una barra en la parte superior y se mueven a la vez cada vez que se suba de nivel se pone en pausa y separan las barras
 * Que también aparezcan números
 * Las letras van a tener varios colores. Indican el número de veces que hay que pulsar cada tecla. Si aparece en negro, se pone en rojo, pero no se elimina
 * cuando la vuelves a pulsar se pone verde, y cuando le des a esa, desaparece
 * En el menú se podrá poner la partida en pausa, y reanudar y poder introducir el nombre del jugador
 */
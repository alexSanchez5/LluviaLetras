/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluvialetras;

import java.util.ArrayList;

/**
 *
 * @author alejandro sanchez
 */
public class Modelo {
    private Controlador c;
    private int contadorAciertos=0;
    private int nivel=1;
    private char[] letrasNivelFacil=new char[8];
    private char[] letrasNivelMedio=new char[27];
    private char[] letrasNivelDificil=new char[37];
    private ArrayList<Character> comprobarLetras=new ArrayList();
    private int letraAscii;
    
    public Modelo(Controlador c){
        this.c=c;
        inicializarArrays();
    }
    
    /**
     * Suma o resta puntos
     * @param correcto
     */
    public void sumarContador(boolean correcto){
        if(correcto){
            contadorAciertos++;
        }else{
            contadorAciertos--;
        }
        if(contadorAciertos>10){
            aumentarNivel();
            contadorAciertos=0;
        }
    }
    
    /**
     * Aumenta un nivel
     */
    public void aumentarNivel(){
        nivel++;
        c.aumentarNivel();
    }
    
    /**
     * Inicia los arrays con las letras o numeros
     */
    public void inicializarArrays(){
        letrasNivelFacil[0]='A';
        letrasNivelFacil[1]='S';
        letrasNivelFacil[2]='D';
        letrasNivelFacil[3]='F';
        letrasNivelFacil[4]='J';
        letrasNivelFacil[5]='K';
        letrasNivelFacil[6]='L';
        letrasNivelFacil[7]='Ñ';
        
        for(int i=0;i<26;i++){
            letraAscii=i+65;
            letrasNivelMedio[i]=(char)letraAscii;
            letrasNivelDificil[i]=(char)letraAscii;
        }
        letrasNivelMedio[26]='Ñ';
        letrasNivelDificil[26]='Ñ';
        
        for (int i = 0; i < 10; i++) {
            letrasNivelDificil[i+27]=(char)(i+48);
        }
    }
    
    /**
     * Devuelve la letra o numero que va a aparecer dependiendo del nivel
     * @return 
     */
    public char darLetra(){
        boolean repetido=false;
        char letra;
        if(nivel<3){
            letra= letrasNivelFacil[aleatorio(8,0)];
        }else if(nivel>=3 && nivel<5){
            letra= letrasNivelMedio[aleatorio(27,1)];
        }else{
            letra=letrasNivelDificil[aleatorio(37,1)];
        }
        for (int i = 0; i < comprobarLetras.size(); i++) {
            if(comprobarLetras.get(i)==letra){
                repetido=true;
            }
        }
        if(repetido){
            return '1';
        }else{
            comprobarLetras.add(letra);
            return letra;
        }
    }
    /**
     * Genera un numero aleatorio entre un maximo y un minimo
     * @param max - es el numero maximo aleatorio
     * @param min - es el numero minimo aleatorio
     * @return - retorna el numero aleatorio que ha generado
     */
    public int aleatorio(int max, int min){
        return (int)Math.floor(Math.random()*(max-min)+min);
    }
    /**
     * este metodo comprueba que la letra que has pulsado este en la pantalla y la elimina del array que guarda las que estan en pantalla
     * @param l - es la letra que ha pulsado
     * @return - retorna verdadero o falso dependiendo si ha podido encontrar la letra en el array o no.
     */
    public boolean eliminar(char l){
        for (int i = 0; i < comprobarLetras.size(); i++) {
            if(l==comprobarLetras.get(i)){
                comprobarLetras.remove(i);
                return true;
            }
        }
        return false;
    }

    public int getContadorAciertos() {
        return contadorAciertos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
}
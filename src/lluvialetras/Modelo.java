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
    private char[] letrasNivelDificil=new char[27];
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
        if(nivel>2){
            System.out.println("Nivel aumentado");
        }
        c.aumentarNivel();
        System.out.println("Nivel "+nivel);
    }
    
    /**
     * Inicia los arrays con las letras
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
            letrasNivelDificil[i]=(char)letraAscii;
        }
        letrasNivelDificil[26]='Ñ';
    }
    
    /**
     * Devuelve la letra que va a aparecer
     * @return 
     */
    public char darLetra(){
        boolean repetido=false;
        char letra;
        if(nivel<3){
            letra= letrasNivelFacil[aleatorio(8,0)];
        }else{
            letra= letrasNivelDificil[aleatorio(27,1)];
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
     * Genera un numero aleatorio
     * @param max
     * @param min
     * @return 
     */
    public int aleatorio(int max, int min){
        return (int)Math.floor(Math.random()*(max-min)+min);
    }
    
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
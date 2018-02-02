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
        InicializarArrays();
    }
    
    /**
     * Suma o resta puntos
     * @param correcto
     */
    public void SumarContador(boolean correcto){
        if(correcto){
            contadorAciertos++;
        }else{
            contadorAciertos--;
        }
    }
    
    /**
     * Aumenta un nivel
     */
    public void AumentarNivel(){
        nivel++;
        if(nivel>2){
            System.out.println("Nivel aumentado");
        }
    }
    
    /**
     * Inicia los arrays con las letras
     */
    public void InicializarArrays(){
        letrasNivelFacil[0]='a';
        letrasNivelFacil[1]='s';
        letrasNivelFacil[2]='d';
        letrasNivelFacil[3]='f';
        letrasNivelFacil[4]='j';
        letrasNivelFacil[5]='k';
        letrasNivelFacil[6]='l';
        letrasNivelFacil[7]='ñ';
        
        for(int i=0;i<26;i++){
            letraAscii=i+91;
            letrasNivelDificil[i]=(char)letraAscii;
        }
        letrasNivelDificil[26]='ñ';
    }
    
    /**
     * Devuelve la letra que va a aparecer
     * @return 
     */
    public char DarLetra(){
        boolean repetido=false;
        char letra;
        if(nivel<2){
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
}
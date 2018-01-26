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
public class Modelo {
    private Controlador c;
    private int contadorAciertos=0;
    private int nivel=1;
    private char[] letrasNivelFacil=new char[8];
    private char[] letrasNivelDificil=new char[27];
    private int letraAscii;
    
    public Modelo(Controlador c){
        this.c=c;
        InicializarArrays();
    }
    
    public void SumarContador(){
        contadorAciertos++;
    }
    
    public void AumentarNivel(){
        nivel++;
        if(nivel>2){
            System.out.println("mandar array dificil");
        }
    }
    
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
    
    public char DarLetra(){
        if(nivel>2){
            return letrasNivelFacil[aleatorio(8,1)];
        }else{
            return letrasNivelDificil[aleatorio(27,1)];
        }
    }
    
    public int aleatorio(int max, int min){
        return (int)Math.floor(Math.random()*(max-min)+min);
    }
}
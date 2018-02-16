/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluvialetras;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author alejandro sanchez
 */
public class VistaPrincipal extends JFrame{
    private Controlador c;
    private JLabel nom;
    private JTextField nombre;
    private JButton empezar;
    
    public VistaPrincipal(Controlador c){
        this.c=c;
        setLayout(null);
        nom=new JLabel("Introduce tu Nombre");
        nom.setBounds(140, 100, 200, 20);
        add(nom);
        nombre=new JTextField(20);
        nombre.setBounds(100, 150, 200, 20);
        add(nombre);
        empezar=new JButton("empezar el juego");
        empezar.setBounds(120, 200, 150, 30);
        empezar.addActionListener(c);
        add(empezar);
        this.getContentPane().setBackground(Color.CYAN);
        this.setBounds(100, 0, 400, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public String getNombre() {
        return nombre.toString();
    }
}
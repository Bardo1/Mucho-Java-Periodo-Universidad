/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author PDI
 */
public class GuiMano extends  JFrame implements ActionListener {
private String[] listaPalabrasBuenas=  {"felicidad", "esperanza", "risa"};
private String[] listaPalabrasMalas=  {"pena", "egoismo", "odio"};
private JButton botonBuscar;
private JTextField textoBusqueda;
private JLabel resultado;

    public GuiMano()  {
        
        super("ventana de prueba");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel etiqueta= new JLabel("Ingrese la Palabra ");
        textoBusqueda= new JTextField(10);
        botonBuscar= new JButton("Buscar");
        botonBuscar.addActionListener(this);
        botonBuscar.setName("botonBusqueda");
        resultado= new JLabel();
        setLayout(new FlowLayout());
        add(etiqueta);
        add(textoBusqueda);
        add(botonBuscar);
        add(resultado);
        setVisible(true);
        
    }
    
     public void actionPerformed(ActionEvent e) {
         if (e.getSource()== botonBuscar )
         {
             String palabraIngresada= textoBusqueda.getText();
            
             for(String palabraBuena : listaPalabrasBuenas) 
             {
                   if (palabraBuena.equals(palabraIngresada))
                   {
                      resultado.setText("Buena Palabra");
                   }
                   
             }
             for(String palabraMala : listaPalabrasMalas) 
             {
                   if (palabraMala.equals(palabraIngresada))
                   {
                      resultado.setText("Mala Palabra");
                   }
                   
             }
         }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GuiMano graficador= new GuiMano();
        graficador.setVisible(true);
    }
}


package ejercicio1;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * Walter
 */
public class Ejercicio1 extends  JFrame implements ActionListener {
private JButton boton1;
private JTextField campotexto1;

    public Ejercicio1()  {
        // nombre de nuestro panel 
        super("Ejercicio1");
        // para que salga nuestra x para cerrarlo en la parte derecha superior
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // tamañano de nuestro panel
        setSize(250,250);
        // creacion de nuestro botón
        boton1= new JButton ("Boton1");
        // para la creacion de nuesro metodo para mas adelante 
        boton1.addActionListener(this);
        // creamos nuestro textfield
        campotexto1 = new JTextField(20);  
        // para que sea invisible
         campotexto1.setVisible(false);
        // definimos la ubicacion de nuestros atributos
        FlowLayout dis= new  FlowLayout();
        setLayout(dis);
        //aderimos a nuestro panel los dos controles
        add(campotexto1);
        add(boton1);
        setVisible(true);
      
    
    }
    
     public void actionPerformed(ActionEvent e) {
       boton1.setName("");
       campotexto1.setText("");
       
    }

 
  
   
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ejercicio1 GuiManual= new Ejercicio1();
        GuiManual.setVisible(true);
        
    }
}

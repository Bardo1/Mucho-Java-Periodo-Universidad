/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package probando;

/**
 *
 * @author Walter
 */
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;


public class mipanel extends javax.swing.JPanel {

    public mipanel(){    
        this.setSize(400,280);
    }
        
    @Override
    public void paint(Graphics g){
        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/casalibertad.jpg"));        
        g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);        
        setOpaque(false);
        super.paintComponent(g);
}
    
}

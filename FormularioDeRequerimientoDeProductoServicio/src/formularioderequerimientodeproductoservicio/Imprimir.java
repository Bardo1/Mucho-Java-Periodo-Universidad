/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formularioderequerimientodeproductoservicio;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class Imprimir extends javax.swing.JDialog implements Printable{
   
    
    public Imprimir(java.awt.Frame parent, boolean modal) {
       
        initComponents();
    }
    private void initComponents( ) {}//aqui va codigo generado por Netbeans
      
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this);
            job.printDialog();
            job.print();
        } catch (PrinterException ex) { }        
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Imprimir dialog = new Imprimir(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration  
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) return NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D)graphics;
        //Punto donde empezará a imprimir dentro la pagina (100, 50)
        g2d.translate(  pageFormat.getImageableX()+100, 
                        pageFormat.getImageableY()+50);
        g2d.scale(0.50,0.50); //Reducción de la impresión al 50%
        jPanel1.printAll(graphics);
        return PAGE_EXISTS;                
    }

}
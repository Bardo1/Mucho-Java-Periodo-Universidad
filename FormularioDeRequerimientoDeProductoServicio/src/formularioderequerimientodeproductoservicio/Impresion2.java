/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formularioderequerimientodeproductoservicio;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import javax.swing.*;
 
/**
 * @author Kike Navarro
 * 31 de Agosto de 2012
 */
public class Impresion2 extends JFrame
{
    public Impresion2()
    {
        setTitle( "Ejemplo de impresión con Java" );
        setSize( 600, 500 );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        iniciarGUI();
    }
 
    private void iniciarGUI()
    {
        iniciarCampos();
        setLayout( new BorderLayout() );
        add( scroll, BorderLayout.CENTER );
        add( crearPanelBotones(), BorderLayout.SOUTH );
    }
 
    private JPanel crearPanelBotones()
    {
        JPanel panel = new JPanel( new GridLayout( 1, 2, 10, 0 ) );
        panel.add( btnImprimir );
        panel.add( btnCerrar );
        return panel;
    }
 
    private void iniciarCampos()
    {
        txtMensaje = new JTextPane();
        scroll = new JScrollPane( txtMensaje );
        scroll.setViewportView( txtMensaje );
        btnCerrar = new JButton( "CERRAR" );
        btnImprimir = new JButton( "IMPRIMIR" );
        btnCerrar.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed( ActionEvent evt )
                {
                    cerrar();
                }
            }
        );
        btnImprimir.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed( ActionEvent evt )
                {
                    imprimir();
                }
            }
        );
 
        txtMensaje.setText( "\nEjemplo de impresión con Java\nwww.tingsystems.com" );
        txtMensaje.insertIcon( new ImageIcon( Impresion2.class.getClassLoader().getResource( "Imagenes/Fondo4.jpg" ) ) );
    }
 
    private void cerrar()
    {
        dispose();
    }
 
    private void imprimir()
    {
        try
        {
            txtMensaje.print();
        }
        catch( PrinterException exc )
        {
            JOptionPane.showMessageDialog( null, "Error en la impresión del documento", "ERROR", JOptionPane.ERROR_MESSAGE );
        }
    }
 
    public static void main( String args[] )
    {
        new Impresion2().setVisible( true );
    }
 
    private JButton btnCerrar;
    private JButton btnImprimir;
    private JScrollPane scroll;
    private JTextPane txtMensaje;
}
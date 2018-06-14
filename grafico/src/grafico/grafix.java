package grafico;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.*;
import javax.swing.JFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author Ruulon
 */
public class grafix extends JFrame {

    private BufferedImage grafica = null;
    private String nombre;
    private int cantidad;
    private Pruebagraf2View p2;
    private int ramos;

    public grafix(Pruebagraf2View p,String nombre, int cantidad, int ramos) {
        //super("Graficos");
        this.p2=p;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.setResizable(false);
        this.ramos = ramos;
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {

             setVisible(false);
             


            }
        });
    }
    public BufferedImage graficas() throws IOException {
        // Creamos y rellenamos el modelo de datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();



            dataset.setValue(15, "Regular", ""+15);
            dataset.setValue(5, "Con deuda", ""+5 );
            dataset.setValue(0,"Eliminado" , ""+0);



             JFreeChart chart = ChartFactory.createStackedBarChart3D("Representacion Grafica de los Estados de los Alumnos", "Estados",
             "Cantidad de Alumnos", dataset,PlotOrientation.VERTICAL, true,
                true, false);
             ChartUtilities.saveChartAsJPEG(new File("images: chart.jpg"), chart, 500, 300);




        //donde guardaremos la imagen?? pues en un bufer jeje
        BufferedImage image = chart.createBufferedImage(500, 450);

        return image;

    }
    public void paint(java.awt.Graphics g) {

        if (grafica == null) {
            try {
                grafica = this.graficas();
            } catch (IOException ex) {
                Logger.getLogger(grafix.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        g.drawImage(grafica,0, 30, this);
    }



}

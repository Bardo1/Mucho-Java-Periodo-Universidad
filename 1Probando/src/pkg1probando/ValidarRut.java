package pkg1probando;
 
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
 
/**
 * This is an example RUT validation
 * @author deerme.org
 */
public class ValidarRut   extends JFrame implements ActionListener {
 
    private JButton btnValidar;
    private JTextField txtRut;
    private JLabel labRut;
 
    public ValidarRut()
    {
        super ( "Ejemplo de Validación de RUT" );
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
 
        // Agregamos elementos a la ventana
        this.setLayout( new FlowLayout(FlowLayout.LEFT, 20, 10)  );
 
        labRut = new JLabel("Rut");
        txtRut = new JTextField(20);
        txtRut.setText("16327531-7");
        btnValidar = new JButton("Validar");
        btnValidar.addActionListener(this);
        this.add(labRut);
        this.add(txtRut);
        this.add(btnValidar);
 
        this.setVisible(true);
 
    }
 
    public static void main(String[] args) {
        // TODO code application logic here
        new ValidarRut();
    }
 
    public void actionPerformed(ActionEvent e) {
 
        // Validamos el RUt
        if (e.getSource()==btnValidar)
        {
            if ( txtRut.getText().length() > 0  )
            {
                // Creamos un arreglo con el rut y el digito verificador
                String[] rut_dv = txtRut.getText().split("-");
                // Las partes del rut (numero y dv) deben tener una longitud positiva
                if ( rut_dv.length == 2   )
                {
                    // Capturamos error (al convertir un string a entero)
                    try
                    {
                        int rut = Integer.parseInt( rut_dv[0] );
                        char dv = rut_dv[1].charAt(0);
 
                        // Validamos que sea un rut valido según la norma
                        if ( this.ValidarRut(rut, dv)  )
                        {
                            JOptionPane.showMessageDialog(rootPane, "Rut correcto");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(rootPane, "Rut incorrecto");
                        }
                    }
                    catch( Exception ex )
                    {
                        System.out.println(" Error " + ex.getMessage());
                    }
                }
            }
        }
    }
 
    /*
     * Método Estático que valida si un rut es válido
     * Fuente : http://www.creations.cl/2009/01/generador-de-rut-y-validador/
     */
    public static boolean ValidarRut(int rut, char dv)
    {
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10)
        {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        return dv == (char) (s != 0 ? s + 47 : 75);
    }
 
}
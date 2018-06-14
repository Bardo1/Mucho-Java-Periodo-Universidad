/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javasumadora.JavaSumadora;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author Walter
 */
public class NewEmptyJUnitTest {

    
    public NewEmptyJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
   
    @Test
    public void testCalculo(){
      JavaSumadora  suma = new JavaSumadora();
      suma.setNumero1(10);
      suma.setNumero2(1);
      int ResultadoEsperado=11;
              assertEquals(ResultadoEsperado,suma.calcular());
    }
    
    @Test // etiqueta, dar nombre, instanciar el objeto a tesstear, y el resultado esperado.
    public void testCalculo2(){
        JavaSumadora suma= new JavaSumadora();
        int ResultadoEsperado=4;
        assertEquals(ResultadoEsperado,suma.calcular("2","2"));
    }
    @Before // por cada metodo que se esta testeando
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

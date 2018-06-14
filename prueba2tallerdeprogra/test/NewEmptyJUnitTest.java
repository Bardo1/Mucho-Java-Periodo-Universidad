/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import prueba2tallerdeprogra.agenda_telefonica;

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
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
  
   
    @Test// test que comprueba que es distinto de nulidad
    public void testBuscarNombre(){
     agenda_telefonica at= new agenda_telefonica();
     //metodo de comparacion de si no es nulo 
     assertNotNull(at.getNombre(1));
    }   
  
    
    
    
    
}

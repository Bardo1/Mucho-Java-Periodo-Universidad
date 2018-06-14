/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2tallerdeprogra;

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
public class agenda_telefonicaTest {
    
    public agenda_telefonicaTest() {
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

    /**
     * Test of agenda_telefonica method, of class agenda_telefonica.
     */
    @Test
    public void testAgenda_telefonica() {
        System.out.println("agenda_telefonica");
        agenda_telefonica instance = new agenda_telefonica();
        instance.agenda_telefonica();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getcontacto method, of class agenda_telefonica.
     */
    @Test
    public void testGetcontacto() {
        System.out.println("getcontacto");
        int id = 0;
        agenda_telefonica instance = new agenda_telefonica();
        String expResult = "";
        String result = instance.getcontacto(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cuentacontacto method, of class agenda_telefonica.
     */
    @Test
    public void testCuentacontacto() {
        System.out.println("cuentacontacto");
        agenda_telefonica instance = new agenda_telefonica();
        int expResult = 0;
        int result = instance.cuentacontacto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTelefono method, of class agenda_telefonica.
     */
    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        int id = 0;
        String nuevoTelefono = "";
        agenda_telefonica instance = new agenda_telefonica();
        instance.setTelefono(id, nuevoTelefono);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class agenda_telefonica.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        int id = 0;
        agenda_telefonica instance = new agenda_telefonica();
        String expResult = "";
        String result = instance.getNombre(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of InsertarContacto method, of class agenda_telefonica.
     */
    @Test
    public void testInsertarContacto() {
        System.out.println("InsertarContacto");
        String nombre = "";
        String apellidos = "";
        String telefono = "";
        agenda_telefonica instance = new agenda_telefonica();
        instance.InsertarContacto(nombre, apellidos, telefono);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

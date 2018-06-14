
package Persistencia;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.*;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author Walter Muñoz
 */
public class Conexion {

   
    private String nombreBD;
    private String usuario;
    private String password;
    private String server;
    private int port;
    private Connection conexion;
    
      public Conexion() {
        this.nombreBD = "bdformularios";
        this.usuario = "root";
        this.password = "5371569";
        this.server="localhost";
        this.port=3306;   
        this.conexion=null;
    }
      public boolean conectar() {
        this.conexion = null;
        try {
             //Get connection
     System.out.println("paso 2");
            Class.forName("com.mysql.jdbc.Driver");
            
            System.out.println("paso 3");
            String URL = "jdbc:mysql://"+this.server+":"+this.port+"/"+this.nombreBD;
            System.out.println("paso 4");
            System.out.println(URL);
            System.out.println("paso 5");
            try{
            this.conexion = DriverManager.getConnection(URL,this.usuario,this.password);
            }catch(SQLException ex){
                return false;
            }
             if (this.conexion != null) {
                  System.out.println();
                  System.out.println("Conexion Exitosa!!!");
                  System.out.println();
                  // Meta data
                  DatabaseMetaData meta = this.conexion.getMetaData();
                  System.out.println("\nDriver Information");
                  System.out.println("Driver Name: " + meta.getDriverName());
                  System.out.println("Driver Version: " + meta.getDriverVersion());
                  System.out.println("\nDatabase Information ");
                  System.out.println("Database Name: " + meta.getDatabaseProductName());
                  System.out.println("Database Version: " + meta.getDatabaseProductVersion());
                  return true;
             }

        }catch(SQLException se) {
             se.printStackTrace();
             
        }catch (ClassNotFoundException cnf){
            cnf.printStackTrace();
            
        }
        return false;

    }
      public boolean cerrar() {
        try {
            this.conexion.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
     /*
     * Ejecuta una query  en la bd y no espera un resultado de la operacion.
     * @param query a ejecutar en la bd.
     * @return verdadero si la operacion se realiza exitosamente, 
     * falso en caso contrario.
     */
      
      
 public boolean IngresarUsuario3(String NuevoNombre,String Contraseña){
 
    System.out.println("ok2");
    try{  
        
    System.out.println("ok3");
    this.conectar();
    System.out.println("ok conector");
    java.sql.Statement conector= conexion.createStatement();
    conector.executeUpdate("insert into usuarios (Nombre,Clave) values('"+NuevoNombre+"','"+Contraseña+"')");
    conector.close();
    conexion.close();
    return true;
    
    }catch(SQLException e){
    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
    
    return false;
    }
     
     
 } 
 public int BuscarNumeroCorrelativo2(){
 
     int valor=0;
     String dato="";
        try{
            this.conectar();
            java.sql.Statement conector=conexion.createStatement();
            System.out.println("este es el valor"+ valor );
            
            ResultSet result =conector.executeQuery("SELECT  t.Dtecnum1 FROM formulario t WHERE t.Dtecnum1 = ( SELECT max( Dtecnum1 )  FROM formulario)");
            //clave= result.getString("Clave");
            while(result.next()){        
            dato = result.getString("Dtecnum1");
            }
            valor= Integer.parseInt(dato);
            valor++;
            System.out.println("este es el ultimo ultimo valor"+valor);
            this.cerrar();
            conector.close();
            return valor;
        }catch(SQLException e){
            System.out.println("error");
            return valor;
        }
 }
 
      
    public boolean ejecutarSinRetorno(String query){
        boolean result = true;
        if(this.conexion != null){
            
            try {
                result =this.conexion.createStatement().execute(query);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    
   public boolean modificaFormulario(String query){
    
        System.out.println("ok2");
    try{  
        
    System.out.println("ok3");
    this.conectar();
    System.out.println("ok conector");
    java.sql.Statement conector= conexion.createStatement();
    conector.executeUpdate(query);
    conector.close();
    conexion.close();
    return true;
    
    }catch(SQLException e){
    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
    
    return false;
    }
            }
            
     /**
     * Ejecuta una query en la bd, y espera un retorno desde la misma de acuerdo
     * a la query ejecutada.
     * @param query que se ejecuta en la bd.
     * @return un listado de mapas que contienen los datos de los objetos a ser
     * instanciados.
     */
    
    public boolean PruebaDeIngreso(String Cargo1){
        System.out.println("ok2");
    try{
        
        System.out.println("ok3");
        this.conectar();
        System.out.println("ok conector");
        java.sql.Statement conector= conexion.createStatement();
        conector.executeUpdate("insert into tablaprobar (NOMBRE) values('"+Cargo1+"')");
        conector.close();
        conexion.close();
        return true;
    }catch(SQLException e){
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        return false;
    }
}
    public ArrayList<HashMap> ejecutarConRetorno(String query){
       ArrayList<HashMap> listado = null;
       System.out.println("que paso?");
       if(this.conexion != null){
            ResultSet result = null;
            try {
                result = this.conexion.createStatement().executeQuery(query);
                if(result != null){
                    boolean valido = result.next();
                    listado = new ArrayList<HashMap>();
                    while(valido){
                        HashMap<String, String> tupla = new HashMap<String, String>();
                         for(int i=result.getMetaData().getColumnCount(); i>0 ; i--){
                             String valorCampo = result.getString(i);
                             String nombreCampo = result.getMetaData().getColumnName(i);
                             tupla.put(nombreCampo,valorCampo);
                         }
                        listado.add(tupla);
                        valido = result.next();
                    }
             
                }
                result.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
       }
       return listado;
    }
    
   
    
    
public boolean Logearse(String nom, String pass){
        boolean estado= false;
        String clave="";
        try{
            this.conectar();
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * from usuarios where nombre = '"+nom+"' ");
            System.out.println("pasooooo"+ nom);
            //clave= result.getString("Clave");
            while(result.next()){
                
                clave= result.getString("Clave");  
                System.out.println("pasooooo"+ clave);
            }
            System.out.println(clave);
            if(clave.equals(pass)){
                estado= true;
                
            }
            this.cerrar();
            conector.close();
            return estado;
        }catch(SQLException e){
            System.out.println("error");
            return estado;
        }
    }
    
    public boolean EliminarF(int valor){
    
          
       String valor2= String.valueOf(valor);
        try{
            this.conectar();    
            System.out.println("si esta adentro");
            java.sql.Statement conector= conexion.createStatement();
            
            conector.executeUpdate("delete from formulario where Dtecnum1='"+valor2+"'");
            conector.executeUpdate("delete from tabladatos where Dtecnum1='"+valor+"'");
            System.out.println("Paso otra vez");
            this.cerrar();
            conector.close();
            return true;
        }catch(SQLException e){
            System.out.println("error");
            return false;
        } 
    }
    
    public boolean buscarForlumario3(String numero){
       int i=0;
       boolean estado= false;
        try{
            this.conectar();
            java.sql.Statement conector=conexion.createStatement();
            ResultSet result =conector.executeQuery("select * from formulario where Dtecnum1='"+numero+"'");
            //clave= result.getString("Clave");
            
            while(result.next()){
            i++;   
            }
            if(i>0){
            estado=true;
            }
           
            this.cerrar();
            conector.close();
            return estado;
        }catch(SQLException e){
            System.out.println("error");
            return estado;
        }
    }
    
    
    
     public boolean eliminarEP(String nom, String rut){
        boolean estado= false;
        String confirmar="";
        String nombre="";
        String lugar= "EPP";
        try{
            this.conectar();
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * from epp where rut = '"+rut+"' ");
            
            while(result.next()){
                nombre= result.getString("nombre");
                confirmar= result.getString("observacion");  
            }
            if(confirmar.equals(nom)){
                conector.executeUpdate("delete from epp where rut = '"+rut+"' ");
                conector.executeUpdate("insert into eliminados (rut,nombre,lugar,detalle) values('"+rut+"', '"+nombre+"', '"+lugar+"', '"+nom+"')");
                conector.close();
                conexion.close();
                return true;
            }else{
                return false;
            }
            
        }catch(SQLException e){
            System.out.println("error");
            return estado;
        }
    }
    
    
    
    
    public boolean GuardarDatosLista(HashMap myMap, String dnumber ){
        
          
        try{
            this.conectar();
            java.sql.Statement conector= conexion.createStatement();
            
            for(int i=0; i<myMap.size();i++){
             
                 String nombrenumero=String.valueOf(i);
                 String [] vector= (String[]) myMap.get(nombrenumero);  
                 
                 String cero=vector[0];
                 String uno=vector[1];
                 String dos=vector[2];
                 String tres=vector[3];
                 String cuatro=vector[4];
                 String cinco=vector[5];
                 String seis=vector[6];
                 
                 conector.executeUpdate("insert into tabladatos (Dtecnum1,DESCRIP,PRODSER,CANTIDAD,PREESTIM,VALORESTIM,VALORPESOS) values('"+dnumber+"','"+uno+"','"+dos+"','"+tres+"','"+cuatro+"','"+cinco+"','"+seis+"')");
             }
            System.out.println("pasooguardors");
            //clave= result.getString("Clave");
            
            this.cerrar();
            conector.close();
            return true;
        }catch(SQLException e){
            System.out.println("error");
            return false;
        }
    }
    
      
     public DefaultTableModel CargarTablaDatosPrimaria(int numeroformulario){
        DefaultTableModel ingreso;
        String[] nombreTabla= {"Descripcion En detalle del Requerimiento","Producto/Servicio","Cantidad","Precio Estimado Unitario Neto","Valor Estimado Total por Item Neto","Valor total Pesos"};
        String[] resultado= new String[6];
        ingreso = new DefaultTableModel(null, nombreTabla);
        try{
            System.out.println("por aqui si pasó");
            this.conectar();    
            //NUMEROCO// 	 	 	 	 	 	
	    java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * from tabladatos where Dtecnum1='"+numeroformulario+"'");
            while(result.next()){                
                resultado[0]= result.getString("HoraRecep1");
                resultado[1]= result.getString("Recibe");  
                resultado[2]= result.getString("Dtecnum1");
                resultado[3]= result.getString("Fecha1");
                resultado[4]= result.getString("Deptoyounidad1");
                resultado[5]= result.getString("Solicitante1");
                resultado[6]= result.getString("Cargo1");
                resultado[7]= result.getString("Recibe");  
                resultado[8]= result.getString("PeriUso1");
                resultado[9]= result.getString("SeisDias1");
                resultado[10]= result.getString("DiezDias1");
                resultado[11]= result.getString("VeinteDias1");
                resultado[12]= result.getString("Producto1");
                resultado[13]= result.getString("TrabajoSer1");  
                resultado[14]= result.getString("AsesoConsul1");
                resultado[15]= result.getString("TCEstrategica1");
                resultado[16]= result.getString("TCRutinaria1");
                resultado[17]= result.getString("StockBodeSi1");
                resultado[18]= result.getString("StockBodeNo1");
                resultado[19]= result.getString("DescipgeneDelProSer1");
                resultado[20]= result.getString("MotivosDelaNecesidadyDestino1");
                resultado[21]= result.getString("CondicionDeAceptacion1");
                resultado[22]= result.getString("ProcedDeBusqueda1");  
                resultado[23]= result.getString("RecomendaProve1");
                resultado[24]= result.getString("MotivoDeRecom1");
                resultado[25]= result.getString("MecaDeEvalua1");
                resultado[26]= result.getString("AsigPptariasubt1");
                resultado[27]= result.getString("ItemAsignac1");
                resultado[28]= result.getString("Saldo1");
                resultado[29]= result.getString("vnzas1bffinanzas1");
                resultado[30]= result.getString("vbaadquisiciones1");
                resultado[31]= result.getString("ValEst1");  
                
                ingreso.addRow(resultado);
                
                
        }
            this.cerrar();
            conector.close();
            return ingreso;
        }catch(SQLException e){
            System.out.println("error");
            return ingreso;
        }
    }
    
    
    
    
     public DefaultTableModel CargarTablaDatos1(int numeroformulario){
        DefaultTableModel ingreso;
        String[] nombreTabla= {"Descripcion En detalle del Requerimiento","Producto/Servicio","Cantidad","Precio Estimado Unitario Neto","Valor Estimado Total por Item Neto","Valor total Pesos"};
        String[] resultado= new String[6];
        ingreso = new DefaultTableModel(null, nombreTabla);
        try{
            System.out.println("por aqui si pasó");
            this.conectar();    
            //NUMEROCO// 	 	 	 	 	 	
	    java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * from tabladatos where Dtecnum1='"+numeroformulario+"'");
            while(result.next()){                
                resultado[0]= result.getString("DESCRIP");
                resultado[1]= result.getString("PRODSER");  
                resultado[2]= result.getString("CANTIDAD");
                resultado[3]= result.getString("PREESTIM");
                resultado[4]= result.getString("VALORESTIM");
                resultado[5]= result.getString("VALORPESOS");
                ingreso.addRow(resultado);
        }
            this.cerrar();
            conector.close();
            return ingreso;
        }catch(SQLException e){
            System.out.println("error");
            return ingreso;
        }
    }
    
   public ArrayList<String>  NombresPublicaciones(String query){         
       ArrayList<String> array = new ArrayList<String>();     
       try{
            this.conectar();          
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery(query);
           
            while(result.next()){
               String let=result.getString("titulo");   
                array.add(let);  
            }
            this.cerrar();
            conector.close();
            return array;
        }catch(SQLException e){
            System.out.println("error");
            return array;
        }
          
        }

public ArrayList<String>  NombresDeAutores(String query){
        
            
       ArrayList<String> array = new ArrayList<String>();     
       try{
            this.conectar();          
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * FROM Persona P, AutorPublicacion AP WHERE P.idPer= and P.idPer=AP.idAutor ");
           
            while(result.next()){
               String let=result.getString("nombre");   
                array.add(let);  
            }
            this.cerrar();
            conector.close();
            return array;
        }catch(SQLException e){
            System.out.println("error");
            return array;
        }
          
        }
       
  public int ContarPublicacionAutorAnioJournal1(String nombreAutor,int anio1){
        
            
        int cantidad=0;       
        try{
            this.conectar();          
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * FROM Persona P, AutorPublicacion AP, Publicacion PU, Journal J WHERE P.nombre='"+nombreAutor+"'and P.idPer=AP.idAutor and AP.idPub=PU.idPub and AP.idPub=J.idPub and PU.anio='"+anio1+"'");
           
            while(result.next()){
                cantidad = cantidad+1;    
            }

            System.out.println("-"+ cantidad);
            this.cerrar();
            conector.close();
            return cantidad;
        }catch(SQLException e){
            System.out.println("error");
            return cantidad;
        }
          
        }
   public int ContarPublicacionAutorAnioLibro1(String nombreAutor,int anio1){
        
            
        int cantidad=0;       
        try{
            this.conectar();         
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * FROM Persona P, AutorPublicacion AP, Publicacion PU, Libro L WHERE P.nombre='"+nombreAutor+"' and P.idPer=AP.idAutor and AP.idPub=PU.idPub and AP.idPub=L.idPub and PU.anio='"+anio1+"'");
           while(result.next()){
                cantidad = cantidad+1;    
            }
             System.out.println("--"+ cantidad);
            this.cerrar();
            conector.close();
            return cantidad;
        }catch(SQLException e){
            System.out.println("error");
            return cantidad;
        }
          
        }
    public int ContarPublicacionAutorAnioArticulo1(String nombreAutor,int anio1){
        
            
        int cantidad=0;       
        try{
            this.conectar();        
           java.sql.Statement conector= conexion.createStatement();
           ResultSet result = conector.executeQuery("select * FROM Persona P, AutorPublicacion AP, Publicacion PU, Articulo A WHERE P.nombre='"+nombreAutor+"' and P.idPer=AP.idAutor and AP.idPub=PU.idPub and AP.idPub=A.idPub and PU.anio='"+anio1+"'");

            while(result.next()){
                cantidad = cantidad+1;    
            }
            System.out.println("--"+ cantidad);
            this.cerrar();
            conector.close();
            return cantidad;
        }catch(SQLException e){
            System.out.println("error");
            return cantidad;
        }
          
        }
  
 public int ContarPublicacionTipoAnio(String tipoIndice,int anio){
        
            
        int cantidad=0;       
        try{
            this.conectar();
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * FROM Publicacion P WHERE P.nombreIndice='"+tipoIndice+"' P.anio='"+anio+"'");
            while(result.next()){
                cantidad = cantidad+1;   
            }
            this.cerrar();
            conector.close();
            return cantidad;
        }catch(SQLException e){
            System.out.println("error");
            return cantidad;
        }
          
        }
  
  public int ContarPublicacionTipoAnio1(String tipo,int anio1){
        
            
        int cantidad=0;       
        try{
            this.conectar();         
            java.sql.Statement conector= conexion.createStatement();
             System.out.println(tipo);
             System.out.println(anio1);
             ResultSet result = conector.executeQuery("select * FROM Publicacion P WHERE P.nombreIndice='"+tipo+"'and P.anio='"+anio1+"'" );
            while(result.next()){
                cantidad = cantidad+1;   
            }
             System.out.println(cantidad);
            this.cerrar();
            conector.close();
            return cantidad;
        }catch(SQLException e){
            System.out.println("error");
            return cantidad;
        }
          
        }
  
  public int contarpublicacionTodoOtroindice2( int anio){
        
            
        int cantidad=0;       
        try{
            this.conectar();         
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * FROM Publicacion P " );
            while(result.next()){
                cantidad = cantidad+1;   
            }
            System.out.println(cantidad);
            this.cerrar();
            conector.close();
            return cantidad;
        }catch(SQLException e){
            System.out.println("error");
            return cantidad;
        }
          
        }
  
  /*
     public boolean Log(String nom, String pass){
        boolean estado= false;
        String clave="";
        try{
           Connection conex =this.conectar();
            java.sql.Statement conector= conex.createStatement();
            ResultSet result = conector.executeQuery("select * from login where nombre = '"+nom+"' ");
            //clave= result.getString("pass");
            while(result.next()){
                
                clave= result.getString("pass");  
            }
            System.out.println(clave);
            if(clave.equals(pass)){
                estado= true;
                
            }
            conex.close();
            conector.close();
            return estado;
        }catch(SQLException e){
            System.out.println("error");
            return estado;
        }
    }
  
    */
}

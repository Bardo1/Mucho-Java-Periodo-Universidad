/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lou
 */
public class ControladorPersistencia extends Conexion{

     public String user;
    public logeado log;
    
    public boolean probarConexion() {
        System.out.println("paso 1");
        Conexion c=new Conexion();
        boolean b=c.conectar();
        return b;
    }
    
    public ArrayList<HashMap> recuperarPersonas() {
        Conexion c=new Conexion();
        String query= "SELECT * FROM Persona;";
        c.conectar();
        ArrayList <HashMap> listaPersonas=c.ejecutarConRetorno(query);
        c.cerrar();
        return listaPersonas;
                  
    }
    
   /* public  java.sql.Connection Probarconexion(){
    Test t= new Test();
    
    return true; //t.displayDbProperties();
    }
     * */
    
    public boolean AgregarListaDeDatos(HashMap myMap, String dnumber){
    return GuardarDatosLista(myMap,dnumber);
    }
    public HashMap BuscarFormulario1(int Numero){
        HashMap datosCuenta = null;
        ArrayList<HashMap> datos;
        Conexion c = new Conexion();
        String consulta = "SELECT * FROM formulario WHERE Dtecnum1 ='"+Numero+"'";
        c.conectar();
        datos = c.ejecutarConRetorno(consulta);
        c.cerrar();
        if(datos.size() > 0){
            datosCuenta = datos.get(0);
        }
        return datosCuenta;
    }
    
       public boolean BuscarFormulario2(String numero){
        
        return buscarForlumario3(numero);
    }
    
    
public boolean PruebaDeIngreso1(
         String FechaRecp1,
         String HoraRecep1,
         boolean Recibe1,
         String Dtecnum1,
         String Fecha,
         String Deptoyounidad1,
         String Solicitante1,
         String Cargo1,
         String PeriUso1,
         String Plazo,
         String Clase,
         String TipoC,
         String StockBode,
         String DescipGeneDelProSer1,
         String MotivosDelaNecesidadyDestino1,
         String ProcedDeBusqueda1,
         String RecomendaProve1,
         String MotivoDeRecom1,
         String Anexo,
         String AsigPptariaSubt1,
         String ItemAsignac1,
         int Saldo1,
         boolean vbffinanzas, 
         boolean vbaadquisiciones,
         double ValEst1,
         double ValorTPesos,
         double Impuesto
         ){
    
         Conexion c = new Conexion();
         
         int Recibe2;
         int vbffinanzas2; 
         int vbaadquisiciones2;
        
         if(vbffinanzas){vbffinanzas2=1;}else{vbffinanzas2=0;}
         if(vbaadquisiciones){vbaadquisiciones2=1;}else{vbaadquisiciones2=0;}
         if(Recibe1){Recibe2=1;}else{Recibe2=0;}
                
         String query ="INSERT formulario VALUES('"+FechaRecp1+"','"+HoraRecep1+"','"+Recibe2+"','"+ Dtecnum1+"','"+Fecha+"','"+Deptoyounidad1+"','"+Solicitante1+"','"+Cargo1+"','"+PeriUso1+"','"+Plazo+"','"+Clase+"','"+TipoC+"','"+StockBode+"','"+DescipGeneDelProSer1+"','"+MotivosDelaNecesidadyDestino1+"','"+ProcedDeBusqueda1+"','"+RecomendaProve1+"','"+MotivoDeRecom1+"','"+Anexo+"','"+AsigPptariaSubt1+"','"+ItemAsignac1+"','"+Saldo1+"','"+vbffinanzas2+"','"+vbaadquisiciones2+"','"+ValEst1+"','"+ValorTPesos+"','"+Impuesto+"')";
        
         c.conectar();
         System.out.println(FechaRecp1);
         c.ejecutarSinRetorno(query);
         c.cerrar();
         return true;

}

public boolean Modificar(
         String FechaRecp1,
         String HoraRecep1,
         boolean Recibe1,
         String Dtecnum1,
         String Fecha,
         String Deptoyounidad1,
         String Solicitante1,
         String Cargo1,
         String PeriUso1,
         String Plazo,
         String Clase,
         String TipoC,
         String StockBode,
         String DescipGeneDelProSer1,
         String MotivosDelaNecesidadyDestino1,
         String ProcedDeBusqueda1,
         String RecomendaProve1,
         String MotivoDeRecom1,
         String Anexo,
         String AsigPptariaSubt1,
         String ItemAsignac1,
         int Saldo1,
         boolean vbffinanzas, 
         boolean vbaadquisiciones,
         double ValEst1,
         double ValorTPesos,
         double Impuesto
         ){
    
         Conexion c = new Conexion();
         int Recibe2;
         int vbffinanzas2; 
         int vbaadquisiciones2;
         if(vbffinanzas){vbffinanzas2=1;}else{vbffinanzas2=0;}
         if(vbaadquisiciones){vbaadquisiciones2=1;}else{vbaadquisiciones2=0;}
         if(Recibe1){Recibe2=1;}else{Recibe2=0;} //
         String query1 ="UPDATE formulario "
                      + "SET FechaRecp1='"+FechaRecp1+"',HoraRecep1='"+HoraRecep1+"',Recibe='"+Recibe2+"',Fecha='"+Fecha+"',Deptoyounidad1='"+Deptoyounidad1+"',Solicitante1='"+Solicitante1+"',Cargo1='"+Cargo1+"',PeriUso1='"+PeriUso1+"',Plazo='"+Plazo+"',Clase='"+Clase+"',TC='"+TipoC+"',StockBode='"+StockBode+"',DescipGeneDelProSer1='"+DescipGeneDelProSer1+"',MotivosDelaNecesidadyDestino1='"+MotivosDelaNecesidadyDestino1+"',ProcedDeBusqueda1='"+ProcedDeBusqueda1+"',RecomendaProve1='"+RecomendaProve1+"',MotivoDeRecom1='"+MotivoDeRecom1+"',Anexo='"+Anexo+"',AsigPptariaSubt1='"+AsigPptariaSubt1+"',ItemAsignac1='"+ItemAsignac1+"',Saldo1='"+Saldo1+"',vbffinanzas='"+vbffinanzas2+"',vbaadquisiciones='"+vbaadquisiciones2+"',ValEst1='"+ValEst1+"',ValorTPesos='"+ValorTPesos+"',Impuesto='"+Impuesto+"'"
                      + "WHERE Dtecnum1='"+Dtecnum1+"'";
         c.conectar();
         System.out.println(FechaRecp1);
         c.modificaFormulario(query1);
         c.cerrar();
         return true;

}
  
    
  public boolean IngresarUsuario2(String NuevoNombre,String Contraseña){
 
     return IngresarUsuario3(NuevoNombre,Contraseña);
    
 }
    
 public int BuscarNumeroCorrelativo1(){
     
 return BuscarNumeroCorrelativo2();
 
 }
    
    
    public HashMap obtenerPersona(String nombre, String apellido, String afiliacion){
        HashMap datosPersona = null;
        ArrayList<HashMap> datos;
        Conexion c = new Conexion();
        String consulta = "SELECT * FROM Persona WHERE nombre ='"+nombre+"'AND apellido='"+apellido+"'AND afiliacion='"+afiliacion+"'";
        
        c.conectar();
        datos = c.ejecutarConRetorno(consulta);
        c.cerrar();
        if(datos.size() > 0){
            datosPersona = datos.get(0);
        }
        
        return datosPersona;
    }
    
    public ArrayList<HashMap> obtenerSubclasif(String unaSubclas){
        ArrayList<HashMap> datosSubclas = null;
        ArrayList<HashMap> datos;
        Conexion c = new Conexion();
        String consulta = "SELECT nombre FROM Subclasificacion WHERE nombreFuente ='"+unaSubclas+"'";
        
        c.conectar();
        datos = c.ejecutarConRetorno(consulta);
        c.cerrar();
        
        if(datos.size() > 0){
            datosSubclas = datos;
        }
        
        return datosSubclas;
    }
    
    public ArrayList<HashMap> cargarTiposPubli(){
        Conexion c=new Conexion();
        String query= "SELECT * FROM TipoPublicacion;";
        c.conectar();
        ArrayList <HashMap> lstTipoPubli=c.ejecutarConRetorno(query);
        c.cerrar();
        return lstTipoPubli;
    }
    public DefaultTableModel cargarTablaDatos(int numeroformulario){
        DefaultTableModel tabla= new DefaultTableModel();
        tabla = CargarTablaDatos1(numeroformulario);
        return tabla;
    }
    public ArrayList<HashMap> cargarEstados(){
        Conexion c=new Conexion();
        String query= "SELECT * FROM Estado;";
        c.conectar();
        ArrayList <HashMap> lstEstados=c.ejecutarConRetorno(query);
        c.cerrar();
        return lstEstados;
    }
    
    public ArrayList<HashMap> cargarRoles(){
        Conexion c=new Conexion();
        String query= "SELECT * FROM Rol;";
        c.conectar();
        ArrayList <HashMap> lstRoles=c.ejecutarConRetorno(query);
        c.cerrar();
        return lstRoles;
    }   
    
    public ArrayList<HashMap> cargarTiposFinan(){
        Conexion c=new Conexion();
        String query= "SELECT * FROM TipoFinanciamiento;";
        c.conectar();
        ArrayList <HashMap> lstTipoFinan=c.ejecutarConRetorno(query);
        c.cerrar();
        return lstTipoFinan;
    }
    
    public ArrayList<HashMap> cargarFuentesExt(){
        Conexion c=new Conexion();
        String query= "SELECT * FROM FuenteExterna;";
        c.conectar();
        ArrayList <HashMap> lstTipoFinan=c.ejecutarConRetorno(query);
        c.cerrar();
        return lstTipoFinan;
    }
    
    public ArrayList<HashMap> cargarIndices(){
        Conexion c=new Conexion();
        String query= "SELECT * FROM Indice;";
        c.conectar();
        ArrayList <HashMap> lstIndices=c.ejecutarConRetorno(query);
        c.cerrar();
        return lstIndices;
    }
    
     public ArrayList<HashMap> cargarFormulario(int numeroformulario){
        Conexion c=new Conexion();
        String query= "select * from tabladatos where Dtecnum1='"+numeroformulario+"'";
        c.conectar();
        ArrayList <HashMap> lstIndices=c.ejecutarConRetorno(query);
        c.cerrar();
        return lstIndices;
    }
    
    public boolean existePersona(HashMap datosPer){
        String nom = (String)datosPer.get("nombre");
        String ape = (String)datosPer.get("apellido");
        String afi = (String)datosPer.get("afiliacion");
        boolean resp = false;
        Conexion c=new Conexion();
        String query= "SELECT idPer FROM Persona WHERE nombre='"+nom+"'AND apellido='"+ape+"' AND afiliacion='"+afi+"'";
        c.conectar();
        ArrayList <HashMap> existe=c.ejecutarConRetorno(query);
        c.cerrar();
        if(existe.size() > 0){
            resp = true;
        }
        return resp;
    }
    
    public boolean existePublicacion(String titulo){
        boolean resp = false;
        Conexion c=new Conexion();
        String query= "SELECT titulo FROM Publicacion WHERE titulo='"+titulo+"'";
        c.conectar();
        ArrayList <HashMap> existe=c.ejecutarConRetorno(query);
        c.cerrar();
        if(existe.size() > 0){
            resp = true;
        }
        return resp;
    }
    
      public boolean Logearse1(String nom, String pass){
      
      boolean Valor= Logearse(nom,pass);
      return Valor;
      
      }
    
    
    public void almacenarJournal(HashMap datos){
        Conexion c = new Conexion();
        
        String titulo = (String)datos.get("titulo");
        int anio = Integer.parseInt(String.valueOf(datos.get("anio")));
        String medio = (String)datos.get("medio");
        int pagIni = Integer.parseInt(String.valueOf(datos.get("pagIni")));
        int pagTer = Integer.parseInt(String.valueOf(datos.get("pagTer")));
        String indice = (String)datos.get("indice");
        
        if (!indice.equals("Sin indice")) {
            String query = "SELECT nombre FROM Estado WHERE nombre='" + indice + "'";
            c.conectar();
            ArrayList<HashMap> lstEstados = c.ejecutarConRetorno(query);
            c.cerrar();
            if (lstEstados.isEmpty()) {
                query = "INSERT INTO Indice VALUES ('" + indice + "')";
                c.conectar();
                c.ejecutarSinRetorno(query);
                c.cerrar();
            }
        }
        
        String query = "INSERT INTO Publicacion VALUES (idPub,'"+titulo+"','"+anio+"','"+medio+"','"+pagIni+"',"
                + "                                     '"+pagTer+"','"+indice+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
        query = "SELECT idPub FROM Publicacion WHERE titulo='"+titulo+"'";
        c.conectar();
        ArrayList<HashMap> datoId = c.ejecutarConRetorno(query);
        c.cerrar();
        
        HashMap id = (HashMap)datoId.get(0);
        int idPub = Integer.parseInt((String)id.get("idPub"));
        
        int volumen = Integer.parseInt(String.valueOf(datos.get("volumen")));
        String serie = (String) datos.get("serie");
        
        query = "INSERT INTO Journal VALUES ('"+idPub+"','"+volumen+"','"+serie+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
        ArrayList<HashMap> lstIDAutores = (ArrayList)datos.get("autores");
        Iterator it = lstIDAutores.iterator();
        while (it.hasNext()) {
            HashMap autor = (HashMap) it.next();
            int idAutor = Integer.parseInt(String.valueOf(autor.get("idAutor")));

            query = "INSERT INTO AutorPublicacion VALUES ('" + idAutor + "','" + idPub+ "');";
            c.conectar();
            c.ejecutarSinRetorno(query);
            c.cerrar();
        }
    }
    
    public void almacenarArticulo(HashMap datos){
        Conexion c = new Conexion();
        
        String titulo = (String)datos.get("titulo");
        int anio = Integer.parseInt(String.valueOf(datos.get("anio")));
        String medio = (String)datos.get("medio");
        int pagIni = Integer.parseInt(String.valueOf(datos.get("pagIni")));
        int pagTer = Integer.parseInt(String.valueOf(datos.get("pagTer")));
        String indice = (String)datos.get("indice");
        
        if (!indice.equals("Sin indice")) {
            String query = "SELECT nombre FROM Estado WHERE nombre='" + indice + "'";
            c.conectar();
            ArrayList<HashMap> lstEstados = c.ejecutarConRetorno(query);
            c.cerrar();
            if (lstEstados.isEmpty()) {
                query = "INSERT INTO Indice VALUES ('" + indice + "')";
                c.conectar();
                c.ejecutarSinRetorno(query);
                c.cerrar();
            }
        }
        
        String query = "INSERT INTO Publicacion VALUES (idPub,'"+titulo+"','"+anio+"','"+medio+"','"+pagIni+"',"
                + "                                     '"+pagTer+"','"+indice+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
        query = "SELECT idPub FROM Publicacion WHERE titulo='"+titulo+"'";
        c.conectar();
        ArrayList<HashMap> datoId = c.ejecutarConRetorno(query);
        c.cerrar();
        
        HashMap id = (HashMap)datoId.get(0);
        int idPub = Integer.parseInt((String)id.get("idPub"));
        
        String ciudad = (String)datos.get("ciudad");
        String pais = (String)datos.get("pais");
        
        query = "INSERT INTO Articulo VALUES ('"+idPub+"','"+ciudad+"','"+pais+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
        ArrayList<HashMap> lstIDAutores = (ArrayList)datos.get("autores");
        Iterator it = lstIDAutores.iterator();
        while (it.hasNext()) {
            HashMap autor = (HashMap) it.next();
            int idAutor = Integer.parseInt(String.valueOf(autor.get("idAutor")));
            
            query = "INSERT INTO AutorPublicacion VALUES ('" + idAutor + "','" + idPub + "');";
            c.conectar();
            c.ejecutarSinRetorno(query);
            c.cerrar();
        }
    }
    
    public void almacenarLibroOCapitulo(HashMap datos){
        Conexion c = new Conexion();
        
        String titulo = (String)datos.get("titulo");
        int anio = Integer.parseInt(String.valueOf(datos.get("anio")));
        String medio = (String)datos.get("medio");
        int pagIni = Integer.parseInt(String.valueOf(datos.get("pagIni")));
        int pagTer = Integer.parseInt(String.valueOf(datos.get("pagTer")));
        String indice = (String)datos.get("indice");
        
        if (!indice.equals("Sin indice")) {
            String query = "SELECT nombre FROM Estado WHERE nombre='" + indice + "'";
            c.conectar();
            ArrayList<HashMap> lstEstados = c.ejecutarConRetorno(query);
            c.cerrar();
            if (lstEstados.isEmpty()) {
                query = "INSERT INTO Indice VALUES ('" + indice + "')";
                c.conectar();
                c.ejecutarSinRetorno(query);
                c.cerrar();
            }
        }
        
        String query = "INSERT INTO Publicacion VALUES (idPub,'"+titulo+"','"+anio+"','"+medio+"','"+pagIni+"',"
                + "                                     '"+pagTer+"','"+indice+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
        query = "SELECT idPub FROM Publicacion WHERE titulo='"+titulo+"'";
        c.conectar();
        ArrayList<HashMap> datoId = c.ejecutarConRetorno(query);
        c.cerrar();
        
        HashMap id = (HashMap)datoId.get(0);
        int idPub = Integer.parseInt((String)id.get("idPub"));
        
        int ISBN = Integer.parseInt(String.valueOf(datos.get("ISBN")));
        String editorial = (String)datos.get("editorial");
        
        query = "INSERT INTO Libro VALUES ('"+idPub+"','"+ISBN+"','"+editorial+"');";
        c.conectar();
        c.ejecutarSinRetorno(query);
        c.cerrar();
        
        ArrayList<HashMap> lstIDAutores = (ArrayList)datos.get("autores");
        Iterator it = lstIDAutores.iterator();
        while (it.hasNext()) {
            HashMap autor = (HashMap) it.next();
            int idAutor = Integer.parseInt(String.valueOf(autor.get("idAutor")));
            
            query = "INSERT INTO AutorPublicacion VALUES ('" + idAutor + "','" + idPub + "');";
            c.conectar();
            c.ejecutarSinRetorno(query);
            c.cerrar();
        }
    }
    
    
    /*
    
   public boolean ingresarUsu(String nom, String pass){
    
       return ingresarUsuario(nom, pass);     
   
   }
   
    public boolean comprobar(String nom, String pass){
        boolean aux;
        this.user=nom;
        setlog(new logeado(nom));
        aux= Log(nom, pass);
      // if(aux){
            //log = new logeado(nom);
          //  user= nom;
        //}
        return aux;
    }
    public void setlog(logeado l){
        log=l;
    }  
   
*/
 
    
}

 
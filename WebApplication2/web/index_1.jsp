<%-- 
    Document   : index
    Created on : 26-12-2012, 05:08:11 PM
    Author     : LitOns
--%>

<%@page import="Logica.Journal"%>
<%@page import="Logica.LibroCapLibro"%>
<%@page import="Logica.Articulo"%>
<%@page import="Logica.Persona"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="Logica.CuentaUsuario"%>
<%@page import="Logica.ControladorLogica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ControladorLogica cl = (ControladorLogica) session.getAttribute("cl");
    if (cl == null) {
        cl = new ControladorLogica();
        session.setAttribute("cl", cl);
    }

    CuentaUsuario cuentaActiva = cl.getCuentaActiva();
    String opcMenuPrin = request.getParameter("opcMenuPrin");
    
    String idPubli = (String) request.getParameter("idPubli");
    String titulo = (String) request.getParameter("titulo");
    String anio = (String) request.getParameter("anio");
    String medio = (String) request.getParameter("medio");
    String pagIni = (String) request.getParameter("pagIni");
    String pagTer = (String) request.getParameter("pagTer");
    String tipoPubli = (String) request.getParameter("tipoPubli");
    String indice = (String)request.getParameter("indices");
    String ciudad = (String) request.getParameter("ciudad");
    String pais = (String) request.getParameter("pais");
    String isbn = (String) request.getParameter("isbn");
    String editorial = (String) request.getParameter("editorial");
    String volumen = (String) request.getParameter("volumen");
    String serie = (String) request.getParameter("serie"); 
    String nomIndice = (String) request.getParameter("nomIndice");
    String mantener = (String) request.getParameter("mantener");
    String opcNuevoAutor = (String) request.getParameter("opcNuevoAutor");
    ArrayList<Persona> seleccionados = null;    
    
    Articulo art = (Articulo) session.getAttribute("art");
    if (art == null) {
        art = new Articulo();
        session.setAttribute("art",art);
    }
    LibroCapLibro lib = (LibroCapLibro) session.getAttribute("lib");
    if (lib == null) {
        lib = new LibroCapLibro();
        session.setAttribute("lib",lib);
    }
    Journal jou = (Journal) session.getAttribute("jou");
    if (jou == null) {
        jou = new Journal();
        session.setAttribute("jou",jou);
    }
    
    if(idPubli != null && !idPubli.equals("ingresado")){
       if(tipoPubli != null){
          if(tipoPubli.equals("Articulo conferencia")){
             if (indice != null) {
                 if (indice.equals("Otro indice")) {
                     indice = nomIndice;
                 }
             }
             if(mantener == null){
                ArrayList<Persona> autores = new ArrayList();
                art = new Articulo(Integer.parseInt(idPubli),titulo,Integer.parseInt(anio),medio,Integer.parseInt(pagIni),Integer.parseInt(pagTer),indice,ciudad,pais);
                art.setAutores(autores);
                session.setAttribute("art",art);
              }
              seleccionados = art.getAutores();
          }else if(tipoPubli.equals("Capitulo de libro") || tipoPubli.equals("Libro")) {
              if (indice != null) {
                  if (indice.equals("Otro indice")) {
                      indice = nomIndice;
                  }
              }
              if(mantener == null){
                 ArrayList<Persona> autores = new ArrayList();
                 lib = new LibroCapLibro(Integer.parseInt(idPubli),titulo,Integer.parseInt(anio),medio,Integer.parseInt(pagIni),Integer.parseInt(pagTer),indice,Integer.parseInt(isbn),editorial);
                 lib.setAutores(autores);
                 session.setAttribute("lib",lib);
              }
              seleccionados = lib.getAutores();
          }else if(tipoPubli.equals("Journal")) {
              if (indice != null) {
                  if (indice.equals("Otro indice")) {
                      indice = nomIndice;
                  }
              }
              if(mantener == null){
                 ArrayList<Persona> autores = new ArrayList();
                 jou = new Journal(Integer.parseInt(idPubli),titulo,Integer.parseInt(anio),medio,Integer.parseInt(pagIni),Integer.parseInt(pagTer),indice,Integer.parseInt(volumen),serie);
                 jou.setAutores(autores);
                 session.setAttribute("jou",jou);
              }
              seleccionados = jou.getAutores();
          }
       }
    }
     
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2//EN">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./Css/Maquetacion.css" type="text/css"/>
        <title>Sistema de Gestion de la Investigación</title>
        <script type="text/javascript">
            function validarDatosPersona(){
                //Valida campos no vacíos
                var id=document.ingresarPersona.id;
                var nom=document.ingresarPersona.nom;
                var ape=document.ingresarPersona.ape;
                var afi=document.ingresarPersona.afi;
                
                var erVacia=/^\s*$/;
                
                if(erVacia.test(id.value) && erVacia.test(nom.value) && erVacia.test(ape.value) && erVacia.test(afi.value)){
                    alert("Debe llenar todos los campos!.");
                    return false;
                }
                
                if(erVacia.test(id.value)){
                    alert("El campo id esta vacio!.");
                    return false;
                }
                if(erVacia.test(nom.value)){
                    alert("El campo nombre esta vacio!.");
                    return false;
                }
                if(erVacia.test(ape.value)){
                    alert("El campo apellido esta vacio!.");
                    return false;
                }
                if(erVacia.test(afi.value)){
                    alert("El campo afiliacion esta vacio!.");
                    return false;
                }
                
                //Valida formato de los datos
                var erIds=/^\d{0,10}$/;
                var erNoms=/^[a-zA-Z]([a-zA-Z]|\s){0,39}$/;
                
                if(!erIds.test(id.value)){
                    alert("El dato ingresado en id no es aceptado!.");
                    return false;
                }
                if(!erNoms.test(nom.value)){
                    alert("El dato ingresado en nombre no es aceptado!.");
                    return false;
                }
                if(!erNoms.test(ape.value)){
                    alert("El dato ingresado en apellido no es aceptado!.");
                    return false;
                }
                if(!erNoms.test(afi.value)){
                    alert("El dato ingresado en afiliacion no es aceptado!.");
                    return false;
                }
                return true;
            }

            function validarDatosPublicacion(){
                //Valida campos no vacíos
                var idPubli = document.ingresarPublicacion.idPubli;
                var titulo = document.ingresarPublicacion.titulo;
                var anio = document.ingresarPublicacion.anio;
                var medio = document.ingresarPublicacion.medio;
                var pagIni = document.ingresarPublicacion.pagIni;
                var pagTer = document.ingresarPublicacion.pagTer;
                
                var erVacia=/^\s*$/;
                
                if(erVacia.test(idPubli.value) && erVacia.test(titulo.value) && erVacia.test(anio.value) && erVacia.test(medio.value)
                    && erVacia.test(pagIni.value) && erVacia.test(pagTer.value)){
                    alert("Debe llenar todos los campos!.");
                    return false;
                }
                if(erVacia.test(idPubli.value)){
                    alert("El campo codigo de publicacion esta vacio!.");
                    return false;
                }
                if(erVacia.test(titulo.value)){
                    alert("El campo titulo esta vacio!.");
                    return false;
                }
                if(erVacia.test(anio.value)){
                    alert("El campo año de publicacion esta vacio!.");
                    return false;
                }
                if(erVacia.test(medio.value)){
                    alert("El campo medio de publicacion esta vacio!.");
                    return false;
                }
                if(erVacia.test(pagIni.value)){
                    alert("El campo pagina de inicio esta vacio!.");
                    return false;
                }
                if(erVacia.test(pagTer.value)){
                    alert("El campo pagina de termino esta vacio!.");
                    return false;
                }
                
                
                //Valida formato de los datos
                var erIds=/^\d{0,10}$/;
                var erIsbnsSerie=/^\d{0,20}$/;
                var erAnioPag=/^\d{0,4}$/;
                var erVol=/^\d{0,2}$/;
                var erTitMedCiuPaisEdi=/^[a-zA-Z]([a-zA-Z]|\s){0,49}$/;
                var erIndice=/^[a-zA-Z]([a-zA-Z]|\s){0,19}$/;
                
                if(!erIds.test(idPubli.value)){
                    alert("El dato ingresado en codigo de publicacion no es aceptado!.");
                    return false;
                }
                if(!erTitMedCiuPaisEdi.test(titulo.value)){
                    alert("El dato ingresado en titulo no es aceptado!.");
                    return false;
                }
                if(!erAnioPag.test(anio.value)){
                    alert("El dato ingresado en año de publicacion no es aceptado!.");
                    return false;
                }
                if(!erTitMedCiuPaisEdi.test(medio.value)){
                    alert("El dato ingresado en medio de publicacion no es aceptado!.");
                    return false;
                }
                if(!erAnioPag.test(pagIni.value)){
                    alert("El dato ingresado en pagina de inicio no es aceptado!.");
                    return false;
                }
                if(!erAnioPag.test(pagTer.value)){
                    alert("El dato ingresado en pagina de termino no es aceptado!.");
                    return false;
                }
                
                if (document.ingresarPublicacion.tipoPubli[0].selected == true) {
                    alert("Debe seleccionar un tipo de publicacion!.");
                    return false;
                }
                
                if (document.ingresarPublicacion.tipoPubli[1].selected == true) {
                    var ciudad = document.ingresarPublicacion.ciudad;
                    var pais = document.ingresarPublicacion.pais;
                    if(erVacia.test(ciudad.value)){
                        alert("El campo ciudad esta vacio!.");
                        return false;
                    }
                    if(erVacia.test(pais.value)){
                        alert("El campo pais esta vacio!.");
                        return false;
                    }
                    if(!erTitMedCiuPaisEdi.test(ciudad.value)){
                        alert("El dato ingresado en ciudad no es aceptado!.");
                        return false;
                    }
                    if(!erTitMedCiuPaisEdi.test(pais.value)){
                        alert("El dato ingresado en pais no es aceptado!.");
                        return false;
                    }
                }
                
                if (document.ingresarPublicacion.tipoPubli[2].selected == true ||
                    document.ingresarPublicacion.tipoPubli[4].selected == true) {
                    
                    var isbn = document.ingresarPublicacion.isbn;
                    var edito = document.ingresarPublicacion.editorial;
                    if(erVacia.test(isbn.value)){
                        alert("El campo ISBN esta vacio!.");
                        return false;
                    }
                    if(erVacia.test(edito.value)){
                        alert("El campo editorial esta vacio!.");
                        return false;
                    }
                    if(!erIsbnsSerie.test(isbn.value)){
                        alert("El dato ingresado en ISBN no es aceptado!.");
                        return false;
                    }
                    if(!erTitMedCiuPaisEdi.test(edito.value)){
                        alert("El dato ingresado en editorial no es aceptado!.");
                        return false;
                    }
                }
                
                if (document.ingresarPublicacion.tipoPubli[3].selected == true) {
                    var volumen = document.ingresarPublicacion.volumen;
                    var serie = document.ingresarPublicacion.serie;
                    if(erVacia.test(volumen.value)){
                        alert("El campo volumen esta vacio!.");
                        return false;
                    }
                    if(erVacia.test(serie.value)){
                        alert("El campo serie esta vacio!.");
                        return false;
                    }
                    if(!erVol.test(volumen.value)){
                        alert("El dato ingresado en volumen no es aceptado!.");
                        return false;
                    }
                    if(!erIsbnsSerie.test(serie.value)){
                        alert("El dato ingresado en serie no es aceptado!.");
                        return false;
                    }
                }
                
                if (document.ingresarPublicacion.indices[1].selected == true) {
                     var nomIndice = document.ingresarPublicacion.nomIndice;
                     if(erVacia.test(nomIndice.value)){
                        alert("El campo nuevo indice esta vacio!.");
                        return false;
                     }
                     if(!erIndice.test(nomIndice.value)){
                        alert("El dato ingresado en nuevo indice no es aceptado!.");
                        return false;
                     }
                }
                return true;
            }
            
            function mostrarEntradas(){
                if (document.ingresarPublicacion.tipoPubli[1].selected == true) {
                    document.getElementById('articulo1').style.display='block';
                    document.getElementById('articulo2').style.display='block';
                }else{
                    document.getElementById('articulo1').style.display='none';
                    document.getElementById('articulo2').style.display='none';
                } 
                if (document.ingresarPublicacion.tipoPubli[2].selected == true || 
                    document.ingresarPublicacion.tipoPubli[4].selected == true) {
                    document.getElementById('libro1').style.display='block';
                    document.getElementById('libro2').style.display='block';
                }else{
                    document.getElementById('libro1').style.display='none';
                    document.getElementById('libro2').style.display='none';
                } 
                if (document.ingresarPublicacion.tipoPubli[3].selected == true) {
                    document.getElementById('journal1').style.display='block';
                    document.getElementById('journal2').style.display='block';
                }else{
                    document.getElementById('journal1').style.display='none';
                    document.getElementById('journal2').style.display='none';
                } 
            }
            
            function nuevoIndice(){
                if (document.ingresarPublicacion.indices[1].selected == true) {
                    document.getElementById('nuevoIndice').style.display='block';
                }else{
                    document.getElementById('nuevoIndice').style.display='none';
                } 
            }
            
            function validarSeleccion(){
                if (document.seleccionarAutor.personas[0].selected == true) {
                    alert("No ha seleccionado ningun autor!.");
                    return false;
                }
                return true;
            }
            
            function validarEliminacion(){
                if (document.autorSeleccionado.seleccionados[0].selected == true) {
                    alert("No ha seleccionado ningun autor para quitar!.");
                    return false;
                }
                return true;
            }
            
        </script>
    </head>
    <body id ="fondo">
        <div id ="contenedor">
            <div id ="cabecera"><img src="./Imagenes/Banner.png"></div>
                <%if (cuentaActiva == null) {%>
            <div id ="autenticacion">
                <center><h2>Ingreso de Usuarios</h2></center>
                <div id="login">
                    <center>
                        <table align="center">
                            <tr>
                                <td>
                                    <form action="./Seguridad/autenticar.jsp" method="post"
                                          name="login">
                                        <table class="tablaLogin">
                                            <tr>
                                                <td>Usuario:<br/><input type="text" name="usuario"></td>
                                            </tr>
                                            <tr><td><br/></tr>
                                            <tr>
                                                <td>Password:<br/><input type="password" name="clave"></td>
                                            </tr>
                                            <tr>
                                                <td align="center"><input type="submit" name="ingresar" value="Ingresar"></td>
                                            </tr>
                                        </table>
                                    </form>
                                </td>
                            </tr>
                        </table>        
                    </center>
                </div>
            </div>
            <%} else {%>
            <div id="seccionIzq">
                <div id ="menu">
                    <table class="tablaMenu">
                        <tr>
                            <td class="tablaMenuTitulo">Actividades</td>
                        </tr>
                        <tr>
                            <td><a href="index.jsp?opcMenuPrin=0">Ingresar Persona</a></td>
                        </tr>
                        <tr>
                            <td><a href="index.jsp?opcMenuPrin=1">Ingresar Publicacion</a></td>
                        </tr>
                        <tr>
                            <td><a href="index.jsp?opcMenuPrin=2">Ingresar Proyecto</a></td>
                        </tr>
                        <%if (cuentaActiva.getTipoUsuario().equals("Academico") || cuentaActiva.getTipoUsuario().equals("Encargado Investigacion")) {%>      
                        <tr>
                            <td><a href="index.jsp?opcMenuPrin=3">Generar Reporte Publicaciones</a></td>
                        </tr>
                        <tr>
                            <td><a href="index.jsp?opcMenuPrin=4">Generar Reporte Proyectos</a></td>
                        </tr>
                        <%}%>
                        <tr>
                            <td><a href="index.jsp?opcMenuPrin=5">Cerrar Sesion</a></td>
                        </tr>
                    </table>                            
                </div>
                <div id ="agregado">&nbsp;</div>
            </div>
            <div id ="contenido">
                <%if (opcMenuPrin == null) {%>
                <h1>&nbsp;Bienvenido a nuestro sistema!.</h1>
                <%} else if (opcMenuPrin.equals("0")) {%>
                <%@ include file='ingresarPersona.jsp' %>
                <%} else if (opcMenuPrin.equals("1")) {%>
                <%@ include file='ingresarPublicacion.jsp' %>
                <%} else if (opcMenuPrin.equals("2")) {%>
                <h1>Parte Raul!!!</h1>
                <%} else if (opcMenuPrin.equals("3")) {%>
                <h1>FUNCA 3!!!</h1>
                <%} else if (opcMenuPrin.equals("4")) {%>
                <h1>FUNCA 4!!!</h1>
                <%} else if (opcMenuPrin.equals("5")) {
                    cl = null;
                    session.setAttribute("cl", cl);
                %>        
                <script type="text/javascript">
                    document.location=("./index.jsp");
                </script>
                <%}%>
            </div>
            <%}%>
            <div id ="pie"></div>
        </div>
    </body>
</html>

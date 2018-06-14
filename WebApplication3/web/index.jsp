<%-- 
    Document   : index
    Created on : 23-dic-2012, 1:47:23
    Author     : Walter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
        <title>ESTE ES EL TITULO DE LA PAGINA</title>     
    </head>
   
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./Css/Maquetacion.css" type="text/css"/>
        <title>Sistema de Gestion de la Investigación</title>
       
      
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

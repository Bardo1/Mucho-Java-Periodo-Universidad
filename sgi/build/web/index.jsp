<%-- 
    Document   : index
    Created on : 26-12-2012, 05:08:11 PM
    Author     : LitOns
--%>

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

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2//EN">

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
                                            <tr><td><br/></tr>
                                            <tr>
                                                <td>Usuario:<br/><input type="text" name="usuario"></td>
                                            </tr>
                                            <tr><td><br/></tr>
                                            <tr>
                                                <td>Password:<br/><input type="password" name="clave"></td>
                                            </tr>
                                            <tr><td><br/></tr>
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
            <div id ="contenido">
                <%if (opcMenuPrin != null) {%>
                <%  if (opcMenuPrin.equals("0")) {%>
                <h1>Parte cythia!!!</h1>
                <%} else if (opcMenuPrin.equals("1")) {%>
                <h2>Ingreso de Publicacion</h2>
                <div id="ingresarPublicacion">
                    <form action="./Seguridad/ingresarPublicacion.jsp" method="post"
                          name="ingresoPublicacion">
                        <div id="datosPubli1">
                            <table class="tablaPublicacion">
                                <tr><td><br/></tr>
                                <tr>
                                    <td>Codigo de publicacion:<br/><input type="text" name="idPubli"></td>
                                </tr>
                                <tr><td><br/></tr>
                                <tr>
                                    <td>Titulo:<br/><input type="text" name="titulo"></td>
                                </tr>
                                <tr><td><br/></tr>
                                <tr>
                                    <td>Año de publicacion:<br/><input type="text" name="anio"></td>
                                </tr>
                                <tr><td><br/></tr>
                                <tr>
                                    <td>Medio de publicacion:<br/><input type="text" name="medio"></td>
                                </tr>
                                <tr><td><br/></tr>
                                <tr>
                                    <td>Pagina de inicio:<br/><input type="text" name="pagIni"></td>
                                </tr>
                                <tr><td><br/></tr>
                                <tr>
                                    <td>Pagina de termino:<br/><input type="text" name="pagTer"></td>
                                </tr>
                            </table>
                        </div>
                        <div id="datosPubli2">
                            <div id="listaParticipantes">
                                <center>
                                    <select name="personas">
                                    <%
                                      ArrayList<HashMap> lstPersonas = cl.cargarPersonas();
                                      Iterator it = lstPersonas.iterator();
                                      while (it.hasNext()) {
                                          HashMap p = (HashMap)it.next();
                                          String id = (String)p.get("idPer");
                                          String nom = (String)p.get("nombre");
                                          String ape = (String)p.get("apellido");
                                    %>
                                    <option value="<%=id%>"><%=nom+","+ape%></option>
                                    <%}%>
                                </select>
                            </center>
                            </div>
                        </div>
                        <div id="datosPubli3"></div>
                        <div id="datosPubli4">
                            <center>
                                <table>
                                    <tr><td><br/></tr>
                                    <tr>
                                        <td align="center"><input type="submit" name="ingresar" value="Ingresar"></td>
                                    </tr>
                                </table>
                            </center>
                        </div>
                    </form>     
                </div>
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
                <%}%>
            </div>
            <%}%>
            <div id ="pie"></div>
        </div>

    </body>
</html>

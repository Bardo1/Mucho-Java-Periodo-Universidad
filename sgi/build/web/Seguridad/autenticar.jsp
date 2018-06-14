<%-- 
    Document   : autenticar
    Created on : 26-12-2012, 06:28:00 PM
    Author     : LitOns
--%>

<%@ page import="java.util.*" %>
<%@ page import="Logica.ControladorLogica" %>


<jsp:useBean id="cl" scope="session" class="Logica.ControladorLogica" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2//EN">

<%
    String usuario = (String) request.getParameter("usuario");
    String clave = (String) request.getParameter("clave");

    if (usuario != "" && usuario != null && clave != "" && clave != null) {

        boolean resultado = cl.autenticar(usuario, clave);
        if (resultado) {
            response.sendRedirect("../index.jsp");
        } else {

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autenticación</title
    </head>
    <body>
        <script type="text/javascript">
            alert("El usuario o password no esta correcto!.");
            document.location=("../index.jsp");
        </script>
    </body>
</html>
<%    }
} else {
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autenticación</title>
    </head>
    <body>
        <script type="text/javascript">
            alert("Debe rellenar todos los campos!.");
            document.location=("../index.jsp");
        </script>
    </body>
</html>
<%}%>
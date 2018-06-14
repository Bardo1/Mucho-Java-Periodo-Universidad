<%-- 
    Document   : ingresarPersona
    Created on : 02-01-2013, 08:33:48 PM
    Author     : Cynthia
--%>

<div id="ingresarPersona">
    <h1>Ingreso de persona</h1>
    <% if (opcNuevoAutor == null) {%>
    <form action="./Seguridad/procesarPersona.jsp" name="ingresarPersona" method="post" onsubmit="return validarDatosPersona();">
    <%}else if (tipoPubli.equals("Articulo conferencia")){%>
    <form action="./Seguridad/procesarPersona.jsp?idPubli=<%=idPubli%>&titulo=<%=titulo%>&anio=<%=anio%>&medio=<%=medio%>&pagIni=<%=pagIni%>&pagTer=<%=pagTer%>&tipoPubli=<%=tipoPubli%>&ciudad=<%=ciudad%>&pais=<%=pais%>&indices=<%=indice%>" name="ingresarPersona" method="post" onsubmit="return validarDatosPersona();">
    <%}else if (tipoPubli.equals("Capitulo de libro") || tipoPubli.equals("Libro")){%>
    <form action="./Seguridad/procesarPersona.jsp?idPubli=<%=idPubli%>&titulo=<%=titulo%>&anio=<%=anio%>&medio=<%=medio%>&pagIni=<%=pagIni%>&pagTer=<%=pagTer%>&tipoPubli=<%=tipoPubli%>&isbn=<%=isbn%>&editorial=<%=editorial%>&indices=<%=indice%>" name="ingresarPersona" method="post" onsubmit="return validarDatosPersona();">
    <%}else if (tipoPubli.equals("Journal")){%>
    <form action="./Seguridad/procesarPersona.jsp?idPubli=<%=idPubli%>&titulo=<%=titulo%>&anio=<%=anio%>&medio=<%=medio%>&pagIni=<%=pagIni%>&pagTer=<%=pagTer%>&tipoPubli=<%=tipoPubli%>&volumen=<%=volumen%>&serie=<%=serie%>&indices=<%=indice%>" name="ingresarPersona" method="post" onsubmit="return validarDatosPersona();">
    <%}%>     
        <table>
            <tr>
                <td>Identificador:</td>
                <td><input type="text" name="id"/></td>
                <td>(m�x. 10 d�gitos)</td>
            </tr>
            <tr>
                <td>Nombre:</td>
                <td><input type="text" name="nom"/></td>
                <td>(m�x. 40 caracteres)</td>
            </tr>
            <tr>
                <td>Apellido:</td>
                <td><input type="text" name="ape"/></td>
                <td>(m�x. 40 caracteres)</td>
            </tr>

            <tr>
                <td>Universidad a la que pertenece:</td>
                <td><input type="text" name="afi"/></td>
                <td>(m�x. 40 caracteres)</td>
            </tr>
            <tr>
                <td><input type="submit" value="Enviar datos"/></td>
            </tr>
        </table>
    </form>
</div>


<%-- 
    Document   : ingresarPublicacion
    Created on : 03-01-2013, 06:15:34 PM
    Author     : LitO
--%>

<div id="ingresarPublicacion">
    <h1>Ingreso de Publicacion</h1>
    <%  if (tipoPubli == null) {%>
    <form action="./Seguridad/procesarPublicacion.jsp" name="ingresarPublicacion" method="post" onsubmit="return validarDatosPublicacion();">
        <table>
            <tr>
                <td>Codigo de publicacion:</td>
                <td><input type="text" name="idPubli"></td>
                <td>(máx. 10 dígitos)</td>
            </tr>
            <tr>
                <td>Titulo:<br/>
                <td><input type="text" name="titulo"></td>
                <td>(máx. 50 caracteres)</td>
            </tr>
            <tr>
                <td>Año de publicacion:</td>
                <td><input type="text" name="anio"></td></td>
                <td>(máx. 4 dígitos)</td>
            </tr>
            <tr>
                <td>Medio de publicacion:</td>
                <td><input type="text" name="medio"></td>
                <td>(máx. 50 dígitos)</td>
            </tr>
            <tr>
                <td>Pagina de inicio:
                <td><input type="text" name="pagIni"></td>
                <td>(máx. 4 dígitos)</td>
            </tr>
            <tr>
                <td>Pagina de termino:</td>
                <td><input type="text" name="pagTer"></td>
                <td>(máx. 4 dígitos)</td>
            </tr>
            <tr>
                <td>Tipo de Publicacion:</td>
                <td><select name="tipoPubli" onclick="mostrarEntradas();">
                        <option value="nulo" selected="selected">Seleccione un tipo</option>
                        <%
                            ArrayList<HashMap> lstTiposPubli = cl.cargarTiposPubli();
                            Iterator it1 = lstTiposPubli.iterator();
                            while (it1.hasNext()) {
                                HashMap tp = (HashMap) it1.next();
                                String nom = (String) tp.get("nombre");
                        %>
                        <option value="<%=nom%>"><%=nom%></option>
                        <%  }%>
                    </select>
                </td>
            </tr>
        </table>
        <table>
            <tr id="articulo1" style="display:none;">
                <td>Ciudad:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;
                </td>
                <td><input type="text" name="ciudad"></td>
                <td>(máx. 50 caracteres)</td>
            </tr>
            <tr id="articulo2" style="display:none;">
                <td>Pais:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td><input type="text" name="pais"></td>
                <td>(máx. 50 caracteres)</td>
            </tr>
            <tr id="libro1" style="display:none;">
                <td>ISBN:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;
                </td>
                <td><input type="text" name="isbn"></td>
                <td>(máx. 20 dígitos)</td>
            </tr>
            <tr id="libro2" style="display:none;">
                <td>Editorial:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td><input type="text" name="editorial"></td>
                <td>(máx. 50 caracteres)</td>
            </tr>
            <tr id="journal1" style="display:none;">
                <td>Volumen:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td><input type="text" name="volumen"></td>
                <td>(máx. 2 dígitos)</td>
            </tr>
            <tr id="journal2" style="display:none;">
                <td>Serie:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td><input type="text" name="serie"></td>
                <td>(máx. 20 caracteres)</td>
            </tr>
        </table>
        <table>
            <tr>
                <td>Indice:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td><select name="indices" onclick="nuevoIndice();">
                        <option value="Sin indice" selected="selected">Sin indice</option>
                        <option value="Otro indice">Otro indice</option>
                        <%
                            ArrayList<HashMap> lstIndices = cl.cargarIndices();
                            Iterator it2 = lstIndices.iterator();
                            while (it2.hasNext()) {
                                HashMap ind = (HashMap) it2.next();
                                String nom = (String) ind.get("nombre");
                        %>
                        <option value="<%=nom%>"><%=nom%></option>
                        <%  }%>
                    </select>
                </td>
            </tr>          
        </table>
        <table>
            <tr id="nuevoIndice" style="display:none;">
                <td>Nuevo Indice:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td><input type="text" name="nomIndice"/></td>
                <td>(máx. 20 caracteres)</td>
            </tr>
        </table>
        <table>
            <tr>
                <td><input type="submit" value="Enviar datos"/></td>
            </tr>
        </table>
    </form>
    <%} else {%>
    <table>
        <tr>
            <td>Codigo de publicacion:</td>
            <td><input type="text" name="idPubli" value="<%=idPubli%>" readonly="readonly"></td>
            <td>(máx. 10 dígitos)</td>
        </tr>
        <tr>
            <td>Titulo:<br/>
            <td><input type="text" name="titulo" value="<%=titulo%>" readonly="readonly"></td>
            <td>(máx. 50 caracteres)</td>
        </tr>
        <tr>
            <td>Año de publicacion:</td>
            <td><input type="text" name="anio" value="<%=anio%>" readonly="readonly"></td></td>
            <td>(máx. 4 dígitos)</td>
        </tr>
        <tr>
            <td>Medio de publicacion:</td>
            <td><input type="text" name="medio" value="<%=medio%>" readonly="readonly"></td>
            <td>(máx. 50 caracteres)</td>
        </tr>
        <tr>
            <td>Pagina de inicio:
            <td><input type="text" name="pagIni" value="<%=pagIni%>" readonly="readonly"></td>
            <td>(máx. 4 dígitos)</td>
        </tr>
        <tr>
            <td>Pagina de termino:</td>
            <td><input type="text" name="pagTer" value="<%=pagTer%>" readonly="readonly"></td>
            <td>(máx. 4 dígitos)</td>
        </tr>
        <tr>
            <td>Tipo de Publicacion:</td>
            <td><select name="tipoPubli">
                    <option value="<%=tipoPubli%>"><%=tipoPubli%></option>
                </select>
            </td>
        </tr>
    </table>
    <table>
        <%  if (tipoPubli.equals("Articulo conferencia")) {%>
        <tr>
            <td>Ciudad:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;
            </td>
            <td><input type="text" name="ciudad" value="<%=ciudad%>" readonly="readonly"></td>
            <td>(máx. 50 caracteres)</td>
        </tr>
        <tr>
            <td>Pais:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </td>
            <td><input type="text" name="pais" value="<%=pais%>" readonly="readonly"></td>
            <td>(máx. 50 caracteres)</td>
        </tr>
        <%} else if (tipoPubli.equals("Capitulo de libro") || tipoPubli.equals("Libro")) {%>
        <tr>
            <td>ISBN:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;
            </td>
            <td><input type="text" name="isbn" value="<%=isbn%>" readonly="readonly"></td>
            <td>(máx. 20 dígitos)</td>
        </tr>
        <tr>
            <td>Editorial:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </td>
            <td><input type="text" name="editorial" value="<%=editorial%>" readonly="readonly"></td>
            <td>(máx. 50 caracteres)</td>
        </tr>
        <%} else if (tipoPubli.equals("Journal")) {%>
        <tr>
            <td>Volumen:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </td>
            <td><input type="text" name="volumen" value="<%=volumen%>" readonly="readonly"></td>
            <td>(máx. 2 dígitos)</td>
        </tr>
        <tr>
            <td>Serie:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;
            </td>
            <td><input type="text" name="serie" value="<%=serie%>" readonly="readonly"></td>
            <td>(máx. 20 caracteres)</td>
        </tr>
        <%}%>
    </table>
    <table>
        <tr>
            <td>Indice:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;
            </td>
            <td><select name="indices">
                    <option value="<%=indice%>"><%=indice%></option>
                </select>
            </td>
        </tr>          
    </table>
    <table>
        <%  if (indice.equals("Otro indice")) {%>
        <tr>
            <td>Nuevo Indice:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;
            </td>
            <td><input type="text" name="nomIndice" value="<%=nomIndice%>" readonly="readonly"></td>
            <td>(máx. 20 caracteres)</td>
        </tr>
        <%}%>
    </table>
    <%}%>
</div>
<%  if (tipoPubli != null) {%>
<div id="ingresarNuevoAutor">
    <form action="./Seguridad/procesarPublicacion.jsp?opcNuevoAutor=Si&opcAutor=<%=tipoPubli%>" name="botonNuevoAutor" method="post">
        <div id="botonNuevoAutor">
            <table>
                <tr>
                    <td><input type="submit" value="Nuevo autor"/></td>
                </tr>        
            </table>
        </div>    
    </form>
</div>
<div id="autores">
    <div id="seccionAutores">
        <center><h3>Seleccione los autores</h3></center>
        <div id="tablaAutores">
            <form action="./Seguridad/procesarPublicacion.jsp?opcEliminar=No&opcAutor=<%=tipoPubli%>" name="seleccionarAutor" method="post" onsubmit="return validarSeleccion();">
                <table>
                    <tr>
                        <td>
                            <select name="personas" size="11">
                                <option value="Sin seleccion" selected="selected">Sin Seleccion</option>
                                <%
                                    ArrayList<HashMap> lstPersonas = cl.cargarPersonas();
                                    Iterator it = lstPersonas.iterator();
                                    while (it.hasNext()) {
                                        HashMap p = (HashMap) it.next();
                                        String id = (String) p.get("idPer");
                                        String nom = (String) p.get("nombre");
                                        String ape = (String) p.get("apellido");
                                %>
                                <option value="<%=id%>"><%=nom + "," + ape%></option>
                                <%  }%>
                            </select>
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td><input type="submit" value="Agregar"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div id="seleccionados">
        <center><h3>Autores seleccionados</h3></center>
        <div id="tablaAutores">
        <form action="./Seguridad/procesarPublicacion.jsp?opcEliminar=Si&opcAutor=<%=tipoPubli%>" name="autorSeleccionado" method="post" onsubmit="return validarEliminacion();">
            <table>
                <tr>
                    <td>
                        <select name="seleccionados" size="11">
                            <option value="Sin seleccion" selected="selected">Sin Seleccion</option>
                            <%
                                Iterator it1 = seleccionados.iterator();
                                while (it1.hasNext()) {
                                       Persona p = (Persona) it1.next();
                                       String id =  String.valueOf(p.getId());
                                       String nom = p.getNombre();
                                       String ape = p.getApellido();
                             %>
                                <option value="<%=id%>"><%=nom + "," + ape%></option>
                             <% }%>
                        </select>
                    </td>
                </tr>
            </table>
            <table>
                <tr>
                    <td><input type="submit" value="Quitar"/></td>
                </tr>
            </table>
        </form>
        </div>
    </div>
</div>
<div id="enviarPublicacion">
    <form action="./Seguridad/procesarPublicacion.jsp?opcIngresar=Si&opcAutor=<%=tipoPubli%>" name="botonIngresar" method="post">
        <div id="botonIngresarPubli">
            <table>
                <tr>
                    <td><input type="submit" value="Ingresar Publicacion"/></td>
                </tr>        
            </table>
        </div>    
    </form>
</div>
<%}%>
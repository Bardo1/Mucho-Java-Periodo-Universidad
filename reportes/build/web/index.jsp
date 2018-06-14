<%-- 
    Document   : index
    Created on : 19-feb-2013, 12:19:16
    Author     : Walter
--%>
 <%    String query="";
   if( Autor.isSelected()) query="select *from Publicacion p, Persona per, AutorPublicacion ap  WHERE per.idPer= ap.idAutor, ap.idPub=p.idPub, per.nombre='"+"nombreselected"+"' ";
   if( Año.isSelected())query="select *from Publicacion p where p.anio='"+"añoselected"+"'";
   if( Tipo.isSelected())query="select *from Publicacion p, Journal jo where p.idPub=jo.idPub";
   query="select *from Publicacion p, Articulo ar where p.idPub=ar.idPub";
   query="select *from Publicacion p, Libro li where p.idPub=li.idPub";
   if(IndiceEspecifico.isSelected())query="select *from Publicacion p where p.nombreIndice='"+"añoselected"+"'";
   if( Autor.isSelected()&&Año.isSelected())query="select *from Publicacion p, Persona per, AutorPublicacion ap  WHERE per.idPer= ap.idAutor, ap.idPub=p.idPub, per.nombre='"+"nombreselected"+"' p.anio= '"+"anioingreso"+"'";
   if( Autor.isSelected()&&Tipo.isSelected())query="select *from Publicacion p, Persona per, AutorPublicacion ap, Journal jo  WHERE per.idPer= ap.idAutor, ap.idPub=p.idPub, per.nombre='"+"nombreselected"+"' p.anio= '"+"anioingreso"+"'";
   if( Autor.isSelected()&&IndiceEspecifico.isSelected())query="select *from Publicacion p, Persona per, AutorPublicacion ap  WHERE per.idPer= ap.idAutor, ap.idPub=p.idPub, per.nombre='"+"nombreselected"+"' p.nombreIndice= '"+"nombre indice"+"'";

   if( Año.isSelected()&&Tipo.isSelected())query="select *from Publicacion p, Persona per, AutorPublicacion ap, Journal jo  WHERE per.idPer= ap.idAutor, ap.idPub=p.idPub, per.nombre='"+"nombreselected"+"' p.anio= '"+"anioingreso"+"'";
   
   
   if( Año.isSelected()&& IndiceEspecifico.isSelected())query="";
   if( Tipo.isSelected()&& IndiceEspecifico.isSelected())query="";
   
   if( Autor.isSelected()&&Año.isSelected()&&Tipo.isSelected())query="";
   if( Autor.isSelected()&&Tipo.isSelected()&&IndiceEspecifico.isSelected())query="";
   if( Autor.isSelected()&&Año.isSelected()&&IndiceEspecifico.isSelected())query="";
   if( Tipo.isSelected()&&IndiceEspecifico.isSelected()&&Año.isSelected()){query="";}
   %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    </body>
</html>

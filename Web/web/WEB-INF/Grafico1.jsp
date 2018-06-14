<%-- 
    Document   : Grafico1
    Created on : 24-dic-2012, 22:50:30
    Author     : Walter
--%>

 
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.ControladorLogica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%  
    ControladorLogica cl = (ControladorLogica) session.getAttribute("cl");
    if (cl == null) {
    cl = new ControladorLogica();
    session.setAttribute("cl", cl);
    }
    
    int valor1= cl.contarJournalAutorAnio("carlos",1995);
    int valor2 =cl.contarConferenciaAutorAnio("carlos",1995);
    int valor3 =cl.contarLibroAutorAnio("carlos",1995);
   
 %>
      
<html>
  <head>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Año', 'Journal','Conferencia','Libro'],
       <% for(int i=anioI; i<=anioFinal; i--){%>
          [anioI, cl.contarJournalAutorAnio(nombreAutor,anioI),cl.contarConferenciaAutorAnio(nombreAutor,anioI),cl.contarLibroAutorAnio(nombreAutor,anioI)],
         ]);
       <%}%>
        var options = {
          title: 'Distribución de publicaciones por año, según tipo, para un autor específico',
          hAxis: {title: 'Año', titleTextStyle: {color: 'red'}}
        };

        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="chart_div" style="width: 900px; height: 500px;"></div>
  </body>
</html>
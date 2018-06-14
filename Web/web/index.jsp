



<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>

<%@page import="Logica.ControladorLogica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ControladorLogica cl = (ControladorLogica) session.getAttribute("cl");
    if (cl == null) {
        cl = new ControladorLogica();
        session.setAttribute("cl", cl);
    }

  
    int valor1= cl.contarpublicacionISCIELO(1995);
    int valor2 =cl.contarpublicacionISI(1995);
    int valor3 = cl.contarpublicacionISIPROCEEDING(1995);
    int total =cl.contarpublicacionTodoOtroindice(1995);
    int valor4 = (valor1+valor2+valor3)-total;
    int porcentaje1= (valor1*100)/total;
    int porcentaje2= (valor2*100)/total;
    int porcentaje3= (valor3*100)/total;
    int porcentaje4= (valor4*100)/total;

%>

<html>
  <head>
    
    
    
    
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">

      // Load the Visualization API and the piechart package.
      google.load('visualization', '1.0', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
            
            
          ['ISI', 25],
          ['SCIELO',25],
          ['ISI PROCEEDING',25],
          ['Otro índice', 25],
         
         
        ]);

        // Set chart options
        var options = {'title':'Distribución de publicaciones según el índice, para un año específico',
                       'width':400,
                       'height':300};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
  </head>

  <body>
    <!--Div that will hold the pie chart-->
    <div id="chart_div"></div>
  </body>
</html>





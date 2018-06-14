package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Grafico3_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <!--Load the AJAX API-->\n");
      out.write("    <script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("      // Load the Visualization API and the piechart package.\n");
      out.write("      google.load('visualization', '1.0', {'packages':['corechart']});\n");
      out.write("\n");
      out.write("      // Set a callback to run when the Google Visualization API is loaded.\n");
      out.write("      google.setOnLoadCallback(drawChart);\n");
      out.write("\n");
      out.write("      // Callback that creates and populates a data table,\n");
      out.write("      // instantiates the pie chart, passes in the data and\n");
      out.write("      // draws it.\n");
      out.write("      function drawChart() {\n");
      out.write("\n");
      out.write("        // Create the data table.\n");
      out.write("        var data = new google.visualization.DataTable();\n");
      out.write("        data.addColumn('string', 'Topping');\n");
      out.write("        data.addColumn('number', 'Slices');\n");
      out.write("        data.addRows([\n");
      out.write("          ['ISI', 3],\n");
      out.write("          ['SCIELO', 3],\n");
      out.write("          ['ISI PROCEEDING', 2],\n");
      out.write("          ['Otro índice', 3],\n");
      out.write("         \n");
      out.write("         \n");
      out.write("        ]);\n");
      out.write("\n");
      out.write("        // Set chart options\n");
      out.write("        var options = {'title':'How Much Pizza I Ate Last Night',\n");
      out.write("                       'width':400,\n");
      out.write("                       'height':300};\n");
      out.write("\n");
      out.write("        // Instantiate and draw our chart, passing in some options.\n");
      out.write("        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));\n");
      out.write("        chart.draw(data, options);\n");
      out.write("      }\n");
      out.write("    </script>\n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("    <!--Div that will hold the pie chart-->\n");
      out.write("    <div id=\"chart_div\"></div>\n");
      out.write("  </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Grafico1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("      google.load(\"visualization\", \"1\", {packages:[\"corechart\"]});\n");
      out.write("      google.setOnLoadCallback(drawChart);\n");
      out.write("      function drawChart() {\n");
      out.write("        var data = google.visualization.arrayToDataTable([\n");
      out.write("          ['Year', 'Journal','Conferencia','Libro'],\n");
      out.write("          ['2004',  1000,400,300],\n");
      out.write("          ['2005',  1170,460,388],\n");
      out.write("          ['2006',  660,1120,100],\n");
      out.write("          ['2007',  1030,540,100]\n");
      out.write("        ]);\n");
      out.write("\n");
      out.write("        var options = {\n");
      out.write("          title: 'Company Performance',\n");
      out.write("          hAxis: {title: 'Year', titleTextStyle: {color: 'red'}}\n");
      out.write("        };\n");
      out.write("\n");
      out.write("        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));\n");
      out.write("        chart.draw(data, options);\n");
      out.write("      }\n");
      out.write("    </script>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div id=\"chart_div\" style=\"width: 900px; height: 500px;\"></div>\n");
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

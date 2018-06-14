package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("      \n");
      out.write("        <title>ESTE ES EL TITULO DE LA PAGINA</title>     \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center>\n");
      out.write("          <font face=\"Arial,Helvetica\" color=#DF2323  size=5 >    <h1>HOOOOOOOOOOOOOOOOOOOOOLA MUNDO</h1>                    </font> \n");
      out.write("        \n");
      out.write("          <font  color=#CCF71E  size=5 >   <h1>PROBANDO</h1>  </font> \n");
      out.write("          <img src=\"http://s3.argim.net/files/s/lindo_cuerpo_sexual.gif\"></img>\n");
      out.write("          <br>  \n");
      out.write("             <br>  \n");
      out.write("              <br>  \n");
      out.write("               <br>  \n");
      out.write("            \n");
      out.write("      <img src=\" http://img.ffffound.com/static-data/assets/6/4623bb28584e61fed8ef054493a775899171aab3_m.gif\"></img>\n");
      out.write("       <center>\n");
      out.write("      \n");
      out.write("      <table border=1>\n");
      out.write("      <tr>\n");
      out.write("               <td> 1</td>\n");
      out.write("               <td>2</td>\n");
      out.write("               <td>3 </td>\n");
      out.write("               <td> 1</td>\n");
      out.write("               <td>2</td>\n");
      out.write("               <td>3 </td>\n");
      out.write("      </tr>\n");
      out.write("      <tr>\n");
      out.write("               <td> 4</td>\n");
      out.write("               <td> 5</td>\n");
      out.write("               <td> 6 </td>\n");
      out.write("               <td> 4</td>\n");
      out.write("               <td> 5</td>\n");
      out.write("               <td> 6 </td>\n");
      out.write("      </tr>\n");
      out.write("       <tr>\n");
      out.write("               <td> 7</td>\n");
      out.write("               <td> 8</td>\n");
      out.write("               <td> 9 </td>\n");
      out.write("               <td> 7</td>\n");
      out.write("               <td> 8</td>\n");
      out.write("               <td> 9 </td>\n");
      out.write("      </tr>\n");
      out.write("      <tr>\n");
      out.write("               <td> 10</td>\n");
      out.write("               <td> 11</td>\n");
      out.write("               <td> 12 </td>\n");
      out.write("               <td> 10</td>\n");
      out.write("               <td> 11</td>\n");
      out.write("               <td> 12 </td>\n");
      out.write("      </tr>\n");
      out.write("</table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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

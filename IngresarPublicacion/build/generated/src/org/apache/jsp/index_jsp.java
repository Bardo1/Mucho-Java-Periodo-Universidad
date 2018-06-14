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
      out.write("<?php\n");
      out.write("\n");
      out.write("//Get Current User Login\n");
      out.write("global $current_user;\n");
      out.write("$current_user = wp_get_current_user();\n");
      out.write("$ulog = $current_user->user_login;\n");
      out.write("$tablename_db = \"db_\".$ulog;\n");
      out.write("\n");
      out.write("mysql_select_db(\"data_base_name_here\");\n");
      out.write("\n");
      out.write("//Create Table If It Does Not Exist\n");
      out.write("$sql = \"CREATE TABLE IF NOT EXISTS $tablename_db (\n");
      out.write("ID int NOT NULL AUTO_INCREMENT,\n");
      out.write("PRIMARY KEY(ID),\n");
      out.write("db_num int,\n");
      out.write("db_amnt int\n");
      out.write(");\";\n");
      out.write("\n");
      out.write("mysql_query($sql); ?>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<form action=\"DirectBill.php\" method=\"post\">\n");
      out.write("<fieldset>\n");
      out.write("<legend>Direct Bill Information:</legend>\n");
      out.write("DB #: <input type=\"int\" name=\"db_num_1\" /> DB Amount: <input type=\"int\" name=\"db_amnt_1\" /> </br>\n");
      out.write("<!--Above table entries is repeated 10 more times-->\n");
      out.write("<strong><!--<input type=\"hidden\" name=\"user_name\" value=\"user_login_ID>--></strong>\n");
      out.write("</fieldset>\n");
      out.write("<input type=\"submit\" />\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("</body>\n");
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

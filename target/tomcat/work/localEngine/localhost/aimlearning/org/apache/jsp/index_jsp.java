package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.aimprosoft.aimlearning.model.Department;
import com.aimprosoft.aimlearning.DAO.DepartmentDAOImpl;
import java.io.PrintWriter;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Aimprosoft Java</title>\n");
      out.write("    <link href=\"css/main.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"departments_main\">\n");
      out.write("    <form>\n");
      out.write("        <div class=\"header_refs\">\n");
      out.write("            <a href=\"/aimlearning_war_exploded/\">Home page</a>\n");
      out.write("            <a href=\"/aimlearning_war_exploded/allEmployees.jsp\">All Employees</a>\n");
      out.write("            <a href=\"/aimlearning_war_exploded/addEmployee.jsp\">Add Employee</a>\n");
      out.write("            <a href=\"/aimlearning_war_exploded/addDepartment.jsp\">Add Department</a>\n");
      out.write("        </div>\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("    <div class=\"departments_all\">\n");
      out.write("        ");

            List<Department> departments = new DepartmentDAOImpl().getAllDepartments();
            PrintWriter printWriter = response.getWriter();
            for(int i = 0 ; i < departments.size(); i++){
                printWriter.println("<a class=\"department_href\"  href=\"http://localhost:8080/aimlearning_war_exploded/departmentByid.jsp?id="+ departments.get(i).getIdDepartment() +"\"> Department: "
                        + "Id: " + departments.get(i).getIdDepartment() +
                        " name: " + departments.get(i).getName() +
                        " address: " + departments.get(i).getAddress() +
                        "</a>      " +
                        "<a class=\"update_button\" href=\"/aimlearning_war_exploded/updateDepartmentServlet?id=" + departments.get(i).getIdDepartment() +
                        "&name=" + departments.get(i).getName() +
                        "&address=" + departments.get(i).getAddress() + "\">    Update this department</a> </p> <br>" );
            }
        
      out.write("\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

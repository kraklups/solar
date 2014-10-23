package org.apache.jsp.WEB_002dINF.template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class layout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
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
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("    \t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>\n");
      out.write("    \t\n");
      out.write("\t\t<title>Default tiles template</title>\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- Bootstrap Core CSS -->\n");
      out.write("    \t<link href=\"resources/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t<!-- Custom CSS -->\n");
      out.write("\t\t<link href=\"resources/css/sb-admin.css\" rel=\"stylesheet\">\n");
      out.write("\t\t\n");
      out.write("    <!-- Custom Fonts -->\n");
      out.write("    <link href=\"resources/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" type=\"text/css\">\t\t\n");
      out.write("\t\t\n");
      out.write("\t</head>\n");
      out.write("\t\n");
      out.write("\t<body>\n");
      out.write("\t\n");
      out.write("\t\t<div class=\"page\">\n");
      out.write("\t\t\t");
      if (_jspx_meth_tiles_insertAttribute_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t<div class=\"content\">\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_tiles_insertAttribute_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_tiles_insertAttribute_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t");
      if (_jspx_meth_tiles_insertAttribute_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("    <!-- jQuery Version 1.11.0 -->\n");
      out.write("    <script src=\"resources/js/jquery-1.11.0.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap Core JavaScript -->\n");
      out.write("    <script src=\"resources/js/bootstrap.min.js\"></script>\t\t\n");
      out.write("\n");
      out.write("    <!-- Firebug JavaScript -->\n");
      out.write("    <script src=\"resources/js/Firebug/firebug.js\"></script>\t\t\n");
      out.write("\t\t\n");
      out.write("\t</body>\n");
      out.write("\t\n");
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

  private boolean _jspx_meth_tiles_insertAttribute_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_insertAttribute_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.tiles.jsp.taglib.InsertAttributeTag.class) : new org.apache.tiles.jsp.taglib.InsertAttributeTag();
    _jspx_th_tiles_insertAttribute_0.setJspContext(_jspx_page_context);
    _jspx_th_tiles_insertAttribute_0.setName("header");
    _jspx_th_tiles_insertAttribute_0.doTag();
    return false;
  }

  private boolean _jspx_meth_tiles_insertAttribute_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_insertAttribute_1 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.tiles.jsp.taglib.InsertAttributeTag.class) : new org.apache.tiles.jsp.taglib.InsertAttributeTag();
    _jspx_th_tiles_insertAttribute_1.setJspContext(_jspx_page_context);
    _jspx_th_tiles_insertAttribute_1.setName("menu");
    _jspx_th_tiles_insertAttribute_1.doTag();
    return false;
  }

  private boolean _jspx_meth_tiles_insertAttribute_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_insertAttribute_2 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.tiles.jsp.taglib.InsertAttributeTag.class) : new org.apache.tiles.jsp.taglib.InsertAttributeTag();
    _jspx_th_tiles_insertAttribute_2.setJspContext(_jspx_page_context);
    _jspx_th_tiles_insertAttribute_2.setName("body");
    _jspx_th_tiles_insertAttribute_2.doTag();
    return false;
  }

  private boolean _jspx_meth_tiles_insertAttribute_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_insertAttribute_3 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.tiles.jsp.taglib.InsertAttributeTag.class) : new org.apache.tiles.jsp.taglib.InsertAttributeTag();
    _jspx_th_tiles_insertAttribute_3.setJspContext(_jspx_page_context);
    _jspx_th_tiles_insertAttribute_3.setName("footer");
    _jspx_th_tiles_insertAttribute_3.doTag();
    return false;
  }
}

package org.apache.jsp.WEB_002dINF.views.park;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class showParks_jspx extends org.apache.jasper.runtime.HttpJspBase
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

      if (_jspx_meth_tiles_insertDefinition_0(_jspx_page_context))
        return;
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

  private boolean _jspx_meth_tiles_insertDefinition_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertDefinition
    org.apache.tiles.jsp.taglib.InsertDefinitionTag _jspx_th_tiles_insertDefinition_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.tiles.jsp.taglib.InsertDefinitionTag.class) : new org.apache.tiles.jsp.taglib.InsertDefinitionTag();
    _jspx_th_tiles_insertDefinition_0.setJspContext(_jspx_page_context);
    _jspx_th_tiles_insertDefinition_0.setName("defaultTemplate");
    _jspx_th_tiles_insertDefinition_0.setJspBody(new showParks_jspxHelper( 0, _jspx_page_context, _jspx_th_tiles_insertDefinition_0, null));
    _jspx_th_tiles_insertDefinition_0.doTag();
    return false;
  }

  private boolean _jspx_meth_tiles_putAttribute_0(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:putAttribute
    org.apache.tiles.jsp.taglib.PutAttributeTag _jspx_th_tiles_putAttribute_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.tiles.jsp.taglib.PutAttributeTag.class) : new org.apache.tiles.jsp.taglib.PutAttributeTag();
    _jspx_th_tiles_putAttribute_0.setJspContext(_jspx_page_context);
    _jspx_th_tiles_putAttribute_0.setParent(_jspx_parent);
    _jspx_th_tiles_putAttribute_0.setName("body");
    _jspx_th_tiles_putAttribute_0.setJspBody(new showParks_jspxHelper( 1, _jspx_page_context, _jspx_th_tiles_putAttribute_0, null));
    _jspx_th_tiles_putAttribute_0.doTag();
    return false;
  }

  private class showParks_jspxHelper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public showParks_jspxHelper( int discriminator, JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( JspWriter out ) 
      throws Throwable
    {
      if (_jspx_meth_tiles_putAttribute_0((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      return false;
    }
    public boolean invoke1( JspWriter out ) 
      throws Throwable
    {
      out.write("<div id=\"wrapper\">");
      out.write("<div class=\"page-wrapper\">");
      out.write("<div class=\"container-fluid\">");
      out.write("<div class=\"row\">");
      out.write("<div class=\"col-lg-12\">");
      out.write("<h2 class=\"page-header\">");
      out.write("Parks");
      out.write("</h2>");
      out.write("</div>");
      out.write("</div>");
      out.write("<div class=\"row\">");
      out.write("<div class=\"col-lg-12\">");
      out.write("<div class=\"panel panel-default\">");
      out.write("<div class=\"panel-heading\">");
      out.write("\n");
      out.write("                            Pill Tabs\n");
      out.write("                        ");
      out.write("</div>");
      out.write("<div class=\"panel-body\">");
      out.write("<ul class=\"nav nav-pills\">");
      out.write("<li class=\"active\">");
      out.write("<a data-toggle=\"tab\" href=\"#home-pills\">");
      out.write("Home");
      out.write("</a>");
      out.write("</li>");
      out.write("<li>");
      out.write("<a data-toggle=\"tab\" href=\"#profile-pills\">");
      out.write("Profile");
      out.write("</a>");
      out.write("</li>");
      out.write("<li>");
      out.write("<a data-toggle=\"tab\" href=\"#messages-pills\">");
      out.write("Messages");
      out.write("</a>");
      out.write("</li>");
      out.write("<li>");
      out.write("<a data-toggle=\"tab\" href=\"#settings-pills\">");
      out.write("Settings");
      out.write("</a>");
      out.write("</li>");
      out.write("</ul>");
      out.write("<div class=\"tab-content\">");
      out.write("<div id=\"home-pills\" class=\"tab-pane fade in active\">");
      out.write("<h4>");
      out.write("Home Tab");
      out.write("</h4>");
      out.write("<p>");
      out.write("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
      out.write("</p>");
      out.write("</div>");
      out.write("<div id=\"profile-pills\" class=\"tab-pane fade\">");
      out.write("<h4>");
      out.write("Profile Tab");
      out.write("</h4>");
      out.write("<p>");
      out.write("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
      out.write("</p>");
      out.write("</div>");
      out.write("<div id=\"messages-pills\" class=\"tab-pane fade\">");
      out.write("<h4>");
      out.write("Messages Tab");
      out.write("</h4>");
      out.write("<p>");
      out.write("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
      out.write("</p>");
      out.write("</div>");
      out.write("<div id=\"settings-pills\" class=\"tab-pane fade\">");
      out.write("<h4>");
      out.write("Settings Tab");
      out.write("</h4>");
      out.write("<p>");
      out.write("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
      out.write("</p>");
      out.write("</div>");
      out.write("</div>");
      out.write("</div>");
      out.write("</div>");
      out.write("</div>");
      out.write("</div>");
      out.write("</div>");
      out.write("</div>");
      out.write("</div>");
      return false;
    }
    public void invoke( java.io.Writer writer )
      throws JspException
    {
      JspWriter out = null;
      if( writer != null ) {
        out = this.jspContext.pushBody(writer);
      } else {
        out = this.jspContext.getOut();
      }
      try {
        switch( this.discriminator ) {
          case 0:
            invoke0( out );
            break;
          case 1:
            invoke1( out );
            break;
        }
      }
      catch( Throwable e ) {
        if (e instanceof SkipPageException)
            throw (SkipPageException) e;
        throw new JspException( e );
      }
      finally {
        if( writer != null ) {
          this.jspContext.popBody();
        }
      }
    }
  }
}

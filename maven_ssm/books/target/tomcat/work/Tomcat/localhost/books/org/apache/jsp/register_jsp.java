/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-12-02 02:30:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("    <title>Book Store</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"../style/css/style.css\" />\r\n");
      out.write("    <script type=\"application/javascript\" src=\"../style/js/jquery.js\"></script>\r\n");
      out.write("    <script type=\"application/javascript\" src=\"../style/myjs/user.js\"></script>\r\n");
      out.write("    <script>var uname='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.uname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'; var url='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';</script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"../style/myjs/cart.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"wrap\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"header\">\r\n");
      out.write("        <div class=\"logo\"><a href=\"book/querAll.action?page=1\"><img src=\"../style/images/logo.gif\" alt=\"\" title=\"\" border=\"0\" /></a></div>\r\n");
      out.write("        <div id=\"menu\">\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"../book/querAll.action?page=1\">首页</a></li>\r\n");
      out.write("                <li><a href=\"../about.jsp\">关于我们</a></li>\r\n");
      out.write("                <li><a href=\"../book/all.action?page=1\">所有图书</a></li>\r\n");
      out.write("                <li><a href=\"../user/log.action\">登录</a></li>\r\n");
      out.write("                <li class=\"selected\"><a href=\"../user/reg.action\">注册</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"center_content\">\r\n");
      out.write("        <div class=\"left_content\">\r\n");
      out.write("            <div class=\"title\"><span class=\"title_icon\"><img src=\"../style/images/bullet1.gif\" alt=\"\" title=\"\" /></span>注册</div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"feat_prod_box_details\">\r\n");
      out.write("                <div class=\"contact_form\">\r\n");
      out.write("                    <div class=\"form_subtitle\">建立新账户</div>\r\n");
      out.write("                        <div class=\"form_row\">\r\n");
      out.write("                            <label class=\"contact\"><strong>用户名:</strong></label>\r\n");
      out.write("                            <input type=\"text\" id=\"userName\" class=\"contact_input\" />\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form_row\">\r\n");
      out.write("                            <label class=\"contact\"><strong>密码:</strong></label>\r\n");
      out.write("                            <input type=\"password\" id=\"password\" class=\"contact_input\" />\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                       ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <!--  <div class=\"form_row\">\r\n");
      out.write("                              <div class=\"terms\">\r\n");
      out.write("                              <input type=\"checkbox\" name=\"terms\" />\r\n");
      out.write("                              I agree to the <a href=\"#\">terms &amp; conditions</a>                        </div>\r\n");
      out.write("                          </div> -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form_row\">\r\n");
      out.write("                            <input type=\"button\" onclick=\"addUser()\" class=\"register\" value=\"注册\" />\r\n");
      out.write("                        </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"clear\"></div>\r\n");
      out.write("        </div><!--end of left content-->\r\n");
      out.write("\r\n");
      out.write("        <div class=\"right_content\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"cart\">\r\n");
      out.write("\r\n");
      out.write("                ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                ");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- <div class=\"title\"><span class=\"title_icon\"><img src=\"../style/images/bullet3.gif\" alt=\"\" title=\"\" /></span>About Our Store</div>\r\n");
      out.write("             <div class=\"about\">\r\n");
      out.write("             <p>\r\n");
      out.write("             <img src=\"../style/images/about.gif\" alt=\"\" title=\"\" class=\"right\" />\r\n");
      out.write("             Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.\r\n");
      out.write("             </p>\r\n");
      out.write("\r\n");
      out.write("             </div>-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div><!--end of right content-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"clear\"></div>\r\n");
      out.write("    </div><!--end of center content-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"footer\">\r\n");
      out.write("        <div class=\"left_footer\"><img src=\"../style/images/footer_logo.gif\" alt=\"\" title=\"\" /><br /> <a href=\"http://www.cssmoban.com/\" title=\"free templates\">cssmoban</a></div>\r\n");
      out.write("        <div class=\"right_footer\">\r\n");
      out.write("            <a href=\"#\">首页</a>\r\n");
      out.write("            <a href=\"#\">关于我们</a>\r\n");
      out.write("            <a href=\"#\">服务</a>\r\n");
      out.write("            <a href=\"#\">隐私政策</a>\r\n");
      out.write("            <a href=\"#\">联系我们</a>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /register.jsp(96,16) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.uname!=null}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                    <div class=\"title\"><span class=\"title_icon\"><img src=\"../style/images/cart.gif\" alt=\"\" title=\"\" /></span>购物车</div>\r\n");
        out.write("                    <div class=\"home_cart_content\">\r\n");
        out.write("                        <span id=\"sum\">0</span>  件物品 | <span class=\"red\" id=\"total\">共: 0元</span>\r\n");
        out.write("                    </div>\r\n");
        out.write("                    <a href=\"../cart/selectByUid.action?page=1\" class=\"view_cart\">查看购物车</a>\r\n");
        out.write("                    <a href=\"cart.jsp\" class=\"view_cart\">退出登录</a>\r\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /register.jsp(104,16) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.uname==null}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                    点击三上方登录才能查询购物车.如果没有账户请先注册\r\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }
}

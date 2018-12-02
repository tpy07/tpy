<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/11
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Book Store</title>
    <link rel="stylesheet" type="text/css" href="../style/css/style.css" />
    <script type="application/javascript" src="../style/js/jquery.js"></script>
    <script type="application/javascript" src="../style/myjs/user.js"></script>

    <script>var uname='${sessionScope.uname}'; var url='${requestScope.url}';</script>
    <script type="text/javascript" src="../style/myjs/cart.js"></script>
</head>
<body>
<div id="wrap">

    <div class="header">
        <div class="logo"><a href="index.jsp"><img src="../style/images/logo.gif" alt="" title="" border="0" /></a></div>
        <div id="menu">
            <ul>
                <li><a href="../book/querAll.action?page=1">首页</a></li>
                <li><a href="../about.jsp">关于我们</a></li>
                <li><a href="../book/all.action?page=1">所有图书</a></li>
                <li class="selected"><a href="../user/log.action">登录</a></li>
                <li><a href="../user/reg.action">注册</a></li>
            </ul>
        </div>


    </div>


    <div class="center_content">
        <div class="left_content">
            <div class="title"><span class="title_icon"><img src="../style/images/bullet1.gif" alt="" title="" /></span>登录</div>

            <div class="feat_prod_box_details">
                <div class="contact_form">
                    <div class="form_subtitle">登录您的帐户</div>

                        <div class="form_row">
                            <label class="contact"><strong>用户名:</strong></label>
                            <input type="text" id="userName" class="contact_input" />
                        </div>


                        <div class="form_row">
                            <label class="contact"><strong>密码:</strong></label>
                            <input type="password" id="password" class="contact_input" />
                        </div>

                        <%--<div class="form_row">
                            <div class="terms">
                                <input type="checkbox" name="terms" />
                                记住账户
                            </div>
                        </div>--%>


                        <div class="form_row">
                            <input type="button" class="register" value="登录" onclick="login()" />
                        </div>

                </div>

            </div>






            <div class="clear"></div>
        </div><!--end of left content-->

        <div class="right_content">

            <div class="cart">

                <c:if test="${sessionScope.uname!=null}">
                    <div class="title"><span class="title_icon"><img src="../style/images/cart.gif" alt="" title="" /></span>购物车</div>
                    <div class="home_cart_content">
                        <span id="sum">0</span>  件物品 | <span class="red" id="total">共: 0元</span>
                    </div>
                    <a href="../cart/selectByUid.action?page=1" class="view_cart">查看购物车</a>
                    <a href="cart.jsp" class="view_cart">退出登录</a>
                </c:if>
                <c:if test="${sessionScope.uname==null}">
                    请先登录或者注册
                </c:if>
            </div>




            <!-- <div class="title"><span class="title_icon"><img src="../style/images/bullet3.gif" alt="" title="" /></span>About Our Store</div>
             <div class="about">
             <p>
             <img src="../style/images/about.gif" alt="" title="" class="right" />
             Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.
             </p>

             </div>-->

        <%--    <div class="right_box">

                <div class="title"><span class="title_icon"><img src="../style/images/bullet4.gif" alt="" title="" /></span>促销商品</div>
                <div class="new_prod_box">
                    <a href="details.jsp">书名</a>
                    <div class="new_prod_bg">
                        <span class="new_icon"><img src="../style/images/promo_icon.gif" alt="" title="" /></span>
                        <a href="details.jsp"><img src="../style/images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a>
                    </div>
                </div>
            </div>--%>


        </div><!--end of right content-->




        <div class="clear"></div>
    </div><!--end of center content-->


    <div class="footer">
        <div class="left_footer"><img src="../style/images/footer_logo.gif" alt="" title="" /><br /> <a href="http://www.cssmoban.com/" title="free templates">cssmoban</a></div>
        <div class="right_footer">
            <a href="#">首页</a>
            <a href="#">关于我们</a>
            <a href="#">服务</a>
            <a href="#">隐私政策</a>
            <a href="#">联系我们</a>

        </div>


    </div>


</div>

</body>
</html>

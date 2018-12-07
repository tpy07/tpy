<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/11
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
    <title>Book Store</title>
    <link rel="stylesheet" type="text/css" href="../style/css/style.css" />

    <script src="../style/js/prototype.js" type="text/javascript"></script>
    <script type="text/javascript" src="../style/js/java.js"></script>
    <script  src="../style/js/jquery.js"></script>
    <script>var uname='${sessionScope.uname}';</script>
    <script type="text/javascript" src="../style/myjs/cart.js"></script>
</head>
<body>
<div id="wrap">

    <div class="header">
        <div class="logo"><a href="querAll.action?page=1"><img src="../style/images/logo.gif" alt="" title="" border="0" /></a></div>
        <div id="menu">
            <ul>
                <li class="selected"><a href="querAll.action?page=1">首页</a></li>
                <li><a href="../about.jsp">关于我们</a></li>
                <li><a href="../category.jsp">所有图书</a></li>
                <li><a href="../user/log.action">登录</a></li>
                <li><a href="../user/reg.action">注册</a></li>
            </ul>
        </div>


    </div>


    <div class="center_content">
        <div class="left_content">
            <div class="crumb_nav">
                <a href="querAll.action?page=1">首页</a> &gt;&gt; ${requestScope.book.bookName}
            </div>
            <div class="title"><span class="title_icon"><img src="../style/images/bullet1.gif" alt="" title="" /></span>${requestScope.book.bookName}</div>

            <div class="feat_prod_box_details">

                <div class="prod_img"><a href="selectByBid.action?bid=${param.bid}"><img style="width: 98px;height: 150px;" src="${requestScope.book.bookImage}" alt="" title="" border="0" /></a>
                    <br /><br />
                </div>

                <div class="prod_det_box">
                    <div class="box_top"></div>
                    <div class="box_center">
                        <div class="prod_title">详细信息</div>
                        <p class="details"> ${requestScope.book.bookContext} </p>
                        <div class="price"><strong>价格:</strong> <span class="red"> ${requestScope.book.bookPrice} $</span></div>
                        <button class="more" onclick="addCart()">加入购物车</button>
                        <div class="clear"></div>
                    </div>

                    <div class="box_bottom"></div>
                </div>
                <div class="clear"></div>
            </div>


            <div id="demo" class="demolayout">

                <ul id="demo-nav" class="demolayout">
                    <li><a class="active" href="#tab1">更多信息</a></li>
                    <%--<li><a class="" href="#tab2">相关书籍</a></li>--%>
                </ul>

                <div class="tabs-container">

                    <div style="display: block;" class="tab" id="tab1">
                        ${requestScope.book.bookContext}
                    </div>

                   <%-- <div style="display: none;" class="tab" id="tab2">
                        <div class="new_prod_box">
                            <a href="details.html">product name</a>
                            <div class="new_prod_bg">
                                <a href="details.html"><img src="../style/images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a>
                            </div>
                        </div>

                        <div class="new_prod_box">
                            <a href="details.html">product name</a>
                            <div class="new_prod_bg">
                                <a href="details.html"><img src="../style/images/thumb2.gif" alt="" title="" class="thumb" border="0" /></a>
                            </div>
                        </div>

                        <div class="new_prod_box">
                            <a href="details.html">product name</a>
                            <div class="new_prod_bg">
                                <a href="details.html"><img src="../style/images/thumb3.gif" alt="" title="" class="thumb" border="0" /></a>
                            </div>
                        </div>

                        <div class="new_prod_box">
                            <a href="details.html">product name</a>
                            <div class="new_prod_bg">
                                <a href="details.html"><img src="../style/images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a>
                            </div>
                        </div>

                        <div class="new_prod_box">
                            <a href="details.html">product name</a>
                            <div class="new_prod_bg">
                                <a href="details.html"><img src="../style/images/thumb2.gif" alt="" title="" class="thumb" border="0" /></a>
                            </div>
                        </div>

                        <div class="new_prod_box">
                            <a href="details.html">product name</a>
                            <div class="new_prod_bg">
                                <a href="details.html"><img src="../style/images/thumb3.gif" alt="" title="" class="thumb" border="0" /></a>
                            </div>
                        </div>



                        <div class="clear"></div>
                    </div>--%>

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
                    点击三上方登录才能查询购物车.如果没有账户请先注册
                </c:if>
            </div>




            <!-- <div class="title"><span class="title_icon"><img src="../style/images/bullet3.gif" alt="" title="" /></span>About Our Store</div>
             <div class="about">
             <p>
             <img src="../style/images/about.gif" alt="" title="" class="right" />
             Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.
             </p>

             </div>-->
            <%--

                        <div class="right_box">

                            <div class="title"><span class="title_icon"><img src="../style/images/bullet4.gif" alt="" title="" /></span>促销商品</div>
                            <div class="new_prod_box">
                                <a href="details.jsp">书名</a>
                                <div class="new_prod_bg">
                                    <span class="new_icon"><img src="../style/images/promo_icon.gif" alt="" title="" /></span>
                                    <a href="details.jsp"><img src="../style/images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a>
                                </div>
                            </div>
                        </div>
            --%>


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
<script type="text/javascript">

    var tabber1 = new Yetii({
        id: 'demo'
    });

</script>
</html>

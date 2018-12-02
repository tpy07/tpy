
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>书店</title>
    <link rel="stylesheet" type="text/css" href="../style/css/style.css" />
    <script  src="../style/js/jquery.js"></script>
    <script>var uname='${sessionScope.uname}';</script>
    <script type="text/javascript" src="../style/myjs/cart.js"></script>
</head>
<body>
<div id="wrap">

    <div class="header">
        <div class="logo"><a href="index.html"><img src="../style/images/logo.gif" alt="" title="" border="0" /></a></div>
        <div id="menu">
            <ul>
                <li><a href="../book/querAll.action?page=1">首页</a></li>
                <li><a href="../about.jsp">关于我们</a></li>
                <li><a href="../book/all.action?page=1">所有图书</a></li>
                <li><a href="../user/log.action">登录</a></li>
                <li><a href="../user/reg.action">注册</a></li>
            </ul>
        </div>


    </div>


    <div class="center_content">
        <div class="left_content">
            <div class="title"><span class="title_icon"><img src="../style/images/bullet1.gif" alt="" title="" /></span>我的购物车</div>

            <div class="feat_prod_box_details">

                <table class="cart_table">
                    <tr class="cart_title">
                        <td>图片</td>
                        <td>书名</td>
                        <td>单价</td>
                        <td>数量</td>
                        <td>总价</td>
                    </tr>
<c:forEach items="${requestScope.cart[0]}" var="cart">
                    <tr>
                        <td><a href="../book/selectByBid.action?bid=${cart.bid.bid}"><img src="../style/images/cart_thumb.gif" alt="" title="" border="0" class="cart_thumb" /></a></td>
                        <td>${cart.bid.bookName}</td>
                        <td>${cart.bid.bookPrice}$</td>
                        <td>${cart.number}</td>
                        <td ><span name="totalPrice">${cart.bid.bookPrice*cart.number}</span>$</td>
                    </tr>
</c:forEach>
                    <tr>
                        <td colspan="5">
                            <c:forEach begin="${requestScope.cart[1].beginPage }" end="${requestScope.cart[1].endPage }" var="pageNum">
                                <a id="page">${pageNum}</a>
                            </c:forEach>
                        </td>
                    </tr>
                    <!--<tr>
                    <td colspan="4" class="cart_total"><span class="red">TOTAL SHIPPING:</span></td>
                    <td> 250$</td>
                    </tr>  -->

                    <tr>
                        <td colspan="4" class="cart_total"><span class="red">总价格:</span></td>
                        <td id="allprice"> 0元</td>
                    </tr>

                </table>
                <a href="#" class="continue">&lt; 返回</a>
                <a href="#" class="checkout">结账 &gt;</a>




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

            <%--<div class="right_box">

                <div class="title"><span class="title_icon"><img src="../style/images/bullet4.gif" alt="" title="" /></span>促销商品</div>
                <div class="new_prod_box">
                    <a href="details.html">书名</a>
                    <div class="new_prod_bg">
                        <span class="new_icon"><img src="../style/images/promo_icon.gif" alt="" title="" /></span>
                        <a href="details.html"><img src="../style/images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a>
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

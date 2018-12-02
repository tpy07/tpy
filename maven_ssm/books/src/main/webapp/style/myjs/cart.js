$(document).ready(function(){
    selectCart();
    totalPrice();
});
function selectCart(){
    if(uname==null||uname==""){
        return;
    }
    $.ajax({
        url: "/books/cart/selectSum.action",
        data: {userName:uname},
        type: "POST",
        dataType: "json",
        async: true, //设为false就是同步请求
        success: function (res) {
            var total=0;
            for(var i=0;i<res.length;i++){
                total+=res[i].bid.bookPrice*=res[i].number;
            }
            $("#total").html("共: "+total+"元");
            $("#sum").html(res.length);
        },
        error: function () {
            console.log("ajxa错误");
        }
    });
}
function addCart() {
    if(uname==""){
        alert("请先登录");
        return;
    }

    var data={'bid.bid':bid,number:1};
    $.ajax({
        url: "../cart/addCart.action",
        data: data,
        type: "POST",
        dataType: "json",
        async: true, //设为false就是同步请求
        success: function (res) {
            console.log(res);
            if(res>0){
                alert("添加成功");

            }
        },
        error: function () {
            console.log("ajxa错误");
        }
    });
}
function totalPrice(){
    var total=0;
    var totalPrice=$('span[name="totalPrice"]').each(function () {
        total= parseFloat(total)+ parseFloat($(this).html());
    });
   /* for (var i=0;i<totalPrice.length;i++){
        alert(totalPrice[i].html);
        /!**!/
    }*/
    $("#allprice").html(total+"$")
}
function chekc(){
    var userName=$("#userName").val();
    var password=$("#password").val();
    var chekName=/^[A-Za-z0-9]+$/
    var chekPwd=/^[\w]{5,12}$/;
    if(chekName.test(userName)){

    }else{
        alert("用户名只能为数字或者英文")
        return false;
    }
    if(chekPwd.test(password)){

    }else{
        alert("密码只能由数字和字母下划线组成长度为5-12")
        return false;
    }
    return true;
}
function login(){
    var uname='${sessionScope.uname}';
    /*if(uname!=""){
        alert("您已经登录,如果需要登录别的账号请先退出登录!");
        return;
    }*/
    var userName=$("#userName").val();
    var password=$("#password").val();
    if(chekc()==false){
        return;
    }

    var data={userName:userName,password:password};
    $.ajax({
        url: "/books/user/login.action",
        data: data,
        type: "POST",
        dataType: "json",
        async: true, //设为false就是同步请求
        success: function (res) {
            console.log(res);
            if(res==null){
                alert("登录失败请检查用户名或密码");
            }else{
                alert("登录成功");
                if(url==null||url==""){
                    window.location="../book/querAll.action?page=1";
                }else{
                    window.location="../"+url;
                }
            }
        },
        error: function () {
            console.log("ajxa错误");
        }
    });
}
function addUser(){
    var userName=$("#userName").val();
    var password=$("#password").val();
    if(chekc()==false){
        return;
    }
    var data={userName:userName,password:password};
    $.ajax({
        url: "/books/user/addUser.action",
        data: data,
        type: "POST",
        dataType: "json",
        async: true, //设为false就是同步请求
        success: function (res) {
            console.log(res);
            if(res>0){
                alert("注册成功");
                if(url==null||url==""){
                    window.location="../book/querAll.action?page=1";
                }else{
                    window.location="../"+url;
                }

            }else{
                alert("注册失败");
            }
        },
        error: function () {
            console.log("ajxa错误");
        }
    });
}
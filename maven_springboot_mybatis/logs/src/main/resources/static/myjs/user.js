function login(page){
    var userName=$("#uname").val();
    var password=$("#pwd").val();
    var chekName=/^[A-Za-z0-9]+$/
    var chekPwd=/^[\w]{5,12}$/;
    if(chekName.test(userName)){

    }else{
        alert("用户名只能为数字或者英文")
        return;
    }
    if(chekPwd.test(password)){

    }else{
        alert("密码只能由数字和字母下划线组成长度为5-12")
        return;
    }
    var data={userName:userName,password:password};
    console.log(data);
    $.ajax({
        url: "/users/login",
        data: data,
        type: "POST",
        dataType: "json",
        async: true, //设为false就是同步请求
        success: function (res) {
            if(res>0){
                alert("登录成功");
                if(page=="index"){
                    window.location="/logs/querAll?pages=1";
                }else if (page=="addbug") {
                    window.location.href="/logs/addBug.html";
                }
                
            }else{
                alert("登录失败");
            }
        },
        error: function (msg) {
            com.showAlert(com.error, msg);
            console.log(msg);
            if (failCallback) {
                failCallback(msg);
            }
        }
    });
}
function add(){
    var userName=$("#userName").val();
    var password=$("#password").val();
    var sex=$('input[name="sex"]:checked').val();
    var city=$("#city").val();
    var chekName=/^[A-Za-z0-9]+$/
    var chekPwd=/^[\w]{5,12}$/;
    if(chekName.test(userName)){

    }else{
        alert("用户名只能为数字或者英文")
        return;
    }
    if(chekPwd.test(password)){

    }else{
        alert("密码只能由数字和字母下划线组成长度为5-12")
        return;
    }
    var data={userName:userName,password:password,sex:sex,city:city};
    $.ajax({
        url: "/users/addUser",
        data: data,
        type: "POST",
        dataType: "json",
        async: true, //设为false就是同步请求
        success: function (res) {
            alert(res);
        },
        error: function (msg) {
            com.showAlert(com.error, msg);
            console.log(msg);
            if (failCallback) {
                failCallback(msg);
            }
        }
    });
}
function checkUser(){
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
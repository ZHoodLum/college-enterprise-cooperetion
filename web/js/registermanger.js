function validates() {
    //管理员账号验证
    var eid = document.getElementById("uid").value;
    var exp = new RegExp(/^\d{0,10}$/);
    if (!exp.test(eid)) {
        alert("请重新输入管理员账号，管理员账号不符合要求！");
        document.getElementById("uid").focus();//光标定位
        return false;//防止向下进行
    }
    //对管理员名称的校验
    var ename = document.getElementById("uname").value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([0-9a-zA-Z\s.]|[\u4e00-\u9fa5\s.]){5,50}$/);
    if (!exp.test(ename)) {
        alert("请重新输入管理员名称，管理员名称不符合要求！");
        document.getElementById("uname").focus();//光标定位
        return false;//防止向下进行

    }
    //密码验证
    //登录密码验证（5位以上位数字）
    var epwd=document.getElementById("upwd").value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([0-9a-zA-Z\s.]){6,20}$/);
    //var exp=new RegExp(/^([123])$/);
    if(!exp.test(epwd)){
        alert("请重新输入密码，密码不符合要求");
        document.getElementById("upwd")//光标定位
        return false;
    }

    //重复密码验证
    var repwd=document.getElementById("repwd").value;
    if(repwd!=epwd){
        alert("重复密码与第一次输入密码不相同");
        document.getElementById("repwd").focus()//光标定位
        return false;
    }
}
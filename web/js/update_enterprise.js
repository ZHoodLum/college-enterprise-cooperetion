function validate() {
    //教师账号验证
    var tid = document.getElementById("tid").value;
    var exp = new RegExp(/^\d{0,10}$/);
    if (!exp.test(tid)) {
        alert("请重新输入教师账号，教师账号不符合要求！");
        document.getElementById("tid").focus();//光标定位
        return false;//防止向下进行
    }
    //教师名称的校验
    var tname = document.getElementById("tname").value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z\s.]|[\u4e00-\u9fa5\s.]){2,50}$/);
    if (!exp.test(tname)) {
        alert("请重新输入教师名称，教师名称不符合要求！");
        document.getElementById("tname").focus();//光标定位
        return false;//防止向下进行
    }
    //密码验证
    //登录密码验证（5位以上位数字）
    var tpwd=document.getElementById("tpwd").value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([0-9a-zA-Z\s.]){6,20}$/);
    //var exp=new RegExp(/^([123])$/);
    if(!exp.test(tpwd)){
        alert("请重新输入密码，密码不符合要求");
        document.getElementById("tpwd").focus(); //光标定位
        return false;
    }

    //重复密码验证
    var repwd=document.getElementById("repwd").value;
    if(repwd!=spwd){
        alert("重复密码与第一次输入密码不相同");
        document.getElementById("repwd").focus(); //光标定位
        return false;
    }
    //职称
    var smajor = document.getElementById("smajor").value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z]|[\u4e00-\u9fa5]){2,30}$/);
    if (!exp.test(smajor)) {
        alert("请重新输入职称，输入字符不符合要求！");
        document.getElementById("smajor").focus();//光标定位
        return false;//防止向下进行

    }
    //电话
    var tphone = document.getElementById("tphone").value;
    var exp = new RegExp(/^0?(13[0-9]|15[012356789]|18[012346789]|14[57]|17[678]|170[059]|14[57]|166|19[89])[0-9]{8}$/);
    if (!exp.test(tphone)) {
        alert("请重新输入手机号，手机号不符合要求！");
        document.getElementById("tphone").focus();//光标定位
        return false;//防止向下进行

    }
    //邮箱
    var email = document.getElementById("email").value;
    var exp = new RegExp(/^[1-9a-zA-Z](\w)*@[1-9a-zA-Z]+\.[a-zA-Z]+$/);
    if (!exp.test(email)) {
        alert("请重新输入邮箱，邮箱不符合要求！");
        document.getElementById("email").focus();//光标定位
        return false;//防止向下进行

    }
    //所在学院
    var tcollege = document.getElementById("tcollege").value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z]|[\u4e00-\u9fa5]){2,30}$/);
    if (!exp.test(tcollege)) {
        alert("请重新输入所在学院，输入字符无效！");
        document.getElementById("tcollege").focus();//光标定位
        return false;//防止向下进行

    }

}
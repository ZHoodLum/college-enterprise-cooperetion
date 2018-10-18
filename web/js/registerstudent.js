function validate() {
    //学生账号验证
    var sid = document.getElementById("sno").value;
    var exp = new RegExp(/^\d{0,10}$/);
    if (!exp.test(sno)) {
        alert("请重新输入学生账号，学生账号不符合要求！");
        document.getElementById("sno").focus();//光标定位
        return false;//防止向下进行
    }
    //对学生名称的校验
    var sname = document.getElementById("sname").value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z\s.]|[\u4e00-\u9fa5\s.]){2,50}$/);
    if (!exp.test(sname)) {
        alert("请重新输入学生名称，学生名称不符合要求！");
        document.getElementById("sname").focus();//光标定位
        return false;//防止向下进行

    }
    //密码验证
    //登录密码验证（5位以上位数字）
    var spwd=document.getElementById("spwd").value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([0-9a-zA-Z\s.]){6,20}$/);
    //var exp=new RegExp(/^([123])$/);
    if(!exp.test(spwd)){
        alert("请重新输入密码，密码不符合要求");
        document.getElementById("spwd").focus(); //光标定位
        return false;
    }

    //重复密码验证
    var repwd=document.getElementById("repwd").value;
    if(repwd!=spwd){
        alert("重复密码与第一次输入密码不相同");
        document.getElementById("repwd").focus(); //光标定位
        return false;
    }
    //专业
    var smajor = document.getElementById("major").value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z]|[\u4e00-\u9fa5]){2,30}$/);
    if (!exp.test(major)) {
        alert("请重新输入专业名，专业名不符合要求！");
        document.getElementById("major").focus();//光标定位
        return false;//防止向下进行

    }
    //籍贯
	 var scity = document.getElementById("city").value;
     var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z]|[\u4e00-\u9fa5]){6,60}$/);
	 if (!exp.test(city)) {
	 alert("请重新输入籍贯，输入字符无效！");
	 document.getElementById("city").focus();//光标定位
	 return false;//防止向下进行

	 }
    //电话
    var sphone = document.getElementById("sphone").value;
    var exp = new RegExp(/^0?(13[0-9]|15[012356789]|18[012346789]|14[57]|17[678]|170[059]|14[57]|166|19[89])[0-9]{8}$/);
    if (!exp.test(sphone)) {
        alert("请重新输入手机号，手机号不符合要求！");
        document.getElementById("sphone").focus();//光标定位
        return false;//防止向下进行

    }
    //邮箱
    var semail = document.getElementById("semail").value;
    var exp = new RegExp(/^[1-9a-zA-Z](\w)*@[1-9a-zA-Z]+\.[a-zA-Z]+$/);
    if (!exp.test(semail)) {
        alert("请重新输入邮箱，邮箱不符合要求！");
        document.getElementById("semail").focus();//光标定位
        return false;//防止向下进行

    }
    //所在学院
    var scollege = document.getElementById("scollege").value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z]|[\u4e00-\u9fa5]){2,30}$/);
    if (!exp.test(scollege)) {
        alert("请重新输入所在学院，输入字符无效！");
        document.getElementById("scollege").focus();//光标定位
        return false;//防止向下进行

    }
    //在校指导教师
    var tname = document.getElementById("tname").value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z\s.]|[\u4e00-\u9fa5\s.]){2,20}$/);
    if (!exp.test(tname)) {
        alert("请重新输入姓名，姓名不符合要求！");
        document.getElementById("tname").focus();//光标定位
        return false;//防止向下进行

    }
}
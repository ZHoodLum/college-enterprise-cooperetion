function validate() {
    //企业账号验证
    var eid = document.myform.eid.value;
    var exp = new RegExp(/^\d{0,10}$/);
    if (!exp.test(eid)) {
        alert("请重新输入企业账号，企业账号不符合要求！");
        document.myform.eid.focus();//光标定位
        return false;//防止向下进行
    }
    //对企业名称的校验
    var ename = document.myform.ename.value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([0-9a-zA-Z\s.]|[\u4e00-\u9fa5\s.]){5,50}$/);
    if (!exp.test(ename)) {
        alert("请重新输入企业名称，企业名称不符合要求！");
        document.myform.ename.focus();//光标定位
        return false;//防止向下进行

    }
    //密码验证
    //登录密码验证（5位以上位数字）
    var epwd=document.myform.epwd.value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([0-9a-zA-Z\s.]){6,20}$/);
    //var exp=new RegExp(/^([123])$/);
    if(!exp.test(epwd)){
        alert("请重新输入密码，密码不符合要求");
        document.myform.epwd.focus(); //光标定位
        return false;
    }

    //重复密码验证
    var repwd=document.myform.repwd.value;
    if(repwd!=epwd){
        alert("重复密码与第一次输入密码不相同");
        document.myform.repwd.focus(); //光标定位
        return false;
    }
    //地址
	 var eadd = document.myform.eadd.value;
     var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z]|[\u4e00-\u9fa5]){6,60}$/);
	 if (!exp.test(eadd)) {
	 alert("请重新输入地址，地址不一致！");
	 document.myform.eadd.focus();//光标定位
	 return false;//防止向下进行

	 }
    //电话
    var ephone = document.myform.ephone.value;
    var exp = new RegExp(/^0?(13[0-9]|15[012356789]|18[012346789]|14[57]|17[678]|170[059]|14[57]|166|19[89])[0-9]{8}$/);
    if (!exp.test(ephone)) {
        alert("请重新输入手机号，手机不符合要求！");
        document.myform.ephone.focus();//光标定位
        return false;//防止向下进行

    }
    //邮箱
    var email = document.myform.email.value;
    var exp = new RegExp(/^[1-9a-zA-Z](\w)*@[1-9a-zA-Z]+\.[a-zA-Z]+$/);
    if (!exp.test(email)) {
        alert("请重新输入邮箱，邮箱不符合要求！");
        document.myform.email.focus();//光标定位
        return false;//防止向下进行

    }
    //对账号管理者姓名的校验
    var emanger = document.myform.emanger.value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z\s.]|[\u4e00-\u9fa5\s.]){2,20}$/);
    if (!exp.test(emanger)) {
        alert("请重新输入姓名，姓名不符合要求！");
        document.myform.emanger.focus();//光标定位
        return false;//防止向下进行

    }
}
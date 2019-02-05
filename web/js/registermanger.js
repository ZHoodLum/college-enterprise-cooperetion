function validate() {
    //管理员账号验证
    var admin_id = document.getElementById("admin_id").value;
    var exp = new RegExp(/^\d{3,10}$/);
    if (!exp.test(admin_id) && admin_id == "") {
        alert("请重新输入管理员账号，管理员账号不符合要求！");
        document.getElementById("admin_id").focus();//光标定位
        return false;//防止向下进行
    }
    //对管理员名称的校验
    var admin_name = document.getElementById("admin_name").value;
    // var exp = new RegExp(/^(?!_)(?!.*?_$)([0-9a-zA-Z\s.]|[\u4e00-\u9fa5\s.]){2,50}$/);
    var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z\s.]|[\u4e00-\u9fa5\s.]){2,50}$/);
    if (!exp.test(admin_name) && admin_name == "") {
        alert("请重新输入管理员名称，1111管理员名称不符合要求！");
        document.getElementById("admin_name").focus();//光标定位
        return false;//防止向下进行

    }
    //密码验证
    //密码验证 ^\d{2,}$
    var admin_password = document.myform.admin_password.value;
    var exp = new RegExp(/^\d{2,}$/);
    if(!exp.test(admin_password) && admin_password == ""){
        alert("密码不符");
        document.myform.admin_password.focus();//光标定位
        return false;//防止向下进行
    }
    //重复密码
    var admin_repassword = document.myform.admin_repassword.value;
    if(admin_repassword!=admin_password){
        alert("密码不一致不符");
        document.myform.admin_repassword.focus();//光标定位
        return false;//防止向下进行
    }
}
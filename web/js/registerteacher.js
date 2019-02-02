function validate() {
    //教师账号验证
    var teacher_account = document.getElementById("teacher_account").value;
    var exp = new RegExp(/^\d{0,10}$/);
    if (!exp.test(teacher_account)  && teacher_account != null) {
        alert("请重新输入教师账号，教师账号不符合要求！");
        document.getElementById("teacher_account").focus();//光标定位
        return false;//防止向下进行
    }
    //教师名称的校验
    var teacher_name = document.getElementById("teacher_name").value;
    // var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z\s.]|[\u4e00-\u9fa5\s.]){2,50}$/);
    var exp = new RegExp(/^(?!_)(?!.*?_$)([0-9a-zA-Z\s.]|[\u4e00-\u9fa5\s.]){5,50}$/);
    if (!exp.test(teacher_name)  && teacher_name != null) {
        alert("请重新输入教师名称，教师名称不符合要求！");
        document.getElementById("teacher_name").focus();//光标定位
        return false;//防止向下进行
    }
    //电话
    var teacher_tel = document.getElementById("teacher_tel").value;
    var exp = new RegExp(/^0?(13[0-9]|15[012356789]|18[012346789]|14[57]|17[678]|170[059]|14[57]|166|19[89])[0-9]{8}$/);
    if (!exp.test(teacher_tel) && teacher_tel != null) {
        alert("请重新输入手机号，手机号不符合要求！");
        document.getElementById("teacher_tel").focus();//光标定位
        return false;//防止向下进行

    }
    //密码验证 ^\d{2,}$
    var teacher_password = document.myform.teacher_password.value;
    var exp = new RegExp(/^\d{2,}$/);
    if(!exp.test(teacher_password) && teacher_password != null){
        alert("密码不符");
        document.myform.teacher_password.focus();//光标定位
        return false;//防止向下进行
    }
    //重复密码
    var teacher_repassword = document.myform.teacher_repassword.value;
    if(teacher_repassword!=teacher_password){
        alert("密码不一致不符");
        document.myform.teacher_repassword.focus();//光标定位
        return false;//防止向下进行
    }
    //职称
    var teacher_job = document.getElementById("teacher_job").value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z]|[\u4e00-\u9fa5]){2,30}$/);
    if (!exp.test(teacher_job) && teacher_job != null) {
        alert("请重新输入职称，输入字符不符合要求！");
        document.getElementById("teacher_job").focus();//光标定位
        return false;//防止向下进行

    }

    //邮箱
    var email = document.getElementById("email").value;
    var exp = new RegExp(/^[1-9a-zA-Z](\w)*@[1-9a-zA-Z]+\.[a-zA-Z]+$/);
    if (!exp.test(email) && email != null) {
        alert("请重新输入邮箱，邮箱不符合要求！");
        document.getElementById("email").focus();//光标定位
        return false;//防止向下进行

    }
    //所在学院
    var teacher_college = document.getElementById("teacher_college").value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z]|[\u4e00-\u9fa5]){2,30}$/);
    if (!exp.test(teacher_college) && teacher_college != null) {
        alert("请重新输入所在学院，输入字符无效！");
        document.getElementById("teacher_college").focus();//光标定位
        return false;//防止向下进行

    }

}
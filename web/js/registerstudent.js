function validate() {
    //学生账号验证
    var student_account = document.getElementById("student_account").value;
    var exp = new RegExp(/^\d{6,10}$/);
    if (!exp.test(student_account) && student_account != null) {
        alert("请重新输入学生学号，学生账号不符合要求！");
        document.getElementById("student_account").focus();//光标定位
        return false;//防止向下进行
    }
    //对学生名称的校验
    var student_name = document.getElementById("student_name").value;
    // var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z\s.]|[\u4e00-\u9fa5\s.]){2,50}$/);
    var exp = new RegExp(/^(?!_)(?!.*?_$)([0-9a-zA-Z\s.]|[\u4e00-\u9fa5\s.]){5,50}$/);
    if (!exp.test(student_name) && student_name != null) {
        alert("请重新输入学生名称，学生名称不符合要求！");
        document.getElementById("student_name").focus();//光标定位
        return false;//防止向下进行

    }
    //电话
    var student_tel = document.getElementById("student_tel").value;
    var exp = new RegExp(/^0?(13[0-9]|15[012356789]|18[012346789]|14[57]|17[678]|170[059]|14[57]|166|19[89])[0-9]{8}$/);
    if (!exp.test(student_tel)&&student_tel != null) {
        alert("请重新输入手机号，手机号不符合要求！");
        document.getElementById("student_tel").focus();//光标定位
        return false;//防止向下进行

    }
    //密码验证
    //密码验证 ^\d{2,}$
    var student_password = document.myform.student_password.value;
    var exp = new RegExp(/^\d{2,}$/);
    if(!exp.test(student_password) && student_password != null){
        alert("密码不符");
        document.myform.student_password.focus();//光标定位
        return false;//防止向下进行
    }
    //重复密码
    var student_repassword = document.myform.student_repassword.value;
    if(student_repassword!=student_password){
        alert("密码不一致不符");
        document.myform.student_repassword.focus();//光标定位
        return false;//防止向下进行
    }
    //专业
    var major = document.getElementById("major").value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z]|[\u4e00-\u9fa5]){2,30}$/);
    if (!exp.test(major) && major != null) {
        alert("请重新输入专业名，专业名不符合要求！");
        document.getElementById("major").focus();//光标定位
        return false;//防止向下进行

    }
    //籍贯
    var city = document.getElementById("city").value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z]|[\u4e00-\u9fa5]){6,60}$/);
    if (!exp.test(city) && city != null) {
        alert("请重新输入籍贯，输入字符无效！");
        document.getElementById("city").focus();//光标定位
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
    var student_college = document.getElementById("student_college").value;
    var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z]|[\u4e00-\u9fa5]){2,30}$/);
    if (!exp.test(student_college) && student_college != null) {
        alert("请重新输入所在学院，输入字符无效！");
        document.getElementById("student_college").focus();//光标定位
        return false;//防止向下进行

    }
}
    //在校指导教师
    // var teacher_name = document.getElementById("teacher_name").value;
    // var exp = new RegExp(/^(?!_)(?!.*?_$)([a-zA-Z\s.]|[\u4e00-\u9fa5\s.]){2,20}$/);
    // if (!exp.test(teacher_name)) {
    //     alert("请重新输入姓名，姓名不符合要求！");
    //     document.getElementById("teacher_name").focus();//光标定位
    //     return false;//防止向下进行
    //
    // }
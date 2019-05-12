# college-enterprise-cooperetion
使用servlet技术开发的校企实习合作信息平台，介于企业与学校之间，为学生提供招聘信息系服务

### 未经著作权人同意不得进行转载或者作为商业性使用（邮箱：）！！！！

### 系统说明
本系统使用的MVC三层架构模式开发的，支持Maven依赖，使用开发工具：IDEA、MySQL；使用数据库连接池：Druid数据库连接池；JSP界面使用了JSTL标签库。

包名|说明
:--|:--
dao|该层所做事务直接操作数据库，针对数据的增添、删除、修改、查找等。
controller|针对具体问题的操作，也可以说是对数据层的操作，对数据业务逻辑处理；
filter|过滤器
util|工具集
vo|封装实体类
resources|连接数据库文件

表名|说明
:--|:--
userinfo|用户表
admininfo|管理员表
enterpriseinfo|企业表
teacherinfo|教师表
jobinfo|招聘信息表

* 用户表和教师表是根据手机号、密码进行登陆
* 管理员和企业表是根据用户账号、密码进行登陆

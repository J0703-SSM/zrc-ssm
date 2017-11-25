<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--
Created by IntelliJ IDEA.
User: lizhongren1
Date: 2017/5/12
Time: 上午11:46
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css"/>
    <script src="../../js/jquery-3.2.1.js"></script>
</head>
<body class="index">
<div class="login_box">
    <form action="/login" method="post">
        <table>
            <tr>
                <td class="login_info">账号：</td>
                <td colspan="2"><input name="admLoginName" type="text" class="width150"/></td>
                <td class="login_error_info"><span class="required"></span></td>
            </tr>
            <tr>
                <td class="login_info">密码：</td>
                <td colspan="2"><input name="admLoginPwd" type="password" class="width150"/></td>
                <td><span class="required"></span></td>
            </tr>
            <tr>
                <td class="login_info">验证码：</td>
                <td class="width70"><input name="" type="text" class="width70"/></td>
                <td><img src="../../images/valicode.jpg" alt="验证码" title="点击更换"/></td>
                <td><span class="required"></span></td>
            </tr>
            <tr>
                <td></td>
                <td class="login_button" colspan="2">
                    <img src="../../images/login_btn.png" onclick="submit()">
                </td>
                <td><span class="required">${logmsg}</span></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

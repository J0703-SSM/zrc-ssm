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
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>云科技</title>
        <link type="text/css" rel="stylesheet" media="all" href="../../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../../styles/global_color.css" />
        <script src="../../../js/jquery-3.2.1.js"></script>
        <script language="javascript" type="text/javascript">
            //保存成功的提示消息
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
            }
            $(document).ready(function () {
                $(".error_msg").innerHTML = "";
                $(".error_msg:empty").hide();
                $.ajax({
                    url:"/admin/findAllRol",
                    type: "get",
                    async: false,
                    dataType: "json",
                    success:function (posts) {
                        for (var i = 0; i < posts.length; i++) {
                            $("#rolBox").append(" <li><input id='"+posts[i].rolId+"' class='rolId' name='rolId' value='"+posts[i].rolId+"' type='checkbox'/>"+posts[i].rolName+"</li>");
                        }
                    }
                });
            })
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../../../images/logo.png" alt="logo" class="left"/>
            <a href="#">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <ul id="menu">
                <li><a href="/index" class="index_on"></a></li>
                <li><a href="/role/role_list" class="role_off"></a></li>
                <li><a href="/admin/admin_list" class="admin_off"></a></li>
                <li><a href="/fee/fee_list" class="fee_off"></a></li>
                <li><a href="/account/account_list" class="account_off"></a></li>
                <li><a href="/service/service_list" class="service_off"></a></li>
                <li><a href="/bill/bill_list" class="bill_off"></a></li>
                <li><a href="/report/report_list" class="report_off"></a></li>
                <li><a href="/user/user_info" class="information_off"></a></li>
                <li><a href="/user/user_modi_pwd" class="password_off"></a></li>
            </ul>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_success">保存成功！</div>
            <form action="/admin/add" method="/post" class="main_form">
                    <div class="text_info clearfix"><span>姓名：</span></div>
                    <div class="input_info">
                        <input type="text" name="admName"/>
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">${naError.defaultMessage}</div>
                    </div>
                    <div class="text_info clearfix"><span>管理员账号：</span></div>
                    <div class="input_info">
                        <input type="text" name="admLoginName"/>
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">${lnError.defaultMessage}</div>
                    </div>
                    <div class="text_info clearfix"><span>密码：</span></div>
                    <div class="input_info">
                        <input type="password" name="admLoginPwd"/>
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">${lpError.defaultMessage}</div>
                    </div>
                    <div class="text_info clearfix"><span>重复密码：</span></div>
                    <div class="input_info">
                        <input type="password" name="admLoginPwd2"  />
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">${lp2Error}</div>
                    </div>      
                    <div class="text_info clearfix"><span>电话：</span></div>
                    <div class="input_info">
                        <input type="text" name="admPhone" class="width200"/>
                        <span class="required">*</span>
                        <div class="validate_msg_medium error_msg">${phError.defaultMessage}</div>
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input type="text" name="admEmail" class="width200"/>
                        <span class="required">*</span>
                        <div class="validate_msg_medium error_msg">${emError.defaultMessage}</div>
                    </div>
                    <div class="text_info clearfix"><span>角色：</span></div>
                    <div class="input_info_high">
                        <div class="input_info_scroll">
                            <ul id="rolBox">
                            </ul>
                        </div>
                        <span class="required">*</span>
                        <div class="validate_msg_tiny error_msg">${rolError}</div>
                    </div>
                    <div class="button_info clearfix">
                        <input type="submit" value="保存" class="btn_save" onclick="showResult();" />
                        <input type="button" value="取消" class="btn_save" />
                    </div>
                </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
            <br />
            <span>版权所有(C)云科技有限公司 </span>
        </div>
    </body>
</html>

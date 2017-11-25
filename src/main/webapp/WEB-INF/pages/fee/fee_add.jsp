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
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="../../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../../styles/global_color.css" />
        <script src="../../../js/jquery-3.2.1.js"></script>
        <script language="javascript" type="text/javascript">
            //保存结果的提示
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
            //切换资费类型
            function feeTypeChange(type) {
                var inputArray = document.getElementById("main").getElementsByTagName("input");
                var form = document.getElementById("form");
                if (type == 1) {
                    form.action = "/fee/add1";
                    inputArray[4].readOnly = true;
                    inputArray[4].value = "";
                    inputArray[4].className += " readonly";
                    inputArray[4].name = "";
                    inputArray[5].readOnly = false;
                    inputArray[5].className = "width100";
                    inputArray[5].name = "basicCost";
                    inputArray[6].readOnly = true;
                    inputArray[6].className += " readonly";
                    inputArray[6].value = "";
                    inputArray[6].name = "";
                }
                else if (type == 2) {
                    form.action = "/fee/add";
                    inputArray[4].readOnly = false;
                    inputArray[4].className = "width100";
                    inputArray[4].name = "basicTime";
                    inputArray[5].readOnly = false;
                    inputArray[5].className = "width100";
                    inputArray[5].name = "basicCost";
                    inputArray[6].readOnly = false;
                    inputArray[6].className = "width100";
                    inputArray[6].name = "unitCost";
                }
                else if (type == 3) {
                    form.action = "/fee/add3";
                    inputArray[4].readOnly = true;
                    inputArray[4].value = "";
                    inputArray[4].name = "";
                    inputArray[4].className += " readonly";
                    inputArray[5].readOnly = true;
                    inputArray[5].value = "";
                    inputArray[5].name = "";
                    inputArray[5].className += " readonly";
                    inputArray[6].readOnly = false;
                    inputArray[6].className = "width100";
                    inputArray[6].name = "unitCost";
                }
            }
            $(document).ready(function () {
                $(".error_msg").innerHTML = "";
                $(".error_msg:empty").hide();
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
                <li><a href="/role_list" class="role_off"></a></li>
                <li><a href="/admin_list" class="admin_off"></a></li>
                <li><a href="/fee_list" class="fee_off"></a></li>
                <li><a href="/account_list" class="account_off"></a></li>
                <li><a href="/service_list" class="service_off"></a></li>
                <li><a href="/bill_list" class="bill_off"></a></li>
                <li><a href="/report_list" class="report_off"></a></li>
                <li><a href="/user_info" class="information_off"></a></li>
                <li><a href="/user_modi_pwd" class="password_off"></a></li>
            </ul>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_fail">添加成功！</div>
            <form action="/fee/add" method="post" class="main_form" id="form">
                <div class="text_info clearfix"><span>资费名称：</span></div>
                <div class="input_info">
                    <input type="text" class="width300" name="feeName" value=""/>
                    <span class="required">*</span>
                    <div class="validate_msg_short error_msg">${feeNameError.defaultMessage}</div>
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info fee_type">
                    <input type="radio" name="feeKind" value="1" id="monthly" onclick="feeTypeChange(1);" />
                    <label for="monthly">包月</label>
                    <input type="radio" name="feeKind" value="2" checked="checked" id="package" onclick="feeTypeChange(2);" />
                    <label for="package">套餐</label>
                    <input type="radio" name="feeKind" value="3" id="timeBased" onclick="feeTypeChange(3);" />
                    <label for="timeBased">计时</label>
                </div>
                <div class="text_info clearfix"><span>基本时长：</span></div>
                <div class="input_info">
                    <input type="text" value="" name="basicTime" class="width100" />
                    <span class="info">小时</span>
                    <span class="required">*</span>
                    <div class="validate_msg_long error_msg">${basicTimeError.defaultMessage}</div>
                </div>
                <div class="text_info clearfix"><span>基本费用：</span></div>
                <div class="input_info">
                    <input type="text" value="" name="basicCost" class="width100" />
                    <span class="info">元</span>
                    <span class="required">*</span>
                    <div class="validate_msg_long error_msg">${basicCostError.defaultMessage}</div>
                </div>
                <div class="text_info clearfix"><span>单位费用：</span></div>
                <div class="input_info">
                    <input type="text" value="" name="unitCost" class="width100" />
                    <span class="info">元/小时</span>
                    <span class="required">*</span>
                    <div class="validate_msg_long error_msg">${unitCostError.defaultMessage}</div>
                </div>
                <div class="text_info clearfix"><span>资费说明：</span></div>
                <div class="input_info_high">
                    <textarea class="width300 height70" name="content"></textarea>
                    <div class="validate_msg_short error_msg"></div>
                </div>                    
                <div class="button_info clearfix">
                    <input type="submit" value="保存" class="btn_save"  onclick="showResult();" />
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

<%--
Created by IntelliJ IDEA.
User: lizhongren1
Date: 2017/5/12
Time: 上午11:46
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>云科技</title>
        <link type="text/css" rel="stylesheet" media="all" href="../../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../../styles/global_color.css" />
        <script src="../../../js/jquery-3.2.1.js"></script>
        <script src="../../../js/collationJs.js"></script>
        <script language="javascript" type="text/javascript">
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag){
                    divResult.style.display = "block";
                }
                else{
                    divResult.style.display = "none";
                }
            }
            //显示选填的信息项
            function showOptionalInfo(imgObj) {
                var div = document.getElementById("optionalInfo");
                if (div.className == "hide") {
                    div.className = "show";
                    imgObj.src = "../../../images/hide.png";
                }
                else {
                    div.className = "hide";
                    imgObj.src = "../../../images/show.png";
                }
            }
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
            <!--保存成功或者失败的提示消息-->
            <div id="save_result_info" class="save_fail">添加成功!</div>
            <form action="/account/add" method="post" class="main_form" id="addForm">
                <!--必填项-->
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info">
                    <input type="text" id="accName" name="accName"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="validate_accName"></div>
                </div>
                <div class="text_info clearfix"><span>身份证：</span></div>
                <div class="input_info">
                    <input type="text" id="idCard" name="accIdCard"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="validate_idCard"></div>
                </div>
                <div class="text_info clearfix"><span>登录账号：</span></div>
                <div class="input_info">
                    <input type="text" id="accLoginName" name="accLoginName" />
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="validate_accLoginName"></div>
                </div>
                <div class="text_info clearfix"><span>密码：</span></div>
                <div class="input_info">
                    <input type="password" id="accLoginPwd" name="accLoginPwd" />
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="validate_accLoginPwd"></div>
                </div>
                <div class="text_info clearfix"><span>重复密码：</span></div>
                <div class="input_info">
                    <input type="password" id="accLoginPwd2" name="accLoginPwd2" />
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="validate_accLoginPwd2"></div>
                </div>
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input  type="text" class="width200" id="accPhone" name="accPhone"/>
                    <span class="required">*</span>
                    <div class="validate_msg_medium" id="validate_accPhone"></div>
                </div>
                <!--可选项-->
                <div class="text_info clearfix"><span>可选项：</span></div>
                <div class="input_info">
                    <img src="../../../images/show.png" alt="展开" onclick="showOptionalInfo(this);" />
                </div>
                <div id="optionalInfo" class="hide">
                    <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
                    <div class="input_info">
                        <input type="text" id="accInviteIdCard" name="accInviteIdCard"/>
                        <div class="validate_msg_long" id="validate_accInviteIdCard"></div>
                    </div>
                    <div class="text_info clearfix"><span>生日：</span></div>
                    <div class="input_info">
                        <input type="date" id="birthday" readonly class="readonly"/>
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input type="text" class="width350" id="email" name="email" value="123"/>
                        <div class="validate_msg_tiny" id="validate_email"></div>
                    </div>
                    <div class="text_info clearfix"><span>职业：</span></div>
                    <div class="input_info">
                        <select >
                            <option selected="selected">干部</option>
                            <option>学生</option>
                            <option>技术人员</option>
                            <option>其他</option>
                        </select>
                    </div>
                    <div class="text_info clearfix"><span>性别：</span></div>
                    <div class="input_info fee_type">
                        <input type="radio"  checked="checked" id="female" />
                        <label for="female">女</label>
                        <input type="radio"  id="male" />
                        <label for="male">男</label>
                    </div>
                    <div class="text_info clearfix"><span>通信地址：</span></div>
                    <div class="input_info">
                        <input type="text" class="width350" id="address" name="address"/>
                        <div class="validate_msg_tiny" id="validate_address"></div>
                    </div>
                    <div class="text_info clearfix"><span>邮编：</span></div>
                    <div class="input_info">
                        <input type="text" id="zipCode" name="zipCode"/>
                        <div class="validate_msg_long" id="validate_zipCode"></div>
                    </div>
                    <div class="text_info clearfix"><span>QQ：</span></div>
                    <div class="input_info">
                        <input type="text" id="tNumber" name="tNumber"/>
                        <div class="validate_msg_long" id="validate_tNumber"></div>
                    </div>
                </div>
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="button" value="保存" id="sub" class="btn_save"/>
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

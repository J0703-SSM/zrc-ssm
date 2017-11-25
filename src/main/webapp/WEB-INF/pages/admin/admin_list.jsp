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
    <link type="text/css" rel="stylesheet" media="all" href="../../../styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="../../../styles/global_color.css"/>
    <script src="../../../js/jquery-3.2.1.js"></script>
    <script language="javascript" type="text/javascript">
        //显示角色详细信息
        function showDetail(flag, a) {
            var detailDiv = a.parentNode.getElementsByTagName("div")[0];
            if (flag) {
                detailDiv.style.display = "block";
            }
            else
                detailDiv.style.display = "none";
        }
        //重置密码
        function resetPwd() {
            alert("请至少选择一条数据！");
            //document.getElementById("operate_result_info").style.display = "block";
        }
        //删除
        function deleteAdmin(admId) {
            var r = window.confirm("确定要删除此管理员吗？");
            // 当点击取消时直接返回不执行语句
            if (!r){
                return;
            }
            $.ajax({
                url:"/admin/admin_delete",
                type:"get",
                async: false,
                data:{admId : admId},
                dataType: "json",
                success:function (posts) {
                    var _html = $("#operate_result_info").html();
                    _html += posts["msg"];
                    $("#operate_result_info").html(_html);
                }
            });
            document.getElementById("operate_result_info").style.display = "block";
            // 删除之后定时一秒刷新界面
            setTimeout(function(){window.location.reload();},1000);
        }
        //全选
        function selectAdmins(inputObj) {
            var inputArray = document.getElementById("datalist").getElementsByTagName("input");
            for (var i = 1; i < inputArray.length; i++) {
                if (inputArray[i].type == "checkbox") {
                    inputArray[i].checked = inputObj.checked;
                }
            }
        }
        $(document).ready(function () {
            var $checkbox = $(".checkbox");
            var $all = $("#all");
            $all.click(function () {
                if ($("#all").is(":checked")){
                    for (var i = 0; i < $checkbox.length;i++){
                        $checkbox[i].checked = true;
                    }
                }else {
                    for (var i = 0; i < $checkbox.length;i++){
                        $checkbox[i].checked = false;
                    }
                }

            });
            $checkbox.click(function () {
                for (var i = 0; i < $checkbox.length;i++){
                    if ($checkbox[i].checked){
                        continue;
                    }
                    $all.prop("checked",false);
                    return;
                }
                $all.prop("checked", true);
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
    <form action="" method="">
        <!--查询-->
        <div class="search_add">
            <div>
                模块：
                <select id="selModules" class="select_search">
                    <option value="-1">请选择模块</option>
                   <c:forEach items="${pers}" var="per">
                       <option name="perId" value="${per.perId}">${per.perName}</option>
                   </c:forEach>
                </select>
            </div>
            <div>角色：<input type="text" value="" class="text_search width200"/></div>
            <div><input type="button" value="搜索" class="btn_search"/></div>
            <input type="button" value="密码重置" class="btn_add" onclick="resetPwd();"/>
            <input type="button" value="增加" class="btn_add" onclick="location.href='/admin/admin_add';"/>
        </div>
        <!--删除和密码重置的操作提示-->
        <div id="operate_result_info" class="operate_fail">
            <img src="../../../images/close.png" onclick="this.parentNode.style.display='none';"/>
            <span>删除失败！数据并发错误。</span><!--密码重置失败！数据并发错误。-->
        </div>
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th class="th_select_all">
                        <input type="checkbox" id="all"/>
                        <span>全选</span>
                    </th>
                    <th>管理员ID</th>
                    <th>姓名</th>
                    <th>登录名</th>
                    <th>电话</th>
                    <th>电子邮件</th>
                    <th>授权日期</th>
                    <th class="width100">拥有角色</th>
                    <th></th>
                </tr>
                <c:forEach items="${admins}" var="admin">
                    <tr>
                        <td><input type="checkbox" class="checkbox"/></td>
                        <td>${admin.admId}</td>
                        <td>${admin.admName}</td>
                        <td>${admin.admLoginName}</td>
                        <td>${admin.admPhone}</td>
                        <td>${admin.admEmail}</td>
                        <td><fmt:formatDate value="${admin.authorizationTime}" pattern="yyyy-MM-dd"/></td>
                        <td>
                            <c:choose>
                                <c:when test="${admin.rolList.size() > 1}">
                                    <a class="summary" onmouseover="showDetail(true,this);"
                                       onmouseout="showDetail(false,this);">${admin.rolList.get(0).rolName}...</a>
                                    <!--浮动的详细信息-->
                                    <div class="detail_info">
                                        <c:forEach items="${admin.rolList}" var="role">
                                            ${role.rolName},
                                        </c:forEach>
                                    </div>
                                </c:when>
                                <c:when test="${admin.rolList.size() == 1}">
                                    ${admin.rolList.get(0).rolName}
                                </c:when>
                                <c:otherwise>
                                    尚未授予权限
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td class="td_modi">
                            <input type="button" value="修改" class="btn_modify"
                                   onclick="location.href='/admin/admin_modi?admId=${admin.admId}';"/>
                            <input type="button" value="删除" class="btn_delete" onclick="deleteAdmin('${admin.admId}');"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <!--分页-->
        <div id="pages">
            第${pg.pageCode}页/共${pg.totalPage}页
            <a href="<c:url value="/admin_list?method=${pg.url}&pageCode=1"/>">首页</a>
            <c:choose>
                <c:when test="${pg.pageCode > 1}">
                    <a href="<c:url value="/admin_list?pageCode=${pg.pageCode - 1}"/>">上一页</a>
                </c:when>
                <c:otherwise>
                    上一页
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${pg.totalPage < 9}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="${pg.totalPage}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${pg.pageCode - 4}"/>
                    <c:set var="end" value="${pg.pageCode + 4}"/>
                    <%-- 头溢出 --%>
                    <c:if test="${begin < 1}">
                        <c:set var="begin" value="1"/>
                        <c:set var="end" value="9"/>
                    </c:if>
                    <%-- 尾溢出 --%>
                    <c:if test="${end > pg.totalPage}">
                        <c:set var="begin" value="${pg.totalPage-8}"/>
                        <c:set var="end" value="${pg.totalPage}"/>
                    </c:if>
                </c:otherwise>
            </c:choose>
            <c:forEach begin="${begin}" end="${end}" var="i">
                <c:choose>
                    <c:when test="${pg.pageCode eq i}">
                        [${i}]
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value="/admin_list?pageCode=${i}"/>">${i}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:choose>
                <c:when test="${pg.pageCode < pg.totalPage}">
                    <a href="<c:url value="/admin_list?pageCode=${pg.pageCode + 1}"/>">下一页</a>
                </c:when>
                <c:otherwise>
                    下一页
                </c:otherwise>
            </c:choose>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
    <span>版权所有(C)云科技有限公司 </span>
</div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        function deleteRole(rolId) {
            var r = window.confirm("确定要删除此角色吗？");
            // 当点击取消时直接返回不执行语句
            if (!r){
                return;
            }
            $.ajax({
                url:"/role/role_delete",
                type:"get",
                async: false,
                data:{rolId : rolId},
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
            <input type="button" value="增加" class="btn_add" onclick="location.href='/role/role_add';"/>
        </div>
        <!--删除的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="../../../images/close.png" onclick="this.parentNode.style.display='none';"/>
        </div> <!--删除错误！该角色被使用，不能删除。-->
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th>角色 ID</th>
                    <th>角色名称</th>
                    <th class="width600">拥有的权限</th>
                    <th class="td_modi"></th>
                </tr>
                <c:forEach items="${roles}" var="role">
                    <tr>
                        <td>${role.rolId}</td>
                        <td>${role.rolName}</td>
                        <td>
                            <c:forEach items="${role.perList}" var="per">
                                ${per.perName},
                            </c:forEach>
                        </td>
                        <td>
                            <input type="button"
                                   value="修改"
                                   class="btn_modify"
                                   onclick="location.href='/role/role_modi?rolId=${role.rolId}';"/>
                            <input type="button" value="删除" class="btn_delete" onclick="deleteRole('${role.rolId}')"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <!--分页-->
        <div id="pages">
            第${pg.pageCode}页/共${pg.totalPage}页
            <a href="<c:url value="/role_list?method=${pg.url}&pageCode=1"/>">首页</a>
            <c:choose>
                <c:when test="${pg.pageCode > 1}">
                    <a href="<c:url value="/role_list?pageCode=${pg.pageCode - 1}"/>">上一页</a>
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
                        <a href="<c:url value="/role_list?pageCode=${i}"/>">${i}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:choose>
                <c:when test="${pg.pageCode < pg.totalPage}">
                    <a href="<c:url value="/role_list?pageCode=${pg.pageCode + 1}"/>">下一页</a>
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
    <p>版权所有(C)云科技有限公司 </p>
</div>
</body>
</html>

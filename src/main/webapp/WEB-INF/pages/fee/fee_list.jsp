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
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="../../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../../styles/global_color.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../../demo/w2ui-1.5.rc1.min.css" />
        <script type="text/javascript" src="../../../demo/w2ui-1.5.rc1.min.js"></script>
        <script src="../../../js/jquery-3.2.1.js"></script>
        <script language="javascript" type="text/javascript">
            //排序按钮的点击事件

            $(document).ready(function () {
//                function addInfoInTable(data) {
//                    var table = $("#datalist");
//                    table  += "<tr class='info'>"
//                            +"<td>"+data.feeId+"</td>"
//                            +"<td><a href='fee_detail.jsp'>"+data.feeName+"</td>"
//                            +"</tr>";
//                }
                $(".sort_asc").click(function () {
                    if (this.className  == "sort_desc"){
                        this.className  = "sort_asc";
                        $("#sortT").val("ascT");
                        $("#sortC").val("ascC");
//                        var arr =   $(".info");
//                        arr.sort(function(a,b){
//                            return a.htmlText>b.htmlText?1:-1;
//                        });//对li进行排序，这里按照从小到大排序
                        $("#info").empty().append(arr);//清空原来内容添加排序后内容。
//                        $.ajax({
//                            url:"/fee/order",
//                            type:"get",
//                            async: false,
//                            dataType: "json",
//                            success:function (posts) {
//                                $(".info").empty();
//                            }
//                        })
                    }
                    else {
                        this.className = "sort_desc";
                        $("#sortT").val("descT");
                        $("#sortC").val("descC");
                    }
                });
            });
            //启用
            function startFee(feeId) {
                var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
                $.ajax({
                    url:"/fee/fee_open",
                    type:"get",
                    async: false,
                    data:{feeId : feeId},
                    dataType: "json",
                    success:function (posts) {
                        var _html = $("#operate_result_info").html();
                        _html += posts["msg"];
                        $("#operate_result_info").html(_html);
                    }
                });
                document.getElementById("operate_result_info").style.display = "block";
            }
            //删除
            function deleteFee(feeId) {
                var r = window.confirm("确定要删除此资费吗？");
                $.ajax({
                    url:"/fee/fee_delete",
                    type:"get",
                    async: false,
                    data:{feeId : feeId},
                    dataType: "json",
                    success:function (posts) {
                        var _html = $("#operate_result_info").html();
                        _html += posts["msg"];
                        $("#operate_result_info").html(_html);
                    }
                });
                $("#"+feeId).style.display = "none";
                document.getElementById("operate_result_info").style.display = "block";
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
            <form action="/fee/fee_list" method="post">
                <!--排序-->
                <div class="search_add">
                    <div>
                        <!--<input type="button" value="月租" class="sort_asc" onclick="sort(this);" />-->
                        <input type="button" name="column" value="基费" class="sort_asc"/>
                        <input type="button" name="column" value="时长" class="sort_asc"/>
                        <%--<c:if test="${sorts == null}">--%>
                            <%--<input type="hidden" name="sort" value="ascC" id="sortC"/>--%>
                            <%--<input type="hidden" name="sort" value="ascT" id="sortT"/>--%>
                        <%--</c:if>--%>
                        <%--<input type="hidden" name="sort" value="${sorts[0]}" id="sortC"/>--%>
                        <%--<input type="hidden" name="sort" value="${sorts[1]}" id="sortT"/>--%>
                    </div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='/fee/fee_add';" />
                </div>
                <!--启用操作的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../../../images/close.png" onclick="this.parentNode.style.display='none';" />
                </div>
                <!--数据区域：用表格展示数据-->
                <div id="data">
                    <table id="datalist">
                        <tr>
                            <th>资费ID</th>
                            <th class="width100">资费名称</th>
                            <th>基本时长</th>
                            <th>基本费用</th>
                            <th>单位费用</th>
                            <th>创建时间</th>
                            <th>开通时间</th>
                            <th class="width50">状态</th>
                            <th class="width200"></th>
                        </tr>
                        <div id="info">
                        <c:forEach items="${fees}" var="fee">
                            <tr id="${fee.feeId}">
                                <td>${fee.feeId}</td>
                                <td><a href="fee_detail.jsp">${fee.feeName}</a></td>
                                <td id="basicTime">
                                    <c:if test="${fee.basicTime != null}">
                                        ${fee.basicTime} 小时
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${fee.basicCost != null}">
                                        ${fee.basicCost} 元
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${fee.unitCost != null}">
                                        ${fee.unitCost} 元/小时
                                    </c:if>
                                </td>
                                <td><fmt:formatDate value="${fee.newTime}" pattern="yyyy-MM-dd"/></td>
                                <td><fmt:formatDate value="${fee.openTime}" pattern="yyyy-MM-dd"/></td>
                                <c:choose>
                                    <c:when test="${fee.state == 0}">
                                        <td>暂未启用</td>
                                        <td>
                                            <input type="button" value="启用" class="btn_start" onclick="startFee(${fee.feeId});" />
                                            <input type="button" value="修改" class="btn_modify" onclick="location.href='fee_modi.jsp';" />
                                            <input type="button" value="删除" class="btn_delete" onclick="deleteFee(${fee.feeId});" />
                                        </td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>已启用</td>
                                    </c:otherwise>
                                </c:choose>

                            </tr>
                        </c:forEach>
                        </div >
                    </table>
                    <p>业务说明：<br />
                    1、创建资费时，状态为暂停，记载创建时间；<br />
                    2、暂停状态下，可修改，可删除；<br />
                    3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
                    4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
                    </p>
                </div>
                <!--分页-->
                <div id="pages">
                    第${pg.pageCode}页/共${pg.totalPage}页
                    <a href="<c:url value="/fee/fee_list?method=${pg.url}&pageCode=1"/>">首页</a>
                    <c:choose>
                        <c:when test="${pg.pageCode > 1}">
                            <a href="<c:url value="/fee/fee_list?pageCode=${pg.pageCode - 1}"/>">上一页</a>
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
                                <a href="<c:url value="/fee/fee_list?pageCode=${i}"/>">${i}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${pg.pageCode < pg.totalPage}">
                            <a href="<c:url value="/fee/fee_list?pageCode=${pg.pageCode + 1}"/>">下一页</a>
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
            <p>版权所有(C)云科技有限公司</p>
        </div>
    </body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加房间</title>
    <%
        String basePath =
                // 协议
                request.getScheme() + "://" +
                        request.getServerName() + ":" +
                        request.getServerPort() +
                        //当前项目
                        request.getContextPath() + "/";
    %>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="jquery.js"></script>
    <script type="text/javascript">

        function checkForm() {
            var $price = $("#price").val();
            // 判空
            if ($price == null  || $price.eq("")){
                $("#tip_price").html("必填");
                return false;
            }
            for (var i=0;i<price.length;i++){
                var $ch = price.charAt(i);
                if ($ch < '0' || $ch > '9'){
                    $("#tip_price").html("数字格式");
                    return false;
                }
            }
            return true;
        }
    </script>
</head>
<body>

<div style="width: 100%;border: 1px red solid;text-align: center">
    <h3>酒店管理系统</h3>
</div>

<div style="text-align: right;width: 100%;border: 1px red solid">
    <span>当前位置：首页 > 添加客房</span>
</div>
<hr>

<div style="text-align: right;width: 100%;border: 1px red solid">
    <a href="return false" onclick="window.history.back(-1)">返回</a>
</div>

<div style="text-align: center;width: 100%;border: 1px red solid">
    <form action="room/doAdd" method="post" onsubmit="return checkForm()">
        <table border="1" style="display: block;margin: 0px auto;width: 500px">
            <tr>
                <td>房型</td>
                <td>
                    <input type="radio" name="type" value="1">标准间 &nbsp;&nbsp;
                    <input type="radio" name="type" value="2">豪华间 &nbsp;&nbsp;
                    <input type="radio" name="type" value="3">总统套间
                </td>
                <td></td>
            </tr>
            <tr>
                <td>价格</td>
                <td>
                    <input type="text" name="price" id="price">
                </td>
                <td>
                    <span id="tip_price" style="color: red;"></span>
                </td>
            </tr>
            <tr>
                <td>所属酒店</td>
                <td>
                    <select name="hid">
                        <option value="-1">-----</option>
                        <c:forEach items="${hotels}" var="h">
                            <option value="${h.hid}">${h.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td></td>
            </tr>
            <tr>
                <td>描述</td>
                <td>
                    <textarea rows="10" cols="20" name="info"></textarea>
                </td>
                <td></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="提交">&nbsp;&nbsp;
                    <input type="reset" value="重置">
                </td>
                <td></td>
            </tr>
        </table>
    </form>

</div>
<div style="text-align: center">
    <span>版权所有&copy;2017-2020</span>
</div>
</body>
</html>

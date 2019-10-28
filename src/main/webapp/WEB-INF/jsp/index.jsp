<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
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
</head>
<body>

<div style="width: 100%;border: 1px red solid;text-align: center">
    <h3>酒店管理系统</h3>
</div>

<hr>
<div style="text-align: right;width: 100%;border: 1px red solid">
    <form action="" method="post">
        名称：<input type="text" id="in_hotel_name">
        <input type="button" id="btn_find_hotel" value="查询">
    </form>
    <script type="text/javascript">
        $(function () {
            $("#btn_find_hotel").click(function () {

                var $hotel_name = $("#in_hotel_name").val();
                $.post("room/find/"+$hotel_name,function (data) {
                    var $content = $("#body_content");
                    var list =data.data;
                    var str = "";
                    for (var i=0;i<list.length;i++){
                        str+="<tr id='room_'>"+list[i].id;
                        str+="<td>"+list[i].hotel.name+"</td>";
                        str+="<td>"+list[i].type+"</td>";
                        str+="<td>"+list[i].price+"</td>";
                        str+="<td>"+list[i].hotel.address+"</td>";
                        str+="<td>"+list[i].hotel.mobile+"</td>";
                        str+="<td>"+"<a href='return false' onclick='delById('"+list[i].id+")></a></td>"
                        str+="</tr>"
                    }
                    $content.html(str);
                });
            })
        })
    </script>
</div>
<hr>

<div style="text-align: right;width: 100%;border: 1px red solid">
    <a href="/room/showAdd">添加</a>
</div>

<div style="width: 100%;border: 1px red solid;text-align: center">
    <table border="1" style="display: block;margin: 0px auto;width: 500px">
        <tr>
            <td>ID</td>
            <td>酒店名称</td>
            <td>房型</td>
            <td>价格</td>
            <td>地址</td>
            <td>电话</td>
            <td>操作</td>
        </tr>
        <tbody id="body_content">
            <c:forEach items="${rooms}" var="r">
                <tr id="room_${r.id}">
                    <td>${r.id}</td>
                    <td>${r.hotel.name}</td>
                    <td>
                        <c:if test="${r.type==1}">总统套房</c:if>
                        <c:if test="${r.type==2}">双人间</c:if>
                        <c:if test="${r.type==3}">单间</c:if>
                    </td>
                    <td>${r.price}</td>
                    <td>${r.hotel.address}</td>
                    <td>${r.hotel.mobile}</td>
                    <script type="text/javascript">
                        // 根据id删除
                        function delById(id) {
                            alert("id:"+id)
                            // 移除一行
                            $("#room_"+id).remove();
                            var url = "room/delete/"+id;
                            $.post(url,function (data) {
                                if (data.status == 200){
                                    alert("删除成功");
                                } else {
                                    alert(data.msg);
                                }
                            });
                        }
                    </script>
                    <td>
                        <a href="javascript:delById(${r.id})" >删除</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>


<div style="text-align: center">
    <span>版权所有&copy;2017-2020</span>
</div>
</body>
</html>

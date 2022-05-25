<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<link href="${pageContext.request.contextPath}/asserts/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/asserts/css/dashboard.css" rel="stylesheet">
<shiro:hasPermission name="emp:add">
    <h2><a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/emp/preAdd">员工添加</a></h2>
</shiro:hasPermission>

<div class="table-responsive">
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th>#</th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>状态</th>
            <th>部门</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${emps}" var="emp" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.gender}</td>
                <td>${emp.status}</td>
                <td>${emp.dept.name}</td>
                <td>
                    <shiro:hasPermission name="emp:update">
                        <a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/emp/${emp.id}">编辑</a>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="emp:del">
                        <button class="btn btn-sm btn-danger" onclick="del(${emp.id})">删除</button>
                    </shiro:hasPermission>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <form action="${pageContext.request.contextPath}/emp" method="post" id="f1">
        <input type="hidden" name="id" id="id">
        <input type="hidden" name="_method" value="delete">

    </form>
</div>

<script type="text/javascript">
    function del(id) {
        if (confirm("是否确定要删除?")) {
            //发送请求
            var empId = document.getElementById("id");
            empId.value = id;

            document.getElementById("f1").submit();

        }

    }

</script>

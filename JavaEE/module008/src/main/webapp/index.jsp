<%@ page import="home.pdm.model.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<div id="top"><span>My Tasks</span></div>
<p class="text_header">My ToDo List</p>
<div class="line"></div>

<form class="form_update" action="update" method="post">
    <table class="table_task">
        <tr class="table_header">
            <td>Name</td>
            <td>Category</td>
            <td>Complete</td>
        </tr>
        <%     List<Task> task = (ArrayList<Task>) session.getAttribute("task"); %>

        <c:if test="<%= task == null %>">
            <tr class="addTask">
                <td class="size_td">The tasks are not present</td>
                <td></td>
                <td><input type="checkbox" name="complete"/></td>
            </tr>
        </c:if>

        <c:forEach items="<%= task %>" var="task">
            <tr class="${task.styleClass}">
                <td class="size_td"><c:out value="${task.name}"/></td>
                <td><c:out value="${task.category}"/></td>

                <c:if test="${task.styleClass == 'addTask'}">
                    <td><input type="checkbox" name="complete" value="${task.id}"/></td>
                </c:if>
                <c:if test="${task.styleClass == 'removeTask'}">
                    <td></td>
                </c:if>
            </tr>
        </c:forEach>

    </table>
    <input class="button" type="submit" value="Update Task"/>
</form>

<div class="line"></div>

<form class="form_update" action="add" method="POST">
    <table class="table">
        <tr>
            <td class="table_name_first_column">Task name:</td>
            <td><input name="name" type="text"/></td>
        </tr>
        <tr>
            <td class="table_name_first_column">Task category:</td>
            <td><input name="category" type="text"/></td>
        </tr>
    </table>
    <input class="button" type="submit" value="Add Task"/>
</form>

</body>
</html>
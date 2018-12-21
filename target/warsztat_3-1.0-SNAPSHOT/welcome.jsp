<%--
  Created by IntelliJ IDEA.
  User: lukaszl
  Date: 21.12.18
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Warsztat 3</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <h3>Ostatnie rozwiązania</h3>
    <table>
        <tr>
            <th>Data dodania</th>
            <th>Rozwiązanie</th>
        </tr>
        <c:forEach items="${solutions}" var="solution">
            <tr>
                <td>${solution.updated}</td>
                <td><c:out value="${solution.description}"></c:out></td>
            </tr>
        </c:forEach>

    </table>

    <%@include file="footer.jsp"%>
</body>
</html>

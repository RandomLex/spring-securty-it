<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="ru">
<head>
    <title>Employees</title>
</head>
<body>
<c:out value="Текущий пользователь: ${requestScope.principal.name}"/>
<table>
    <th>Имя</th>
    <th>Зарплата</th>
    <tr>
        <td><c:out value="${requestScope.employee.name}"/></td>
        <td><c:out value="${empty employee.salary ? 0 : employee.salary}"/></td>
    </tr>
</table>
<footer>
    <p><a href="logout">Logout</a></p>
</footer>
</body>
</html>

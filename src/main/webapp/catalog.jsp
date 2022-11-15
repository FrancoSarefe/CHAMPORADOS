<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" %>

<html>
<head>
<title>Webshoppe::Toy Catalog</title>
<style type="text/css">
body {
    margin: 50px;
}
</style>
</head>
<body>
    <h2>Toy Catalog</h2>
    <hr />
    <c:if test="${empty catalog}">
        <b>Empty Catalog!</b>
    </c:if>
    <c:if test="${not empty catalog}">
        <table>
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Description</td>
                    <td>Price</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${catalog}" var="toy">
                    <form action="${pageContext.request.contextPath}/cart" method="POST">
                        <tr>
                            <td><c:out value="${toy.id}"/></td>
                            <td><c:out value="${toy.name}"/></td>
                            <td><c:out value="${toy.description}"/></td>
                            <td><c:out value="${toy.price}"/></td>
                            <td>
                             <input type="hidden" name="id" value="${toy.id}">
                             <input type="hidden" name="name" value="${toy.name}"> 
                             <input type="hidden" name="description" value="${toy.description}"> 
                             <input type="hidden" name="price" value="${toy.price}">
                             <input type="submit" value="Add to cart">
                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>
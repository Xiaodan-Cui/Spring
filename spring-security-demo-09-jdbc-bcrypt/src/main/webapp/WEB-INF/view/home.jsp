<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>

<title>Company Home Page</title>
</head>
<body>
 <h2> COmpany Home Page-Yoooo-no soup</h2>
 <hr>
 welcome to our home\
 
 <hr>
 <security:authorize access="hasRole('MANAGER')">
 <p>
 
 <a href="${pageContext.request.contextPath}/leaders">LeaderShip Metting</a>
 (only for leaders)
 </p>
 </security:authorize>
 <security:authorize access="hasRole('ADMIN')">
  <p>
 <a href="${pageContext.request.contextPath}/systems">IT System Metting</a>
 (only for ITs)
 </p>
 </security:authorize>
 <p>
 User:<security:authentication property="principal.username"/>
 
 <br><br>
Role:<security:authentication property="principal.authorities"/>
 </p>
 <hr>
 
 <form:form action="${pageContext.request.contextPath}/logout"
 method="post">
 <input type="submit" value="Logout" />
 </form:form>
</body>
</html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title>Save Customers</title>
	<link type="text/css" 
			rel="stylesheet" 
			href="${pageContext.request.contextPath}/resources/css/style.css" />
			<title>List Customers</title>
	<link type="text/css" 
			rel="stylesheet" 
			href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>

		<div id="container">
			<h3>Save Customer</h3>
			<form:form action="saveCustomer" modelAttribute="customer" methode="POST">
				<form:hidden path="id"/>
				<tbody>
				 <tr>
				 	<td><label>First name:</label></td>
				 	<td><form:input path="firstName"/></td>
				 </tr>
				 <tr>
				 	<td><label>Last name:</label></td>
				 	<td><form:input path="lastName"/></td>
				 </tr>
				 <tr>
				 	<td><label>Email:</label></td>
				 	<td><form:input path="email"/></td>
				 </tr>
				 <tr>
				 	<td><label></label></td>
				 	<td><input type="submit" value="Save" class="save"/></td>
				 </tr>
				</tbody>
			
			</form:form>
			<div style="clear;both;"></div>
			<p><a href="${pageContext.request.contextPath}/customer/list">Back To List</a></p>
	</div>
	</div>
</body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.error {color:red}
</style>
</head>
<body>
<i>Fill out the form. Asterist (*) means required.</i>
	<form:form action="processForm" modelAttribute="student">
	
	First name:<form:input path="firstName" />
	<br><br>
	Last name(*):<form:input path="lastName" />
	<form:errors path="lastName" cssClass="error" />
	<br><br>
	Free passes: <form:input path="freePasses" />
	<form:errors path="freePasses" cssClass="error" />
	<br><br>
	Course Code: <form:input path="courseCode" />
	<form:errors path="courseCode" cssClass="error" />
	<br><br>
	Postal Code: <form:input path="postalCode" />
	<form:errors path="postalCode" cssClass="error" />
	<br><br>
	Country: <form:select path="country">
		<form:options items="${student.countryOptions}" />
		
		</form:select>
	<br><br>
	Favorite Language
	
	Java <form:radiobutton path="favoriteLanguage" value="java" />
	C# <form:radiobutton path="favoriteLanguage" value="c#" />
	Python <form:radiobutton path="favoriteLanguage" value="python" />
	Ruby <form:radiobutton path="favoriteLanguage" value="ruby" />
	<br><br>
	Operating Systems

   Linux<form:checkbox path="operatingSystems" value="Linux" />
   MacOS<form:checkbox path="operatingSystems" value="MacOS" />
   Windows<form:checkbox path="operatingSystems" value="Windows" />
	
	<br><br>
	<input type="submit" value="Submit" />
	</form:form>
</body>
</html>
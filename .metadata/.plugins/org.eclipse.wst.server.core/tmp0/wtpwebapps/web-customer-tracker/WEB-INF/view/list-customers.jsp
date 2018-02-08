<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link type="text/css" 
		  rel="stylesheet" 
		  href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			<!-- put new button: Add Customer -->
			<input type="button" value="Add Customer" 
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button">
		
			<!-- add our html table here -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<!-- loop over and print customers -->
				<c:forEach var="tempCustomer" items="${customers}">
					<tr>
						<td>${tempCustomer.firstName }</td>
						<td>${tempCustomer.lastName }</td>
						<td>${tempCustomer.email }</td>
						<td>
							<!-- Construct an update Link -->
							<c:url var="updateLink" value="/customer/showFormForUpdate">
								<c:param name="customerId" value="${tempCustomer.id}"/>
							</c:url>
							<!-- Construct a Delete Link -->
							<c:url var="deleteLink" value="/customer/deleteCustomer">
								<c:param name="customerId" value="${tempCustomer.id}"/>
							</c:url>
							<a href="${updateLink}">Update</a>
							 | 
							<!-- <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false"> -->
							<a href="${deleteLink}" onclick="return (confirm('Are you sure you want to delete this customer?'))">
							Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>
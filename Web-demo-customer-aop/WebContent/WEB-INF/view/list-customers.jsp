<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference css -->
	
	<link type = "text/css"
			rel = "stylesheet"
			href= "${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

	<div id = "wrapper">
		<div id = "header">		
			<h2> Customer Relationship Manager</h2>		
		</div>	
	</div>

	<div id = "container">
		<div id = "content">
			<!-- put new buttone : add customer -->
			<input type="button" value="Add Customer"
					onclick = "window.location.href='showForm'; return false"
					class="add-button"
			/>
			<table>
				<tr>
					<th> Fist Name </th>
					<th> Last Name </th>
					<th> Email </th>
					<th> Action </th>
				</tr>
			<c:forEach var = "temp" items = "${customers}">
			
			<!-- construct an update link with customer id -->
			<c:url var="LinkForUpdate" value="/customer/showFormForUpdate">
				<c:param name="customerId" value="${temp.id}" />
			</c:url>
			
			<!-- construct a delete link with customer id -->
			<c:url var="LinkForDelete" value="/customer/delete">
				<c:param name="customerId" value="${temp.id}" />
			</c:url>
			
				<tr>
					<td> ${temp.firstName} </td>
					<td> ${temp.lastName} </td>
					<td> ${temp.email} </td>
					<td> 
					<!-- display the update link -->
					<a href = "${LinkForUpdate}">Update</a>
					<!-- display the delete link -->
					|
					<a href = "${LinkForDelete}"
					onclick="if(!(confirm('Delete this customer?'))) return false"
					>Delete</a>
					</td>
				</tr>
			</c:forEach>
			</table>
		
		</div>
	
	</div>

</body>

</html>










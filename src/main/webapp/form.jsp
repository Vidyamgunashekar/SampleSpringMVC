<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
	<c:choose>
		<%-- Register Form --%>
		<c:when test="${param.action == 'register'}">
			<h2>Register Here</h2>
			<form action="register" method="post">
				<input type="text" name="id" placeholder="Enter ID here" required>
				<input type="text" name="name" placeholder="Enter Name here"
					required> <input type="text" name="sal"
					placeholder="Enter Salary here" required> <input
					type="submit" value="Register">
			</form>
		</c:when>

		<%-- Update Salary Form --%>
		<c:when test="${param.action == 'updateSalary'}">
			<h2>Update Salary</h2>
			<form action="update" method="post">
				<input type="text" name="id" placeholder="Enter ID here" required>
				<input type="text" name="sal" placeholder="Enter Salary here"
					required> <input type="submit" value="Update">
			</form>
		</c:when>

		<%-- Select Single Record Form --%>
		<c:when test="${param.action == 'selectSingleRecord'}">
			<h2>Select Single Record</h2>
			<form action="selectbyid" method="post">
				<input type="text" name="id" placeholder="Enter ID here" required>
				<input type="submit" value="Select">
			</form>
		</c:when>


		<%-- Select Single Record Form --%>
		<c:when test="${param.action == 'selectAllRecords'}">
			<h2>Select Single Record</h2>
			<form action="selectallrecords">

				<input type="submit" value="Select">
			</form>
		</c:when>



		<%-- Delete by ID Form --%>
		<%-- Select Single Record Form --%>
		<c:when test="${param.action == 'deleteRecordById'}">
			<h2>Select Single Record</h2>
			<form action="deleterecordbyid">

				<input type="submit" value="Select">
			</form>
		</c:when>



		<%-- Default Form --%>
		<c:otherwise>
			<h2>No Form Selected</h2>
		</c:otherwise>
	</c:choose>
</body>
</html>


<%@page import="com.action.service.AdministrateurServiceStub"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String password = request.getParameter("password");
	String hashedPassword = "";
	if (password != null) {
		AdministrateurServiceStub stub = new AdministrateurServiceStub();

		// Create a new params object for the method hashPassword
		AdministrateurServiceStub.HashPassword params = new AdministrateurServiceStub.HashPassword();

		// Set necessary arguments
		params.setClairText(password);

		// Get the method call response object
		AdministrateurServiceStub.HashPasswordResponse hashPasswordResponse = stub.hashPassword(params);

		// Get the return value
		hashedPassword = hashPasswordResponse.get_return();

	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client Service Web</title>
</head>
<body>

	<form>
		<input type="text" name="password" />
		<button type="submit">Hasher</button>
	</form>

	<%
		if (password != null) {
	%>
		<label>Texte en clair: <%=request.getParameter("password")%></label>
		<br>
		<label>Hash: <%=hashedPassword%></label>
	<%
		}
	%>
</body>
</html>
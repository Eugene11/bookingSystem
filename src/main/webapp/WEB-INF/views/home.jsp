<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page session="false" %>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="/myapp/resources/booking.js?"></script>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Simple example of processing batch booking  
</h1>

<a href="${pageContext.request.contextPath}/booking/booked">Book batch request</a>

<input id="buttonAdd" type="button" value="book batch meeting" />
<script type="text/javascript">
	var urlAddBook = "${pageContext.request.contextPath}/booking/book";
</script>


</body>

</html>

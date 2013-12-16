
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/booking/">Home</a>
	<c:if test="${!empty listOutBook}" >
		<br/>
		<c:forEach items="${listOutBook}" var="bookedItem">
			${bookedItem.getBookingDate()}
			<br/>
			<c:forEach items="${bookedItem.getBookingConfirmedMeeting()}" var="meeting">
				${meeting[0]}
				${meeting[1]}
				${meeting[2]}
				<br/>
			</c:forEach>
		</c:forEach>
	</c:if>
	<c:if test="${empty listOutBook}" >
		<br>
		No Booking
	</c:if>
</body>
</html>
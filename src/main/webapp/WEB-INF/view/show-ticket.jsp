<jsp:useBean id="Tickets" scope="request" type="com.spring.mvc.dao.TicketImpl"/>
<!DOCTYPE html>
<html>
<head>
  <title>Your ticket</title>
</head>
<body>
${Tickets}
<br>

</body>
</html>
<jsp:useBean id="Events" scope="request" type="com.spring.mvc.dao.EventImpl"/>
<!DOCTYPE html>
<html>
<head>
  <title>Your user</title>
</head>
<body>

Name - ${Events.title}
<br>
Email - ${Events.date}

<br><br>
<a href="CreateTicket">Create Event</a>
</body>
</html>
<jsp:useBean id="Users" scope="request" type="com.spring.mvc.dao.UserImpl"/>
<!DOCTYPE html>
<html>
<head>
    <title>Your user</title>
</head>
<body>

Name - ${Users.name}
<br>
Email - ${Users.email}

<br><br>
<a href="createEvent">Create Event</a>
</body>
</html>

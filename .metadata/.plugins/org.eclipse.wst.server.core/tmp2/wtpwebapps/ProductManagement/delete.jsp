<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#00FFFF">
  <h1>Delete Doctor</h1>
  <h1>
    <a href="Index.jsp">List Product</a>
  </h1>
  <form action="MyServlet" method="post">
    Enter ID<input type="text" name="id"> <input type="submit"
      value="delete" name="Action">
  </form>
</body>
</html>
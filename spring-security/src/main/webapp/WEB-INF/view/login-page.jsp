<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Custom Login Page</title>

     <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body>

    <h3>Custom Login Page</h3>
    <form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">
      <%-- Sping security will auth the user using the default form "name="" " so need to have the exact values --%>

      <%-- Check for login error --%>
      <c:if test="${param.error != null}">
          <i class="failed">Sorry! You entered invalid Username/Password!</i>
      </c:if>

      <p>
        User name: <input type="text" name="username" value="" placeholder="Enter username">
      </p>

      <p>
        Password: <input type="password" name="password" value="" placeholder="Enter your password">
      </p>

      <input type="submit" name="" value="Login">

    </form:form>




  </body>
</html>

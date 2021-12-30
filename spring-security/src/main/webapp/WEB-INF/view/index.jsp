<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Company Home Page</title>
  </head>
  <body>

    <h2>Company Home Page</h2>
    <hr>

    <h5>Welcome to the company home page!</h5>
    <hr>

    <%-- display user name and role --%>

    <p>
      <%-- display the username of the logged in user --%>
      User: <security:authentication property="principal.username" />
      <br>
      <%-- display the user roles for the logged in user --%>
      Role(s): <security:authentication property="principal.authorities" />
    </p>


    <security:authorize access="hasRole('MANAGER')">
      <%-- Add a link to point to /leader... this is for the managers --%>
      <p>
        <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a> (Only for Managers folks)
      </p>
    </security:authorize>


    <security:authorize access="hasRole('ADMIN')">
      <%-- Add a link to point to /systems... this is for the admins --%>
      <p>
        <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a> (Only for Admins peeps)
      </p>
    </security:authorize>

    <hr>

    <%--  --%>

    <%-- Add a logout button --%>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">

      <input type="submit" name="" value="Logout">

    </form:form>

  </body>
</html>

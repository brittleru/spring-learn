<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Customer Registration Form</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
  </head>
  <body>

    <p><i>Fill out the form. Asterisk(*) means required.</i></p>
    <form:form action="processForm" modelAttribute="customer" >
      <p>First Name: <form:input path="firstName" /></p>
      <p>Last Name (*): <form:input path="lastName" />
        <%-- Add css class with cssClass and it will show the form errors --%>
        <%-- only if we have an error after input --%>
        <form:errors path="lastName" cssClass="error" />
      </p>
      <p>Free Passes: <form:input path="freePasses" />
        <form:errors path="freePasses" cssClass="error"/>
      </p>
      <p>Postal Code: <form:input path="postalCode"/>
        <form:errors path="postalCode" class="error"/>
      </p>
      <p>Course Code: <form:input path="courseCode"/>
        <form:errors path="courseCode" class="error"/>
      </p>

      <input type="submit" name="" value="Submit">
    </form:form>

  </body>
</html>

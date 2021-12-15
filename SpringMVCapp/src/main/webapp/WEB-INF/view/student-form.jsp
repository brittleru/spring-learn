<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="utf-8">
  <title>Student Registration Form</title>
</head>
<body>

  <form:form action="processForm" modelAttribute="student">
    <p>First Name: <form:input path="firstName"/></p>
    <p>Last Name: <form:input path="lastName"/></p>

    <%-- Multi selection options data binding --%>
    <div class="">
      Country:
      <form:select path="country">
        <form:options items="${countryOptions}" />
      </form:select>
    </div>

    <%-- Radio button data binding --%>
    <div class="">
      <p>Favorite Programming Language:</p>
      <div class="">
        <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}" />

      </div>

    </div>

    <%-- Check box data binding --%>
    <div class="">
      <p>Operating Systems:</p>
      Linux <form:checkbox path="operatingSystems" value="Linux" />
      Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
      MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />

    </div>

    <br>
    <input type="submit" name="" value="Submit">


  </form:form>

</body>
</html>

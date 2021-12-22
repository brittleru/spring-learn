<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en" dir="ltr" xmlns="http://www.thymeleaf.org">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/master.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">


  <title>Customer Form - Add employee</title>
</head>
<body>

  <div class="container main-content">
    <div class="form-content">
      <h1>Add Employees</h1>
      <hr>

      <%-- if we have non-null valuse of the fields spring will call getters on load --%>
      <%-- and setters on submit --%>
      <form:form class="" action="save-employee" modelAttribute="employee" method="post">

        <%-- need to associate this data with employee id --%>
        <%-- to set the content of the original employee --%>
        <%-- with the new content of the updated employee --%>
        <form:hidden path="id" />

        <%-- <table class="table table-bordered"> --%>
        <table>
          <%-- <thead class="table-primary">
            <tr>
              <th></th>
            </tr>
          </thead> --%>
          <tbody >
            <tr>
              <td><label for="">First name:</label></td>
              <td><form:input path="firstName"/></td>
            </tr>

            <tr>
              <td><label for="">Last name:</label></td>
              <td><form:input path="lastName"/></td>
            </tr>

            <tr>
              <td><label for="">Email:</label></td>
              <td><form:input path="email"/></td>
            </tr>

            <tr>
              <td><label for=""></label></td>
              <td><input type="submit" name="" class="btn btn-success" value="Save"></td>
            </tr>
          </tbody>
        </table>
      </form:form>

      <div class="navigate-back">
        <p>
          <a class="btn btn-secondary" href="${pageContext.request.contextPath}/employee/list">Back to the Employees List</a>
        </p>
      </div>

    </div>

  </div>



</body>
</html>

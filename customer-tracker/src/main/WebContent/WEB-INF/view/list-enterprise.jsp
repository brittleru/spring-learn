<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en" dir="ltr" xmlns="http://www.thymeleaf.org">
  <head>
    <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Enterprise - Data Source</title>
  </head>
  <body>

    <div class="container">
      <h1>Enterprise Details</h1>

      <hr>

      <h3>Current Employees</h3>

      <table class="table table-bordered table-striped">
        <thead class="table-primary">
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
          </tr>
        </thead>

        <tbody>
          <%-- Loop over and print the employees --%>
          <c:forEach var="tempEmployee" items="${employees}">
            <tr>
              <td>${tempEmployee.firstName}</td>
              <td>${tempEmployee.lastName}</td>
              <td>${tempEmployee.email}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>


      <hr>

      <h3>Current Customers</h3>

      <table class="table table-bordered table-striped">
        <thead class="table-success">
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
          </tr>
        </thead>

        <tbody>
          <%-- Loop over and pring the customers --%>
          <c:forEach var="tempCustomer" items="${customers}">
            <tr>
              <td>${tempCustomer.firstName}</td>
              <td>${tempCustomer.lastName}</td>
              <td>${tempCustomer.email}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>

    </div>

  </body>
</html>

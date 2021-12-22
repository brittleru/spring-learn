<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.example.utils.SortUtils" %>

<!DOCTYPE html>
<html lang="en" dir="ltr" xmlns="http://www.thymeleaf.org">
  <head>
    <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
          <%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"> --%>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/master.css">
    <title>Employees - Data Source</title>
  </head>
  <body>

    <div class="container">
      <h1><a href="${pageContext.request.contextPath}/" class="a-no-underline"><i class="fa fa-chevron-left" style="font-size:34px"></i></a>Enterprise Details</h1>

      <hr>
      <h3>Current Employees</h3>
      <%-- Put a new button: Add Employee --%>
      <br>
      <input id="employeeButton" class="btn btn-primary" type="button" value="Add Employee"/>
      <br>
        <br>
      <%-- add a search box --%>
      <form:form action="search" method="GET">
        Search for an employee: <input type="text" name="searchEmployeeName" value="">
        <input type="submit" name="" value="Search" class="btn btn-info">
      </form:form>

      <br>



      <table class="table table-bordered table-striped">
        <thead class="table-primary">
          <tr>
            <th>
              <%-- construct a sort link for the first name --%>
              <c:url var="sortByFirstName" value="/employee/list">
                <c:param name="sort" value="<%= Integer.toString(SortUtils.FIRST_NAME) %>"/>
              </c:url>
              <a class="a-no-underline" href="${sortByFirstName}">First Name</a>
            </th>

            <th>
              <%-- construct a sort link for the first name --%>
              <c:url var="sortByLastName" value="/employee/list">
                <c:param name="sort" value="<%= Integer.toString(SortUtils.LAST_NAME) %>"/>
              </c:url>
              <a class="a-no-underline" href="${sortByLastName}">Last Name</a>
            </th>

            <th>
              <%-- construct a sort link for the first name --%>
              <c:url var="sortByEmail" value="/employee/list">
                <c:param name="sort" value="<%= Integer.toString(SortUtils.EMAIL) %>"/>
              </c:url>
              <a class="a-no-underline" href="${sortByEmail}">Email</a>
            </th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          <%-- Loop over and print the employees --%>
          <c:forEach var="tempEmployee" items="${employees}">

            <%-- Construct an "Update" link with employee ID --%>
            <c:url var="updateLink" value="/employee/update">
              <%-- get the employee id --%>
              <c:param name="employeeId" value="${tempEmployee.id}" />
            </c:url>

            <%-- Construct an "Delete" link with employee ID --%>
            <c:url var="deleteLink" value="/employee/delete">
              <%-- get the employee id --%>
              <c:param name="employeeId" value="${tempEmployee.id}" />
            </c:url>

            <tr>
              <td>${tempEmployee.firstName}</td>
              <td>${tempEmployee.lastName}</td>
              <td>${tempEmployee.email}</td>
              <td>
                <%-- display the update link --%>
                <a href="${updateLink}" class="btn btn-success">Update</a>
                <%-- TODO: change this to js app code, see why it doesn't load js app --%>
                <a href="${deleteLink}" onclick="return confirm('Are you sure you want to delete this employee?');" class="btn btn-danger">Delete</a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/employeeApp.js"></script>


  </body>
</html>

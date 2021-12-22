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
    <title>Customers - Data Source</title>
  </head>
  <body>

    <div class="container">
      <h1><a href="${pageContext.request.contextPath}/" class="a-no-underline"><i class="fa fa-chevron-left" style="font-size:34px"></i></a>Customers Details</h1>

      <hr>


      <h3>Current Customers</h3>

      <%-- Put a new button: Add Customer --%>
      <br>
      <input id="customerButton" class="btn btn-primary" type="button" value="Add Customer"/>
      <br>
        <br>
      <%-- add a search box --%>
      <form:form action="search" method="GET">
        Search for a customer: <input type="text" name="searchCustomerName" value="">
        <input type="submit" name="" value="Search" class="btn btn-info">
      </form:form>

      <br>






      <table class="table table-bordered table-striped">
        <thead class="table-primary">
          <tr>
            <th>
              <%-- construct a sort link for the first name --%>
              <c:url var="sortByFirstName" value="/customer/list">
                <c:param name="sort" value="<%= Integer.toString(SortUtils.FIRST_NAME) %>"/>
              </c:url>
              <a class="a-no-underline" href="${sortByFirstName}">First Name</a>
            </th>
            <th>
              <!-- construct a sort link for last name -->
              <c:url var="sortByLastName" value="/customer/list">
                <c:param name="sort" value="<%= Integer.toString(SortUtils.LAST_NAME) %>"/>
              </c:url>

              <a class="a-no-underline" href="${sortByLastName}">Last Name</a>
            </th>
            <th>
              <!-- construct a sort link for email -->
              <c:url var="sortByEmail" value="/customer/list">
                <c:param name="sort" value="<%= Integer.toString(SortUtils.EMAIL) %>"/>
              </c:url>

              <a class="a-no-underline" href="${sortByEmail}">Email</a>
            </th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          <%-- Loop over and pring the customers --%>
          <c:forEach var="tempCustomer" items="${customers}">

            <%-- Construct an "Update" link with customer ID --%>
            <c:url var="updateLink" value="/customer/update">
              <%-- get the customer id --%>
              <c:param name="customerId" value="${tempCustomer.id}" />
            </c:url>

            <%-- Construct an "Delete" link with customer ID --%>
            <c:url var="deleteLink" value="/customer/delete">
              <%-- get the customer id --%>
              <c:param name="customerId" value="${tempCustomer.id}" />
            </c:url>

            <tr>
              <td>${tempCustomer.firstName}</td>
              <td>${tempCustomer.lastName}</td>
              <td>${tempCustomer.email}</td>
              <td>
                <%-- display the update link --%>
                <a href="${updateLink}" class="btn btn-success">Update</a>
                <%-- TODO: change this to js app code, see why it doesn't load js app --%>
                <a href="${deleteLink}" onclick="return confirm('Are you sure you want to delete this customer?');" class="btn btn-danger">Delete</a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>

      <c:if test="${empty customers}">

      	<p>Did not find any customer.</p>

      </c:if>
    </div>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app.js"></script>

  </body>
</html>

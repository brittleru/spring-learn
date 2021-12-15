<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Successful Registration</title>
  </head>
  <body>

    <h3>The customer is confirmed: ${customer.firstName} ${customer.lastName}</h3>
    <h4>Free passes: ${customer.freePasses}</h4>
    <h4>Postal code: ${customer.postalCode}</h4>
    <h4>Course code: ${customer.courseCode}</h4>
  </body>
</html>

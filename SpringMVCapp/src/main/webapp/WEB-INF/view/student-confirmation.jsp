<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="utf-8">
  <title>Student Confirmation</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

  <h2>The student is confirmed: ${student.firstName} ${student.lastName}</h2>
  <h3>Country: ${student.country}</h3>
  <h3>Favorite Language: ${student.favoriteLanguage}</h3>


  <h3>Operating Systems: </h3>
  <div class="">
    <ul>
      <c:forEach var="temp" items="${student.operatingSystems}">
        <li> ${temp} </li>
      </c:forEach>
    </ul>
  </div>


</body>
</html>

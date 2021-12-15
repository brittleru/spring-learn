<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Spring Yay</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
  </head>
  <body>

    <div class="student-content">
      <h2>Hello World of Spring!</h2>
      <br>
      <p>Student name: ${param.studentName}</p>
      <br>
      <p id="change-text">The message: ${message}</p>

      <div id="child1" class="block center">
              <img class="img-fix" src="${pageContext.request.contextPath}/resources/imgs/image.jpeg" alt="Medi cea cute!">
      </div>
      <button id="click-me" type="button" name="button">Click me</button>
    </div>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app.js">

    </script>
  </body>
</html>

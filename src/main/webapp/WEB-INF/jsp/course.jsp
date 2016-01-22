<%@ page pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
  <head>
    <title>springmvc</title>
  </head>
  <body>
    课程名:&nbsp ${course.name}
    <br><br>
    时长:&nbsp ${course.duration}
    <br><br>
    <img src="<%=request.getContextPath()%>/${course.imagePath}" />
  </body>
</html>

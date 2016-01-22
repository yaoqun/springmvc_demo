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
    描述:&nbsp ${course.info}
    <br><br>
    <img src="<%=request.getContextPath()%>/${course.imagePath}" />
  </body>
</html>

<%@ page pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
  <head>
    <title>springmvc</title>
  </head>
  <body>
    <form action="<%=request.getContextPath()%>/course/do_add" method="post">
      课程Id:&nbsp <input type="text" id="id" name="id">
      <input type="submit" id="submitBtn" value="提交" />
    </form>
  </body>
</html>

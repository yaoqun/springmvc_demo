<%@ page pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
  <head>
    <title>springmvc</title>
  </head>
  <body>
    <form action="<%=request.getContextPath()%>/course/do_upload"
          enctype="multipart/form-data"
          method="post">
      <input type="file" name="userfile" />
      <br><br>
      <input type="submit" value="提交" />
    </form>
  </body>
</html>

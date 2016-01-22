<%@ page pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
  <head>
    <title>springmvc</title>
    <script type="text/javascript"
            src="<%=request.getContextPath()%>/res/js/course_query.js">
    </script>
  </head>
  <script>
  jQuery( function($) {
    var urlStr = "<%=request.getContextPath()%>/course/query/json2/<%=request.getParameter("courseId")%>";
    $.ajax({
      method: "GET",
      url: urlStr,
      success:function(data, status, jqXHR) {
        var course = data;
        var path = "<%=request.getContextPath()%>/";
        $(".course_name").html(course.name);
        $(".course_duration").html(course.duration);
        $(".course_image").attr("src", path+course.imagePath);
      }
    });
  });
  </script>
  <body>
    课程名:<div class="course_name"></div>
    <br><br>
    时长:<div class="course_duration"></div>
    <br><br>
    <img class="course_image" />
  </body>
</html>

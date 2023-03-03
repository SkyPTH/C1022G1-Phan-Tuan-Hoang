<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 3/2/2023
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<p>Chúc mừng đã login thành công tại thời gian <a id="clock"></a></p>
<script>
    function displayTime() {
        var currentTime = new Date();
        var hours = currentTime.getHours();
        var minutes = currentTime.getMinutes();
        var seconds = currentTime.getSeconds();
        var meridiem = "AM";
        if (hours > 12) {
            hours = hours - 12;
            meridiem = "PM";
        }
        if (hours === 0) {
            hours = 12;
        }
        if (minutes < 10) {
            minutes = "0" + minutes;
        }
        if (seconds < 10) {
            seconds = "0" + seconds;
        }
        var time =
            hours + ":" + minutes + ":" + seconds + " " + meridiem;
        document.getElementById("clock").innerHTML = time;
    }
    setInterval(displayTime, 1000);
</script>
</body>
</html>

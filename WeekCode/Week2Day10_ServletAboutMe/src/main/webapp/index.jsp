<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>About Me</title>
</head>
<body>
<h1><%= "Home Page" %>
</h1>
<br/>
<a href="about-me">About Me</a><br>
<p>Song Lyrics</p>
<form method="post" action="/about-me">
<input type="text" name="song-lyrics"><input type="submit" name="submitButton">
</form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add User</title>
</head>
<body>
<h2>Add New User</h2>
<form action="Controller" method="post">
  <input type="hidden" name="action" value="add_user">
  <table>
    <tr>
      <td>Username:</td>
      <td><input type="text" name="username" required></td>
    </tr>
    <tr>
      <td>First Name:</td>
      <td><input type="text" name="firstName" required></td>
    </tr>
    <tr>
      <td>Last Name:</td>
      <td><input type="text" name="lastName" required></td>
    </tr>
    <tr>
      <td>Email:</td>
      <td><input type="email" name="email" required></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type="password" name="password" required></td>
    </tr>
    <tr>
      <td>Facebook:</td>
      <td><input type="text" name="facebook"></td>
    </tr>
    <tr>
      <td>Bio:</td>
      <td><textarea name="bio"></textarea></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="Add User"></td>
    </tr>
  </table>
</form>
</body>
</html>
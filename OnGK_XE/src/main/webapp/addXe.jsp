<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/26/2024
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="text-align: center;">
    <h1>CỬA HÀNG BÁN XE GẮN MÁY ABC</h1>
    <div>
        <form action="controller" method="post">
            <input type="hidden" name="action" value="add_xe">
            <label for="maXe">Mã xe</label>
            <input type="text" id="maXe" name="maXe" required>
            <label for="tenXe">Tên xe:</label>
            <input type="text" id="tenXe" name="tenXe" required>
            <label for="giaXe">Giá xe:</label>
            <input type="text" id="giaXe" name="giaXe" required>
            <label for="namSanXuat">Năm sản xuất:</label>
            <input type="text" id="namSanXuat" name="namSanXuat" required>
            <label for="hangXe">Hãng xe:</label>
            <input type="text" id="hangXe" name="hangXe" required>
            <input type="submit" value="Thêm Xe">
            <input type="reset" value="Làm mới">


        </form>
    </div>
    </div>
</body>
</html>

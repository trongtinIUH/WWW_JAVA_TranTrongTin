<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/26/2024
  Time: 3:08 PM
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
            <input type="hidden" name="action" value="add_thuoc">
            <label for="maThuoc">Mã Thuốc</label>
            <input type="text" id="maThuoc" name="maThuoc" required>
            <label for="tenThuoc">Tên thuốc:</label>
            <input type="text" id="tenThuoc" name="tenThuoc" required>
            <label for="giaThuoc">Giá :</label>
            <input type="text" id="giaThuoc" name="giaThuoc" required>
            <label for="namSX">Năm sản xuất:</label>
            <input type="text" id="namSX" name="namSX" required>
            <label for="maLoai">Mã Loai:</label>
            <input type="text" id="maLoai" name="maLoai" required>
            <input type="submit" value="Thêm Xe">
            <input type="reset" value="Làm mới">


        </form>
    </div>
    </div>
</body>
</html>

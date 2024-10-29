<%@ page import="trantrongtin_iuh.ongk_xe.backend.dtos.XeDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/26/2024
  Time: 1:48 AM
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
</div>

<nav>
    <a href="controller?action=list_xe">Danh sách Xe</a> |
    <a href="addXe.jsp">Thêm Xe</a>
    <h2>Tìm xe theo Giá</h2>
    <div>
        <form action="controller" method="get">
            <input type="hidden" name="action" value="find_xe">
            <label for="giaXe">Giá xe:</label>
            <input type="text" id="giaXe" name="giaXe" required>
            <input type="submit" value="Tìm Kiếm">
            <input type="reset" value="Làm mới">
        </form>
    </div>

    <h2>Xóa xe theo mã xe</h2>
    <div>
        <form action="controller" method="post">
            <input type="hidden" name="action" value="delete_xe">
            <label for="maXe">Nhập Mã xe:</label>
            <input type="text" id="maXe" name="maXeXoa" required>
            <input type="submit" value="Xóa">
            <input type="reset" value="Làm mới">
        </form>
    </div>
</nav>

<h2>Danh Sách Xe</h2>

<table>
    <thead>
    <tr>
        <th>Mã xe</th>
        <th>Tên Xe</th>
        <th>Giá Xe</th>
        <th>Năm SX</th>
        <th>Hãng Xe</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<XeDTO> xeDTOList = (List<XeDTO>) request.getAttribute("list_xe");
        if (xeDTOList != null && !xeDTOList.isEmpty()) {
            for (XeDTO xe : xeDTOList) {
    %>
    <tr>
        <td><%= xe.getMaXe() %></td>
        <td><%= xe.getTenXe() %></td>
        <td><%= xe.getGiaXe() %></td>
        <td><%= xe.getNamSanXuat() %></td>
        <td><%= xe.getHangXe() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="5">Không có dữ liệu xe nào.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>

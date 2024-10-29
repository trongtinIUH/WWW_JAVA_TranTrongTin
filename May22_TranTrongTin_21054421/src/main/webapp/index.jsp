<%@ page import="trantrongtin_iuh.may22_trantrongtin_21054421.backend.dtos.ThuocDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/26/2024
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav>
    <a href="controller?action=list_thuoctheotungloai">Danh sách thuốc theo từng loại</a> |
    <a href="dsThuoc.jsp">Danh sách  thuốc</a>
    <a href="dsloaiThuoc.jsp">Danh sách loai thuốc</a>
    <a href="addThuoc.jsp">Thêm Thuốc</a>

</nav>

<h2>Danh Sách thuốc theo từng loại </h2>

<table>
    <thead>
    <tr>
        <th>Mã Thuốc</th>
        <th>Tên Thuốc</th>
        <th>Giá Thuốc</th>
        <th>Năm SX</th>
        <th>Mã loại thuốc</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<ThuocDTO> xeDTOList = (List<ThuocDTO>) request.getAttribute("dsThuocTheoLoai");
        if (xeDTOList != null && !xeDTOList.isEmpty()) {
            for (ThuocDTO xe : xeDTOList) {
    %>
    <tr>
        <td><%= xe.getMaThuoc() %></td>
        <td><%= xe.getTenThuoc() %></td>
        <td><%= xe.getGiaThuoc() %></td>
        <td><%= xe.getNamSX() %></td>
        <td><%= xe.getMaLoai() %></td>
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
<H2 style="text-align: center;margin-top:20px">Trần Trọng Tín_21054421</H2>
</body>
</html>

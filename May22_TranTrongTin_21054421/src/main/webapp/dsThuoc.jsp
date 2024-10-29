<%@ page import="trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository.entity.Thuoc" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/26/2024
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách thuốc</title>
</head>
<body>
<nav>
    <a href="controller?action=list_thuoctheotungloai">Danh sách thuốc theo từng loại</a> |
    <a href="dsThuoc.jsp">Danh sách  thuốc</a>
    <a href="dsloaiThuoc.jsp">Danh sách loai thuốc</a>

</nav>
<h2>Danh Sách thuốc </h2>

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
        List<Thuoc> xeDTOList = (List<Thuoc>) request.getAttribute("dsThuoc");
        if (xeDTOList != null && !xeDTOList.isEmpty()) {
            for (Thuoc xe : xeDTOList) {
    %>
    <tr>
        <td><%= xe.getMaThuoc() %></td>
        <td><%= xe.getTenthuoc() %></td>
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
</body>
</html>

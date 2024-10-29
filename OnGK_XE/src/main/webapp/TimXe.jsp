<%@ page import="trantrongtin_iuh.ongk_xe.backend.dtos.XeDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/26/2024
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh Sách Xe</h2>
<div style="text-align: center; flex-direction: row; margin:20px">
    <a href="controller?action=list_xe">Danh sách Xe</a> |
    <a href="addXe.jsp">Thêm Xe</a>
</div>
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
        List<XeDTO> xeDTOList = (List<XeDTO>) request.getAttribute("xe");
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

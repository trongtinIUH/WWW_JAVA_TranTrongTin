<%@ page import="trantrongtin_iuh.may22_trantrongtin_21054421.backend.repository.entity.Loaithuoc" %>
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
    <title>Title</title>
</head>
<body>
<h2>Danh Sách loại thuốc </h2>

<table>
    <thead>
    <tr>
        <th>Mã loại Thuốc</th>
        <th>Tên loại Thuốc</th>

    </tr>
    </thead>
    <tbody>
    <%
        List<Loaithuoc> xeDTOList = (List<Loaithuoc>) request.getAttribute("dsLoaiThuoc");
        if (xeDTOList != null && !xeDTOList.isEmpty()) {
            for (Loaithuoc xe : xeDTOList) {
    %>
    <tr>
        <td><%= xe.getMaLoai() %></td>
        <td><%= xe.getTenLoai() %></td>


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

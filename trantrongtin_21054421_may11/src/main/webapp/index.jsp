<%@ page import="trantrongtin_iuh.trantrongtin_21054421_may11.backend.dtos.XeDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Cửa Hàng Bán Xe Gắn Máy ABC</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
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

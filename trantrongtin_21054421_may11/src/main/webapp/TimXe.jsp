<%@ page import="trantrongtin_iuh.trantrongtin_21054421_may11.backend.dtos.XeDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Thông Tin Xe</title>
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

<div style="text-align: center; margin: 20px">
  <h1>Thông Tin Xe Tìm Theo Giá Xe</h1>
</div>

<%
  List<XeDTO> xeList = (List<XeDTO>) request.getAttribute("xe"); // Lấy xe từ request
  if (xeList != null) {
%>
<table>
  <thead>
  <tr>
    <th>Mã xe</th>
    <th>Tên Xe</th>
    <th> Giá Xe</th>
    <th>Năm SX</th>
    <th>Hãng Xe</th>
  </tr>
  </thead>
  <tbody>
  <% for (XeDTO xe : xeList) { %>
  <tr>
    <td><%= xe.getMaXe() %></td>
    <td><%= xe.getTenXe() %></td>
    <td><%= xe.getGiaXe() %></td>
    <td><%= xe.getNamSanXuat() %></td>
    <td><%= xe.getHangXe() %></td>
  </tr>
    <% } %>
  </tbody>
</table>
<%
} else {
%>
<p>Không tìm thấy thông tin xe với tên đã nhập.</p>
<%
  }
%>

<nav>
  <a href="controller?action=list_xe">Danh sách Xe</a> |
  <a href="addXe.jsp">Thêm Xe</a>
</nav>

</body>
</html>

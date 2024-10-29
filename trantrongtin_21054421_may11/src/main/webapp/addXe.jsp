<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Xe</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: #333;
        }
        form {
            margin-top: 20px;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"],
        input[type="number"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<h1>Thêm Xe</h1>

<form action="controller" method="post">
    <input type="hidden" name="action" value="add_xe">
    <label for="maXe">Mã Xe:</label>
    <input type="text" id="maXe" name="maXe" required>

    <label for="tenXe">Tên Xe:</label>
    <input type="text" id="tenXe" name="tenXe" required>

    <label for="giaXe">Giá Xe:</label>
    <input type="number" id="giaXe" name="giaXe" required>

    <label for="namSanXuat">Năm Sản Xuất:</label>
    <input type="number" id="namSanXuat" name="namSanXuat"  required>

    <label for="hangXe">Tên Hãng Xe:</label>
    <input type="text" id="hangXe" name="tenHangXe" required>

    <input type="submit" value="Thêm Xe">
</form>

</body>
</html>

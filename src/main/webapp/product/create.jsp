<%--
  Created by IntelliJ IDEA.
  User: kubap
  Date: 06/03/2022
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<a href="/products">Danh sách sản phẩm</a>
<c:if test="${message!=null}">
    <p class="alert alert-success">${message}</p>
</c:if>
<form action="/products?action=create" method="post">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Mã sản phẩm:</label>
        <input type="text" class="form-control" id="exampleInputEmail1" name="id">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Tên sản phẩm:</label>
        <input type="text" class="form-control" id="exampleInputPassword1" name="name">
    </div>
    <div class="mb-3">
        <label for="price" class="form-label">Giá sản phẩm:</label>
        <input type="text" class="form-control" id="price" name="price">
    </div>
    <div class="mb-3">
        <label for="description" class="form-label">Mô tả sản phẩm:</label>
        <input type="text" class="form-control" id="description" name="description">
    </div>
    <button type="submit" class="btn btn-primary">Tạo mới</button>
</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>

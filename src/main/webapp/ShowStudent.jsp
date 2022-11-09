<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>SHOW</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a href="/AddStudentServlet" type="button" class="btn btn-primary">ADD</a>
        <a href="/ShowStuden_Servlet" type="button" class="btn btn-primary" style="margin-left: 20px">ShowAll</a>
        <div style="margin-left: 600px">
        <form class="form-inline" action="/SearchServlet">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" name="search">
            <button class="btn btn-success" type="submit">Search</button>
        </form>
        </div>
    </nav>
    <br>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Date of Birth</th>
            <th>Email</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${Student}" var="St">
            <tr>
                <td>${St.getIdStudent()}</td>
                <td>${St.getName()}</td>
                <td>${St.getDateOfBirth()}</td>
                <td>${St.getEmail()}</td>
                <td>${St.getAddress()}</td>
                <td>
                    <a href="/EditControllor?id=${St.getIdStudent()}" type="button" class="btn btn-warning">Edit</a>
                    <a href="/DeleteServlet?id=${St.getIdStudent()}" type="button"
                       onclick="return confirm('Bạn có chắc chắn muốn xóa không?')" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
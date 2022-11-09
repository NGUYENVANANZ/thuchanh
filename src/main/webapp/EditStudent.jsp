<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/9/2022
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>EDIT</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<a href="/ShowStuden_Servlet"><h3><<< Back</h3></a>
<div class="container">
  <h2>Add new Student</h2>
  <form action="/EditControllor" method="post">
    <div class="form-group">
      <div class="form-group">
        <label>Id:</label>
        <input type="text" class="form-control" name="id" value="${student.getIdStudent()}" readonly>
      </div>
      <label>Name:</label>
      <input type="text" class="form-control" name="name" value="${student.getName()}" >
    </div>
    <div class="form-group">
      <label >Email address:</label>
      <input type="text" class="form-control" name="email" value="${student.getEmail()}">
    </div>
    <div class="form-group">
      <label>Date of Birth:</label>
      <input type="text" class="form-control" name="date" value="${student.getDateOfBirth()}">
    </div>
    <div class="form-group">
      <label>Address:</label>
      <input type="text" class="form-control" name="address" value="${student.getAddress()}">
    </div>
    <div class="form-group">
      <label>Phone Number:</label>
      <input type="text" class="form-control" name="phone" value="${student.getPhoneNumber()}">
    </div>
    <div class="form-group">
      <p>Class: ${classname} </p>
      <label>Class Edit: </label>
      <select name="idClassRoom">
        <c:forEach items="${listClass}" var="c">
          <option value="${c.getIdClass()}">${c.getNameClass()}</option>
        </c:forEach>
      </select>
    </div>
    <button type="submit" class="btn btn-primary">Edit</button>
  </form>
</div>

</body>
</html>

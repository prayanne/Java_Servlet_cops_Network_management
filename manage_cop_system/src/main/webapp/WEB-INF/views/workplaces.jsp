<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>Workplaces</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css"/>
</head>
<body>
<div class="container">
  <h2>Work Network Stacker</h2>
  <a class="btn" href="${pageContext.request.contextPath}/workplace/new">+ New Workplace</a>
  <div class="cards">
    <c:forEach var="w" items="${workplaces}">
      <div class="card">
        <div class="title">${w.name}</div>
        <div>
          <span class="badge">${w.location}</span>
          <span class="badge mono">${w.iconKey}</span>
        </div>
        <p>${w.summary}</p>
        <a class="btn" href="${pageContext.request.contextPath}/workplace?id=${w.id}&tab=tree">Open</a>
      </div>
    </c:forEach>
  </div>
</div>
</body>
</html>

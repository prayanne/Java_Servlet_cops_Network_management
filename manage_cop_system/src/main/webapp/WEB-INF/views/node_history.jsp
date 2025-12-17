<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>Node History</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css"/>
</head>
<body>
<div class="container">
  <a class="btn" href="javascript:history.back()">← Back</a>
  <h2>Node History</h2>
  <a class="btn" href="${pageContext.request.contextPath}/log/new?nodeId=${nodeId}">+ add history</a>
  <div class="badge mono">nodeId: ${nodeId}</div>
  <c:forEach var="l" items="${logs}">
    <div class="card">
      <div class="title">${l.title}</div>
      <div class="badge">at: ${l.occurredAt}</div>
      <a class="btn" href="${pageContext.request.contextPath}/log/edit?id=${l.id}">Edit</a>
      <pre>${l.content}</pre>
    </div>
  </c:forEach>
</div>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>Report</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css"/>
</head>
<body>
<div class="container">
  <a class="btn" href="javascript:history.back()">← Back</a>

  <c:if test="${report == null}">
    <h2>Report not found</h2>
  </c:if>

  <c:if test="${report != null}">
    <h2>${report.title}</h2>
    <div>
      <span class="badge">created: ${report.createdAt}</span>
      <c:if test="${report.reportDate != null}">
        <span class="badge">date: ${report.reportDate}</span>
      </c:if>
      <c:if test="${report.author != null}">
        <span class="badge">author: ${report.author}</span>
      </c:if>
      <c:if test="${report.tagsCsv != null}">
        <span class="badge">${report.tagsCsv}</span>
      </c:if>
    </div>
    <pre>${report.content}</pre>
  </c:if>
</div>
</body>
</html>

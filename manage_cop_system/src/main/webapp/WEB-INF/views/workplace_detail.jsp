<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>Workplace</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css"/>
</head>
<body>
<div class="container">
  <a class="btn" href="${pageContext.request.contextPath}/workplaces">← Back</a>
  <h2>${workplace.name}</h2>
  <div>
    <span class="badge">${workplace.location}</span>
    <span class="badge">${workplace.summary}</span>
  </div>

  <div class="tabs">
    <a class="tab ${tab=='tree' ? 'active' : ''}" href="${pageContext.request.contextPath}/workplace?id=${workplace.id}&tab=tree">Network Tree</a>
    <a class="tab ${tab=='reports' ? 'active' : ''}" href="${pageContext.request.contextPath}/workplace?id=${workplace.id}&tab=reports">Reports</a>
  </div>
  
  <c:if test="${tab=='tree'}">
    <h3>Tree</h3>
    <a class="btn" href="${pageContext.request.contextPath}/node/new?workplaceId=${workplace.id}">+ New Node</a>
    <c:forEach var="n" items="${nodes}">
      <div class="tree-row" style="padding-left:${n.depth * 22}px;">
        <span class="badge mono">${n.nodeType}</span>
        <a href="${pageContext.request.contextPath}/node/history?nodeId=${n.id}">${n.displayName}</a>
        <a class="btn" style="margin-left:8px;" href="${pageContext.request.contextPath}/node/edit?id=${n.id}">Edit</a>
        <a class="btn" style="margin-left:8px;" href="${pageContext.request.contextPath}/node/new?workplaceId=${workplace.id}&parentId=${n.id}">+ Child</a>
      </div>
    </c:forEach>
  </c:if>

  <c:if test="${tab=='reports'}">
    <div style="display:flex; justify-content:space-between; align-items:center;">
      <h3>Reports</h3>
      <a class="btn" href="${pageContext.request.contextPath}/report/new?workplaceId=${workplace.id}">+ New Report</a>
    </div>

    <c:forEach var="r" items="${reports}">
      <div class="card">
        <div class="title">
          <a href="${pageContext.request.contextPath}/report?id=${r.id}">${r.title}</a>
        </div>
        <div>
          <span class="badge">created: ${r.createdAt}</span>
          <c:if test="${r.reportDate != null}">
            <span class="badge">date: ${r.reportDate}</span>
          </c:if>
          <c:if test="${r.tagsCsv != null}">
            <span class="badge">${r.tagsCsv}</span>
          </c:if>
        </div>
        <c:if test="${r.author != null}">
          <div class="mono">author: ${r.author}</div>
        </c:if>
      </div>
    </c:forEach>
  </c:if>
</div>
</body>
</html>

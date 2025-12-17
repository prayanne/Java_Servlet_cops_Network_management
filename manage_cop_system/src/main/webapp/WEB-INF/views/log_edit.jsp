<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html><html><head>
<meta charset="UTF-8"/>
<title>Edit Log</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css"/>
</head><body>
<div class="container">
  <a class="btn" href="${pageContext.request.contextPath}/node/history?nodeId=${log.nodeId}">← Back</a>

  <c:if test="${log == null}">
    <h2>Log not found</h2>
  </c:if>

  <c:if test="${log != null}">
    <h2>Edit Activity Log</h2>
    <div class="badge mono">logId: ${log.id}, nodeId: ${log.nodeId}</div>

    <form method="post" action="${pageContext.request.contextPath}/log/update">
      <input type="hidden" name="id" value="${log.id}"/>
      <input type="hidden" name="nodeId" value="${log.nodeId}"/>

      <div class="form-row"><label>Title</label>
        <input type="text" name="title" value="${log.title}" required/>
      </div>

      <div class="form-row"><label>Content</label>
        <textarea name="content">${log.content}</textarea>
      </div>

      <button class="btn" type="submit">Save</button>
    </form>
  </c:if>
</div>
</body></html>

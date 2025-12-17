<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html><html><head>
<meta charset="UTF-8"/>
<title>Edit Node</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css"/>
</head><body>
<div class="container">
  <a class="btn" href="${pageContext.request.contextPath}/workplace?id=${node.workplaceId}&tab=tree">← Back</a>
  <h2>Edit Node</h2>

  <div class="badge mono">#${node.id} [${node.nodeType}]</div>

  <form method="post" action="${pageContext.request.contextPath}/node/update">
    <input type="hidden" name="id" value="${node.id}"/>
    <input type="hidden" name="workplaceId" value="${node.workplaceId}"/>

    <div class="form-row"><label>Display Name</label><input type="text" name="displayName" value="${node.displayName}" required/></div>
    <div class="form-row"><label>Sort Order</label><input type="text" name="sortOrder" value="${node.sortOrder}"/></div>
    <div class="form-row"><label>Meta JSON</label><textarea name="metaJson">${node.metaJson}</textarea></div>

    <button class="btn" type="submit">Save</button>
  </form>
</div>
</body></html>

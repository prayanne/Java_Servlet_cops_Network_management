<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html><html><head>
<meta charset="UTF-8"/>
<title>New Node</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css"/>
</head><body>
<div class="container">
  <a class="btn" href="${pageContext.request.contextPath}/workplace?id=${workplaceId}&tab=tree">← Back</a>
  <h2>New Network Node</h2>

  <form method="post" action="${pageContext.request.contextPath}/node/create">
    <input type="hidden" name="workplaceId" value="${workplaceId}"/>

    <div class="form-row">
      <label>Parent (optional)</label>
      <select name="parentId">
        <option value="">(root)</option>
        <c:forEach var="p" items="${allNodes}">
          <option value="${p.id}" data-type="${p.nodeType}" ${presetParentId == p.id ? 'selected' : ''}>
			  #${p.id} [${p.nodeType}] ${p.displayName}
			</option>
        </c:forEach>
      </select>
    </div>

    <div class="form-row">
      <label>Node Type</label>
      <select name="nodeType" required>
        <option value="ISP">ISP</option>
        <option value="MODEM">MODEM</option>
        <option value="HASH">HASH</option>
        <option value="ROUTER">ROUTER</option>
        <option value="ORG">ORG</option>
        <option value="DEVICE">DEVICE</option>
      </select>
    </div>

    <div class="form-row"><label>Display Name</label><input type="text" name="displayName" required/></div>
    <div class="form-row"><label>Sort Order</label><input type="text" name="sortOrder" value="0"/></div>
    <div class="form-row"><label>Meta JSON (optional)</label><textarea name="metaJson"></textarea></div>

    <button class="btn" type="submit">Create</button>
  </form>
</div>
</body></html>

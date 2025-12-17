<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html><html><head>
<meta charset="UTF-8"/>
<title>New Workplace</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css"/>
</head><body>
<div class="container">
  <a class="btn" href="${pageContext.request.contextPath}/workplaces">← Back</a>
  <h2>New Workplace</h2>

  <form method="post" action="${pageContext.request.contextPath}/workplace/create">
    <div class="form-row"><label>Name</label><input type="text" name="name" required/></div>
    <div class="form-row"><label>Location</label><input type="text" name="location"/></div>
    <div class="form-row"><label>Icon Key</label><input type="text" name="iconKey" placeholder="office/factory/..."/></div>
    <div class="form-row"><label>Summary</label><input type="text" name="summary"/></div>
    <button class="btn" type="submit">Create</button>
  </form>
</div>
</body></html>

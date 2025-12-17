<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>New Report</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css"/>
</head>
<body>
<div class="container">
  <a class="btn" href="javascript:history.back()">← Back</a>
  <h2>New Report</h2>

  <form method="post" action="${pageContext.request.contextPath}/report/create">
    <input type="hidden" name="workplaceId" value="${workplaceId}"/>

    <div class="form-row">
      <label>Title</label>
      <input type="text" name="title" required />
    </div>

    <div class="form-row">
      <label>Report Date (optional)</label>
      <input type="date" name="reportDate" />
    </div>

    <div class="form-row">
      <label>Author (optional)</label>
      <input type="text" name="author" />
    </div>

    <div class="form-row">
      <label>Tags CSV (optional)</label>
      <input type="text" name="tagsCsv" placeholder="network, isp, adhoc" />
    </div>

    <div class="form-row">
      <label>Content</label>
      <textarea name="content"></textarea>
    </div>

    <button class="btn" type="submit">Create</button>
  </form>
</div>
</body>
</html>

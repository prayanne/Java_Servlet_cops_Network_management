<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html><html><head>
<meta charset="UTF-8"/>
<title>작업 기록 추가</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css"/>
</head><body>
<div class="container">
  <a class="btn" href="${pageContext.request.contextPath}/node/history?nodeId=${nodeId}">← 뒤로</a>
  <h2>작업 기록 추가</h2>
  <div class="badge mono">nodeId: ${nodeId}</div>

  <form method="post" action="${pageContext.request.contextPath}/log/create">
    <input type="hidden" name="nodeId" value="${nodeId}"/>

    <div class="form-row">
      <label>제목</label>
      <input type="text" name="title" required placeholder="예) AP 채널 변경"/>
    </div>

    <div class="form-row">
      <label>내용</label>
      <textarea name="content" placeholder="작업 내용, 확인 결과, 후속 조치 등을 기록하세요."></textarea>
    </div>

    <button class="btn" type="submit">저장</button>
  </form>
</div>
</body></html>

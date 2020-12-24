<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>

<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://kit.fontawesome.com/cc60939e22.js"
	crossorigin="anonymous"></script>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

header {
	background-image: url("${rootPath}/static/image/main.jpg");
	background-attachment: fixed;
	background-position: center;
	background-repeat: no-repeat;
	background-size: 100%;
	color: white;
	text-align: center;
	padding: 2rem;
}

body {
	background-image: url("${rootPath}/static/image/main.jpg");
	height: 100%;
	width: 100%;
	background-position: center;
	background-size: cover;
	position: absolute;
}

header h2 {
	margin: 16px;
	text-shadow: 3px 3px 3px rgba(0, 0, 0, 0.2);
}
</style>

</head>
<body>
	<header>
		<h2>BigPOS 시스템 매입매출 관리 종합 프로젝트</h2>
	</header>
	<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>
	<section>
		<c:choose>
			<c:when test="${BODY == 'PRO_WRITE'}">
				<%@ include
					file="/WEB-INF/views/component/product/product_writeV2.jspf"%>
			</c:when>

			<c:when test="${BODY == 'PRO_HOME'}">
				<%@ include
					file="/WEB-INF/views/component/product/product_list.jspf"%>
			</c:when>

			<c:when test="${BODY == 'PRO_DETAIL' }">
				<%@ include
					file="/WEB-INF/views/component/product/product_detail.jspf"%>
			</c:when>

			<c:when test="${BODY == 'DEPT_LIST' }">
				<%@ include file="/WEB-INF/views/component/dept/dept_list.jspf"%>
			</c:when>

			<c:when test="${BODY == 'DEPT_WRITE'}">
				<%@ include file="/WEB-INF/views/component/dept/dept_write.jspf"%>
			</c:when>

			<c:when test="${BODY == 'DEPT_DETAIL'}">
				<%@ include file="/WEB-INF/views/component/dept/dept_detail.jspf"%>
			</c:when>

			<c:when test="${BODY == 'MEM_WRITE'}">
				<%@ include file="/WEB-INF/views/component/member/member_write.jspf"%>
			</c:when>

			<c:when test="${BODY == 'LOGIN'}">
				<%@ include file="/WEB-INF/views/component/member/member_login.jspf"%>
			</c:when>
			
			<c:when test="${BODY == 'IOLIST_HOME'}">
				<%@ include file="/WEB-INF/views/component/iolist/iolist_list.jspf"%>
			</c:when>
			
			<c:when test="${BODY == 'IO_WRITE'}">
				<%@ include file="/WEB-INF/views/component/iolist/iolist_write.jspf"%>
			</c:when>

			<c:otherwise>
				<%@ include file="/WEB-INF/views/include/include-main.jspf"%>
			</c:otherwise>

		</c:choose>
	</section>
</body>
</html>

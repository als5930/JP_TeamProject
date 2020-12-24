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
	position: relative;
	height: 500px;
	color: white;
	background-image: url("../image/53.jpg");
	background-position: center;
	background-repeat: no-repeat;
	background-size: 80% 80%;
	background-attachment: fixed;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

header h1 {
	font-weight: 500;
	color: black;
	text-shadow: -1px 0 rgb(5, 245, 245), 0 1px rgb(198, 0, 248), 0 1px
		rgb(0, 232, 248), 0 -1px rgb(13, 235, 243);
}

body {
	background-image: url("${rootPath}/static/image/1237.jpg");
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

footer {
	background-color: blue;
	color: white;
	text-align: center;
	padding: 10px;
	margin-top: 16%;
}
</style>

</head>
<body>
	<header>
		<h1>BigPOS 시스템 매입매출 관리 종합 프로젝트</h1>
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

			<c:when test="${BODY == 'IPRICE_HOME'}">
				<%@ include file="/WEB-INF/views/component/iprice/iprice_list.jspf"%>
			</c:when>
			<c:when test="${BODY == 'IP_WRITE'}">
				<%@ include file="/WEB-INF/views/component/iprice/iprice_write.jspf"%>
			</c:when>


			<c:otherwise>
				<%@ include file="/WEB-INF/views/include/include-main.jspf"%>
			</c:otherwise>

		</c:choose>
	</section>
	<section>
		<footer>
			<address>copyRight &copy; als3478@naver.com</address>
		</footer>

	</section>
</body>
</html>

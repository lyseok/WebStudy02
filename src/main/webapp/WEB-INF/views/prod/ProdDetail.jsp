<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/bootstrap-5.3.6-dist/css/bootstrap.min.css">
</head>
<body>
<main class="container">
	<h4>상품 상세 조회</h4>
	<table class="table">
		<tr>
			<th>상품코드</th>
			<td>${prod.prodId }</td>
		</tr>
		<tr>
			<th>상품명</th>
			<td>${prod.prodName }</td>
		</tr>
		<tr>
			<th>분류코드</th>
			<td>${prod.lprodGu }</td>
		</tr>
		<tr>
			<th>거래처코드</th>
			<td>${prod.buyerId }</td>
		</tr>
		<tr>
			<th>매입단가</th>
			<td>${prod.prodCost }</td>
		</tr>
		<tr>
			<th>상매출단가</th>
			<td>${prod.prodPrice }</td>
		</tr>
		<tr>
			<th>한인판매단가</th>
			<td>${prod.prodSale }</td>
		</tr>
		<tr>
			<th>대략적설명</th>
			<td>${prod.prodOutline }</td>
		</tr>
		<tr>
			<th>자세한 설명</th>
			<td>${prod.prodDetail }</td>
		</tr>
		<tr>
			<th>상품사진</th>
			<td>${prod.prodImg }</td>
		</tr>
		<tr>
			<th>전재고량</th>
			<td>${prod.prodTotalstock }</td>
		</tr>
		<tr>
			<th>입고일자</th>
			<td>${prod.prodInsdate }</td>
		</tr>
		<tr>
			<th>적정재고</th>
			<td>${prod.prodProperstock }</td>
		</tr>
		<tr>
			<th>크기</th>
			<td>${prod.prodSize }</td>
		</tr>
		<tr>
			<th>색상</th>
			<td>${prod.prodColor }</td>
		</tr>
		<tr>
			<th>배달사항</th>
			<td>${prod.prodDelivery }</td>
		</tr>
		<tr>
			<th>판매단위</th>
			<td>${prod.prodUnit }</td>
		</tr>
		<tr>
			<th>포장수량</th>
			<td>${prod.prodQtyin }</td>
		</tr>
		<tr>
			<th>판매단위</th>
			<td>${prod.prodQtysale }</td>
		</tr>
		<tr>
			<th>마일리지</th>
			<td>${prod.prodMileage }</td>
		</tr>
	</table>
</main>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/bootstrap-5.3.6-dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="product-save.action" method="post">
		
		ProductName: <input type="text" name="productName"/>
		<br><br>

		ProductDesc: <input type="text" name="productDesc"/>
		<br><br>
		
		ProductPrice: <input type="text" name="productPrice" />
		<br><br>
		
		<input type="submit" value="Submit"/>
		<br><br>
	
	</form>

</body>
</html>
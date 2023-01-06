<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/SpringMVCJspView/product/updateProduct" method="post">
   Product Id: <input type="text" name="pid" id="pid" value=${prod.pid} readonly><br>
   Product Name: <input type="text" name="pname" id="pname" value=${prod.pname}><br>
   Product Qty : <input type="text" name="qty" id="qty" value=${prod.qty}><br>
   Product price : <input type="text" name="price" id="price" value=${prod.price}><br>
   <button type="submit" name="btn" id="btn">update product</button>
</form>
</body>
</html>
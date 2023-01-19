<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@include file="init.jspf"%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<form onsubmit="onSubmitImg(event)">
	<label for="input-img">Cargue una imagen</label>
	<input type="file" id="input-img" name="input-img"/>
	<button class="btn btn-success" type="submit">Cargar imagen</button>
	<hr/>
	
	<div class="w-100 d-flex flex-row justify-content-around">
		<div>
			<img id="output-img" style="display: none" src=""/>
		</div>
		<div style="width: 300px" class="text-wrap">
			<h4>Imagen Binaria:</h4>
			<hr/>
			<p id="bin-img"></p>			
		</div>
	</div>	
	
</form>
</body>

</html>
<%
	String url = "https://sau.dinardap.gob.ec/sau-sso/login.do?";
	String client_id = "client_id=";
	String redirect_uri = "&redirect_uri=";
	System.out.println(url+client_id+redirect_uri);
	//response.sendRedirect(url+client_id+redirect_uri);
	//response.sendRedirect("paginas/index.jsf");
%>
<html>
<body>
	<form id="forma" action="main" method="get">
		Usuario: <input type="text" name="token"><br />
		Password: <input type="text" name="security"><br />
		<input type="submit" value="Iniciar" />
	</form>
</body>
</html>
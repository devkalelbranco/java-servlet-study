<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.kalelbranco.gerenciador.modelo.Empresa" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de empresas</title>
</head>
<body>

	<c:import url="logout-parcial.jsp" />

	Usuário logado: ${ usuarioLogado.login }
	
	<br/>
	<br/>

	Lista de empresas: <br/>
	
	
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				
				<li> 
					${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
					<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id }">Editar </a>|
					<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id }">Remover</a>
				</li>
			</c:forEach>
		</ul>
		
		<c:if test="${empty empresas }">
			Nenhuma empresa cadastrada
		</c:if>
		
		


</body>
</html>
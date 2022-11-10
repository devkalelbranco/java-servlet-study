package br.kalelbranco.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.kalelbranco.gerenciador.modelo.Banco;
import br.kalelbranco.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		Empresa emp = banco.buscaEmpresaPorId(id);
		
		System.out.println(emp.getNome());
		
		request.setAttribute("empresa", emp);
		
		return "forward:formAlterarEmpresa.jsp";		
	}
	
}

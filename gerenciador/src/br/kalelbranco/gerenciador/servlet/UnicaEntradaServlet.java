package br.kalelbranco.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.kalelbranco.gerenciador.acao.Acao;
import br.kalelbranco.gerenciador.acao.AlteraEmpresa;
import br.kalelbranco.gerenciador.acao.ListaEmpresas;
import br.kalelbranco.gerenciador.acao.MostraEmpresa;
import br.kalelbranco.gerenciador.acao.NovaEmpresa;
import br.kalelbranco.gerenciador.acao.NovaEmpresaForm;
import br.kalelbranco.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		String retAcao = null;
		String nomeDaClasse = "br.kalelbranco.gerenciador.acao." + paramAcao;
		
		try {
			Class classe = Class.forName(nomeDaClasse); //carrega a classe com a string
			Acao acao = (Acao) classe.newInstance();
			retAcao = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
				
		
		String[] tipoEEndereco = retAcao.split(":");
		if(tipoEEndereco[0].equals("forward")) {			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		} else {			
			response.sendRedirect(tipoEEndereco[1]);
		}
				
	}

}

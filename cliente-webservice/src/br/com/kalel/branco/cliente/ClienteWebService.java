package br.com.kalel.branco.cliente;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

public class ClienteWebService {
	
	public static void main(String[] args) throws Exception {
		
		String conteudo = Request
				.Post("http://localhost:8280/gerenciador/empresas")
				.addHeader("Accept", "application/xml")
				.execute()
				.returnContent()
				.asString();
		
		System.out.println(conteudo);
	}

}

package br.com.ferry.gerenciador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaEmpresas")
public class ListaEmpresas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco bk = new Banco();
		List<Empresa> lista = bk.getLista();
		
		request.setAttribute("empresas", lista);
		RequestDispatcher rp = request.getRequestDispatcher("/listaEmpresas.jsp");
		rp.forward(request, response);
	}

}

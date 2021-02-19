package br.com.ferry.gerenciador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alteraEmpresa")
public class AlteraEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parameter = request.getParameter("nome");
		String parameter2 = request.getParameter("data");
		String parameter3 = request.getParameter("id");
		Integer id = Integer.valueOf(parameter3);
		
		Date abertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			abertura = sdf.parse(parameter2);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco bk = new Banco();
		Empresa emp = bk.buscaEmpresa(id);
		emp.setNome(parameter);
		emp.setDataAbertura(abertura);
		
		response.sendRedirect("listaEmpresas");
	}
}

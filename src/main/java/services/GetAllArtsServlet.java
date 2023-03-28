package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import bbdd.ArtElementType;
import bbdd.ConsultasBBDD;
import dao.ArtElement;
import dao.User;
import manager.CommandInvoker;
import manager.CommandsType;

/**
 * Servlet implementation class GetAllArtsServlet
 */
@WebServlet("/GetAllArtsServlet")
public class GetAllArtsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllArtsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

	    User user = new User("Laura", "", "", "", "135246");
	    CommandInvoker invoker = new CommandInvoker(user);
	    CommandsType commandType = CommandsType.ART_GALERY;
	    List<Object> arts = invoker.executeCommand(commandType);

	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<body>");
	    out.println("<h1>Lista de artistas:</h1>");
	    for(Object art : arts) {
	        out.println("<p>" + art.toString() + "</p>");
	    }
	    out.println("</body>");
	    out.println("</html>");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public JSONArray execute(){
	    try {
	        List<ArtElement> artsList = ConsultasBBDD.getArtElements(ArtElementType.ARTWORKS);
	        JSONArray artsArray = new JSONArray(artsList);
	        return artsArray;
	    } catch (SQLException e) {
	        throw new RuntimeException("Impossible get all work art");
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

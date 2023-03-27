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

@WebServlet(urlPatterns = "/getAllArtist")
public class GetAllArtistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");

	    User user = new User("Laura", "", "", "", "135246");
	    CommandInvoker invoker = new CommandInvoker(user);
	    CommandsType commandType = CommandsType.ARTISTS;
	    List<Object> artists = invoker.executeCommand(commandType);

	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<body>");
	    out.println("<h1>Lista de artistas:</h1>");
	    for(Object artist : artists) {
	        out.println("<p>" + artist.toString() + "</p>");
	    }
	    out.println("</body>");
	    out.println("</html>");
	}
		
	public JSONArray execute(){
	    try {
	        List<ArtElement> artistsList = ConsultasBBDD.getArtElements(ArtElementType.ARTISTS);
	        JSONArray artistsArray = new JSONArray(artistsList);
	        return artistsArray;
	    } catch (SQLException e) {
	        throw new RuntimeException("Impossible get all artists");
	    }
	}
}

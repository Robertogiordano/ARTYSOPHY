/*package services;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User;
import manager.CommandInvoker;
import manager.CommandsType;
import org.junit.Test;

public class GetAllArtistServletTest {

	@Test
	public void testDoGet() throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);

		when(response.getWriter()).thenReturn(writer);

		User user = new User("Laura", "", "", "", "135246");
		CommandInvoker invoker = mock(CommandInvoker.class);
		CommandsType commandType = CommandsType.ARTISTS;
		List<Object> artists = new ArrayList<Object>();
		artists.add("Artist 1");
		artists.add("Artist 2");
		when(invoker.executeCommand(commandType)).thenReturn(artists);

		GetAllArtistServlet servlet = new GetAllArtistServlet();
		servlet.doGet(request, response);
		writer.flush();

		String result = stringWriter.toString();
		assertTrue(result.contains("<p>Artist 1</p>"));
		assertTrue(result.contains("<p>Artist 2</p>"));
	}
}*/


/*package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;


class PruebaArtits {

	@Test
	public void test() throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		when(request.getParameter("id")).thenReturn("0");
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		
		when(response.getWriter()).thenReturn(writer);
		new GetAllArtistServlet().doGet(request, response);
		System.out.println(stringWriter.toString());
		
		//Transformalor a JSONObject
		JSONObject objectResponse = new JSONObject(response);
		String code = objectResponse.get("code").toString();
		String resultado = objectResponse.get("resultado").toString();
		assertEquals("ok", code);
		assertNotNull(resultado);
	}

}*/

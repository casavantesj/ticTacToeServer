package edu.dcu.cpssd.tictactoe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import edu.dcu.cpssd.tictactoe.core.Game;

/**
 * Servlet implementation class NewGame
 */
@WebServlet(name = "newGame", urlPatterns = { "/newGame" })
public class NewGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewGame() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");

		ServletContext context = getServletContext();
		Game newGame;
		JSONObject requestObject = new JSONObject().put("name", name);

		if (context.getAttribute("id") == null) {
			newGame = new Game("id");
		} else {
			newGame = (Game) context.getAttribute("id");
		}

		//JSONObject responseObject = newGame.createNewGame(requestObject);

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
	//	responseObject.write(out);
		out.flush();
		out.close();
		context.setAttribute("id", newGame);
		request.getSession().setAttribute("id", newGame);

	}

}

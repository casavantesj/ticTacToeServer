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

import edu.dcu.cpssd.tictactoe.core.GameFactory;
import edu.dcu.cpssd.tictactoe.core.Game;
import edu.dcu.cpssd.tictactoe.core.User;

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");

		ServletContext servletContex = getServletConfig().getServletContext();

		GameFactory gameFactory = (GameFactory) servletContex.getAttribute("gameFactory");

		if (gameFactory == null) {
			gameFactory = new GameFactory();
		}

		User user = new User(name);
		Game game = gameFactory.newGame(user);
		JSONObject responseObject = new JSONObject().put("id", game.getId()).put("letter",
				game.getUserTurn(user));
		servletContex.setAttribute("gameFactory", gameFactory);
		request.getSession().setAttribute("user", new User(name));

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		responseObject.write(out);
		out.flush();
		out.close();
		

		/*
		 * String name = request.getParameter("name"); ServletContext
		 * servletContext = getServletContext(); GameFactory gameFactory =
		 * (GameFactory) servletContext.getAttribute("gameFactory"); if
		 * (gameFactory == null) { gameFactory = new GameFactory(); } User user
		 * = new User(name); Game game = gameFactory.newGame(user);
		 * request.getSession().setAttribute("user", new User(name));
		 * servletContext.setAttribute("gameFactory", gameFactory);
		 */

	}

}

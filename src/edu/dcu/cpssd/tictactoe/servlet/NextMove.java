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

import edu.dcu.cpssd.tictactoe.core.Board;
import edu.dcu.cpssd.tictactoe.core.GameFactory;
import edu.dcu.cpssd.tictactoe.core.Game;

/**
 * Servlet implementation class NextMove
 */
@WebServlet(name = "nextMove", urlPatterns = { "/nextMove" })
public class NextMove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NextMove() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");

		ServletContext servletContext = getServletConfig().getServletContext();

		GameFactory gameFactory = (GameFactory) servletContext.getAttribute("gameFactory");
		Game game = gameFactory.getGameWithId(id);

		Board board = game.getBoard();
		int turn = game.getTurn();
		int[] positions = board.getPositions();
		int winner = game.getWinner();

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		new JSONObject().put("board", positions).put("turn", turn).put("winner", winner).write(out);
		out.flush();
		out.close();

	}

}

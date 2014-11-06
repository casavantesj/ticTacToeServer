package edu.dcu.cpssd.tictactoe.core.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.dcu.cpssd.tictactoe.core.Board;
import edu.dcu.cpssd.tictactoe.core.Game;

public class GameTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void test() {

	}

	// test return letter
	@Test
	public final void testIfReturnLetterX() {
		String id = "id-1";
		Game game = new Game(id);

		assertEquals("X", game.getLetter());

	}

	public final void testIfReturnLetter0() {
		String id = "id-1";
		int turn = 2;
		Game game = new Game(id);
		game.setTurn(turn);
		assertEquals("O", game.getLetter());
	}

	public final void testIfReturnLetterError() {
		String id = "id-1";
		Game game = new Game(id);
		
		assertEquals("no valid", game.getLetter());
	}

	@Test
	public final void testIfGetReturnPositions() {
		Game game = new Game("23");
		int[] positions = game.getBoard().getPositions();

		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, positions);
	}

	@Test
	public final void testIfGetReturnBoardPositions() throws Exception {
		int position = 1;
		int turn = 2;
		Game game = new Game("23");
		game.setTurn(turn);
		int[] positions = game.move(position, turn);
		assertArrayEquals(new int[] { 0, 2, 0, 0, 0, 0, 0, 0, 0 }, positions);
	}

	@Test
	public final void testIfGetReturnBoardPositionswothPosition14() throws Exception {
		// TODO
		int position = 14;
		int turn = 2;
		Game game = new Game("23");
		game.setTurn(turn);
		int[] positions = game.move(position, turn);
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, positions);
	}

	@Test
	public final void testIfGetReturnBoardAllPositions() throws Exception {
		// TODO
		int position = 7;
		int turn = 2;
		Game game = new Game("23");
		game.setTurn(turn);
		int[] positions = game.move(position, 1);
		positions = game.move(0, 1);
		positions = game.move(2, 2);
		assertArrayEquals(new int[] { 1, 0, 2, 0, 0, 0, 0, 1, 0 }, positions);
	}

	// test return id

	// test return winner

	@Test
	public final void testIfIsWinner() {
		int turn = 2;
		int[] boardPositions = new int[] { 2, 2, 2, 0, 0, 0, 0, 0, 0 };
		Board board = new Board(boardPositions);
		Game game = new Game("23", board);
		game.setTurn(turn);
		
		assertEquals(true, game.isWinner(turn));
		// como testear
	}

}

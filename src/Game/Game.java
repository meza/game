package Game;

import Frames.MainFrame;

class Game
{
	public static void main(String[] args)
	{
		Game game = new Game();
		game.start();
	}

	private void start()
	{
		MainFrame frame = new MainFrame();
		frame.buildFrame();
	}
}

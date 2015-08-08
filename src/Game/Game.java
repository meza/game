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
		System.out.println("before the frame created");
		MainFrame frame = new MainFrame();
		frame.buildFrame();
		System.out.println("after the frame created");
	}
}

package Game;

import Frames.MainFrame;

public class Game
{
	public static void main(String[] args)
	{
		Game game = new Game();
		game.start();
	}

	private void start()
	{
		System.out.println("frame elott");
		MainFrame frame = new MainFrame();
		frame.buildFrame();
		System.out.println("frame utan");
	}
}

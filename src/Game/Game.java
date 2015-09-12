package Game;

import Content.GameContent;

class Game
{
	public static void main(String[] args)
	{
		Game game = new Game();
		game.start();
	}

	private void start()
	{
		GameContent gameContent = new GameContent();
		gameContent.buildMainFrame();
		gameContent.buildMainPage();
	}
}

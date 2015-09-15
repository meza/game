package Game;

import BuildContent.BuildGameContent;

class Game
{
	public static void main(String[] args)
	{
		Game game = new Game();
		game.start();
	}

	private void start()
	{
		BuildGameContent gameContent = new BuildGameContent();
		gameContent.buildMainFrame();
		gameContent.addMainPageToTheMainFrame();
	}
}

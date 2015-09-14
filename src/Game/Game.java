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
		BuildGameContent buildGameContent = new BuildGameContent();
		buildGameContent.buildMainFrame();
		buildGameContent.addMainPageToTheMainFrame();
	}
}

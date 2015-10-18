package Game;

import BuildContent.BuildGameContent;

public class Game {

    public void start()
    {
        BuildGameContent gameContent = new BuildGameContent();
        gameContent.buildMainFrame();
        gameContent.addMenuBarToTheMainFrame();
        gameContent.addMainPageToTheMainFrame();
    }
}

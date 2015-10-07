package BuildContent;

import javax.swing.*;
import java.text.MessageFormat;

public class BuildGameContent
{
	private static final OtherFunctions otherFunctions = new OtherFunctions();
	private static final JFrame mainFrame = new JFrame();

	public void buildMainFrame()
	{
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setSize(1200, 800);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setVisible(true);
		mainFrame.setTitle(otherFunctions.getPropertyText("mainFrameTitle"));
		mainFrame.validate();
	}

	public void addMenuBarToTheMainFrame()
	{
		BuildMenuBar menuBar = new BuildMenuBar();

		mainFrame.setJMenuBar(menuBar.buildMenuBar());
		//disable "Save game" menu item because game is not exist currently
		otherFunctions.changeMenuItemState("Save game", false);
		mainFrame.validate();
	}

	public void addMainPageToTheMainFrame()
	{
		BuildMainPage mainPage = new BuildMainPage();

		mainFrame.getContentPane().add(mainPage.buildMainPage());
		mainFrame.validate();
	}

	void addSelectRacePageToTheMainFrame()
	{
		BuildSelectRacePage selectRacePage = new BuildSelectRacePage();

		mainFrame.getContentPane().removeAll();
		mainFrame.repaint();
		mainFrame.setTitle(otherFunctions.getPropertyText("mainFrameTitleSelectRacePage"));
		//disable "New game" menu item because new game creation started
		otherFunctions.changeMenuItemState("New game", false);
		mainFrame.getContentPane().add(selectRacePage.buildSelectRacePage());
		mainFrame.validate();
	}

	void addCharacterGeneratorPageToTheMainFrame()
	{
		BuildCharacterGeneratorPage characterGeneratorPage = new BuildCharacterGeneratorPage();

		mainFrame.getContentPane().removeAll();
		mainFrame.repaint();
		mainFrame.setTitle(MessageFormat.format(
			                   otherFunctions.getPropertyText("mainFrameTitleGenerateRacePage"),
			                   otherFunctions.getSelectedRace()));
		mainFrame.getContentPane().add(characterGeneratorPage.buildCharacterGeneratorPage());
		OtherFunctions.nameField.requestFocus();
		mainFrame.validate();
	}
}

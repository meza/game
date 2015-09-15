package BuildContent;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

public class BuildGameContent
{
	final Properties LabelsProperties = new Properties();
	protected static final JFrame mainFrame = new JFrame();
	private String selectedRace = "";

	public BuildGameContent()
	{
		loadProperties();
	}

	private void loadProperties()
	{
		try
		{
			LabelsProperties.load(new FileInputStream("src/StaticContent/Properties/Labels.properties"));
		}
		catch (IOException e)
		{
			System.out.println("Exception Occurred: " + e.getMessage());
		}
	}

	public void buildMainFrame()
	{
		BuildMenuBar menuBar = new BuildMenuBar();

		mainFrame.setTitle(LabelsProperties.getProperty("mainFrameTitle"));
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setSize(1200, 800);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setVisible(true);
		mainFrame.setJMenuBar(menuBar.buildMenuBar());
		//disable "Save game" menu item because game is not exist currently
		changeMenuItemState("Save game", false);
		mainFrame.validate();
	}

	public void addMainPageToTheMainFrame()
	{
		BuildMainPage mainPage = new BuildMainPage();

		mainFrame.getContentPane().add(BorderLayout.CENTER, mainPage.buildMainPage());
		mainFrame.validate();
	}

	void addSelectRacePageToTheMainFrame()
	{
		BuildSelectRacePage selectRacePage = new BuildSelectRacePage();

		mainFrame.getContentPane().removeAll();
		mainFrame.repaint();
		mainFrame.setTitle(LabelsProperties.getProperty("mainFrameTitleSelectRacePage"));
		//disable "New game" menu item because new game creation started
		changeMenuItemState("New game", false);
		mainFrame.getContentPane().add(selectRacePage.buildSelectRacePage());
		mainFrame.validate();
	}

	protected void changeMenuItemState(String menuItemName, Boolean isEnabled)
	{
		int numberOfTheMenus = mainFrame.getJMenuBar().getMenuCount();

		for (int i = 0; i < numberOfTheMenus; i++)
		{
			setMenuItemState(i, menuItemName, isEnabled);
		}
	}

	private void setMenuItemState(int menuNumber, String menuItemName, Boolean isEnabled)
	{
		int numberOfTheMenuItems = mainFrame.getJMenuBar().getMenu(menuNumber).getMenuComponentCount();

		for (int j = 0; j < numberOfTheMenuItems; j++)
		{
			String menuItemText = mainFrame.getJMenuBar().getMenu(menuNumber).getMenuComponent(j).getName();

			if (menuItemName.equals(menuItemText))
			{
				mainFrame.getJMenuBar().getMenu(menuNumber).getMenuComponent(j).setEnabled(isEnabled);
				return;
			}
		}
	}

	void setSelectedRace(String race)
	{
		selectedRace = race;
	}

	private String getSelectedRace()
	{
		return selectedRace;
	}

	void addCharacterGeneratorPageToTheMainFrame()
	{
		BuildCharacterGeneratorPage characterGeneratorPage = new BuildCharacterGeneratorPage();

		mainFrame.setTitle(MessageFormat.format(LabelsProperties.getProperty("mainFrameTitleGenerateRacePage"), getSelectedRace()));
	}

}

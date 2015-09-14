package BuildContent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

public class BuildGameContent
{
	final Properties LabelsProperties = new Properties();
	private final JFrame mainFrame = new JFrame();
	final Border border = new LineBorder(Color.WHITE, 2, true);
	private final Font buttonFont = new Font("Monospaced", Font.BOLD, 25);
	private String selectedRace;

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
		mainFrame.validate();
	}

	public void addMainPageToTheMainFrame()
	{
		BuildMainPage mainPage = new BuildMainPage();

		mainFrame.getContentPane().add(BorderLayout.CENTER, mainPage.buildMainPage());
		mainFrame.validate();
	}

	void setButtonStyle(JButton button)
	{
		button.setBackground(Color.darkGray);
		button.setForeground(Color.white);
		button.setFont(buttonFont);
		button.setBorder(border);
	}

	void addSelectRacePageToTheMainFrame()
	{
		BuildSelectRacePage selectRacePage = new BuildSelectRacePage();

		mainFrame.getContentPane().removeAll();
		mainFrame.repaint();
		mainFrame.setTitle(LabelsProperties.getProperty("mainFrameTitleSelectRacePage"));
		mainFrame.getContentPane().add(selectRacePage.buildSelectRacePage());
		mainFrame.validate();
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

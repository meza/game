package BuildContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BuildMainPage
{
	private final BuildGameContent buildGameContent = new BuildGameContent();

	JPanel buildMainPage()
	{
		JPanel mainPanel = new JPanel(new GridLayout(2, 1));
		JPanel startPanel = new JPanel();
		JPanel emptyPanel = new JPanel();
		JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
		JButton newGameButton = new JButton(buildGameContent.LabelsProperties.getProperty("newGameButtonText"));
		JButton loadGameButton = new JButton(buildGameContent.LabelsProperties.getProperty("loadGameButtonText"));

		//format the buttons
		buildGameContent.setButtonStyle(newGameButton);
		buildGameContent.setButtonStyle(loadGameButton);

		//add tooltips to the buttons
		newGameButton.setToolTipText(buildGameContent.LabelsProperties.getProperty("newGameButtonToolTipText"));
		loadGameButton.setToolTipText(buildGameContent.LabelsProperties.getProperty("loadGameButtonToolTipText"));

		//add the buttons to the panel
		buttonsPanel.add(newGameButton);
		buttonsPanel.add(loadGameButton);

		//format the panels
		emptyPanel.setBackground(Color.darkGray);

		buttonsPanel.setBackground(Color.darkGray);
		buttonsPanel.setPreferredSize(new Dimension(200, 100));

		startPanel.setBackground(Color.darkGray);

		//add panel to set the buttons size
		startPanel.add(buttonsPanel);

		//add action listeners to the buttons
		newGameButton.addActionListener(new NewGameListener());
		loadGameButton.addActionListener(new LoadGameListener());

		//add the panels to the main panel
		mainPanel.add(emptyPanel);
		mainPanel.add(startPanel);

		return mainPanel;
	}

	private class NewGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			buildGameContent.addSelectRacePageToTheMainFrame();
		}
	}

	private class LoadGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}

}

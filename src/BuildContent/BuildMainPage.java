package BuildContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BuildMainPage
{
	private final OtherFunctions otherFunctions = new OtherFunctions();
	private final BuildGameContent gameContent = new BuildGameContent();

	JPanel buildMainPage()
	{
		JPanel mainPanel = new JPanel(new GridLayout(2, 1));

		mainPanel.add(buildNewGamePanel());
		mainPanel.add(buildLoadGamePanel());

		return mainPanel;
	}

	private JPanel buildNewGamePanel()
	{
		JPanel newGamePanel = new JPanel();
		JButton newGameButton = new JButton();

		otherFunctions.buildButton(
				newGameButton,
				otherFunctions.getPropertyText("newGameButton"),
				otherFunctions.getPropertyText("newGameButtonToolTip"),
				new NewGameListener(),
				250,
				50);

		otherFunctions.setPanelStyle(newGamePanel);
		newGamePanel.add(Box.createVerticalGlue());
		newGamePanel.add(newGameButton);
		newGamePanel.add(Box.createRigidArea(new Dimension(0, 5)));

		return newGamePanel;
	}

	private JPanel buildLoadGamePanel()
	{
		JPanel loadGamePanel = new JPanel();
		JButton loadGameButton = new JButton();

		otherFunctions.buildButton(
				loadGameButton,
				otherFunctions.getPropertyText("loadGameButton"),
				otherFunctions.getPropertyText("loadGameButtonToolTip"),
				new LoadGameListener(),
				250,
				50);

		otherFunctions.setPanelStyle(loadGamePanel);
		loadGamePanel.add(Box.createRigidArea(new Dimension(0, 5)));
		loadGamePanel.add(loadGameButton);

		return loadGamePanel;
	}

	private class NewGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			gameContent.addSelectRacePageToTheMainFrame();
		}
	}

	private class LoadGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}
}

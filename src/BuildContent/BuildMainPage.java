package BuildContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BuildMainPage
{
	private static final OtherFunctions otherFunctions = new OtherFunctions();
	private static final BuildGameContent gameContent = new BuildGameContent();

	JPanel buildMainPage()
	{
		JPanel mainPanel = new JPanel(new GridLayout(2, 1));

		mainPanel.add(buildNewGameButtonPanel());
		mainPanel.add(buildLoadGameButtonPanel());

		return mainPanel;
	}

	private JPanel buildNewGameButtonPanel()
	{
		JPanel newGamePanel = new JPanel();

		otherFunctions.setPanelStyle(newGamePanel, 3);

		newGamePanel.add(Box.createVerticalGlue());
		newGamePanel.add(
				otherFunctions.buildButton(
						otherFunctions.getPropertyText("newGameButton"),
						otherFunctions.getPropertyText("newGameButtonToolTip"),
						otherFunctions.bigFont,
						250,
						50,
						new NewGameListener()));
		newGamePanel.add(Box.createRigidArea(new Dimension(0, 5)));

		return newGamePanel;
	}

	private JPanel buildLoadGameButtonPanel()
	{
		JPanel loadGamePanel = new JPanel();

		otherFunctions.setPanelStyle(loadGamePanel, 3);

		loadGamePanel.add(Box.createRigidArea(new Dimension(0, 5)));
		loadGamePanel.add(
				otherFunctions.buildButton(
						otherFunctions.getPropertyText("loadGameButton"),
						otherFunctions.getPropertyText("loadGameButtonToolTip"),
						otherFunctions.bigFont,
						250,
						50,
						new LoadGameListener()));

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

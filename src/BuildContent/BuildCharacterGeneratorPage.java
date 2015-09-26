package BuildContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BuildCharacterGeneratorPage
{
	private final OtherFunctions otherFunctions = new OtherFunctions();
	private final BuildGameContent gameContent = new BuildGameContent();

	JPanel buildCharacterGeneratorPage()
	{
		JPanel mainPanel = new JPanel(new GridLayout(1, 3));

		mainPanel.add(buildCharacterNamePanel());
		mainPanel.add(buildCharacterStatPanel());
		mainPanel.add(buildStartGamePanel());

		return mainPanel;
	}

	private JPanel buildCharacterNamePanel()
	{
		JPanel characterNamePanel = new JPanel();
		JButton validateCharacterNameButton = new JButton();
		JButton backButton = new JButton();

		otherFunctions.buildButton(
				validateCharacterNameButton,
				otherFunctions.getPropertyText("validateCharacterNameButton"),
				otherFunctions.getPropertyText("validateCharacterNameButtonToolTip"),
				otherFunctions.mediumFont,
				350,
				50,
				new validateCharacterNameListener());

		otherFunctions.buildButton(
				backButton,
				otherFunctions.getPropertyText("backButton"),
				otherFunctions.getPropertyText("backButtonToolTip"),
				otherFunctions.bigFont,
				150,
				50,
				new backButtonListener());

		otherFunctions.setPanelStyle(characterNamePanel);

		characterNamePanel.add(Box.createRigidArea(new Dimension(0, 20)));
		characterNamePanel.add(otherFunctions.buildRaceImage(
				"/StaticContent/Images/" + otherFunctions.getSelectedRace() + ".jpg"));
		characterNamePanel.add(Box.createRigidArea(new Dimension(0, 20)));
		characterNamePanel.add(otherFunctions.buildTextArea(
				otherFunctions.getPropertyText("characterNameQuestion"),
				otherFunctions.bigFont,
				470,
				45));
		characterNamePanel.add(otherFunctions.buildTextField(
				otherFunctions.getPropertyText("offered" + otherFunctions.getSelectedRace() + "CharacterName"),
				450,
				45));
		characterNamePanel.add(otherFunctions.buildTextArea(
				otherFunctions.getPropertyText("characterNameLengthHint"),
				otherFunctions.smallFont,
				500,
				30));
		characterNamePanel.add(Box.createRigidArea(new Dimension(0, 20)));
		characterNamePanel.add(validateCharacterNameButton);
		characterNamePanel.add(Box.createVerticalGlue());
		characterNamePanel.add(backButton);
		characterNamePanel.add(Box.createRigidArea(new Dimension(0, 60)));

		return characterNamePanel;
	}

	private JPanel buildCharacterStatPanel()
	{
		JPanel characterStatPanel = new JPanel();

		characterStatPanel.setBackground(Color.green);

		return characterStatPanel;
	}

	private JPanel buildStartGamePanel()
	{
		JPanel startGamePanel = new JPanel();
		JButton startGameButton = new JButton();

		otherFunctions.buildButton(
				startGameButton,
				otherFunctions.getPropertyText("startGameButton"),
				otherFunctions.getPropertyText("startGameButtonToolTip"),
				otherFunctions.bigFont,
				250,
				50,
				new StartGameListener());

		otherFunctions.setPanelStyle(startGamePanel);

		startGamePanel.add(Box.createVerticalGlue());
		startGamePanel.add(startGameButton);
		startGamePanel.add(Box.createRigidArea(new Dimension(0, 60)));

		return startGamePanel;
	}

	private class validateCharacterNameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}

	private class backButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			gameContent.addSelectRacePageToTheMainFrame();
		}
	}

	private class StartGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}
}

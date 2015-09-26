package BuildContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BuildCharacterGeneratorPage
{
	private final BuildMainPage mainPage = new BuildMainPage();
	private final BuildGameContent gameContent = new BuildGameContent();
	private final BuildSelectRacePage selectRacePage = new BuildSelectRacePage();
	private final BuildMenuBar menuBar = new BuildMenuBar();
	private final Font smallTextFont = new Font("Monospaced", Font.BOLD, 15);

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

		mainPage.buildButton(
				validateCharacterNameButton,
				gameContent.LabelsProperties.getProperty("validateCharacterNameButton"),
				gameContent.LabelsProperties.getProperty("validateCharacterNameButtonToolTip"),
				new validateCharacterNameListener(),
				450,
				50);

		mainPage.buildButton(
				backButton,
				gameContent.LabelsProperties.getProperty("backButton"),
				gameContent.LabelsProperties.getProperty("backButtonToolTip"),
				new backButtonListener(),
				150,
				50);

		characterNamePanel.setLayout(new BoxLayout(characterNamePanel, BoxLayout.PAGE_AXIS));
		characterNamePanel.setBackground(Color.darkGray);

		characterNamePanel.add(Box.createRigidArea(new Dimension(0, 20)));
		characterNamePanel.add(selectRacePage.buildRaceImage(
				"/StaticContent/Images/" + gameContent.getSelectedRace() + ".jpg"));
		characterNamePanel.add(Box.createRigidArea(new Dimension(0,20)));
		characterNamePanel.add(selectRacePage.buildTextArea(
				gameContent.LabelsProperties.getProperty("characterNameQuestion"),
				selectRacePage.textFont,
				380,
				45));
		characterNamePanel.add(Box.createRigidArea(new Dimension(0, 20)));
		characterNamePanel.add(buildTextField(
				gameContent.LabelsProperties.getProperty("offered" + gameContent.getSelectedRace() + "CharacterName"),
				450,
				45));
		characterNamePanel.add(selectRacePage.buildTextArea(
				gameContent.LabelsProperties.getProperty("characterNameLengthHint"),
				smallTextFont,
				500,
				30));
		characterNamePanel.add(Box.createRigidArea(new Dimension(0, 20)));
		characterNamePanel.add(validateCharacterNameButton);
		characterNamePanel.add(Box.createVerticalGlue());
		characterNamePanel.add(backButton);
		characterNamePanel.add(Box.createRigidArea(new Dimension(0,60)));

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

		mainPage.buildButton(
				startGameButton,
				gameContent.LabelsProperties.getProperty("startGameButton"),
				gameContent.LabelsProperties.getProperty("startGameButtonToolTip"),
				new StartGameListener(),
				250,
				50);

		startGamePanel.setLayout(new BoxLayout(startGamePanel, BoxLayout.PAGE_AXIS));
		startGamePanel.setBackground(Color.darkGray);

		startGamePanel.add(Box.createVerticalGlue());
		startGamePanel.add(startGameButton);
		startGamePanel.add(Box.createRigidArea(new Dimension(0,60)));

		return startGamePanel;
	}

	private JTextField buildTextField(String text, int width, int height)
	{
		JTextField textField = new JTextField(text);

		textField.setFont(selectRacePage.textFont);
		textField.setBackground(Color.darkGray);
		textField.setForeground(Color.white);
		textField.setBorder(menuBar.border);
		textField.setCaretColor(Color.white);
		textField.setCaretPosition(textField.getText().length());
		textField.setAlignmentX(Component.CENTER_ALIGNMENT);
		textField.setMinimumSize(new Dimension(width, height));
		textField.setMaximumSize(new Dimension(width, height));
		textField.setPreferredSize(new Dimension(width, height));

		return textField;
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

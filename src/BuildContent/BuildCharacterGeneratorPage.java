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
		mainPanel.add(buildCharacterAttributePanel());
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
				120,
				50,
				new backButtonListener());

		otherFunctions.setPanelStyle(characterNamePanel, 3);

		characterNamePanel.add(Box.createRigidArea(new Dimension(0, 120)));
		characterNamePanel.add(otherFunctions.buildRaceImage(
				"/StaticContent/Images/" + otherFunctions.getSelectedRace() + ".jpg"));
		characterNamePanel.add(Box.createRigidArea(new Dimension(0, 20)));
		characterNamePanel.add(otherFunctions.buildTextArea(
				otherFunctions.getPropertyText("characterNameQuestion"),
				otherFunctions.bigFont,
				470,
				80));
		characterNamePanel.add(otherFunctions.buildTextField(
				otherFunctions.getPropertyText("offered" + otherFunctions.getSelectedRace() + "CharacterName"),
				true,
				370,
				45));
		characterNamePanel.add(otherFunctions.buildTextArea(
				otherFunctions.getPropertyText("characterNameLengthHint"),
				otherFunctions.smallFont,
				500,
				60));
		characterNamePanel.add(Box.createRigidArea(new Dimension(0, 20)));
		characterNamePanel.add(validateCharacterNameButton);
		characterNamePanel.add(Box.createVerticalGlue());
		characterNamePanel.add(backButton);
		characterNamePanel.add(Box.createRigidArea(new Dimension(0, 60)));

		return characterNamePanel;
	}

	private JPanel buildCharacterAttributePanel()
	{
		JPanel characterAttributePanel = new JPanel();

		otherFunctions.setPanelStyle(characterAttributePanel, 3);

		characterAttributePanel.add(Box.createRigidArea(new Dimension(0, 200)));
		characterAttributePanel.add(buildAvailableAttributePointsPanel());
		characterAttributePanel.add(Box.createRigidArea(new Dimension(0, 60)));
		characterAttributePanel.add(buildChangeAttributePanel(otherFunctions.getPropertyText("strength"), new DecreaseStrengthListener(), new IncreaseStrengthListener()));
		characterAttributePanel.add(Box.createRigidArea(new Dimension(0, 15)));
		characterAttributePanel.add(buildChangeAttributePanel(otherFunctions.getPropertyText("dexterity"), new DecreaseDexterityListener(), new IncreaseDexterityListener()));
		characterAttributePanel.add(Box.createRigidArea(new Dimension(0, 15)));
		characterAttributePanel.add(buildChangeAttributePanel(otherFunctions.getPropertyText("agility"), new DecreaseAgilityListener(), new IncreaseAgilityListener()));
		characterAttributePanel.add(Box.createRigidArea(new Dimension(0, 15)));
		characterAttributePanel.add(buildChangeAttributePanel(otherFunctions.getPropertyText("intelligent"), new DecreaseIntelligentListener(), new IncreaseIntelligentListener()));
		characterAttributePanel.add(Box.createRigidArea(new Dimension(0, 15)));
		characterAttributePanel.add(buildChangeAttributePanel(otherFunctions.getPropertyText("vitality"), new DecreaseVitalityListener(), new IncreaseVitalityListener()));

		return characterAttributePanel;
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
				300,
				100,
				new StartGameListener());

		otherFunctions.setPanelStyle(startGamePanel, 3);
		//startGamePanel.setBackground(Color.green);

		startGamePanel.add(Box.createRigidArea(new Dimension(0, 120)));
		startGamePanel.add(buildStatPanel("hitPoints"));
		startGamePanel.add(Box.createRigidArea(new Dimension(0, 10)));
		startGamePanel.add(buildStatPanel("meleeDamage"));
		startGamePanel.add(Box.createRigidArea(new Dimension(0, 10)));
		startGamePanel.add(buildStatPanel("rangedDamage"));
		startGamePanel.add(Box.createRigidArea(new Dimension(0, 10)));
		startGamePanel.add(buildStatPanel("magicDamage"));
		startGamePanel.add(Box.createRigidArea(new Dimension(0, 10)));
		startGamePanel.add(buildStatPanel("physicalDefense"));
		startGamePanel.add(Box.createRigidArea(new Dimension(0, 10)));
		startGamePanel.add(buildStatPanel("magicDefense"));
		startGamePanel.add(Box.createRigidArea(new Dimension(0, 10)));
		startGamePanel.add(buildStatPanel("accuracy"));
		startGamePanel.add(Box.createRigidArea(new Dimension(0, 10)));
		startGamePanel.add(buildStatPanel("evasion"));

		startGamePanel.add(Box.createVerticalGlue());
		startGamePanel.add(startGameButton);
		startGamePanel.add(Box.createRigidArea(new Dimension(0, 60)));

		return startGamePanel;
	}

	private JPanel buildAvailableAttributePointsPanel()
	{
		JPanel panel = new JPanel();

		otherFunctions.setPanelStyle(panel, 2);

		panel.add(otherFunctions.buildTextArea(
				otherFunctions.getPropertyText("availableAttributePoints"),
				otherFunctions.bigFont,
				410,
				40));
		panel.add(otherFunctions.buildTextArea(
				"15",
				otherFunctions.bigFont,
				40,
				40));

		return panel;
	}

	private JPanel buildChangeAttributePanel(
			String attributeName,
			ActionListener decreaseListener,
			ActionListener increaseListener)
	{
		JPanel panel = new JPanel();
		JTextArea attributeNameTextArea;
		JTextArea attributeValueTextArea;
		JButton decreaseButton = new JButton();
		JButton increaseButton = new JButton();

		attributeNameTextArea = otherFunctions.buildTextArea(attributeName, otherFunctions.bigFont, 200, 40);
		attributeNameTextArea.setToolTipText(otherFunctions.getPropertyText(attributeName.toLowerCase() + "ToolTip"));

		otherFunctions.buildButton(
				decreaseButton,
				otherFunctions.getPropertyText("decreaseButton"),
				otherFunctions.getPropertyText("decreaseButtonToolTip"),
				otherFunctions.bigFont,
				60,
				40,
				decreaseListener);

		otherFunctions.buildButton(
				increaseButton,
				otherFunctions.getPropertyText("increaseButton"),
				otherFunctions.getPropertyText("increaseButtonToolTip"),
				otherFunctions.bigFont,
				60,
				40,
				increaseListener);

		attributeValueTextArea = otherFunctions.buildTextArea("6", otherFunctions.bigFont, 30, 40);
		attributeValueTextArea.setToolTipText(otherFunctions.getPropertyText("attributeValueToolTip"));

		otherFunctions.setPanelStyle(panel, 2);

		panel.add(attributeNameTextArea);
		panel.add(decreaseButton);
		panel.add(Box.createRigidArea(new Dimension(20, 0)));
		panel.add(attributeValueTextArea);
		panel.add(Box.createRigidArea(new Dimension(15, 0)));
		panel.add(increaseButton);

		return panel;
	}

	private JPanel buildStatPanel(String statName)
	{
		JPanel statPanel = new JPanel();
		JTextArea statNameTextArea;
		JTextArea statValueTextArea;

		statNameTextArea = otherFunctions.buildTextArea(otherFunctions.getPropertyText(statName) + ":", otherFunctions.bigFont, 270, 40);
		System.out.println((statName + "ToolTip"));
		statNameTextArea.setToolTipText("Current amount of the " + otherFunctions.getPropertyText(statName));

		statValueTextArea = otherFunctions.buildTextArea("10", otherFunctions.bigFont, 30, 40);
		statValueTextArea.setToolTipText(otherFunctions.getPropertyText("statValueToolTip"));

		otherFunctions.setPanelStyle(statPanel, 2);
		statPanel.add(statNameTextArea);
		statPanel.add(statValueTextArea);

		return statPanel;
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

	private class DecreaseStrengthListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}

	private class IncreaseStrengthListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}

	private class DecreaseDexterityListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}

	private class IncreaseDexterityListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}

	private class DecreaseAgilityListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}

	private class IncreaseAgilityListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}

	private class DecreaseIntelligentListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}

	private class IncreaseIntelligentListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}

	private class DecreaseVitalityListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}

	private class IncreaseVitalityListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}

	private class StartGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}
}

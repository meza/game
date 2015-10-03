package BuildContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

class BuildCharacterGeneratorPage
{
	private static final OtherFunctions otherFunctions = new OtherFunctions();
	private static final BuildGameContent gameContent = new BuildGameContent();
	private static final HashMap<String, JTextArea> attributeTextAreaList = new HashMap<>();

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
		characterAttributePanel.add(buildChangeAttributePanel(
				otherFunctions.getPropertyText("strength"),
				new DecreaseStrengthListener(),
				new IncreaseStrengthListener()));
		characterAttributePanel.add(Box.createRigidArea(new Dimension(0, 15)));
		characterAttributePanel.add(buildChangeAttributePanel(
				otherFunctions.getPropertyText("dexterity"),
				new DecreaseDexterityListener(),
				new IncreaseDexterityListener()));
		characterAttributePanel.add(Box.createRigidArea(new Dimension(0, 15)));
		characterAttributePanel.add(buildChangeAttributePanel(
				otherFunctions.getPropertyText("intelligent"),
				new DecreaseIntelligentListener(),
				new IncreaseIntelligentListener()));
		characterAttributePanel.add(Box.createRigidArea(new Dimension(0, 15)));
		characterAttributePanel.add(buildChangeAttributePanel(
				otherFunctions.getPropertyText("agility"),
				new DecreaseAgilityListener(),
				new IncreaseAgilityListener()));
		characterAttributePanel.add(Box.createRigidArea(new Dimension(0, 15)));
		characterAttributePanel.add(buildChangeAttributePanel(
				otherFunctions.getPropertyText("vitality"),
				new DecreaseVitalityListener(),
				new IncreaseVitalityListener()));

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
		startGamePanel.add(buildStatPanel("attackSpeed"));
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
		JTextArea availableAttributePoints;
		String attributePoints = "6";

		otherFunctions.setPanelStyle(panel, 2);

		availableAttributePoints = otherFunctions.buildTextArea(
				attributePoints,
				otherFunctions.bigFont,
				40,
				40);

		panel.add(otherFunctions.buildTextArea(
				otherFunctions.getPropertyText("availableAttributePoints"),
				otherFunctions.bigFont,
				410,
				40));
		panel.add(availableAttributePoints);

		setTextAreaList("attributePoints", availableAttributePoints);

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
		int basicAttributeValue = 1;

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

		attributeValueTextArea = otherFunctions.buildTextArea(
				String.valueOf(basicAttributeValue),
				otherFunctions.bigFont,
				30,
				40);
		attributeValueTextArea.setToolTipText(otherFunctions.getPropertyText("attributeValueToolTip"));

		setTextAreaList(attributeName.toLowerCase(), attributeValueTextArea);

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
		String basicStatPoints = "1";

		statNameTextArea = otherFunctions.buildTextArea(
				otherFunctions.getPropertyText(statName) + ":",
				otherFunctions.bigFont,
				270,
				40);
		statNameTextArea.setToolTipText("Current amount of the " + otherFunctions.getPropertyText(statName));

		statValueTextArea = otherFunctions.buildTextArea(
				basicStatPoints,
				otherFunctions.bigFont,
				30,
				40);
		statValueTextArea.setToolTipText(otherFunctions.getPropertyText("statValueToolTip"));

		otherFunctions.setPanelStyle(statPanel, 2);
		statPanel.add(statNameTextArea);
		statPanel.add(statValueTextArea);

		setTextAreaList(statName, statValueTextArea);

		return statPanel;
	}

	private void setTextAreaList(String textAreaName, JTextArea textArea)
	{
		attributeTextAreaList.put(textAreaName, textArea);
	}

	private JTextArea getTextAreaList(String textAreaName)
	{
		return attributeTextAreaList.get(textAreaName);
	}

	private void decreaseAttributeValue(String attribute)
	{
		JTextArea valueTextArea = getTextAreaList(attribute);
		JTextArea attributeValueTextArea = getTextAreaList("attributePoints");
		int strengthValue = Integer.valueOf(valueTextArea.getText());
		int attributeValue = Integer.valueOf(attributeValueTextArea.getText());

		if ((strengthValue > 1))
		{
			valueTextArea.setText(String.valueOf(strengthValue - 1));
			attributeValueTextArea.setText(String.valueOf(attributeValue + 1));
		}
	}

	private void increaseAttributeValue(String attribute)
	{
		JTextArea valueTextArea = getTextAreaList(attribute);
		JTextArea attributeValueTextArea = getTextAreaList("attributePoints");
		int strengthValue = Integer.valueOf(valueTextArea.getText());
		int attributeValue = Integer.valueOf(attributeValueTextArea.getText());

		if ((attributeValue > 0))
		{
			valueTextArea.setText(String.valueOf(strengthValue + 1));
			attributeValueTextArea.setText(String.valueOf(attributeValue - 1));
		}

	}

	private void calculateStatValues()
	{
		JTextArea hitPointsValueTextArea = getTextAreaList("hitPoints");
		JTextArea meleeDamageValueTextArea = getTextAreaList("meleeDamage");
		JTextArea rangedDamageValueTextArea = getTextAreaList("rangedDamage");
		JTextArea magicDamageValueTextArea = getTextAreaList("magicDamage");
		JTextArea physicalDefenseValueTextArea = getTextAreaList("physicalDefense");
		JTextArea magicDefenseValueTextArea = getTextAreaList("magicDefense");
		JTextArea attackSpeedValueTextArea = getTextAreaList("attackSpeed");
		JTextArea accuracyValueTextArea = getTextAreaList("accuracy");
		JTextArea evasionValueTextArea = getTextAreaList("evasion");
		JTextArea strengthValueTextArea = getTextAreaList("strength");
		JTextArea dexterityValueTextArea = getTextAreaList("dexterity");
		JTextArea intelligentValueTextArea = getTextAreaList("intelligent");
		JTextArea agilityValueTextArea = getTextAreaList("agility");
		JTextArea vitalityValueTextArea = getTextAreaList("vitality");
		int strengthValue = Integer.valueOf(strengthValueTextArea.getText());
		int dexterityValue = Integer.valueOf(dexterityValueTextArea.getText());
		int intelligentValue = Integer.valueOf(intelligentValueTextArea.getText());
		int agilityValue = Integer.valueOf(agilityValueTextArea.getText());
		int vitalityValue = Integer.valueOf(vitalityValueTextArea.getText());

		hitPointsValueTextArea.setText(String.valueOf(strengthValue + (2 * vitalityValue)));
		meleeDamageValueTextArea.setText(String.valueOf(2 * strengthValue));
		rangedDamageValueTextArea.setText(String.valueOf(2 * dexterityValue));
		magicDamageValueTextArea.setText(String.valueOf(2 * intelligentValue));
		physicalDefenseValueTextArea.setText(String.valueOf(vitalityValue));
		magicDefenseValueTextArea.setText(String.valueOf(intelligentValue));
		attackSpeedValueTextArea.setText(String.valueOf(2 * agilityValue));
		accuracyValueTextArea.setText(String.valueOf(dexterityValue));
		evasionValueTextArea.setText(String.valueOf(agilityValue));
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
			decreaseAttributeValue("strength");
			calculateStatValues();
		}
	}

	private class IncreaseStrengthListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			increaseAttributeValue("strength");
			calculateStatValues();
		}
	}

	private class DecreaseDexterityListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			decreaseAttributeValue("dexterity");
			calculateStatValues();
		}
	}

	private class IncreaseDexterityListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			increaseAttributeValue("dexterity");
			calculateStatValues();
		}
	}

	private class DecreaseAgilityListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			decreaseAttributeValue("agility");
			calculateStatValues();
		}
	}

	private class IncreaseAgilityListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			increaseAttributeValue("agility");
			calculateStatValues();
		}
	}

	private class DecreaseIntelligentListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			decreaseAttributeValue("intelligent");
			calculateStatValues();
		}
	}

	private class IncreaseIntelligentListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			increaseAttributeValue("intelligent");
			calculateStatValues();
		}
	}

	private class DecreaseVitalityListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			decreaseAttributeValue("vitality");
			calculateStatValues();
		}
	}

	private class IncreaseVitalityListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			increaseAttributeValue("vitality");
			calculateStatValues();
		}
	}

	private class StartGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int attributeValue = Integer.valueOf(getTextAreaList("attributePoints").getText());

			if ((attributeValue > 0))
			{
				JOptionPane.showMessageDialog(
						null,
						otherFunctions.getPropertyText("startGamePopUpContent"),
						otherFunctions.getPropertyText("startGamePopUpTitle"),
						JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				System.out.println("start");
			}
		}
	}
}

package BuildContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BuildCharacterGeneratorPage
{
	private static final OtherFunctions otherFunctions = new OtherFunctions();
	private static final BuildGameContent gameContent = new BuildGameContent();
	static JTextField nameField = new JTextField();

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

		otherFunctions.setPanelStyle(characterNamePanel, 3);

		nameField = otherFunctions.buildTextField(
						otherFunctions.getPropertyText("offered" + otherFunctions.getSelectedRace() + "CharacterName"),
						true,
						370,
						45);

		characterNamePanel.add(Box.createRigidArea(new Dimension(0, 120)));
		characterNamePanel.add(otherFunctions.buildRaceImage(
			                       "/StaticContent/Images/" + otherFunctions.getSelectedRace() + ".jpg"));
		characterNamePanel.add(Box.createRigidArea(new Dimension(0, 20)));
		characterNamePanel.add(otherFunctions.buildTextArea(
			                       otherFunctions.getPropertyText("characterNameQuestion"),
			                       otherFunctions.bigFont,
			                       470,
			                       80));
		characterNamePanel.add(nameField);
		characterNamePanel.add(otherFunctions.buildTextArea(
			                       otherFunctions.getPropertyText("characterNameLengthHint"),
			                       otherFunctions.smallFont,
			                       500,
			                       60));
		characterNamePanel.add(Box.createRigidArea(new Dimension(0, 20)));
		characterNamePanel.add(otherFunctions.buildButton(
			                       otherFunctions.getPropertyText("validateCharacterNameButton"),
			                       otherFunctions.getPropertyText("validateCharacterNameButtonToolTip"),
			                       otherFunctions.mediumFont,
			                       350,
			                       50,
			                       new validateCharacterNameListener()));
		characterNamePanel.add(Box.createVerticalGlue());
		characterNamePanel.add(otherFunctions.buildButton(
			                       otherFunctions.getPropertyText("backButton"),
			                       otherFunctions.getPropertyText("backButtonToolTip"),
			                       otherFunctions.bigFont,
			                       120,
			                       50,
			                       new backButtonListener()));
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
		startGamePanel.add(otherFunctions.buildButton(
			                   otherFunctions.getPropertyText("startGameButton"),
			                   otherFunctions.getPropertyText("startGameButtonToolTip"),
			                   otherFunctions.bigFont,
			                   300,
			                   100,
			                   new StartGameListener()));
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

		otherFunctions.setTextAreaList("attributePoints", availableAttributePoints);

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
		int basicAttributeValue = 1;

		attributeNameTextArea = otherFunctions.buildTextArea(
									attributeName,
									otherFunctions.bigFont,
									200,
									40);
		attributeValueTextArea = otherFunctions.buildTextArea(
									String.valueOf(basicAttributeValue),
									otherFunctions.bigFont,
									30,
									40);
		attributeNameTextArea.setToolTipText(otherFunctions.getPropertyText(attributeName.toLowerCase() + "ToolTip"));
		attributeValueTextArea.setToolTipText(otherFunctions.getPropertyText("attributeValueToolTip"));

		otherFunctions.setTextAreaList(attributeName.toLowerCase(), attributeValueTextArea);
		otherFunctions.setPanelStyle(panel, 2);

		panel.add(attributeNameTextArea);
		panel.add(otherFunctions.buildButton(
			          otherFunctions.getPropertyText("decreaseButton"),
			          otherFunctions.getPropertyText("decreaseButtonToolTip"),
			          otherFunctions.bigFont,
			          60,
			          40,
			          decreaseListener));
		panel.add(Box.createRigidArea(new Dimension(20, 0)));
		panel.add(attributeValueTextArea);
		panel.add(Box.createRigidArea(new Dimension(15, 0)));
		panel.add(otherFunctions.buildButton(
			          otherFunctions.getPropertyText("increaseButton"),
			          otherFunctions.getPropertyText("increaseButtonToolTip"),
			          otherFunctions.bigFont,
			          60,
			          40,
			          increaseListener));

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
		statValueTextArea = otherFunctions.buildTextArea(
								basicStatPoints,
								otherFunctions.bigFont,
								30,
								40);
		statNameTextArea.setToolTipText("Current amount of the " + otherFunctions.getPropertyText(statName));
		statValueTextArea.setToolTipText(otherFunctions.getPropertyText("statValueToolTip"));

		otherFunctions.setTextAreaList(
			statName,
			statValueTextArea);
		otherFunctions.setPanelStyle(
			statPanel,
			2);

		statPanel.add(statNameTextArea);
		statPanel.add(statValueTextArea);

		return statPanel;
	}

	private void decreaseAttributeValue(String attribute)
	{
		JTextArea attributeValueTextArea = otherFunctions.getTextAreaList(attribute);
		JTextArea availableAttributeValueTextArea = otherFunctions.getTextAreaList("attributePoints");
		int attributeValue = Integer.valueOf(attributeValueTextArea.getText());
		int availableAttributeValue = Integer.valueOf(availableAttributeValueTextArea.getText());

		if ((attributeValue > 1))
		{
			attributeValueTextArea.setText(String.valueOf(attributeValue - 1));
			availableAttributeValueTextArea.setText(String.valueOf(availableAttributeValue + 1));
		}
	}

	private void increaseAttributeValue(String attribute)
	{
		JTextArea attributeValueTextArea = otherFunctions.getTextAreaList(attribute);
		JTextArea availableAttributeValueTextArea = otherFunctions.getTextAreaList("attributePoints");
		int attributeValue = Integer.valueOf(attributeValueTextArea.getText());
		int availableAttributeValue = Integer.valueOf(availableAttributeValueTextArea.getText());

		if ((availableAttributeValue > 0))
		{
			attributeValueTextArea.setText(String.valueOf(attributeValue + 1));
			availableAttributeValueTextArea.setText(String.valueOf(availableAttributeValue - 1));
		}

	}

	private void calculateStatValues()
	{
		JTextArea hitPointsValueTextArea = otherFunctions.getTextAreaList("hitPoints");
		JTextArea meleeDamageValueTextArea = otherFunctions.getTextAreaList("meleeDamage");
		JTextArea rangedDamageValueTextArea = otherFunctions.getTextAreaList("rangedDamage");
		JTextArea magicDamageValueTextArea = otherFunctions.getTextAreaList("magicDamage");
		JTextArea physicalDefenseValueTextArea = otherFunctions.getTextAreaList("physicalDefense");
		JTextArea magicDefenseValueTextArea = otherFunctions.getTextAreaList("magicDefense");
		JTextArea attackSpeedValueTextArea = otherFunctions.getTextAreaList("attackSpeed");
		JTextArea accuracyValueTextArea = otherFunctions.getTextAreaList("accuracy");
		JTextArea evasionValueTextArea = otherFunctions.getTextAreaList("evasion");
		JTextArea strengthValueTextArea = otherFunctions.getTextAreaList("strength");
		JTextArea dexterityValueTextArea = otherFunctions.getTextAreaList("dexterity");
		JTextArea intelligentValueTextArea = otherFunctions.getTextAreaList("intelligent");
		JTextArea agilityValueTextArea = otherFunctions.getTextAreaList("agility");
		JTextArea vitalityValueTextArea = otherFunctions.getTextAreaList("vitality");
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
			int attributeValue = Integer.valueOf(otherFunctions.getTextAreaList("attributePoints").getText());

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

			}
		}
	}
}

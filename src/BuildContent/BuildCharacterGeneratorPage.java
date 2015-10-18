package BuildContent;

import BuildContent.Listeners.ListenerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class BuildCharacterGeneratorPage implements FocusListener
{
	private static final OtherFunctions otherFunctions = new OtherFunctions();
	private static final BuildGameContent gameContent = new BuildGameContent();
    private final ListenerFactory listenerBuilder = new ListenerFactory(new ValueModifier(otherFunctions));

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

		OtherFunctions.nameField = otherFunctions.buildTextField(
						otherFunctions.getPropertyText("offered" + otherFunctions.getSelectedRace() + "CharacterName"),
						true,
						370,
						45);
		OtherFunctions.nameField.addFocusListener(this);

		characterNamePanel.add(Box.createRigidArea(new Dimension(0, 120)));
		characterNamePanel.add(otherFunctions.buildRaceImage(
			                       "/StaticContent/Images/" + otherFunctions.getSelectedRace() + ".jpg"));
		characterNamePanel.add(Box.createRigidArea(new Dimension(0, 20)));
		characterNamePanel.add(otherFunctions.buildTextArea(
			                       otherFunctions.getPropertyText("characterNameQuestion"),
			                       otherFunctions.bigFont,
			                       470,
			                       80));
		characterNamePanel.add(OtherFunctions.nameField);
		characterNamePanel.add(otherFunctions.buildTextArea(
			                       otherFunctions.getPropertyText("characterNameLengthHint"),
			                       otherFunctions.smallFont,
			                       500,
			                       60));
		characterNamePanel.add(Box.createRigidArea(new Dimension(0, 20)));
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

    private void addListeners(JPanel panel, String attribute) {
        panel.add(buildChangeAttributePanel(
                otherFunctions.getPropertyText(attribute),
                listenerBuilder.decreaserFor(attribute),
                listenerBuilder.increaserFor(attribute)));
    }

	private JPanel buildCharacterAttributePanel()
	{
		JPanel characterAttributePanel = new JPanel();

		otherFunctions.setPanelStyle(characterAttributePanel, 3);

		characterAttributePanel.add(Box.createRigidArea(new Dimension(0, 200)));
		characterAttributePanel.add(buildAvailableAttributePointsPanel());
		characterAttributePanel.add(Box.createRigidArea(new Dimension(0, 60)));
        addListeners(characterAttributePanel, "strength");
		characterAttributePanel.add(Box.createRigidArea(new Dimension(0, 15)));
        addListeners(characterAttributePanel, "dexterity");
		characterAttributePanel.add(Box.createRigidArea(new Dimension(0, 15)));
        addListeners(characterAttributePanel, "intelligent");
		characterAttributePanel.add(Box.createRigidArea(new Dimension(0, 15)));
        addListeners(characterAttributePanel, "agility");
		characterAttributePanel.add(Box.createRigidArea(new Dimension(0, 15)));
        addListeners(characterAttributePanel, "vitality");
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

	@Override
	public void focusGained(FocusEvent e)
	{

	}

	@Override
	public void focusLost(FocusEvent e)
	{
		otherFunctions.validateCharacterName();
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

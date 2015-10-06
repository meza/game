package BuildContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BuildSelectRacePage
{
	private static final OtherFunctions otherFunctions = new OtherFunctions();
	private static final BuildGameContent gameContent = new BuildGameContent();

	JPanel buildSelectRacePage()
	{
		JPanel mainPanel = new JPanel(new GridLayout(1, 3));
		JPanel dwarfPanel;

		dwarfPanel = buildRacePanel("Dwarf", new DwarfSelectedListener());
		dwarfPanel.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.white));

		mainPanel.add(buildRacePanel("Vampire", new VampireSelectedListener()));
		mainPanel.add(dwarfPanel);
		mainPanel.add(buildRacePanel("Elf", new ElfSelectedListener()));

		return mainPanel;
	}

	private JPanel buildRacePanel(String race, ActionListener listener)
	{
		JPanel panel = new JPanel();

		otherFunctions.setPanelStyle(panel, 3);

		addItemsToTheRaceSelectorPanel(
			panel,
			otherFunctions.buildRaceImage("/StaticContent/Images/" + race + ".jpg"),
			otherFunctions.buildTextArea(
				otherFunctions.getPropertyText(race.toLowerCase() + "RaceDescription"),
				otherFunctions.mediumFont,
				400,
				250),
			otherFunctions.buildButton(
				otherFunctions.getPropertyText("select" + race + "Button"),
				otherFunctions.getPropertyText("select" + race + "ButtonToolTip"),
				otherFunctions.bigFont,
				300,
				50,
				listener));

		return panel;
	}

	private void addItemsToTheRaceSelectorPanel(JPanel panel, JLabel label, JTextArea description, JButton button)
	{
		panel.add(Box.createRigidArea(new Dimension(0, 100)));
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(0, 70)));
		panel.add(description);
		panel.add(Box.createRigidArea(new Dimension(0, 70)));
		panel.add(button);
	}

	private class VampireSelectedListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			otherFunctions.setSelectedRace("Vampire");
			gameContent.addCharacterGeneratorPageToTheMainFrame();
		}
	}

	private class DwarfSelectedListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			otherFunctions.setSelectedRace("Dwarf");
			gameContent.addCharacterGeneratorPageToTheMainFrame();
		}
	}

	private class ElfSelectedListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			otherFunctions.setSelectedRace("Elf");
			gameContent.addCharacterGeneratorPageToTheMainFrame();
		}
	}
}

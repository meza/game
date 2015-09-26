package BuildContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BuildSelectRacePage
{
	private final OtherFunctions otherFunctions = new OtherFunctions();
	private final BuildGameContent gameContent = new BuildGameContent();

	JPanel buildSelectRacePage()
	{
		JPanel mainPanel = new JPanel(new GridLayout(1, 3));
		JPanel vampirePanel = new JPanel();
		JPanel dwarfPanel = new JPanel();
		JPanel elfPanel = new JPanel();

		buildRacePanel(
				vampirePanel,
				"/StaticContent/Images/Vampire.jpg",
				otherFunctions.getPropertyText("vampireRaceDescription"),
				otherFunctions.getPropertyText("selectVampireButton"),
				otherFunctions.getPropertyText("selectVampireButtonToolTip"),
				new VampireSelectedListener());

		buildRacePanel(
				dwarfPanel,
				"/StaticContent/Images/Dwarf.jpg",
				otherFunctions.getPropertyText("dwarfRaceDescription"),
				otherFunctions.getPropertyText("selectDwarfButton"),
				otherFunctions.getPropertyText("selectDwarfButtonToolTip"),
				new DwarfSelectedListener());

		buildRacePanel(
				elfPanel,
				"/StaticContent/Images/Elf.jpg",
				otherFunctions.getPropertyText("elfRaceDescription"),
				otherFunctions.getPropertyText("selectElfButton"),
				otherFunctions.getPropertyText("selectElfButtonToolTip"),
				new ElfSelectedListener());

		dwarfPanel.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.white));

		mainPanel.add(vampirePanel);
		mainPanel.add(dwarfPanel);
		mainPanel.add(elfPanel);

		return mainPanel;
	}

	private void buildRacePanel(
			JPanel panel,
			String imageLocation,
			String raceDescription,
			String buttonText,
			String buttonToolTipText,
			ActionListener listener)
	{
		JButton button = new JButton();

		otherFunctions.buildButton(button, buttonText, buttonToolTipText, listener, 250, 50);
		otherFunctions.setPanelStyle(panel);

		addItemsToTheRaceSelectorPanel(
				panel,
				otherFunctions.buildRaceImage(imageLocation),
				otherFunctions.buildTextArea(raceDescription, otherFunctions.mediumFont, 400, 250),
				button);
	}

	private void addItemsToTheRaceSelectorPanel(JPanel panel, JLabel label, JTextArea description, JButton button)
	{
		panel.add(Box.createRigidArea(new Dimension(0, 30)));
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

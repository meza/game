package BuildContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

class BuildSelectRacePage
{
	private final BuildGameContent buildGameContent = new BuildGameContent();
	private final BuildMainPage buildMainPage = new BuildMainPage();
	private final Font textFont = new Font("Monospaced", Font.BOLD, 20);

	JPanel buildSelectRacePage()
	{
		JPanel mainPanel = new JPanel(new GridLayout(1, 3));
		JPanel vampirePanel = new JPanel();
		JPanel dwarfPanel = new JPanel();
		JPanel elfPanel = new JPanel();

		buildRacePanel(
				vampirePanel,
				"/StaticContent/Images/Vampire.jpg",
				buildGameContent.LabelsProperties.getProperty("vampireRaceDescription"),
				buildGameContent.LabelsProperties.getProperty("selectVampireButtonText"),
				buildGameContent.LabelsProperties.getProperty("selectVampireButtonToolTipText"),
				new VampireSelectedListener());

		buildRacePanel(
				dwarfPanel,
				"/StaticContent/Images/Dwarf.jpg",
				buildGameContent.LabelsProperties.getProperty("dwarfRaceDescription"),
				buildGameContent.LabelsProperties.getProperty("selectDwarfButtonText"),
				buildGameContent.LabelsProperties.getProperty("selectDwarfButtonToolTipText"),
				new DwarfSelectedListener());

		buildRacePanel(
				elfPanel,
				"/StaticContent/Images/Elf.jpg",
				buildGameContent.LabelsProperties.getProperty("elfRaceDescription"),
				buildGameContent.LabelsProperties.getProperty("selectElfButtonText"),
				buildGameContent.LabelsProperties.getProperty("selectElfButtonToolTipText"),
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
		JLabel iconLabel;
		ImageIcon icon;
		JTextArea infoArea = new JTextArea();
		JButton button = new JButton();

		icon = createImageIcon(imageLocation);
		iconLabel = new JLabel(icon);
		iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		setRaceDescriptionStyle(infoArea, raceDescription);

		buildMainPage.buildButton(
				button,
				buttonText,
				buttonToolTipText,
				listener);

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBackground(Color.darkGray);

		addItemsToRaceSelectorPanel(panel, iconLabel, infoArea, button);
	}

	private ImageIcon createImageIcon(String path)
	{
		URL imgURL = BuildSelectRacePage.class.getResource(path);
		return new ImageIcon(imgURL);
	}

	private void setRaceDescriptionStyle(JTextArea textArea, String description)
	{
		textArea.setText(description);
		textArea.setFont(textFont);
		textArea.setBackground(Color.darkGray);
		textArea.setForeground(Color.white);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setMinimumSize(new Dimension(200, 200));
		textArea.setMaximumSize(new Dimension(400, 250));
		textArea.setPreferredSize(new Dimension(300, 250));
	}

	private void addItemsToRaceSelectorPanel(JPanel panel, JLabel label, JTextArea description, JButton button)
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
			buildGameContent.setSelectedRace("Vampire");
			buildGameContent.addCharacterGeneratorPageToTheMainFrame();
		}
	}

	private class DwarfSelectedListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			buildGameContent.setSelectedRace("Dwarf");
			buildGameContent.addCharacterGeneratorPageToTheMainFrame();
		}
	}

	private class ElfSelectedListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			buildGameContent.setSelectedRace("Elf");
			buildGameContent.addCharacterGeneratorPageToTheMainFrame();
		}
	}
}

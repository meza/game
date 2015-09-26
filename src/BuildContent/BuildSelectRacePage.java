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
	final Font textFont = new Font("Monospaced", Font.BOLD, 20);

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
				buildGameContent.LabelsProperties.getProperty("selectVampireButton"),
				buildGameContent.LabelsProperties.getProperty("selectVampireButtonToolTip"),
				new VampireSelectedListener());

		buildRacePanel(
				dwarfPanel,
				"/StaticContent/Images/Dwarf.jpg",
				buildGameContent.LabelsProperties.getProperty("dwarfRaceDescription"),
				buildGameContent.LabelsProperties.getProperty("selectDwarfButton"),
				buildGameContent.LabelsProperties.getProperty("selectDwarfButtonToolTip"),
				new DwarfSelectedListener());

		buildRacePanel(
				elfPanel,
				"/StaticContent/Images/Elf.jpg",
				buildGameContent.LabelsProperties.getProperty("elfRaceDescription"),
				buildGameContent.LabelsProperties.getProperty("selectElfButton"),
				buildGameContent.LabelsProperties.getProperty("selectElfButtonToolTip"),
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

		buildMainPage.buildButton(button, buttonText, buttonToolTipText, listener, 250, 50);

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBackground(Color.darkGray);

		addItemsToRaceSelectorPanel(
				panel,
				buildRaceImage(imageLocation),
				buildTextArea(raceDescription, textFont, 400, 250),
				button);
	}

	 JLabel buildRaceImage(String imageLocation)
	{
		JLabel iconLabel;
		ImageIcon icon;

		icon = createImageIcon(imageLocation);
		iconLabel = new JLabel(icon);
		iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		return iconLabel;
	}

	private ImageIcon createImageIcon(String path)
	{
		URL imgURL = BuildSelectRacePage.class.getResource(path);
		return new ImageIcon(imgURL);
	}

	JTextArea buildTextArea(String text, Font font, int width, int height)
	{
		JTextArea infoArea = new JTextArea(text);

		infoArea.setFont(font);
		infoArea.setBackground(Color.darkGray);
		infoArea.setForeground(Color.white);
		infoArea.setLineWrap(true);
		infoArea.setWrapStyleWord(true);
		infoArea.setEditable(false);
		infoArea.setMinimumSize(new Dimension(width, height));
		infoArea.setMaximumSize(new Dimension(width, height));
		infoArea.setPreferredSize(new Dimension(width, height));

		return infoArea;
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

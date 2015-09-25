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
		JLabel vampireIconLabel;
		JLabel dwarfIconLabel;
		JLabel elfIconLabel;
		ImageIcon vampireIcon;
		ImageIcon dwarfIcon;
		ImageIcon elfIcon;
		JTextArea vampireInfo = new JTextArea();
		JTextArea dwarfInfo = new JTextArea();
		JTextArea elfInfo = new JTextArea();
		String vampireText = buildGameContent.LabelsProperties.getProperty("vampireRaceDescription");
		String dwarfText = buildGameContent.LabelsProperties.getProperty("dwarfRaceDescription");
		String elfText = buildGameContent.LabelsProperties.getProperty("elfRaceDescription");
		JButton selectVampireButton = new JButton(buildGameContent.LabelsProperties.getProperty("selectVampireButtonText"));
		JButton selectDwarfButton = new JButton(buildGameContent.LabelsProperties.getProperty("selectDwarfButtonText"));
		JButton selectElfButton = new JButton(buildGameContent.LabelsProperties.getProperty("selectElfButtonText"));

		//create the race icons
		vampireIcon = createImageIcon("/StaticContent/Images/vampire.jpg");
		dwarfIcon = createImageIcon("/StaticContent/Images/dwarf.jpg");
		elfIcon = createImageIcon("/StaticContent/Images/elf.jpg");

		//add the icons to the labels
		vampireIconLabel = new JLabel(vampireIcon);
		dwarfIconLabel = new JLabel(dwarfIcon);
		elfIconLabel = new JLabel(elfIcon);

		//set the icons alignment to center
		vampireIconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		dwarfIconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		elfIconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		//format the race descriptions
		setRaceDescriptionStyle(vampireInfo, vampireText);
		setRaceDescriptionStyle(dwarfInfo, dwarfText);
		setRaceDescriptionStyle(elfInfo, elfText);

		//format the race selector buttons
//		buildMainPage.setButtonStyle(selectVampireButton);
		selectVampireButton.setAlignmentX(Component.CENTER_ALIGNMENT);

//		buildMainPage.setButtonStyle(selectDwarfButton);
		selectDwarfButton.setAlignmentX(Component.CENTER_ALIGNMENT);

//		buildMainPage.setButtonStyle(selectElfButton);
		selectElfButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		//add tooltips to the buttons
		selectVampireButton.setToolTipText(buildGameContent.LabelsProperties.getProperty("selectVampireButtonToolTipText"));
		selectDwarfButton.setToolTipText(buildGameContent.LabelsProperties.getProperty("selectDwarfButtonToolTipText"));
		selectElfButton.setToolTipText(buildGameContent.LabelsProperties.getProperty("selectElfButtonToolTipText"));

		//add action listeners to the buttons
		selectVampireButton.addActionListener(new VampireSelectedListener());
		selectDwarfButton.addActionListener(new DwarfSelectedListener());
		selectElfButton.addActionListener(new ElfSelectedListener());

		//set panels layout
		vampirePanel.setLayout(new BoxLayout(vampirePanel, BoxLayout.PAGE_AXIS));
		dwarfPanel.setLayout(new BoxLayout(dwarfPanel, BoxLayout.PAGE_AXIS));
		elfPanel.setLayout(new BoxLayout(elfPanel, BoxLayout.PAGE_AXIS));

		//format the panels
		vampirePanel.setBackground(Color.darkGray);

		dwarfPanel.setBackground(Color.darkGray);
		dwarfPanel.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.white));

		elfPanel.setBackground(Color.darkGray);

		//add content to the panels
		addItemsToRaceSelectorPanel(vampirePanel, vampireIconLabel, vampireInfo, selectVampireButton);
		addItemsToRaceSelectorPanel(dwarfPanel, dwarfIconLabel, dwarfInfo, selectDwarfButton);
		addItemsToRaceSelectorPanel(elfPanel, elfIconLabel, elfInfo, selectElfButton);

		//add the panels to the main panel
		mainPanel.add(vampirePanel);
		mainPanel.add(dwarfPanel);
		mainPanel.add(elfPanel);

		return mainPanel;
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

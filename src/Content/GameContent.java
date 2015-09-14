package Content;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Properties;

public class GameContent
{
	final Properties LabelsProperties = new Properties();
	private final JFrame mainFrame = new JFrame();
	final Border border = new LineBorder(Color.WHITE, 2, true);
	private final Font textFont = new Font("Monospaced", Font.BOLD, 20);
	private final Font buttonFont = new Font("Monospaced", Font.BOLD, 25);
	private String selectedRace;

	public GameContent()
	{
		loadProperties();
	}

	private void loadProperties()
	{
		try
		{
			LabelsProperties.load(new FileInputStream("src/StaticContent/Properties/Labels.properties"));
		}
		catch (IOException e)
		{
			System.out.println("Exception Occurred: " + e.getMessage());
		}
	}

	public void buildMainFrame()
	{
		BuildMenuBar menuBar = new BuildMenuBar();

		mainFrame.setTitle(LabelsProperties.getProperty("mainFrameTitle"));
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setSize(1200, 800);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setVisible(true);
		mainFrame.setJMenuBar(menuBar.buildMenuBar());
		mainFrame.validate();
	}

	public void addMainPageToTheMainFrame()
	{
		mainFrame.getContentPane().add(BorderLayout.CENTER, buildMainPage());
		mainFrame.validate();
	}

	private JPanel buildMainPage()
	{
		JPanel mainPanel = new JPanel(new GridLayout(2, 1));
		JPanel startPanel = new JPanel();
		JPanel emptyPanel = new JPanel();
		JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
		JButton newGameButton = new JButton(LabelsProperties.getProperty("newGameButtonText"));
		JButton loadGameButton = new JButton(LabelsProperties.getProperty("loadGameButtonText"));

		//format the buttons
		setButtonStyle(newGameButton);
		setButtonStyle(loadGameButton);

		//add tooltips to the buttons
		newGameButton.setToolTipText(LabelsProperties.getProperty("newGameButtonToolTipText"));
		loadGameButton.setToolTipText(LabelsProperties.getProperty("loadGameButtonToolTipText"));

		//add the buttons to the panel
		buttonsPanel.add(newGameButton);
		buttonsPanel.add(loadGameButton);

		//format the panels
		emptyPanel.setBackground(Color.darkGray);

		buttonsPanel.setBackground(Color.darkGray);
		buttonsPanel.setPreferredSize(new Dimension(200, 100));

		startPanel.setBackground(Color.darkGray);

		//add panel to set the buttons size
		startPanel.add(buttonsPanel);

		//add action listeners to the buttons
		newGameButton.addActionListener(new NewGameListener());
		loadGameButton.addActionListener(new LoadGameListener());

		//add the panels to the main panel
		mainPanel.add(emptyPanel);
		mainPanel.add(startPanel);

		return mainPanel;
	}

	private void setButtonStyle(JButton button)
	{
		button.setBackground(Color.darkGray);
		button.setForeground(Color.white);
		button.setFont(buttonFont);
		button.setBorder(border);
	}

	private class NewGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			mainFrame.getContentPane().removeAll();
			mainFrame.repaint();
			mainFrame.setTitle(LabelsProperties.getProperty("mainFrameTitleSelectRacePage"));
			mainFrame.getContentPane().add(buildSelectRacePage());
			mainFrame.validate();
		}
	}

	private JPanel buildSelectRacePage()
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
		String vampireText = LabelsProperties.getProperty("vampireRaceDescription");
		String dwarfText = LabelsProperties.getProperty("dwarfRaceDescription");
		String elfText = LabelsProperties.getProperty("elfRaceDescription");
		JButton selectVampireButton = new JButton(LabelsProperties.getProperty("selectVampireButtonText"));
		JButton selectDwarfButton = new JButton(LabelsProperties.getProperty("selectDwarfButtonText"));
		JButton selectElfButton = new JButton(LabelsProperties.getProperty("selectElfButtonText"));

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
		setButtonStyle(selectVampireButton);
		selectVampireButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		setButtonStyle(selectDwarfButton);
		selectDwarfButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		setButtonStyle(selectElfButton);
		selectElfButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		//add tooltips to the buttons
		selectVampireButton.setToolTipText(LabelsProperties.getProperty("selectVampireButtonToolTipText"));
		selectDwarfButton.setToolTipText(LabelsProperties.getProperty("selectDwarfButtonToolTipText"));
		selectElfButton.setToolTipText(LabelsProperties.getProperty("selectElfButtonToolTipText"));

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
		URL imgURL = NewGameListener.class.getResource(path);
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
			setSelectedRace("Vampire");
			buildCharacterGeneratorPage();
		}
	}

	private void setSelectedRace(String race)
	{
		selectedRace = race;
	}

	private String getSelectedRace()
	{
		return selectedRace;
	}

	private class DwarfSelectedListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			setSelectedRace("Dwarf");
			buildCharacterGeneratorPage();
		}
	}

	private class ElfSelectedListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			setSelectedRace("Elf");
			buildCharacterGeneratorPage();
		}
	}

	private void buildCharacterGeneratorPage()
	{
		//buildCharacterGeneratorPage(getSelectedRace());
		mainFrame.setTitle(MessageFormat.format(LabelsProperties.getProperty(
				"mainFrameTitleGenerateRacePage"), getSelectedRace()));
		/*JPanel namePanel = new JPanel();
		JLabel vampireIconLabel;
		ImageIcon vampireIcon;
		JTextField characterNameField = new JTextField("Sziv Arr");

		vampireIcon = createImageIcon("/StaticContent/Images/vampire.jpg");
		vampireIconLabel = new JLabel(vampireIcon);

		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.PAGE_AXIS));
		namePanel.setBackground(Color.darkGray);

		namePanel.add(Box.createRigidArea(new Dimension(0,20)));
		namePanel.add(vampireIconLabel);
		namePanel.add(Box.createRigidArea(new Dimension(0,40)));
		namePanel.add(characterNameField);


		//remove the old panels and add the new ones
		mainFrame.getContentPane().removeAll();
		mainFrame.setLayout(new GridLayout(1, 3));
		mainFrame.repaint();
		mainFrame.getContentPane().add(namePanel);
		//mainFrame.getContentPane().add(statPanel);
		//mainFrame.getContentPane().add(startGamePanel);
		mainFrame.validate();*/
	}

	private class LoadGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}
}

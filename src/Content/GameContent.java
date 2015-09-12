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
	private Properties mainFrameLabelsProperties = new Properties();
	private Properties labelsForMultiplePagesProperties = new Properties();
	private Properties selectRacePageProperties = new Properties();
	private Properties generateRacePageProperties = new Properties();
	private final JFrame mainFrame = new JFrame();
	private final Border border = new LineBorder(Color.WHITE, 2, true);
	private final Font menuFont = new Font("Monospaced", Font.BOLD, 15);
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
			mainFrameLabelsProperties.load(new FileInputStream(
					"src/StaticContent/Properties/MainFrameLabels.properties"));
			labelsForMultiplePagesProperties.load(new FileInputStream(
					"src/StaticContent/Properties/LabelsForMultiplePlaces.properties"));
			selectRacePageProperties.load(new FileInputStream(
					"src/StaticContent/Properties/SelectRacePage.properties"));
			generateRacePageProperties.load(new FileInputStream(
					"src/StaticContent/Properties/GenerateRacePage.properties"));
		}
		catch (IOException e)
		{
			System.out.println("Exception Occurred: " + e.getMessage());
		}
	}

	public void buildMainFrame()
	{
		mainFrame.setTitle(mainFrameLabelsProperties.getProperty("mainFrameTitle"));
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setSize(1200, 800);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setVisible(true);
		mainFrame.setJMenuBar(buildMenuBar());
		mainFrame.validate();
	}

	private JMenuBar buildMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu(mainFrameLabelsProperties.getProperty("gameMenuText"));
		JMenu optionsMenu = new JMenu(mainFrameLabelsProperties.getProperty("optionsMenuText"));
		JMenu helpMenu = new JMenu(mainFrameLabelsProperties.getProperty("helpMenuText"));
		JMenuItem newGameMenu = new JMenuItem(labelsForMultiplePagesProperties.getProperty("newGameText"));
		JMenuItem loadGameMenu = new JMenuItem(labelsForMultiplePagesProperties.getProperty("loadGameText"));
		JMenuItem saveGameMenu = new JMenuItem(mainFrameLabelsProperties.getProperty("saveGameMenuText"));
		JMenuItem quitGameMenu = new JMenuItem(mainFrameLabelsProperties.getProperty("quitGameMenuText"));
		JMenuItem settingsOptionsMenu = new JMenuItem(mainFrameLabelsProperties.getProperty("settingsOptionsMenuText"));
		JMenuItem helpHelpMenu = new JMenuItem(mainFrameLabelsProperties.getProperty("helpHelpMenuText"));
		JMenuItem updateHelpMenu = new JMenuItem(mainFrameLabelsProperties.getProperty("updateHelpMenuText"));
		JMenuItem aboutHelpMenu = new JMenuItem(mainFrameLabelsProperties.getProperty("aboutHelpMenuText"));

		//format the menu items
		setMenuItemStyle(newGameMenu);
		setMenuItemStyle(loadGameMenu);
		setMenuItemStyle(saveGameMenu);
		setMenuItemStyle(quitGameMenu);
		setMenuItemStyle(settingsOptionsMenu);
		setMenuItemStyle(helpHelpMenu);
		setMenuItemStyle(updateHelpMenu);
		setMenuItemStyle(aboutHelpMenu);

		//disable save game option because game is not exist currently
		saveGameMenu.setEnabled(false);

		//add tooltip to the menu items
		newGameMenu.setToolTipText(labelsForMultiplePagesProperties.getProperty("newGameToolTipText"));
		loadGameMenu.setToolTipText(labelsForMultiplePagesProperties.getProperty("loadGameToolTipText"));
		saveGameMenu.setToolTipText(mainFrameLabelsProperties.getProperty("saveGameMenuToolTipText"));
		quitGameMenu.setToolTipText(mainFrameLabelsProperties.getProperty("quitGameMenuToolTipText"));
		settingsOptionsMenu.setToolTipText(mainFrameLabelsProperties.getProperty("settingsOptionsMenuToolTipText"));
		helpHelpMenu.setToolTipText(mainFrameLabelsProperties.getProperty("helpHelpMenuToolTipText"));
		updateHelpMenu.setToolTipText(mainFrameLabelsProperties.getProperty("updateHelpMenuToolTipText"));
		aboutHelpMenu.setToolTipText(mainFrameLabelsProperties.getProperty("aboutHelpMenuToolTipText"));

		//add menu items to the menus
		gameMenu.add(newGameMenu);
		gameMenu.add(loadGameMenu);
		gameMenu.add(saveGameMenu);
		gameMenu.add(quitGameMenu);

		optionsMenu.add(settingsOptionsMenu);

		helpMenu.add(helpHelpMenu);
		helpMenu.add(updateHelpMenu);
		helpMenu.add(aboutHelpMenu);

		//format the menus
		setMenuStyle(gameMenu);
		setMenuStyle(optionsMenu);
		setMenuStyle(helpMenu);

		//add menus to the menu bar
		menuBar.add(gameMenu);
		menuBar.add(optionsMenu);
		menuBar.add(helpMenu);

		//format the menu bar
		menuBar.setBackground(Color.darkGray);

		//add action listeners to the menu items
		newGameMenu.addActionListener(new NewGameListener());
		loadGameMenu.addActionListener(new LoadGameListener());
		saveGameMenu.addActionListener(new SaveGameListener());
		quitGameMenu.addActionListener(new QuitGameListener());
		settingsOptionsMenu.addActionListener(new SettingsListener());
		helpHelpMenu.addActionListener(new HelpListener());
		updateHelpMenu.addActionListener(new UpdateListener());
		aboutHelpMenu.addActionListener(new AboutListener());

		return menuBar;
	}

	private void setMenuItemStyle(JMenuItem menuItem)
	{
		menuItem.setBackground(Color.darkGray);
		menuItem.setForeground(Color.white);
		menuItem.setFont(menuFont);
		menuItem.setBorder(border);
	}

	private void setMenuStyle(JMenu menu)
	{
		menu.setForeground(Color.white);
		menu.setFont(menuFont);
	}

	public void buildMainPage()
	{
		JPanel startPanel = new JPanel();
		JPanel emptyPanel = new JPanel();
		JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
		JButton newGameButton = new JButton(labelsForMultiplePagesProperties.getProperty("newGameText"));
		JButton loadGameButton = new JButton(labelsForMultiplePagesProperties.getProperty("loadGameText"));

		//format the buttons
		setButtonStyle(newGameButton);
		setButtonStyle(loadGameButton);

		//add tooltips to the buttons
		newGameButton.setToolTipText(labelsForMultiplePagesProperties.getProperty("newGameToolTipText"));
		loadGameButton.setToolTipText(labelsForMultiplePagesProperties.getProperty("loadGameToolTipText"));

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

		//add panels to the frame
		mainFrame.setLayout(new GridLayout(2, 1));
		mainFrame.getContentPane().add(BorderLayout.CENTER, emptyPanel);
		mainFrame.getContentPane().add(BorderLayout.CENTER, startPanel);
		mainFrame.validate();
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
			buildSelectRacePage();
		}
	}

	private void buildSelectRacePage()
	{
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
		String vampireText = selectRacePageProperties.getProperty("vampireText");
		String dwarfText = selectRacePageProperties.getProperty("dwarfText");
		String elfText = selectRacePageProperties.getProperty("elfText");
		JButton selectVampireButton = new JButton(selectRacePageProperties.getProperty("selectVampireButtonText"));
		JButton selectDwarfButton = new JButton(selectRacePageProperties.getProperty("selectDwarfButtonText"));
		JButton selectElfButton = new JButton(selectRacePageProperties.getProperty("selectElfButtonText"));

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
		selectVampireButton.setToolTipText(selectRacePageProperties.getProperty("selectVampireButtonToolTipText"));
		selectDwarfButton.setToolTipText(selectRacePageProperties.getProperty("selectDwarfButtonToolTipText"));
		selectElfButton.setToolTipText(selectRacePageProperties.getProperty("selectElfButtonToolTipText"));

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

		//remove the old panels and add the new ones
		mainFrame.getContentPane().removeAll();
		mainFrame.setLayout(new GridLayout(1, 3));
		mainFrame.repaint();
		mainFrame.setTitle(selectRacePageProperties.getProperty("mainFrameTitleSelectRacePage"));
		mainFrame.getContentPane().add(vampirePanel);
		mainFrame.getContentPane().add(dwarfPanel);
		mainFrame.getContentPane().add(elfPanel);
		mainFrame.validate();
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
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(0, 90)));
		panel.add(description);
		panel.add(Box.createRigidArea(new Dimension(0, 90)));
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
		mainFrame.setTitle(MessageFormat.format(generateRacePageProperties.getProperty(
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

	private class SaveGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}

	private class QuitGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int result = JOptionPane.showOptionDialog(
					null,
					"Are you really want to quit?",
					"Are you really want to quit?",
					JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null,
					new String[]{"Yes, quit", "No, cancel"},
					"No, cancel");

			if (result == 0)
			{
				mainFrame.dispose();
			}
		}
	}

	private class SettingsListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}

	private class HelpListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}

	private class UpdateListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}

	private class AboutListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			JOptionPane.showMessageDialog(
					null,
					"Matta's Best RPG Game\nVersion 0.1",
					"About",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
}

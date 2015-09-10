package Content;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class GameContent
{
	private final JFrame mainFrame = new JFrame("Matta's Best RPG Game");
	private final Border border = new LineBorder(Color.WHITE, 2, true);
	private final Font buttonFont = new Font("Monospaced", Font.BOLD, 25);

	public void buildMainFrame()
	{
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setSize(1200, 800);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setVisible(true);
	}

	public void buildMenus()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("Game");
		JMenu optionsMenu = new JMenu("Options");
		JMenu helpMenu = new JMenu("Help");
		JMenuItem newGameMenu = new JMenuItem("New game");
		JMenuItem loadGameMenu = new JMenuItem("Load game");
		JMenuItem saveGameMenu = new JMenuItem("Save game");
		JMenuItem quitGameMenu = new JMenuItem("Quit");
		JMenuItem settingsOptionsMenu = new JMenuItem("Settings");
		JMenuItem helpHelpMenu = new JMenuItem("Help");
		JMenuItem updateHelpMenu = new JMenuItem("Check for update");
		JMenuItem aboutHelpMenu = new JMenuItem("About");
		Font menuFont = new Font("Monospaced", Font.BOLD, 15);

		//format the menu items
		newGameMenu.setBackground(Color.darkGray);
		newGameMenu.setForeground(Color.white);
		newGameMenu.setFont(menuFont);
		newGameMenu.setBorder(border);

		loadGameMenu.setBackground(Color.darkGray);
		loadGameMenu.setForeground(Color.white);
		loadGameMenu.setFont(menuFont);
		loadGameMenu.setBorder(border);

		saveGameMenu.setBackground(Color.darkGray);
		saveGameMenu.setForeground(Color.white);
		saveGameMenu.setFont(menuFont);
		saveGameMenu.setBorder(border);

		quitGameMenu.setBackground(Color.darkGray);
		quitGameMenu.setForeground(Color.white);
		quitGameMenu.setFont(menuFont);
		quitGameMenu.setBorder(border);

		settingsOptionsMenu.setBackground(Color.darkGray);
		settingsOptionsMenu.setForeground(Color.white);
		settingsOptionsMenu.setFont(menuFont);
		settingsOptionsMenu.setBorder(border);

		helpHelpMenu.setBackground(Color.darkGray);
		helpHelpMenu.setForeground(Color.white);
		helpHelpMenu.setFont(menuFont);
		helpHelpMenu.setBorder(border);

		updateHelpMenu.setBackground(Color.darkGray);
		updateHelpMenu.setForeground(Color.white);
		updateHelpMenu.setFont(menuFont);
		updateHelpMenu.setBorder(border);

		aboutHelpMenu.setBackground(Color.darkGray);
		aboutHelpMenu.setForeground(Color.white);
		aboutHelpMenu.setFont(menuFont);
		aboutHelpMenu.setBorder(border);

		//disable save game option because no current game
		saveGameMenu.setEnabled(false);

		//add tooltip for the menu items
		newGameMenu.setToolTipText("Start a 'New game'");
		loadGameMenu.setToolTipText("Continue an existing game");
		saveGameMenu.setToolTipText("Save the current game");
		quitGameMenu.setToolTipText("Quit from the game");
		settingsOptionsMenu.setToolTipText("Basic settings");
		helpHelpMenu.setToolTipText("You can find some help here");
		updateHelpMenu.setToolTipText("Check for new updates");
		aboutHelpMenu.setToolTipText("About the game");

		//add menu items to menus
		gameMenu.add(newGameMenu);
		gameMenu.add(loadGameMenu);
		gameMenu.add(saveGameMenu);
		gameMenu.add(quitGameMenu);

		optionsMenu.add(settingsOptionsMenu);

		helpMenu.add(helpHelpMenu);
		helpMenu.add(updateHelpMenu);
		helpMenu.add(aboutHelpMenu);

		//format the menus
		gameMenu.setForeground(Color.white);
		gameMenu.setFont(menuFont);

		optionsMenu.setForeground(Color.white);
		optionsMenu.setFont(menuFont);

		helpMenu.setForeground(Color.white);
		helpMenu.setFont(menuFont);

		//add menus to menu bar
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

		//add menu bar to the main frame
		mainFrame.setJMenuBar(menuBar);
		mainFrame.validate();
	}

	public void buildMainPage()
	{
		JPanel startPanel = new JPanel();
		JPanel emptyPanel = new JPanel();
		JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
		JButton newGameButton = new JButton("New game");
		JButton loadGameButton = new JButton("Load game");

		//format the buttons
		newGameButton.setBackground(Color.darkGray);
		newGameButton.setForeground(Color.white);
		newGameButton.setFont(buttonFont);
		newGameButton.setBorder(border);

		loadGameButton.setBackground(Color.darkGray);
		loadGameButton.setForeground(Color.white);
		loadGameButton.setFont(buttonFont);
		loadGameButton.setBorder(border);

		//add tooltips to the buttons
		newGameButton.setToolTipText("Start a 'New game'");
		loadGameButton.setToolTipText("Continue an existing game");

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

	private class NewGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
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
			String vampireText1 = "The vampires 'life' is all about sucking. They think they rule the night while ";
			String vampireText2 = "they do nothing else just sucking all night long and sleep while the sun is ";
			String vampireText3 = "shining. They are the perfect choice for 'The Nobodies' whom think they are";
			String vampireText4 = " 'Somebodies'.";
			String dwarfText1 = "Dwarves have bad tempers and worse body odour. They rarely came out of their caves, ";
			String dwarfText2 = "much to the relief of all other races. They are the race of choice for people who ";
			String dwarfText3 = "speak with fake scottish accents at renaissance faires and feel uneasy around women.";
			String elfText1 = "Elves are slender and beautiful as well as annoying. They live in forests where they ";
			String elfText2 = "molest small animals and play boring music all night long. They are the perfect choice ";
			String elfText3 = "for depressed and sociopathic players who feel undervalued and misunderstood.";
			JButton selectVampireButton = new JButton("Select Vampire");
			JButton selectDwarfButton = new JButton("Select Dwarf");
			JButton selectElfButton = new JButton("Select Elf");
			Font infoFont = new Font("Monospaced", Font.BOLD, 20);

			//create race icons
			vampireIcon = createImageIcon("/Images/vampire.jpg", "The shame of the species");
			dwarfIcon = createImageIcon("/Images/dwarf.jpg", "Worst of the worsts");
			elfIcon = createImageIcon("/Images/elf.jpg", "A fat and ugly elf");

			//add the icons to the labels
			vampireIconLabel = new JLabel(vampireIcon);
			dwarfIconLabel = new JLabel(dwarfIcon);
			elfIconLabel = new JLabel(elfIcon);

			vampireIconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			dwarfIconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			elfIconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

			//format the race descriptions
			vampireInfo.setText(vampireText1 + vampireText2 + vampireText3 + vampireText4);
			vampireInfo.setFont(infoFont);
			vampireInfo.setBackground(Color.darkGray);
			vampireInfo.setForeground(Color.white);
			vampireInfo.setLineWrap(true);
			vampireInfo.setWrapStyleWord(true);
			vampireInfo.setEditable(false);
			vampireInfo.setMinimumSize(new Dimension(200, 200));
			vampireInfo.setMaximumSize(new Dimension(400, 250));
			vampireInfo.setPreferredSize(new Dimension(300, 250));

			dwarfInfo.setText(dwarfText1 + dwarfText2 + dwarfText3);
			dwarfInfo.setFont(infoFont);
			dwarfInfo.setBackground(Color.darkGray);
			dwarfInfo.setForeground(Color.white);
			dwarfInfo.setLineWrap(true);
			dwarfInfo.setWrapStyleWord(true);
			dwarfInfo.setEditable(false);
			dwarfInfo.setMinimumSize(new Dimension(200, 200));
			dwarfInfo.setMaximumSize(new Dimension(400, 250));
			dwarfInfo.setPreferredSize(new Dimension(300, 250));

			elfInfo.setText(elfText1 + elfText2 + elfText3);
			elfInfo.setFont(infoFont);
			elfInfo.setBackground(Color.darkGray);
			elfInfo.setForeground(Color.white);
			elfInfo.setLineWrap(true);
			elfInfo.setWrapStyleWord(true);
			elfInfo.setEditable(false);
			elfInfo.setMinimumSize(new Dimension(200, 200));
			elfInfo.setMaximumSize(new Dimension(400, 250));
			elfInfo.setPreferredSize(new Dimension(300, 250));

			//format the buttons
			selectVampireButton.setBackground(Color.darkGray);
			selectVampireButton.setForeground(Color.white);
			selectVampireButton.setFont(buttonFont);
			selectVampireButton.setBorder(border);
			selectVampireButton.setAlignmentX(Component.CENTER_ALIGNMENT);

			selectDwarfButton.setBackground(Color.darkGray);
			selectDwarfButton.setForeground(Color.white);
			selectDwarfButton.setFont(buttonFont);
			selectDwarfButton.setBorder(border);
			selectDwarfButton.setAlignmentX(Component.CENTER_ALIGNMENT);

			selectElfButton.setBackground(Color.darkGray);
			selectElfButton.setForeground(Color.white);
			selectElfButton.setFont(buttonFont);
			selectElfButton.setBorder(border);
			selectElfButton.setAlignmentX(Component.CENTER_ALIGNMENT);

			//set panels layout
			vampirePanel.setLayout(new BoxLayout(vampirePanel, BoxLayout.PAGE_AXIS));
			dwarfPanel.setLayout(new BoxLayout(dwarfPanel, BoxLayout.PAGE_AXIS));
			elfPanel.setLayout(new BoxLayout(elfPanel, BoxLayout.PAGE_AXIS));

			//format the panels
			vampirePanel.setBackground(Color.darkGray);
			dwarfPanel.setBackground(Color.darkGray);
			dwarfPanel.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.white));
			elfPanel.setBackground(Color.darkGray);

			//add content to the panels
			vampirePanel.add(Box.createRigidArea(new Dimension(0,20)));
			vampirePanel.add(vampireIconLabel);
			vampirePanel.add(Box.createRigidArea(new Dimension(0,90)));
			vampirePanel.add(vampireInfo);
			vampirePanel.add(Box.createRigidArea(new Dimension(0,90)));
			vampirePanel.add(selectVampireButton);

			dwarfPanel.add(Box.createRigidArea(new Dimension(0,20)));
			dwarfPanel.add(dwarfIconLabel);
			dwarfPanel.add(Box.createRigidArea(new Dimension(0,90)));
			dwarfPanel.add(dwarfInfo);
			dwarfPanel.add(Box.createRigidArea(new Dimension(0,90)));
			dwarfPanel.add(selectDwarfButton);

			elfPanel.add(Box.createRigidArea(new Dimension(0,20)));
			elfPanel.add(elfIconLabel);
			elfPanel.add(Box.createRigidArea(new Dimension(0,90)));
			elfPanel.add(elfInfo);
			elfPanel.add(Box.createRigidArea(new Dimension(0,90)));
			elfPanel.add(selectElfButton);

			//remove panels and add the new ones
			mainFrame.getContentPane().removeAll();
			mainFrame.setLayout(new GridLayout(1, 3));
			mainFrame.repaint();
			mainFrame.setTitle("Matta's Best RPG Game - Select Race");
			mainFrame.getContentPane().add(vampirePanel);
			mainFrame.getContentPane().add(dwarfPanel);
			mainFrame.getContentPane().add(elfPanel);
			mainFrame.validate();
		}
	}

	private ImageIcon createImageIcon(String path, String description)
	{
		URL imgURL = NewGameListener.class.getResource(path);
		return new ImageIcon(imgURL, description);
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

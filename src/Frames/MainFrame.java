package Frames;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame
{
	private JFrame mainFrame;
	private final Font buttonFont = new Font("Monospaced", Font.BOLD, 25);
	private final Font menuFont = new Font("Monospaced", Font.BOLD, 15);
	private final Border buttonBorder = new LineBorder(Color.WHITE, 2, true);

	public void buildFrame()
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
		JPanel startPanel = new JPanel();
		JPanel emptyPanel = new JPanel();
		JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
		JButton newGame = new JButton("New game");
		JButton loadGame = new JButton("Load game");
		mainFrame = new JFrame("Matta's Best RPG Game");

		//add menu items and format them
		newGameMenu.setBackground(Color.darkGray);
		newGameMenu.setForeground(Color.white);
		newGameMenu.setFont(menuFont);
		newGameMenu.setBorder(buttonBorder);

		loadGameMenu.setBackground(Color.darkGray);
		loadGameMenu.setForeground(Color.white);
		loadGameMenu.setFont(menuFont);
		loadGameMenu.setBorder(buttonBorder);

		saveGameMenu.setBackground(Color.darkGray);
		saveGameMenu.setForeground(Color.white);
		saveGameMenu.setFont(menuFont);
		saveGameMenu.setBorder(buttonBorder);

		quitGameMenu.setBackground(Color.darkGray);
		quitGameMenu.setForeground(Color.white);
		quitGameMenu.setFont(menuFont);
		quitGameMenu.setBorder(buttonBorder);

		settingsOptionsMenu.setBackground(Color.darkGray);
		settingsOptionsMenu.setForeground(Color.white);
		settingsOptionsMenu.setFont(menuFont);
		settingsOptionsMenu.setBorder(buttonBorder);

		helpHelpMenu.setBackground(Color.darkGray);
		helpHelpMenu.setForeground(Color.white);
		helpHelpMenu.setFont(menuFont);
		helpHelpMenu.setBorder(buttonBorder);

		updateHelpMenu.setBackground(Color.darkGray);
		updateHelpMenu.setForeground(Color.white);
		updateHelpMenu.setFont(menuFont);
		updateHelpMenu.setBorder(buttonBorder);

		aboutHelpMenu.setBackground(Color.darkGray);
		aboutHelpMenu.setForeground(Color.white);
		aboutHelpMenu.setFont(menuFont);
		aboutHelpMenu.setBorder(buttonBorder);

		//add menu items to menus and format the menus
		gameMenu.add(newGameMenu);
		gameMenu.add(loadGameMenu);
		gameMenu.add(saveGameMenu);
		gameMenu.add(quitGameMenu);
		gameMenu.setForeground(Color.white);
		gameMenu.setFont(menuFont);

		optionsMenu.add(settingsOptionsMenu);
		optionsMenu.setForeground(Color.white);
		optionsMenu.setFont(menuFont);

		helpMenu.add(helpHelpMenu);
		helpMenu.add(updateHelpMenu);
		helpMenu.add(aboutHelpMenu);
		helpMenu.setForeground(Color.white);
		helpMenu.setFont(menuFont);

		//add menus to menu bar and format the bar
		menuBar.add(gameMenu);
		menuBar.add(optionsMenu);
		menuBar.add(helpMenu);
		menuBar.setBackground(Color.darkGray);

		//add action listeners to the menu items
		newGameMenu.addActionListener(new NewGameListener());
		loadGameMenu.addActionListener(new LoadGameListener());
		saveGameMenu.addActionListener(new SaveGameListener());
		quitGameMenu.addActionListener(new QuitGameListener());
		settingsOptionsMenu.addActionListener(new SettingsGameListener());
		helpHelpMenu.addActionListener(new HelpGameListener());
		updateHelpMenu.addActionListener(new UpdateGameListener());
		aboutHelpMenu.addActionListener(new AboutGameListener());

		//format the buttons
		newGame.setBackground(Color.darkGray);
		newGame.setForeground(Color.white);
		newGame.setFont(buttonFont);
		newGame.setBorder(buttonBorder);

		loadGame.setBackground(Color.darkGray);
		loadGame.setForeground(Color.white);
		loadGame.setFont(buttonFont);
		loadGame.setBorder(buttonBorder);

		//add action listeners to the buttons
		newGame.addActionListener(new NewGameListener());
		loadGame.addActionListener(new LoadGameListener());

		//format the panels, add buttons
		emptyPanel.setBackground(Color.darkGray);

		buttonsPanel.setPreferredSize(new Dimension(200, 100));
		buttonsPanel.setBackground(Color.darkGray);
		buttonsPanel.add(newGame);
		buttonsPanel.add(loadGame);

		startPanel.add(buttonsPanel);
		startPanel.setBackground(Color.darkGray);

		//add everything to the frame, format the frame
		mainFrame.setJMenuBar(menuBar);
		mainFrame.setLayout(new GridLayout(2, 1));
		mainFrame.getContentPane().add(BorderLayout.CENTER, emptyPanel);
		mainFrame.getContentPane().add(BorderLayout.CENTER, startPanel);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setSize(1200, 800);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setVisible(true);
	}

	private class NewGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			JPanel raceSelectorPanelUpper = new JPanel(new GridLayout(1, 3));
			JPanel raceSelectorPanelLower = new JPanel(new GridLayout(1, 3));
			JPanel raceImagePanel1 = new JPanel();
			JPanel raceImagePanel2 = new JPanel();
			JPanel raceImagePanel3 = new JPanel();
			JPanel raceInfoPanel1 = new JPanel();
			JPanel raceInfoPanel2 = new JPanel();
			JPanel raceInfoPanel3 = new JPanel();
			JTextArea vampireInfo = new JTextArea();
			JTextArea dwarfInfo = new JTextArea();
			JTextArea elfInfo = new JTextArea();
			JButton selectRace1 = new JButton();
			JButton selectRace2 = new JButton();
			JButton selectRace3 = new JButton();

			//add race descriptions
			String elfText1 = "Elves are slender and beautiful as well as annoying. They live in forests where they ";
			String elfText2 = "molest small animals and play boring music all night long. They are the perfect choice ";
			String elfText3 = "for depressed and sociopathic players who feel undervalued and misunderstood.";
			String dwarfText1 = "Dwarves have bad tempers and worse body odour. They rarely came out of their caves, ";
			String dwarfText2 = "much to the relief of all other races. They are the race of choice for people who ";
			String dwarfText3 = "speak with fake scottish accents at renaissance faires and feel uneasy around women.";
			String vampireText1 = "Vampires are stupid. They think they rule the night while they do nothing else ";
			String vampireText2 = "just sucking. The vampires 'life' is all about sucking. They suck all night long ";
			String vampireText3 = "and sleep while the sun is shining. They are the perfect choice for 'The Nobodies' ";
			String vampireText4 = "whom think they are 'Somebodies'.";

			//format the race descriptions
			Font infoFont = new Font("Monospaced", Font.BOLD, 20);

			vampireInfo.setText(vampireText1 + vampireText2 + vampireText3 + vampireText4);
			vampireInfo.setFont(infoFont);
			vampireInfo.setBackground(Color.darkGray);
			vampireInfo.setForeground(Color.white);
			vampireInfo.setLineWrap(true);
			vampireInfo.setWrapStyleWord(true);
			vampireInfo.setEditable(false);
			vampireInfo.setMinimumSize(new Dimension(200, 200));
			vampireInfo.setMaximumSize(new Dimension(400, 400));
			vampireInfo.setPreferredSize(new Dimension(300, 300));

			dwarfInfo.setText(dwarfText1 + dwarfText2 + dwarfText3);
			dwarfInfo.setFont(infoFont);
			dwarfInfo.setBackground(Color.darkGray);
			dwarfInfo.setForeground(Color.white);
			dwarfInfo.setLineWrap(true);
			dwarfInfo.setWrapStyleWord(true);
			dwarfInfo.setEditable(false);
			dwarfInfo.setMinimumSize(new Dimension(200, 200));
			dwarfInfo.setMaximumSize(new Dimension(400, 400));
			dwarfInfo.setPreferredSize(new Dimension(300, 300));

			elfInfo.setText(elfText1 + elfText2 + elfText3);
			elfInfo.setFont(infoFont);
			elfInfo.setBackground(Color.darkGray);
			elfInfo.setForeground(Color.white);
			elfInfo.setLineWrap(true);
			elfInfo.setWrapStyleWord(true);
			elfInfo.setEditable(false);
			elfInfo.setMinimumSize(new Dimension(200, 200));
			elfInfo.setMaximumSize(new Dimension(400, 400));
			elfInfo.setPreferredSize(new Dimension(300, 300));

			//format the buttons
			selectRace1.setText("Select this race");
			selectRace1.setFont(buttonFont);
			selectRace1.setBorder(buttonBorder);
			selectRace1.setBackground(Color.darkGray);
			selectRace1.setForeground(Color.white);

			selectRace2.setText("Select this race");
			selectRace2.setFont(buttonFont);
			selectRace2.setBorder(buttonBorder);
			selectRace2.setBackground(Color.darkGray);
			selectRace2.setForeground(Color.white);

			selectRace3.setText("Select this race");
			selectRace3.setFont(buttonFont);
			selectRace3.setBorder(buttonBorder);
			selectRace3.setBackground(Color.darkGray);
			selectRace3.setForeground(Color.white);

			//add action listeners to the buttons
			selectRace1.addActionListener(new VampireRaceSelectedListener());
			selectRace2.addActionListener(new DwarfRaceSelectedListener());
			selectRace3.addActionListener(new ElfRaceSelectedListener());

			//format the race panels
			raceImagePanel1.setBackground(Color.darkGray);
			raceImagePanel2.setBackground(Color.darkGray);
			raceImagePanel3.setBackground(Color.darkGray);
			raceInfoPanel1.setBackground(Color.darkGray);
			raceInfoPanel1.setLayout(new BoxLayout(raceInfoPanel1, BoxLayout.Y_AXIS));
			raceInfoPanel2.setBackground(Color.darkGray);
			raceInfoPanel2.setLayout(new BoxLayout(raceInfoPanel2, BoxLayout.Y_AXIS));
			raceInfoPanel3.setBackground(Color.darkGray);
			raceInfoPanel3.setLayout(new BoxLayout(raceInfoPanel3, BoxLayout.Y_AXIS));

			//add info and buttons to the panels
			raceInfoPanel1.add(vampireInfo);
			raceInfoPanel1.add(selectRace1);
			raceInfoPanel2.add(dwarfInfo);
			raceInfoPanel2.add(selectRace2);
			raceInfoPanel3.add(elfInfo);
			raceInfoPanel3.add(selectRace3);

			raceSelectorPanelUpper.add(BorderLayout.CENTER, raceImagePanel1);
			raceSelectorPanelUpper.add(BorderLayout.CENTER, raceImagePanel2);
			raceSelectorPanelUpper.add(BorderLayout.CENTER, raceImagePanel3);
			raceSelectorPanelLower.add(BorderLayout.CENTER, raceInfoPanel1);
			raceSelectorPanelLower.add(BorderLayout.CENTER, raceInfoPanel2);
			raceSelectorPanelLower.add(BorderLayout.CENTER, raceInfoPanel3);

			//remove previous panels, add new panels
			mainFrame.getContentPane().removeAll();
			mainFrame.setTitle("Matta's Best RPG Game - Select Race");
			mainFrame.getContentPane().add(BorderLayout.CENTER, raceSelectorPanelUpper);
			mainFrame.getContentPane().add(BorderLayout.CENTER, raceSelectorPanelLower);
			mainFrame.validate();
		}
	}

	private class LoadGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("Load game");
		}
	}

	private class SaveGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("Save game");
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

			if(result == 0)
			{
				mainFrame.dispose();
			}
		}
	}

	private class SettingsGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("Settings");
		}
	}

	private class HelpGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("Help");
		}
	}

	private class UpdateGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("Check update");
		}
	}

	private class AboutGameListener implements ActionListener
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

	private class VampireRaceSelectedListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("Vampire selected");
		}
	}

	private class DwarfRaceSelectedListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("Dwarf selected");
		}
	}

	private class ElfRaceSelectedListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("Elf selected");
		}
	}
}

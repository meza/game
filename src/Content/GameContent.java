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

		//add tooltip for the menu items
		newGameMenu.setToolTipText("Start a 'New game'");
		loadGameMenu.setToolTipText("Continue an existing game");
		saveGameMenu.setToolTipText("Save the current game");
		quitGameMenu.setToolTipText("Quit from the game");
		settingsOptionsMenu.setToolTipText("Basic settings");
		helpHelpMenu.setToolTipText("You can find some helps here");
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
		Font buttonFont = new Font("Monospaced", Font.BOLD, 25);

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

		//
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
			ImageIcon vampireIcon = new ImageIcon();
			ImageIcon dwarfIcon = new ImageIcon();
			ImageIcon elfIcon = new ImageIcon();
			String vampireInfo;
			String dwarfInfo;
			String elfInfo;
			JButton selectVampire = new JButton();
			JButton selectDwarf = new JButton();
			JButton selectElf = new JButton();

			/*ImageIcon icon = createImageIcon("/Images/elf.jpg", "Elf");
			JLabel label = new JLabel("rewrwerwer", icon, JLabel.CENTER);
			panel.add(label);*/

			//remove panels
			mainFrame.getContentPane().removeAll();
			mainFrame.setLayout(new GridLayout(3, 2));
			mainFrame.repaint();
			mainFrame.getContentPane().add(vampirePanel);
			mainFrame.validate();

			//add race selector page content
		//	buildRaceSelectorPage(mainFrame.getContentPane());
		//	mainFrame.validate();
		}
	}

	private ImageIcon createImageIcon(String path, String description)
	{
		URL imgURL = NewGameListener.class.getResource(path);
		return new ImageIcon(imgURL, description);
	}

	public static void buildRaceSelectorPage(Container pane)
	{
		JButton button1 = new JButton("Button 1");
		JButton button2 = new JButton("Button 2");
		JButton button3 = new JButton("Button 3");
		JButton button4 = new JButton("Long-Named Button 4");
		JButton button5 = new JButton("5");
		GridBagConstraints c1 = new GridBagConstraints();
		GridBagConstraints c2 = new GridBagConstraints();
		GridBagConstraints c3 = new GridBagConstraints();
		GridBagConstraints c4 = new GridBagConstraints();
		GridBagConstraints c5 = new GridBagConstraints();

		pane.setLayout(new GridBagLayout());

		c1.weightx = 0.5;
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.gridx = 0;
		c1.gridy = 0;
		pane.add(button1, c1);

		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 0.5;
		c2.gridx = 1;
		c2.gridy = 0;
		pane.add(button2, c2);

		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.weightx = 0.5;
		c3.gridx = 2;
		c3.gridy = 0;
		pane.add(button3, c3);

		c4.fill = GridBagConstraints.HORIZONTAL;
		c4.ipady = 40;      //make this component tall
		c4.weightx = 0.0;
		c4.gridwidth = 3;
		c4.gridx = 0;
		c4.gridy = 1;
		pane.add(button4, c4);

		c5.fill = GridBagConstraints.HORIZONTAL;
		c5.ipady = 0;       //reset to default
		c5.weighty = 1.0;   //request any extra vertical space
		c5.anchor = GridBagConstraints.PAGE_END; //bottom of space
		c5.insets = new Insets(10,0,0,0);  //top padding
		c5.gridx = 1;       //aligned with button 2
		c5.gridwidth = 2;   //2 columns wide
		c5.gridy = 2;       //third row
		pane.add(button5, c5);
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

package Content;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BuildMenuBar
{
	private final Font menuFont = new Font("Monospaced", Font.BOLD, 15);
	private final GameContent gameContent = new GameContent();

	JMenuBar buildMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu(gameContent.LabelsProperties.getProperty("gameMenuText"));
		JMenu optionsMenu = new JMenu(gameContent.LabelsProperties.getProperty("optionsMenuText"));
		JMenu helpMenu = new JMenu(gameContent.LabelsProperties.getProperty("helpMenuText"));
		JMenuItem newGameMenu = new JMenuItem(gameContent.LabelsProperties.getProperty("newGameMenuItemText"));
		JMenuItem loadGameMenu = new JMenuItem(gameContent.LabelsProperties.getProperty("loadGameMenuItemText"));
		JMenuItem saveGameMenu = new JMenuItem(gameContent.LabelsProperties.getProperty("saveGameMenuItemText"));
		JMenuItem quitGameMenu = new JMenuItem(gameContent.LabelsProperties.getProperty("quitGameMenuItemText"));
		JMenuItem settingsOptionsMenu = new JMenuItem(gameContent.LabelsProperties.getProperty("settingsOptionsMenuItemText"));
		JMenuItem helpHelpMenu = new JMenuItem(gameContent.LabelsProperties.getProperty("helpHelpMenuItemText"));
		JMenuItem updateHelpMenu = new JMenuItem(gameContent.LabelsProperties.getProperty("updateHelpMenuItemText"));
		JMenuItem aboutHelpMenu = new JMenuItem(gameContent.LabelsProperties.getProperty("aboutHelpMenuItemText"));

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
		newGameMenu.setToolTipText(gameContent.LabelsProperties.getProperty("newGameMenuItemToolTipText"));
		loadGameMenu.setToolTipText(gameContent.LabelsProperties.getProperty("loadGameMenuItemToolTipText"));
		saveGameMenu.setToolTipText(gameContent.LabelsProperties.getProperty("saveGameMenuItemToolTipText"));
		quitGameMenu.setToolTipText(gameContent.LabelsProperties.getProperty("quitGameMenuItemToolTipText"));
		settingsOptionsMenu.setToolTipText(gameContent.LabelsProperties.getProperty("settingsOptionsMenuItemToolTipText"));
		helpHelpMenu.setToolTipText(gameContent.LabelsProperties.getProperty("helpHelpMenuItemToolTipText"));
		updateHelpMenu.setToolTipText(gameContent.LabelsProperties.getProperty("updateHelpMenuItemToolTipText"));
		aboutHelpMenu.setToolTipText(gameContent.LabelsProperties.getProperty("aboutHelpMenuItemToolTipText"));

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
		menuItem.setBorder(gameContent.border);
	}

	private void setMenuStyle(JMenu menu)
	{
		menu.setForeground(Color.white);
		menu.setFont(menuFont);
	}

	private class NewGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
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
				System.out.println("111111111111");
				gameContent.closeGame();
				System.out.println("4444444444444444444");
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

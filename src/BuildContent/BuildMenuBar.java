package BuildContent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BuildMenuBar
{
	private final BuildGameContent buildGameContent = new BuildGameContent();
	private final Font menuFont = new Font("Monospaced", Font.BOLD, 15);
	final Border border = new LineBorder(Color.WHITE, 2, true);

	JMenuBar buildMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu(buildGameContent.LabelsProperties.getProperty("gameMenuText"));
		JMenu optionsMenu = new JMenu(buildGameContent.LabelsProperties.getProperty("optionsMenuText"));
		JMenu helpMenu = new JMenu(buildGameContent.LabelsProperties.getProperty("helpMenuText"));
		JMenuItem newGameMenu = new JMenuItem(buildGameContent.LabelsProperties.getProperty("newGameMenuItemText"));
		JMenuItem loadGameMenu = new JMenuItem(buildGameContent.LabelsProperties.getProperty("loadGameMenuItemText"));
		JMenuItem saveGameMenu = new JMenuItem(buildGameContent.LabelsProperties.getProperty("saveGameMenuItemText"));
		JMenuItem quitGameMenu = new JMenuItem(buildGameContent.LabelsProperties.getProperty("quitGameMenuItemText"));
		JMenuItem settingsOptionsMenu = new JMenuItem(buildGameContent.LabelsProperties.getProperty("settingsOptionsMenuItemText"));
		JMenuItem helpHelpMenu = new JMenuItem(buildGameContent.LabelsProperties.getProperty("helpHelpMenuItemText"));
		JMenuItem updateHelpMenu = new JMenuItem(buildGameContent.LabelsProperties.getProperty("updateHelpMenuItemText"));
		JMenuItem aboutHelpMenu = new JMenuItem(buildGameContent.LabelsProperties.getProperty("aboutHelpMenuItemText"));

		//format the menu items
		setMenuItemStyle(newGameMenu);
		setMenuItemStyle(loadGameMenu);
		setMenuItemStyle(saveGameMenu);
		setMenuItemStyle(quitGameMenu);
		setMenuItemStyle(settingsOptionsMenu);
		setMenuItemStyle(helpHelpMenu);
		setMenuItemStyle(updateHelpMenu);
		setMenuItemStyle(aboutHelpMenu);

		//add tooltip to the menu items
		newGameMenu.setToolTipText(buildGameContent.LabelsProperties.getProperty("newGameMenuItemToolTipText"));
		loadGameMenu.setToolTipText(buildGameContent.LabelsProperties.getProperty("loadGameMenuItemToolTipText"));
		saveGameMenu.setToolTipText(buildGameContent.LabelsProperties.getProperty("saveGameMenuItemToolTipText"));
		quitGameMenu.setToolTipText(buildGameContent.LabelsProperties.getProperty("quitGameMenuItemToolTipText"));
		settingsOptionsMenu.setToolTipText(buildGameContent.LabelsProperties.getProperty("settingsOptionsMenuItemToolTipText"));
		helpHelpMenu.setToolTipText(buildGameContent.LabelsProperties.getProperty("helpHelpMenuItemToolTipText"));
		updateHelpMenu.setToolTipText(buildGameContent.LabelsProperties.getProperty("updateHelpMenuItemToolTipText"));
		aboutHelpMenu.setToolTipText(buildGameContent.LabelsProperties.getProperty("aboutHelpMenuItemToolTipText"));

		//add name to the menu items
		newGameMenu.setName(buildGameContent.LabelsProperties.getProperty("newGameMenuItemText"));
		loadGameMenu.setName(buildGameContent.LabelsProperties.getProperty("loadGameMenuItemText"));
		saveGameMenu.setName(buildGameContent.LabelsProperties.getProperty("saveGameMenuItemText"));
		quitGameMenu.setName(buildGameContent.LabelsProperties.getProperty("quitGameMenuItemText"));
		settingsOptionsMenu.setName(buildGameContent.LabelsProperties.getProperty("settingsOptionsMenuItemText"));
		helpHelpMenu.setName(buildGameContent.LabelsProperties.getProperty("helpHelpMenuItemText"));
		updateHelpMenu.setName(buildGameContent.LabelsProperties.getProperty("updateHelpMenuItemText"));
		aboutHelpMenu.setName(buildGameContent.LabelsProperties.getProperty("aboutHelpMenuItemText"));

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

		//add name to the menus
		gameMenu.setName(buildGameContent.LabelsProperties.getProperty("gameMenuText"));
		optionsMenu.setName(buildGameContent.LabelsProperties.getProperty("optionsMenuText"));
		helpMenu.setName(buildGameContent.LabelsProperties.getProperty("helpMenuText"));

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

	private class NewGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			buildGameContent.addSelectRacePageToTheMainFrame();
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
				System.exit(0);
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

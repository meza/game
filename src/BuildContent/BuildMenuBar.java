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

		menuBar.add(buildGameMenu());
		menuBar.add(buildOptionsMenu());
		menuBar.add(buildHelpMenu());

		menuBar.setBackground(Color.darkGray);

		return menuBar;
	}

	private JMenu buildGameMenu()
	{
		JMenu gameMenu = new JMenu();
		JMenuItem newGameMenuItem = new JMenuItem();
		JMenuItem loadGameMenuItem = new JMenuItem();
		JMenuItem saveGameMenuItem = new JMenuItem();
		JMenuItem quitMenuItem = new JMenuItem();

		buildMenuItem(
				newGameMenuItem,
				buildGameContent.LabelsProperties.getProperty("newGameMenuItemText"),
				buildGameContent.LabelsProperties.getProperty("newGameMenuItemToolTipText"),
				new NewGameListener());

		buildMenuItem(
				loadGameMenuItem,
				buildGameContent.LabelsProperties.getProperty("loadGameMenuItemText"),
				buildGameContent.LabelsProperties.getProperty("loadGameMenuItemToolTipText"),
				new LoadGameListener());

		buildMenuItem(
				saveGameMenuItem,
				buildGameContent.LabelsProperties.getProperty("saveGameMenuItemText"),
				buildGameContent.LabelsProperties.getProperty("saveGameMenuItemToolTipText"),
				new SaveGameListener());

		buildMenuItem(
				quitMenuItem,
				buildGameContent.LabelsProperties.getProperty("quitMenuItemText"),
				buildGameContent.LabelsProperties.getProperty("quitMenuItemToolTipText"),
				new QuitGameListener());

		buildMenu(
				gameMenu,
				buildGameContent.LabelsProperties.getProperty("gameMenuText"));

		gameMenu.add(newGameMenuItem);
		gameMenu.add(loadGameMenuItem);
		gameMenu.add(saveGameMenuItem);
		gameMenu.add(quitMenuItem);

		return gameMenu;
	}

	private JMenu buildOptionsMenu()
	{
		JMenu optionsMenu = new JMenu();
		JMenuItem settingsMenuItem = new JMenuItem();

		buildMenuItem(
				settingsMenuItem,
				buildGameContent.LabelsProperties.getProperty("settingsMenuItemText"),
				buildGameContent.LabelsProperties.getProperty("settingsMenuItemToolTipText"),
				new SettingsListener());

		buildMenu(
				optionsMenu,
				buildGameContent.LabelsProperties.getProperty("optionsMenuText"));

		optionsMenu.add(settingsMenuItem);
		
		return optionsMenu;
	}

	private JMenu buildHelpMenu()
	{
		JMenu helpMenu = new JMenu();
		JMenuItem helpMenuItem = new JMenuItem();
		JMenuItem updateMenuItem =new JMenuItem();
		JMenuItem aboutMenuItem = new JMenuItem();

		buildMenuItem(
				helpMenuItem,
				buildGameContent.LabelsProperties.getProperty("helpMenuItemText"),
				buildGameContent.LabelsProperties.getProperty("helpMenuItemToolTipText"),
				new HelpListener());

		buildMenuItem(
				updateMenuItem,
				buildGameContent.LabelsProperties.getProperty("updateMenuItemText"),
				buildGameContent.LabelsProperties.getProperty("updateMenuItemToolTipText"),
				new UpdateListener());

		buildMenuItem(
				aboutMenuItem,
				buildGameContent.LabelsProperties.getProperty("aboutMenuItemText"),
				buildGameContent.LabelsProperties.getProperty("aboutMenuItemToolTipText"),
				new AboutListener());

		buildMenu(
				helpMenu,
				buildGameContent.LabelsProperties.getProperty("helpMenuText"));

		helpMenu.add(helpMenuItem);
		helpMenu.add(updateMenuItem);
		helpMenu.add(aboutMenuItem);

		return helpMenu;
	}

	private JMenuItem buildMenuItem(JMenuItem menuItem, String text, String toolTipText, ActionListener listener)
	{
		menuItem.setText(text);
		menuItem.setToolTipText(toolTipText);
		menuItem.setName(text);
		setMenuItemStyle(menuItem);
		menuItem.addActionListener(listener);

		return menuItem;
	}

	private JMenu buildMenu(JMenu menu, String text)
	{
		menu.setText(text);
		menu.setName(text);
		setMenuStyle(menu);

		return menu;
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

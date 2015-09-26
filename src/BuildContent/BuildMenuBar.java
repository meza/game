package BuildContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BuildMenuBar
{
	private final OtherFunctions otherFunctions = new OtherFunctions();
	private final BuildGameContent gameContent = new BuildGameContent();

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
				otherFunctions.getPropertyText("newGameMenuItem"),
				otherFunctions.getPropertyText("newGameMenuItemToolTip"),
				new NewGameListener());

		buildMenuItem(
				loadGameMenuItem,
				otherFunctions.getPropertyText("loadGameMenuItem"),
				otherFunctions.getPropertyText("loadGameMenuItemToolTip"),
				new LoadGameListener());

		buildMenuItem(
				saveGameMenuItem,
				otherFunctions.getPropertyText("saveGameMenuItem"),
				otherFunctions.getPropertyText("saveGameMenuItemToolTip"),
				new SaveGameListener());

		buildMenuItem(
				quitMenuItem,
				otherFunctions.getPropertyText("quitMenuItem"),
				otherFunctions.getPropertyText("quitMenuItemToolTip"),
				new QuitGameListener());

		buildMenu(
				gameMenu,
				otherFunctions.getPropertyText("gameMenu"));

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
				otherFunctions.getPropertyText("settingsMenuItem"),
				otherFunctions.getPropertyText("settingsMenuItemToolTip"),
				new SettingsListener());

		buildMenu(
				optionsMenu,
				otherFunctions.getPropertyText("optionsMenu"));

		optionsMenu.add(settingsMenuItem);

		return optionsMenu;
	}

	private JMenu buildHelpMenu()
	{
		JMenu helpMenu = new JMenu();
		JMenuItem helpMenuItem = new JMenuItem();
		JMenuItem updateMenuItem = new JMenuItem();
		JMenuItem aboutMenuItem = new JMenuItem();

		buildMenuItem(
				helpMenuItem,
				otherFunctions.getPropertyText("helpMenuItem"),
				otherFunctions.getPropertyText("helpMenuItemToolTip"),
				new HelpListener());

		buildMenuItem(
				updateMenuItem,
				otherFunctions.getPropertyText("updateMenuItem"),
				otherFunctions.getPropertyText("updateMenuItemToolTip"),
				new UpdateListener());

		buildMenuItem(
				aboutMenuItem,
				otherFunctions.getPropertyText("aboutMenuItem"),
				otherFunctions.getPropertyText("aboutMenuItemToolTip"),
				new AboutListener());

		buildMenu(
				helpMenu,
				otherFunctions.getPropertyText("helpMenu"));

		helpMenu.add(helpMenuItem);
		helpMenu.add(updateMenuItem);
		helpMenu.add(aboutMenuItem);

		return helpMenu;
	}

	private void buildMenuItem(JMenuItem menuItem, String content, String toolTipText, ActionListener listener)
	{
		menuItem.setText(content);
		menuItem.setToolTipText(toolTipText);
		menuItem.setName(content);
		menuItem.setBackground(Color.darkGray);
		menuItem.setForeground(Color.white);
		menuItem.setFont(otherFunctions.smallFont);
		menuItem.setBorder(otherFunctions.border);
		menuItem.addActionListener(listener);
	}

	private void buildMenu(JMenu menu, String content)
	{
		menu.setText(content);
		menu.setName(content);
		menu.setForeground(Color.white);
		menu.setFont(otherFunctions.smallFont);
	}

	private class NewGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			gameContent.addSelectRacePageToTheMainFrame();
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
					otherFunctions.getPropertyText("quitPanelContent"),
					otherFunctions.getPropertyText("quitPanelTitle"),
					JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null,
					new String[]{
							otherFunctions.getPropertyText("quitPanelYesButton"),
							otherFunctions.getPropertyText("quitPanelNoButton")},
					otherFunctions.getPropertyText("quitPanelNoButton"));

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
					otherFunctions.getPropertyText("aboutPanelContent"),
					otherFunctions.getPropertyText("aboutPanelTitle"),
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
}

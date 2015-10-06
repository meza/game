package BuildContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BuildMenuBar
{
	private static final OtherFunctions otherFunctions = new OtherFunctions();
	private static final BuildGameContent gameContent = new BuildGameContent();

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

		buildMenu(gameMenu, otherFunctions.getPropertyText("gameMenu"));

		gameMenu.add(buildMenuItem(
			             otherFunctions.getPropertyText("newGameMenuItem"),
			             otherFunctions.getPropertyText("newGameMenuItemToolTip"),
			             new NewGameListener()));
		gameMenu.add(buildMenuItem(
			             otherFunctions.getPropertyText("loadGameMenuItem"),
			             otherFunctions.getPropertyText("loadGameMenuItemToolTip"),
			             new LoadGameListener()));
		gameMenu.add(buildMenuItem(
			             otherFunctions.getPropertyText("saveGameMenuItem"),
			             otherFunctions.getPropertyText("saveGameMenuItemToolTip"),
			             new SaveGameListener()));
		gameMenu.add(buildMenuItem(
			             otherFunctions.getPropertyText("quitMenuItem"),
			             otherFunctions.getPropertyText("quitMenuItemToolTip"),
			             new QuitGameListener()));

		return gameMenu;
	}

	private JMenu buildOptionsMenu()
	{
		JMenu optionsMenu = new JMenu();

		buildMenu(optionsMenu, otherFunctions.getPropertyText("optionsMenu"));

		optionsMenu.add(buildMenuItem(
			                otherFunctions.getPropertyText("settingsMenuItem"),
			                otherFunctions.getPropertyText("settingsMenuItemToolTip"),
			                new SettingsListener()));

		return optionsMenu;
	}

	private JMenu buildHelpMenu()
	{
		JMenu helpMenu = new JMenu();

		buildMenu(helpMenu, otherFunctions.getPropertyText("helpMenu"));

		helpMenu.add(buildMenuItem(
			             otherFunctions.getPropertyText("helpMenuItem"),
			             otherFunctions.getPropertyText("helpMenuItemToolTip"),
			             new HelpListener()));
		helpMenu.add(buildMenuItem(
			             otherFunctions.getPropertyText("updateMenuItem"),
			             otherFunctions.getPropertyText("updateMenuItemToolTip"),
			             new UpdateListener()));
		helpMenu.add(buildMenuItem(
			             otherFunctions.getPropertyText("aboutMenuItem"),
			             otherFunctions.getPropertyText("aboutMenuItemToolTip"),
			             new AboutListener()));

		return helpMenu;
	}

	private JMenuItem buildMenuItem(String content, String toolTipText, ActionListener listener)
	{
		JMenuItem menuItem = new JMenuItem();

		menuItem.setText(content);
		menuItem.setToolTipText(toolTipText);
		menuItem.setName(content);
		menuItem.setBackground(Color.darkGray);
		menuItem.setForeground(Color.white);
		menuItem.setFont(otherFunctions.smallFont);
		menuItem.setBorder(otherFunctions.border);
		menuItem.addActionListener(listener);

		return menuItem;
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

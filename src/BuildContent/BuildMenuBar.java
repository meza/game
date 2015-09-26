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
				buildGameContent.LabelsProperties.getProperty("newGameMenuItem"),
				buildGameContent.LabelsProperties.getProperty("newGameMenuItemToolTip"),
				new NewGameListener());

		buildMenuItem(
				loadGameMenuItem,
				buildGameContent.LabelsProperties.getProperty("loadGameMenuItem"),
				buildGameContent.LabelsProperties.getProperty("loadGameMenuItemToolTip"),
				new LoadGameListener());

		buildMenuItem(
				saveGameMenuItem,
				buildGameContent.LabelsProperties.getProperty("saveGameMenuItem"),
				buildGameContent.LabelsProperties.getProperty("saveGameMenuItemToolTip"),
				new SaveGameListener());

		buildMenuItem(
				quitMenuItem,
				buildGameContent.LabelsProperties.getProperty("quitMenuItem"),
				buildGameContent.LabelsProperties.getProperty("quitMenuItemToolTip"),
				new QuitGameListener());

		buildMenu(
				gameMenu,
				buildGameContent.LabelsProperties.getProperty("gameMenu"));

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
				buildGameContent.LabelsProperties.getProperty("settingsMenuItem"),
				buildGameContent.LabelsProperties.getProperty("settingsMenuItemToolTip"),
				new SettingsListener());

		buildMenu(
				optionsMenu,
				buildGameContent.LabelsProperties.getProperty("optionsMenu"));

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
				buildGameContent.LabelsProperties.getProperty("helpMenuItem"),
				buildGameContent.LabelsProperties.getProperty("helpMenuItemToolTip"),
				new HelpListener());

		buildMenuItem(
				updateMenuItem,
				buildGameContent.LabelsProperties.getProperty("updateMenuItem"),
				buildGameContent.LabelsProperties.getProperty("updateMenuItemToolTip"),
				new UpdateListener());

		buildMenuItem(
				aboutMenuItem,
				buildGameContent.LabelsProperties.getProperty("aboutMenuItem"),
				buildGameContent.LabelsProperties.getProperty("aboutMenuItemToolTip"),
				new AboutListener());

		buildMenu(
				helpMenu,
				buildGameContent.LabelsProperties.getProperty("helpMenu"));

		helpMenu.add(helpMenuItem);
		helpMenu.add(updateMenuItem);
		helpMenu.add(aboutMenuItem);

		return helpMenu;
	}

	private void buildMenuItem(JMenuItem menuItem, String text, String toolTipText, ActionListener listener)
	{
		menuItem.setText(text);
		menuItem.setToolTipText(toolTipText);
		menuItem.setName(text);
		menuItem.setBackground(Color.darkGray);
		menuItem.setForeground(Color.white);
		menuItem.setFont(menuFont);
		menuItem.setBorder(border);
		menuItem.addActionListener(listener);
	}

	private void buildMenu(JMenu menu, String text)
	{
		menu.setText(text);
		menu.setName(text);
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
					buildGameContent.LabelsProperties.getProperty("quitPanelContent"),
					buildGameContent.LabelsProperties.getProperty("quitPanelTitle"),
					JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null,
					new String[]{
							buildGameContent.LabelsProperties.getProperty("quitPanelYesButton"),
							buildGameContent.LabelsProperties.getProperty("quitPanelNoButton")},
					buildGameContent.LabelsProperties.getProperty("quitPanelNoButton"));

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
					buildGameContent.LabelsProperties.getProperty("aboutPanelContent"),
					buildGameContent.LabelsProperties.getProperty("aboutPanelTitle"),
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
}

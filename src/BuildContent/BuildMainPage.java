package BuildContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BuildMainPage
{
	private final BuildGameContent buildGameContent = new BuildGameContent();
	private final BuildMenuBar buildMenuBar = new BuildMenuBar();
	private final Font buttonFont = new Font("Monospaced", Font.BOLD, 25);

	JPanel buildMainPage()
	{
		JPanel mainPanel = new JPanel(new GridLayout(2, 1));
		JPanel newGamePanel = new JPanel();
		JPanel loadGamePanel = new JPanel();
		JButton newGameButton = new JButton();
		JButton loadGameButton = new JButton();

		buildButton(
				newGameButton,
				buildGameContent.LabelsProperties.getProperty("newGameButtonText"),
				buildGameContent.LabelsProperties.getProperty("newGameButtonToolTipText"),
				new NewGameListener());

		buildButton(
				loadGameButton,
				buildGameContent.LabelsProperties.getProperty("loadGameButtonText"),
				buildGameContent.LabelsProperties.getProperty("loadGameButtonToolTipText"),
				new LoadGameListener());

		buildNewGamePanel(newGamePanel, newGameButton);
		buildLoadGamePanel(loadGamePanel, loadGameButton);

		mainPanel.add(newGamePanel);
		mainPanel.add(loadGamePanel);

		return mainPanel;
	}

	void buildButton(JButton button, String text, String toolTipText, ActionListener listener)
	{
		button.setBackground(Color.darkGray);
		button.setForeground(Color.white);
		button.setFont(buttonFont);
		button.setBorder(buildMenuBar.border);
		button.setMinimumSize(new Dimension(200, 50));
		button.setMaximumSize(new Dimension(200, 50));
		button.setPreferredSize(new Dimension(200, 50));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setText(text);
		button.setToolTipText(toolTipText);
		button.addActionListener(listener);
	}

	private void buildNewGamePanel(JPanel newGamePanel, JButton newGameButton)
	{
		setPanelStyle(newGamePanel);
		newGamePanel.add(Box.createVerticalGlue());
		newGamePanel.add(newGameButton);
		newGamePanel.add(Box.createRigidArea(new Dimension(0, 5)));
	}

	private void buildLoadGamePanel(JPanel loadGamePanel, JButton loadGameButton)
	{
		setPanelStyle(loadGamePanel);
		loadGamePanel.add(Box.createRigidArea(new Dimension(0, 5)));
		loadGamePanel.add(loadGameButton);
	}

	private void setPanelStyle(JPanel panel)
	{
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBackground(Color.darkGray);
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

}

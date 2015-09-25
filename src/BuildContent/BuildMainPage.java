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

		mainPanel.add(buildNewGamePanel());
		mainPanel.add(buildLoadGamePanel());

		return mainPanel;
	}

	private JPanel buildNewGamePanel()
	{
		JPanel newGamePanel = new JPanel();
		JButton newGameButton = new JButton();

		buildButton(
				newGameButton,
				buildGameContent.LabelsProperties.getProperty("newGameButtonText"),
				buildGameContent.LabelsProperties.getProperty("newGameButtonToolTipText"),
				new NewGameListener());

		setPanelStyle(newGamePanel);
		newGamePanel.add(Box.createVerticalGlue());
		newGamePanel.add(newGameButton);
		newGamePanel.add(Box.createRigidArea(new Dimension(0, 5)));

		return newGamePanel;
	}

	private JPanel buildLoadGamePanel()
	{
		JPanel loadGamePanel = new JPanel();
		JButton loadGameButton = new JButton();

		buildButton(
				loadGameButton,
				buildGameContent.LabelsProperties.getProperty("loadGameButtonText"),
				buildGameContent.LabelsProperties.getProperty("loadGameButtonToolTipText"),
				new LoadGameListener());

		setPanelStyle(loadGamePanel);
		loadGamePanel.add(Box.createRigidArea(new Dimension(0, 5)));
		loadGamePanel.add(loadGameButton);

		return loadGamePanel;
	}

	void buildButton(JButton button, String text, String toolTipText, ActionListener listener)
	{
		button.setText(text);
		button.setToolTipText(toolTipText);
		button.setBackground(Color.darkGray);
		button.setForeground(Color.white);
		button.setFont(buttonFont);
		button.setBorder(buildMenuBar.border);
		button.setMinimumSize(new Dimension(250, 50));
		button.setMaximumSize(new Dimension(250, 50));
		button.setPreferredSize(new Dimension(250, 50));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.addActionListener(listener);
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

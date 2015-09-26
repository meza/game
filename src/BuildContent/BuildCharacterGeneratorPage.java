package BuildContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BuildCharacterGeneratorPage
{
	private final BuildMainPage mainPage = new BuildMainPage();
	private final BuildGameContent gameContent = new BuildGameContent();

	JPanel buildCharacterGeneratorPage()
	{
		JPanel mainPanel = new JPanel(new GridLayout(1, 3));

		mainPanel.add(buildCharacterNamePanel());
		mainPanel.add(buildCharacterStatPanel());
		mainPanel.add(buildStartGamePanel());

		return mainPanel;
	}

	private JPanel buildCharacterNamePanel()
	{
		JPanel characterNamePanel = new JPanel();

		characterNamePanel.setBackground(Color.green);

		return characterNamePanel;
	}

	private JPanel buildCharacterStatPanel()
	{
		JPanel characterStatPanel = new JPanel();

		characterStatPanel.setBackground(Color.yellow);

		return characterStatPanel;
	}

	private JPanel buildStartGamePanel()
	{
		JPanel startGamePanel = new JPanel();
		JButton startGameButton = new JButton();

		mainPage.buildButton(
				startGameButton,
				gameContent.LabelsProperties.getProperty("startGameButtonText"),
				gameContent.LabelsProperties.getProperty("startGameButtonToolTipText"),
				new StartGameListener());

		startGamePanel.setLayout(new BoxLayout(startGamePanel, BoxLayout.PAGE_AXIS));
		startGamePanel.setBackground(Color.cyan);

		startGamePanel.add(Box.createVerticalGlue());
		startGamePanel.add(startGameButton);
		startGamePanel.add(Box.createRigidArea(new Dimension(0,60)));

		return startGamePanel;
	}

	private class StartGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

		}
	}
}

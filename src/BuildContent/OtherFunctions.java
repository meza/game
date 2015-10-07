package BuildContent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

class OtherFunctions
{
	private static final Properties LabelsProperties = new Properties();
	private static final HashMap<String, JTextArea> attributeTextAreaList = new HashMap<>();
	private static final HashMap<String, JMenuItem> menuItemList = new HashMap<>();
	private static String selectedRace = "";
	static JTextField nameField = new JTextField();
	final Font smallFont = new Font("Monospaced", Font.BOLD, 15);
	final Font mediumFont = new Font("Monospaced", Font.BOLD, 20);
	final Font bigFont = new Font("Monospaced", Font.BOLD, 25);
	final Border border = new LineBorder(Color.WHITE, 2, true);

	public OtherFunctions()
	{
		loadProperties();
	}

	private void loadProperties()
	{
		try
		{
			LabelsProperties.load(new FileInputStream("src/StaticContent/Properties/Labels.properties"));
		}
		catch (IOException e)
		{
			System.out.println("Exception Occurred: " + e.getMessage());
		}
	}

	String getPropertyText(String textID)
	{
		return LabelsProperties.getProperty(textID);
	}

	void changeMenuItemState(String menuItemName, Boolean state)
	{
		getMenuItemList(menuItemName).setEnabled(state);
	}

	JButton buildButton(
		String content,
		String toolTipText,
		Font font,
		int width,
		int height,
		ActionListener listener)
	{
		JButton button = new JButton();

		button.setText(content);
		button.setToolTipText(toolTipText);
		button.setBackground(Color.darkGray);
		button.setForeground(Color.white);
		button.setFont(font);
		button.setBorder(border);
		button.setFocusPainted(false);
		button.setMinimumSize(new Dimension(width, height));
		button.setMaximumSize(new Dimension(width, height));
		button.setPreferredSize(new Dimension(width, height));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.addActionListener(listener);

		return button;
	}

	//LINE_AXIS = 2; PAGE_AXIS = 3
	void setPanelStyle(JPanel panel, int axis)
	{
		panel.setLayout(new BoxLayout(panel, axis));
		panel.setBackground(Color.darkGray);
	}

	JLabel buildRaceImage(String imageLocation)
	{
		JLabel iconLabel;
		ImageIcon icon;

		URL imgURL = BuildSelectRacePage.class.getResource(imageLocation);
		icon = new ImageIcon(imgURL);
		iconLabel = new JLabel(icon);
		iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		return iconLabel;
	}

	JTextArea buildTextArea(String content, Font font, int width, int height)
	{
		JTextArea textArea = new JTextArea(content);

		textArea.setFont(font);
		textArea.setBackground(Color.darkGray);
		textArea.setForeground(Color.white);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setMinimumSize(new Dimension(width, height));
		textArea.setMaximumSize(new Dimension(width, height));
		textArea.setPreferredSize(new Dimension(width, height));

		return textArea;
	}

	JTextField buildTextField(String content, Boolean state, int width, int height)
	{
		JTextField textField = new JTextField(content);

		textField.setFont(mediumFont);
		textField.setBackground(Color.darkGray);
		textField.setForeground(Color.white);
		textField.setBorder(border);
		textField.setCaretColor(Color.white);
		textField.setAlignmentX(Component.CENTER_ALIGNMENT);
		textField.setEnabled(state);
		textField.setMinimumSize(new Dimension(width, height));
		textField.setMaximumSize(new Dimension(width, height));
		textField.setPreferredSize(new Dimension(width, height));

		return textField;
	}

	void validateCharacterName()
	{
		String correctName = nameField.getText().replaceAll("[^a-zA-Z0-9 ]", "");

		if (correctName.length() == 0)
		{
			nameField.setText(getPropertyText("offered" + getSelectedRace() + "CharacterName"));
			return;
		}
		if (correctName.length() > 30)
		{
			correctName = correctName.substring(0, 30);
		}

		nameField.setText(correctName);
	}

	void setSelectedRace(String race)
	{
		selectedRace = race;
	}

	String getSelectedRace()
	{
		return selectedRace;
	}

	void setTextAreaList(String textAreaName, JTextArea textArea)
	{
		attributeTextAreaList.put(textAreaName, textArea);
	}

	JTextArea getTextAreaList(String textAreaName)
	{
		return attributeTextAreaList.get(textAreaName);
	}

	void setMenuItemList(String menuItemName, JMenuItem menuItem)
	{
		menuItemList.put(menuItemName, menuItem);
	}

	private JMenuItem getMenuItemList(String menuItemName)
	{
		return menuItemList.get(menuItemName);
	}
}

package BuildContent;

import javax.swing.*;

public class MainFrameBuilder {

    private final JFrame mainFrame;
    private final OtherFunctions otherFunctions;

    public MainFrameBuilder(OtherFunctions otherFunctions) {
        this.mainFrame = new JFrame();
        this.otherFunctions = otherFunctions;
    }

    public JFrame build() {
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(1200, 800);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setVisible(true);
        mainFrame.setTitle(otherFunctions.getPropertyText("mainFrameTitle"));
        mainFrame.validate();
        return mainFrame;

    }
}

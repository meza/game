package BuildContent.Listeners;

import BuildContent.ValueModifier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecreaseValueListener implements ActionListener
{
    private final ValueModifier valueModifier;
    private String attribute;

    public DecreaseValueListener(String attribute, ValueModifier valueModifier) {
        this.valueModifier = valueModifier;
        this.attribute = attribute;
    }

    public void actionPerformed(ActionEvent event)
    {
        valueModifier.decreaseAttributeValue(attribute);
        valueModifier.calculateStatValues();
    }
}

package BuildContent.Listeners;

import BuildContent.ValueModifier;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ListenerFactory {
    private final ValueModifier valueModifier;
    private Map<String, ActionListener> increasers = new HashMap<>();
    private Map<String, ActionListener> decreasers = new HashMap<>();


    public ListenerFactory(ValueModifier valueModifier) {
        this.valueModifier = valueModifier;
    }

    public ActionListener increaserFor(String attribute) {

        if(!increasers.containsKey(attribute)) {
            increasers.put(attribute, new IncreaseValueListener(attribute, valueModifier));
        }

        return increasers.get(attribute);
    }

    public ActionListener decreaserFor(String attribute) {
        if(!decreasers.containsKey(attribute)) {
            decreasers.put(attribute, new DecreaseValueListener(attribute, valueModifier));
        }

        return decreasers.get(attribute);
    }

}

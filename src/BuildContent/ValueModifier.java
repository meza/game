package BuildContent;

import javax.swing.*;

public class ValueModifier {

    private final OtherFunctions otherFunctions;

    public ValueModifier(OtherFunctions otherFunctions) {
        this.otherFunctions = otherFunctions;
    }

    public void decreaseAttributeValue(String attribute) {
        JTextArea attributeValueTextArea = otherFunctions.getTextAreaList(attribute);
        JTextArea availableAttributeValueTextArea = otherFunctions.getTextAreaList("attributePoints");
        int attributeValue = Integer.valueOf(attributeValueTextArea.getText());
        int availableAttributeValue = Integer.valueOf(availableAttributeValueTextArea.getText());

        if ((attributeValue > 1))
        {
            attributeValueTextArea.setText(String.valueOf(attributeValue - 1));
            availableAttributeValueTextArea.setText(String.valueOf(availableAttributeValue + 1));
        }
    }

    public void increaseAttributeValue(String attribute)
    {
        JTextArea attributeValueTextArea = otherFunctions.getTextAreaList(attribute);
        JTextArea availableAttributeValueTextArea = otherFunctions.getTextAreaList("attributePoints");
        int attributeValue = Integer.valueOf(attributeValueTextArea.getText());
        int availableAttributeValue = Integer.valueOf(availableAttributeValueTextArea.getText());

        if ((availableAttributeValue > 0))
        {
            attributeValueTextArea.setText(String.valueOf(attributeValue + 1));
            availableAttributeValueTextArea.setText(String.valueOf(availableAttributeValue - 1));
        }

    }

    public void calculateStatValues()
    {
        JTextArea hitPointsValueTextArea = otherFunctions.getTextAreaList("hitPoints");
        JTextArea meleeDamageValueTextArea = otherFunctions.getTextAreaList("meleeDamage");
        JTextArea rangedDamageValueTextArea = otherFunctions.getTextAreaList("rangedDamage");
        JTextArea magicDamageValueTextArea = otherFunctions.getTextAreaList("magicDamage");
        JTextArea physicalDefenseValueTextArea = otherFunctions.getTextAreaList("physicalDefense");
        JTextArea magicDefenseValueTextArea = otherFunctions.getTextAreaList("magicDefense");
        JTextArea attackSpeedValueTextArea = otherFunctions.getTextAreaList("attackSpeed");
        JTextArea accuracyValueTextArea = otherFunctions.getTextAreaList("accuracy");
        JTextArea evasionValueTextArea = otherFunctions.getTextAreaList("evasion");
        JTextArea strengthValueTextArea = otherFunctions.getTextAreaList("strength");
        JTextArea dexterityValueTextArea = otherFunctions.getTextAreaList("dexterity");
        JTextArea intelligentValueTextArea = otherFunctions.getTextAreaList("intelligent");
        JTextArea agilityValueTextArea = otherFunctions.getTextAreaList("agility");
        JTextArea vitalityValueTextArea = otherFunctions.getTextAreaList("vitality");
        int strengthValue = Integer.valueOf(strengthValueTextArea.getText());
        int dexterityValue = Integer.valueOf(dexterityValueTextArea.getText());
        int intelligentValue = Integer.valueOf(intelligentValueTextArea.getText());
        int agilityValue = Integer.valueOf(agilityValueTextArea.getText());
        int vitalityValue = Integer.valueOf(vitalityValueTextArea.getText());

        hitPointsValueTextArea.setText(String.valueOf(strengthValue + (2 * vitalityValue)));
        meleeDamageValueTextArea.setText(String.valueOf(2 * strengthValue));
        rangedDamageValueTextArea.setText(String.valueOf(2 * dexterityValue));
        magicDamageValueTextArea.setText(String.valueOf(2 * intelligentValue));
        physicalDefenseValueTextArea.setText(String.valueOf(vitalityValue));
        magicDefenseValueTextArea.setText(String.valueOf(intelligentValue));
        attackSpeedValueTextArea.setText(String.valueOf(2 * agilityValue));
        accuracyValueTextArea.setText(String.valueOf(dexterityValue));
        evasionValueTextArea.setText(String.valueOf(agilityValue));
    }

}

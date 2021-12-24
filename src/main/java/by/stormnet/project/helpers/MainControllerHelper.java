package by.stormnet.project.helpers;

import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

public class MainControllerHelper {

    public static void addCheckBoxInfo(ListView<String> listView, CheckBox checkBox) {
        ObservableList<String> items = listView.getItems();
        items.add(checkBox.getText() + " is " + checkBox.isSelected());
        listView.setItems(items);
    }

    public static void addTextAreaInfo(TextArea bigText, RadioButton radioButton) {
        String text = bigText.getText() != null ? bigText.getText() : "";
        String resultText = text.concat(radioButton.getText())
                                .concat(", ");
        bigText.setText(resultText);
    }
}

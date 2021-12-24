package by.stormnet.project.controllers;

import by.stormnet.project.FxApplication;
import by.stormnet.project.models.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.stormnet.project.helpers.MainControllerHelper.addCheckBoxInfo;
import static by.stormnet.project.helpers.MainControllerHelper.addTextAreaInfo;
import static java.util.Objects.requireNonNull;
import static javafx.stage.Modality.WINDOW_MODAL;

public class MainController {

    @FXML
    private MenuBar menuBar;
    @FXML
    private Label labelText;
    @FXML
    private TextField textField;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private ComboBox<String> initComboBox;
    @FXML
    private ListView<String> listView;
    @FXML
    private TextArea bigText;
    @FXML
    private CheckBox checkBox_1;
    @FXML
    private CheckBox checkBox_2;
    @FXML
    private CheckBox checkBox_3;
    @FXML
    private RadioButton radioBtn_1;
    @FXML
    private RadioButton radioBtn_2;
    @FXML
    private RadioButton radioBtn_3;
    @FXML
    private Slider slider;
    @FXML
    private Label spinerLabel;
    @FXML
    private DatePicker datePicker;

    @FXML
    private void initialize() {
        List<String> comboBoxList = new ArrayList<>();
        comboBoxList.add("Item_1");
        comboBoxList.add("Item_2");
        comboBoxList.add("Item_3");
        ObservableList<String> list = FXCollections.observableArrayList(comboBoxList);
        initComboBox.setItems(list);
    }

    @FXML
    protected void onLabelButtonClick() {
        labelText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onReadTextButtonClick() {
        textField.setText("Hello word!");
    }

    @FXML
    protected void onWriteTextButtonClick() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Info");
        alert.setHeaderText(textField.getText());
        Optional<ButtonType> buttonType = alert.showAndWait();
        textField.setText(buttonType.get().getText());
    }

    @FXML
    protected void onComboBoxButtonClick() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(comboBox.getValue());
        alert.showAndWait();
    }

    @FXML
    protected void onCheckBox_1Click() {
        addCheckBoxInfo(listView, checkBox_1);
    }

    @FXML
    protected void onCheckBox_2Click() {
        addCheckBoxInfo(listView, checkBox_2);
    }

    @FXML
    protected void onCheckBox_3Click() {
        addCheckBoxInfo(listView, checkBox_3);
    }

    @FXML
    protected void onRadioBtn_1Click() {
        addTextAreaInfo(bigText, radioBtn_1);
    }

    @FXML
    protected void onRadioBtn_2Click() {
        addTextAreaInfo(bigText, radioBtn_2);
    }

    @FXML
    protected void onRadioBtn_3Click() {
        addTextAreaInfo(bigText, radioBtn_3);
    }

    @FXML
    protected void onSliderButtonClick() {
        int sliderValue = (int) slider.getValue();
        spinerLabel.setText(Integer.toString(sliderValue));
    }

    @FXML
    protected void onTableWindowShow(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(FxApplication.class.getResource("table.fxml")); //создаем загрузчик
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("My modal window");
        stage.initModality(WINDOW_MODAL);
        stage.initOwner(((Node)event.getSource()).getScene().getWindow());
        TableController tableController = loader.getController(); //получаем контроллер
        Person newPerson = new Person(textField.getText(), (int) slider.getValue(), Person.Position.DEV);
        tableController.onTransferData(newPerson); //передаем данные
        stage.show();
    }

    @FXML
    protected void onQuit() {
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void onDatePickerChoose() {
        LocalDate datePickerValue = datePicker.getValue();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        labelText.setText(datePickerValue.format(dateFormat));
    }
}
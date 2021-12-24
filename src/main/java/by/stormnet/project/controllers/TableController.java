package by.stormnet.project.controllers;

import by.stormnet.project.models.Person;
import by.stormnet.project.models.Person.Position;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import static by.stormnet.project.models.Person.Position.*;

public class TableController {

    private ObservableList<Person> persons = FXCollections.observableArrayList();

    @FXML
    private TableView<Person> table;
    @FXML
    private TableColumn<Person, String> name;
    @FXML
    private TableColumn<Person, Integer> age;
    @FXML
    private TableColumn<Person, Position> position;

    @FXML
    private void initialize() {
        initData();

        name.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        age.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
        position.setCellValueFactory(new PropertyValueFactory<Person, Position>("position"));

        table.setItems(persons);
    }

    private void initData() {
        persons.add(new Person("Tom Anderson", 27, DEV));
        persons.add(new Person("Pit Parker", 31, QA));
        persons.add(new Person("Nick Adams", 29, AQA));
        persons.add(new Person("Kate Note", 36, BA));
    }

    private void initDataNew() {
        persons.clear();
        persons.add(new Person("Nick Jonson", 21, DEV));
        persons.add(new Person("Fitch Samuel", 30, QA));
        persons.add(new Person("Mike Dalas", 23, QA));
        persons.add(new Person("Mary Susen", 32, BA));
    }

    @FXML
    protected void onWriteTable() {
        table.setItems(null);
        initDataNew();
        table.setItems(persons);
    }

    @FXML
    protected void onReadTable() {
        int row = table.getSelectionModel().getFocusedIndex();
        Person selectPerson = table.getItems().get(row);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(selectPerson.toString());
        alert.showAndWait();
    }

    @FXML
    protected void onAddRow() {
        ObservableList<Person> items = table.getItems();
        Person newPerson = new Person("Nick Addson", 33, DEV);
        items.add(newPerson);
    }

    @FXML
    protected void onRemoveRow() {
        int row = table.getSelectionModel().getFocusedIndex();
        Person selectPerson = table.getItems().get(row);
        table.getItems().remove(selectPerson);
    }

    @FXML
    protected void onTransferData(Person newPerson) {
        table.getItems().add(newPerson);
//        ObservableList<Person> items = table.getItems();
//        items.add(newPerson);
    }
}

module by.stormnet.project {
    requires javafx.controls;
    requires javafx.fxml;


    opens by.stormnet.project to javafx.fxml;
    exports by.stormnet.project;
    exports by.stormnet.project.controllers;
    exports by.stormnet.project.models;
    opens by.stormnet.project.controllers to javafx.fxml;
}
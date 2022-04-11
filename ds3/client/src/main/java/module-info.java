module by.bakhar.bsu.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;


    opens by.bsu.bakhar to javafx.fxml;
    exports by.bsu.bakhar;
    opens by.bsu.bakhar.controller to javafx.fxml;
    exports by.bsu.bakhar.controller;
}
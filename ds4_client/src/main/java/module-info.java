module by.bsu.bakhar.ds4_client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;

    opens by.bsu.bakhar to javafx.fxml;
    exports by.bsu.bakhar;
    opens by.bsu.bakhar.controller;
    exports by.bsu.bakhar.controller;
    opens by.bsu.bakhar.ds4_client to javafx.fxml;
    exports by.bsu.bakhar.ds4_client;
}
module by.bakhar.ds {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires mysql.connector.java;

    opens by.bsu.bakhar to javafx.fxml;
    exports by.bsu.bakhar;
    opens by.bsu.bakhar.controller to javafx.fxml;
    exports by.bsu.bakhar.controller;


}
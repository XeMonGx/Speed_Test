module fxml.speed_test {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens gui to javafx.fxml;
    exports gui;
    exports model;
    opens model to javafx.fxml;
    exports model.clicktest;
    opens model.clicktest to javafx.fxml;
}
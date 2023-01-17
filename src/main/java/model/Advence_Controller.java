package model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class Advence_Controller {

    @FXML
    public void back(ActionEvent event) throws IOException {
        Menu_Controller.changePane(event,"menu.fxml");
    }
}

package model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class Game_Selection_Controller {

    @FXML
    public void clickTest(ActionEvent event) throws IOException {
        Menu_Controller.changePane(event,"click_test.fxml");
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
        Menu_Controller.changePane(event,"menu.fxml");
    }
}

package model;

import gui.Speed_Test_GUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Game_Selection_Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void clickTest(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Speed_Test_GUI.class.getResource("click_test.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,1200,720);
        stage.setScene(scene);
        stage.show();
    }
}

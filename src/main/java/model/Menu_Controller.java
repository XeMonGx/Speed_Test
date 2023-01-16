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


public class Menu_Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void playButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Speed_Test_GUI.class.getResource("game_selection.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,1200,720);
        stage.setScene(scene);
        stage.show();
    }
}

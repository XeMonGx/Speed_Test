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
import java.util.Objects;


public class Menu_Controller {

    @FXML
    public void playButton(ActionEvent event) throws IOException {
        changePane(event,"game_selection.fxml");
    }

    @FXML
    public void advanceButton(ActionEvent event) throws IOException {
        changePane(event,"advance.fxml");
    }

    public static void changePane(ActionEvent event, String file) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(Speed_Test_GUI.class.getResource(file)));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,1200,720);
        stage.setScene(scene);
        stage.show();
    }
}

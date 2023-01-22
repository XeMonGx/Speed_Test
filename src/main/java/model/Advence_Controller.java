package model;

import dao.Advance_DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;

public class Advence_Controller {

    private Advance_DAO data;
    @FXML
    private LineChart linechart;
    @FXML
    private ChoiceBox<String> choiceSec;
    private String[] sec = {"1","2","5","10","15"};

    @FXML
    public void initialize(){
        String url = "jdbc:mysql://localhost:3306/SpeedTestDB";
        String username = "root";
        String password = "guillaume";
        data = new Advance_DAO(url,username,password);
        linechart.setTitle("Click");
        linechart.getData().add(data.getClickTest(5));
        choiceSec.setValue("5");
        choiceSec.getItems().addAll(sec);
        choiceSec.setOnAction(this::getScore);
    }

    public void getScore(ActionEvent event){
        linechart.getData().remove(0);
        linechart.getData().add(data.getClickTest(Integer.parseInt(choiceSec.getValue())));
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
        Menu_Controller.changePane(event,"menu.fxml");
    }
}

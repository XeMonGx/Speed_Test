package model.clicktest;

import dao.Click_Test_DAO;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Click_Test_Controller {

    @FXML
    private Label timer;
    @FXML
    private Label nb_click;
    @FXML
    private Button click_button;
    private Timeline timeline;
    private Chrono chrono;
    private boolean first;
    private int nbClick;
    private int sec;
    private Click_Test_DAO data;

    public Click_Test_Controller(){
        String url = "jdbc:mysql://localhost:3306/SpeedTestDB";
        String username = "root";
        String password = "guillaume";
        data = new Click_Test_DAO(url,username,password);
        sec = 5;
        nbClick = 0;
        first = true;
        chrono = new Chrono();
        timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            if(chrono.ss.get() == sec-1 && chrono.th.get() == 9 && chrono.hd.get() == 9) {
                timeline.stop();
                click_button.setVisible(false);
                Click_Test_DB val = new Click_Test_DB(data.getSize(),"guillaume",nbClick,sec);
                data.add(val);
            }
            chrono.update();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    @FXML
    public void initialize(){
        timer.textProperty().bind(Bindings.format("%02d:%d%d",chrono.ss,chrono.th,chrono.hd));
    }

    @FXML
    public void click(){
        if(first) {
            timeline.play();
            first = false;
        }
        nbClick++;
        nb_click.setText(Integer.toString(nbClick));
    }

    @FXML
    public void b1Sec(){
        sec = 1;
    }
    @FXML
    public void b2Sec(){
        sec = 2;
    }
    @FXML
    public void b5Sec(){
        sec = 5;
    }
    @FXML
    public void b10Sec(){
        sec = 10;
    }
    @FXML
    public void b15Sec(){
        sec = 15;
    }

    @FXML
    public void reset(){
        first = true;
        timeline.stop();
        chrono.reset();
        nbClick = 0;
        nb_click.setText("0");
        click_button.setVisible(true);
    }

}
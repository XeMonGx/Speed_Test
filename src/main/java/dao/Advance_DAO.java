package dao;

import javafx.scene.chart.XYChart;

import java.sql.*;

public class Advance_DAO {

    private String url;
    private String username;
    private String password;

    public Advance_DAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public XYChart.Series getClickTest(int sec){
        try {
            XYChart.Series series = new XYChart.Series();
            Connection con = DriverManager.getConnection(url,username,password);
            Statement statement = con.createStatement();
            ResultSet resultCount = statement.executeQuery("select nbClick from clickTest where second = "+ sec + ";");
            resultCount.next();
            int i = 0;
            do{
                series.getData().add(new XYChart.Data(String.valueOf(i),resultCount.getInt(1)));
                i++;
            }while (resultCount.next());
            series.setName(sec + "s");
            return series;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

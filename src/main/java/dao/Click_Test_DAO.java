package dao;


import model.Click_Test_DB;

import java.sql.*;

public class Click_Test_DAO {

    private String url;
    private String username;
    private String password;

    public Click_Test_DAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void add(Click_Test_DB clickTestDb){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            if(clickTestDb.getId() != 0){
                PreparedStatement statement = con.prepareStatement(
                        "insert into clickTest values (?,?,?,?,?)"
                );
                statement.setInt(1,clickTestDb.getId());
                statement.setDate(2,clickTestDb.getDate());
                statement.setString(3,clickTestDb.getName());
                statement.setInt(4,clickTestDb.getNbClick());
                statement.setInt(5,clickTestDb.getSecond());
                statement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getSize(){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) from clickTest;");
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

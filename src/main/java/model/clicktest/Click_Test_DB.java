package model.clicktest;

import java.sql.Date;

public class Click_Test_DB {

    private final int id;
    private final Date date;
    private final String name;
    private final int nbClick;
    private final int second;

    public Click_Test_DB(int id, String name, int nbClick, int second) {
        this.id = id;
        this.date = Date.valueOf(java.time.LocalDate.now());
        this.name = name;
        this.nbClick = nbClick;
        this.second = second;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public int getNbClick() {
        return nbClick;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Click_Test_DB{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", nbClick=" + nbClick +
                ", second=" + second +
                '}';
    }

}

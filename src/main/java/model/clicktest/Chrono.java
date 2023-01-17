package model.clicktest;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Chrono {

    public IntegerProperty ss = new SimpleIntegerProperty();
    public IntegerProperty th = new SimpleIntegerProperty();
    public IntegerProperty hd = new SimpleIntegerProperty();
    private final IntegerProperty cpt = new SimpleIntegerProperty();

    public void update(){
        cpt.set((cpt.get()) + 1);
        hd.set((cpt.get()) % 10);
        th.set((cpt.get() / 10) % 10);
        ss.set((cpt.get() / 100) % 60);
    }

    public void reset(){
        cpt.set(0);
        hd.set(0);
        th.set(0);
        ss.set(0);
    }

}

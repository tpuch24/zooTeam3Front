package zooapp.jmdel.fr.zooapp.model.Food;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by jean-michel on 07/06/2016.
 */

public class Food implements Serializable {
    //protected long index;
    protected String name;
    protected String type;
    protected Double stock;
    protected String unity;
    protected String eater; //Check Enum en_eater_type

    public Food(String name,String type,Double stock,String unity,String eater) {
        //this.index = index;
        this.name = name;
        this.type = type;
        this.stock = stock;
        this.unity = unity;
        this.eater = eater;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public String getEater () {
        return eater;
    }

    public void setEater (String eater) {
        this.eater = eater;
    }
}


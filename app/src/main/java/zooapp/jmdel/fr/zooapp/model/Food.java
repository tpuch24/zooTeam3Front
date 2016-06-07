package zooapp.jmdel.fr.zooapp.model;

import java.util.Enumeration;

/**
 * Created by jean-michel on 07/06/2016.
 */

public class Food {

    protected String name;
    protected String type;
    protected Double stock;
    protected String unity;
    protected String eater_type; //Check Enum en_eater_type

    public Food(String name,String type,Double stock,String unity,String eater_type ) {

        this.name = name;
        this.type = type;
        this.stock = stock;
        this.unity = unity;
        this.eater_type = eater_type;
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

    public String getEater_type() {
        return eater_type;
    }

    public void setEater_type(String eater_type) {
        this.eater_type = eater_type;
    }
}


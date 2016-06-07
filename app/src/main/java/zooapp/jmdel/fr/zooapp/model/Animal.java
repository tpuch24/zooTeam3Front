package zooapp.jmdel.fr.zooapp.model;

/**
 * Created by Thierry on 06/06/2016.
 */
public class Animal {

    protected String name;
    protected String specy;
    protected int age;

    public Animal(int age, String specy, String name) {
        this.age = age;
        this.specy = specy;
        this.name = name;
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public String getSpecy() {
        return specy;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecy(String specy) {
        this.specy = specy;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

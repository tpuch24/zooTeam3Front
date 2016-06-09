package zooapp.jmdel.fr.zooapp.model;

import java.io.Serializable;
import java.util.Date;

public class Ticket implements Serializable{
    int id;
    String category;
    String date;
    int number_sold;
    int income;

    public Ticket(int id, int income, String category, String date, int number_sold) {
        this.id = id;
        this.income = income;
        this.category = category;
        this.date = date;
        this.number_sold = number_sold;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumber_sold() {
        return number_sold;
    }

    public void setNumber_sold(int number_sold) {
        this.number_sold = number_sold;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

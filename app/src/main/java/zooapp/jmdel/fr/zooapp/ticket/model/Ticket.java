package zooapp.jmdel.fr.zooapp.ticket.model;

import java.io.Serializable;
import java.util.Date;

public class Ticket implements Serializable{
    String category;
    String date;
    int numberSold;
    int income;
    int id;

    public Ticket(int id, int income, String category, String date, int numberSold) {
        this.id = id;
        this.income = income;
        this.category = category;
        this.date = date;
        this.numberSold = numberSold;
    }

    public Ticket() {
        this.id=0;
        this.income = 0;
        this.category = "";
        this.date = "";
        this.numberSold = 0;
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

    public int getNumberSold() {
        return numberSold;
    }

    public void setNumberSold(int numberSold) {
        this.numberSold = numberSold;
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

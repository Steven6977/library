package entity;

import util.Constants;
//import util.Constants;

public class Book extends Entity{
    private int    id;
    private String name;
    private String author;
    private String publisher;
    private int state;
    private String stateCn;
    
    public Book() {

    }
    

    public Book(String n, String a, String p) {
        this.name = n;
        this.author = a;
        this.publisher = p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        setStateCn();
    }
    
    public String getStateCN() {
        return stateCn;
    }

    public void setStateCn() {
        switch (state) {
            case Constants.int_inavailable:
            	stateCn = Constants.inavailable;
                break;
            case Constants.int_available:
            	stateCn = Constants.available;
                break;
        }
    }
}

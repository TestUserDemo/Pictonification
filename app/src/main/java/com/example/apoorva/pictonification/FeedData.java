package com.example.apoorva.pictonification;

public class FeedData {

    String message;
    String title;
    String name;
    String date;

    public FeedData(){}

    public FeedData(String message, String title, String name, String time) {
        this.message = message;
        this.title = title;
        this.name = name;
        this.date = time;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}

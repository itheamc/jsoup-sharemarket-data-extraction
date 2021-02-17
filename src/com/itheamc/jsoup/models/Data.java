package com.itheamc.jsoup.models;

public class Data {
    private int id;
    private String title;
    private String value;

    // COnstructor
    public Data(int id, String title, String value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }


    // Overriding toString() method
    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

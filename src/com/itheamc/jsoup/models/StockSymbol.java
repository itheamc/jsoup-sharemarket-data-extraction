package com.itheamc.jsoup.models;

public class StockSymbol {
    private int id;
    private String symbol;

    // Constructor
    public StockSymbol() {
    }

    // Constructor with parameters
    public StockSymbol(int id, String symbol) {
        this.id = id;
        this.symbol = symbol;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    // Overriding toString() method
    @Override
    public String toString() {
        return "StockSymbol{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}

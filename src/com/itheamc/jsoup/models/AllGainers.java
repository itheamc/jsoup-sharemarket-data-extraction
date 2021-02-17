package com.itheamc.jsoup.models;

public class AllGainers {
    private int id;
    private String symbol;
    private String lastTradingPrice;
    private String percentChange;

    // Constructor
    public AllGainers() {
    }

    // Constructor with parameters
    public AllGainers(int id, String symbol, String lastTradingPrice, String percentChange) {
        this.id = id;
        this.symbol = symbol;
        this.lastTradingPrice = lastTradingPrice;
        this.percentChange = percentChange;
    }


    // Getters
    public int getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getLastTradingPrice() {
        return lastTradingPrice;
    }

    public String getPercentChange() {
        return percentChange;
    }


    // Overriding toString() method
    @Override
    public String toString() {
        return "AllGainers{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", lastTradingPrice='" + lastTradingPrice + '\'' +
                ", percentChange='" + percentChange + '\'' +
                '}';
    }
}

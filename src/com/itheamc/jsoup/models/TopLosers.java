package com.itheamc.jsoup.models;

public class TopLosers {
    private int id;
    private String symbol;
    private String lastTradingPrice;
    private String pointChange;
    private String percentChange;

    // Constructor
    public TopLosers() {
    }

    // Constructor with parameters
    public TopLosers(int id, String symbol, String lastTradingPrice, String pointChange, String percentChange) {
        this.id = id;
        this.symbol = symbol;
        this.lastTradingPrice = lastTradingPrice;
        this.pointChange = pointChange;
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

    public String getPointChange() {
        return pointChange;
    }

    public String getPercentChange() {
        return percentChange;
    }


    // Overriding toString() method
    @Override
    public String toString() {
        return "TopLosers{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", lastTradingPrice='" + lastTradingPrice + '\'' +
                ", pointChange='" + pointChange + '\'' +
                ", percentChange='" + percentChange + '\'' +
                '}';
    }
}

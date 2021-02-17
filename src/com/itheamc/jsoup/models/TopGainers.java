package com.itheamc.jsoup.models;

public class TopGainers {
    private int id;
    private String symbol;
    private String lastTradingPrice;
    private String pointChange;
    private String percentChange;

    // Constructor
    public TopGainers() {
    }

    // Constructor with parameters
    public TopGainers(int id, String symbol, String lastTradingPrice, String pointChange, String percentChange) {
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
        return "TopGainers{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", lastTradingPrice='" + lastTradingPrice + '\'' +
                ", pointChange='" + pointChange + '\'' +
                ", percentChange='" + percentChange + '\'' +
                '}';
    }
}

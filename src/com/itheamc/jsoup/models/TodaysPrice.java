package com.itheamc.jsoup.models;

public class TodaysPrice {
    private String id;
    private String companyName;
    private String transactionsNumber;
    private String maxPrice;
    private String minPrice;
    private String closingPrice;
    private String tradedShares;
    private String previousClosing;
    private String difference;

    // Empty Constructor
    public TodaysPrice() {
    }


    // Constructor with parameters
    public TodaysPrice(String id, String companyName, String transactionsNumber, String maxPrice, String minPrice, String closingPrice, String tradedShares, String previousClosing, String difference) {
        this.id = id;
        this.companyName = companyName;
        this.transactionsNumber = transactionsNumber;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.closingPrice = closingPrice;
        this.tradedShares = tradedShares;
        this.previousClosing = previousClosing;
        this.difference = difference;
    }


    // Getters
    public String getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getTransactionsNumber() {
        return transactionsNumber;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public String getClosingPrice() {
        return closingPrice;
    }

    public String getTradedShares() {
        return tradedShares;
    }

    public String getPreviousClosing() {
        return previousClosing;
    }

    public String getDifference() {
        return difference;
    }


    // Overriding toString() method
    @Override
    public String toString() {
        return "TodaysPrice{" +
                "id='" + id + '\'' +
                ", companyName='" + companyName + '\'' +
                ", transactionsNumber='" + transactionsNumber + '\'' +
                ", maxPrice='" + maxPrice + '\'' +
                ", minPrice='" + minPrice + '\'' +
                ", closingPrice='" + closingPrice + '\'' +
                ", tradedShares='" + tradedShares + '\'' +
                ", previousClosing='" + previousClosing + '\'' +
                ", difference='" + difference + '\'' +
                '}';
    }
}

package com.itheamc.jsoup;

import com.itheamc.jsoup.models.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NepalStockExchange {
    private static final String BASE_URL = "http://www.nepalstock.com/";
    private static final String todays_price_url = "main/todays_price/";

    // Creating main method
    public static void main(String[] args) {
//        System.out.println(getTodaysPriceData(2).toString());
//        System.out.println(getStockSymbol());
//        System.out.println(getPageNumbers());
//        System.out.println(getTopGainers());
//        System.out.println(getTopLosers());
        System.out.println(getAllGainersLosers("gainers"));
    }


    // Function to extract today's price data
    private static List<TodaysPrice> getTodaysPriceData(int page) {

        String url = BASE_URL + todays_price_url;
        if (page > 0) {
            url =  url + "index/" + page + "/";
        }

        // Creating Empty List
        List<TodaysPrice> todaysPriceList = new ArrayList<>();
        // Emplementing Jsoup Library
        try {
            Document document = Jsoup.connect(url).get();
            Element body = document.body();

            // Getting the list of table elements from the body
            Elements tables = body.getElementsByTag("table");
            if (tables.size() > 0) {
                for (Element table: tables) {
                    Element tBody = table.selectFirst("tbody");
                    if (tBody != null) {
                        // if table body is not null or exist there
                        Elements tableRows = tBody.getElementsByTag("tr");
                        for (Element tr: tableRows) {
                            Elements td = tr.getElementsByTag("td");
                            if (td.size() > 6) {
                                String td1 = td.get(0).text();
                                String td2 = td.get(1).text();
                                String td3 = td.get(2).text();
                                String td4 = td.get(3).text();
                                String td5 = td.get(4).text();
                                String td6 = td.get(5).text();
                                String td7 = td.get(6).text();
                                String td8 = td.get(7).text();
                                String td9 = td.get(8).text();

                                // Adding to the list
                                todaysPriceList.add(new TodaysPrice(
                                        td1,
                                        td2,
                                        td3,
                                        td4,
                                        td5,
                                        td6,
                                        td7,
                                        td8,
                                        td9
                                ));
                            }

                        }
                        break;
                    }
                }

//                // Printing the listItems
//                System.out.println(todaysPriceList.toString());
            } else {
                System.out.println("Something went wrong");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return todaysPriceList;
    }


    // Function to extract list of stock symbols
    private static List<StockSymbol> getStockSymbol() {
        List<StockSymbol> stockSymbolList = new ArrayList<>();
        String url = BASE_URL + todays_price_url;
        try {
            Document document = Jsoup.connect(url).get();
            Element body = document.body();

            Elements allElements = body.getAllElements();

            // Getting element consisting list of symbols
            for (Element element: allElements) {
                if (element.hasClass("stock-symbol")) {
                    Elements options = element.getElementsByTag("option");
                    for (int i = 1; i < options.size(); i++) {
                        stockSymbolList.add(new StockSymbol(
                                i,
                                options.get(i).text()
                        ));
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stockSymbolList;
    }

    // Function to get the number of pages
    private static int getPageNumbers() {
        String url = BASE_URL + todays_price_url;

        int tempPage = 0;
        try {
            Document document = Jsoup.connect(url).get();
            Element body = document.body();

            Elements allElements = body.getAllElements();

            // Getting element consisting list of symbols
            for (Element element: allElements) {
                if (element.hasClass("pager")) {
                    Elements pages = element.getElementsByTag("a");
                    tempPage = pages.size()-1;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tempPage;
    }

    // Function to get the list of top-gainers
    private static List<TopGainers> getTopGainers() {
        List<TopGainers> topGainersList = new ArrayList<>();

        try {
            Document document = Jsoup.connect(BASE_URL).get();
            Element body = document.body();

            // Get all elements of the body
            Elements allElements = body.getAllElements();

            // Getting the table having the id of "top-gainers"
            for (Element element: allElements) {
                Element gainersElement = element.selectFirst("#top-gainers");
                if (gainersElement != null) {
                    Element tbody = gainersElement.selectFirst("tbody");
                    Elements tableRows = tbody.getElementsByAttributeValue("valign", "top");
                    for (int i = 0; i < tableRows.size(); i++) {
                        Elements tableDatas = tableRows.get(i).getElementsByTag("td");
                        if (tableDatas.size() > 3) {
                            String symbol = tableDatas.get(0).text();
                            String ltp = tableDatas.get(1).text();
                            String pointChange = tableDatas.get(2).text();
                            String percentChange = tableDatas.get(3).text();

                            topGainersList.add(new TopGainers(
                                    i+1,
                                    symbol,
                                    ltp,
                                    pointChange,
                                    percentChange
                            ));
                        }

                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return topGainersList;
    }


    // Function to get the list of top-losers
    private static List<TopLosers> getTopLosers() {
        List<TopLosers> topLosersList = new ArrayList<>();

        try {
            Document document = Jsoup.connect(BASE_URL).get();
            Element body = document.body();

            // Get all elements of the body
            Elements allElements = body.getAllElements();

            // Getting the table having the id of "top-losers"
            for (Element element: allElements) {
                Element gainersElement = element.selectFirst("#top-losers");
                if (gainersElement != null) {
                    Element tbody = gainersElement.selectFirst("tbody");
                    Elements tableRows = tbody.getElementsByAttributeValue("valign", "top");
                    for (int i = 0; i < tableRows.size(); i++) {
                        Elements tableDatas = tableRows.get(i).getElementsByTag("td");
                        if (tableDatas.size() > 3) {
                            String symbol = tableDatas.get(0).text();
                            String ltp = tableDatas.get(1).text();
                            String pointChange = tableDatas.get(2).text();
                            String percentChange = tableDatas.get(3).text();

                            topLosersList.add(new TopLosers(
                                    i+1,
                                    symbol,
                                    ltp,
                                    pointChange,
                                    percentChange
                            ));
                        }

                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return topLosersList;
    }


    // Function to get the list of all top gainers
    /*
    pass parameter -- 'gainers' for all gainers list
    and -- 'losers' for all losers list
     */
    private static List<AllGainersLosers> getAllGainersLosers(String gainers_or_losers) {
        List<AllGainersLosers> allGainersLosers = new ArrayList<>();
        String url = BASE_URL + gainers_or_losers;
        try {
            Document document = Jsoup.connect(url).get();
            Element body = document.body();

            // Get all elements of the body
            Elements allElements = body.getAllElements();

            // Getting the table having the id of "top-gainers"
            for (Element element: allElements) {
                Element gainersElement = element.selectFirst(".dataTable");
                if (gainersElement != null) {
                    Element tbody = gainersElement.selectFirst("tbody");
                    Elements tableRows = tbody.getElementsByClass("row1");
                    for (int i = 0; i < tableRows.size(); i++) {
                        Elements tableDatas = tableRows.get(i).getElementsByTag("td");
                        if (tableDatas.size() > 2) {
                            String symbol = tableDatas.get(0).text();
                            String ltp = tableDatas.get(1).text();
                            String percentChange = tableDatas.get(2).text();

                            allGainersLosers.add(new AllGainersLosers(
                                    i+1,
                                    symbol,
                                    ltp,
                                    percentChange
                            ));
                        }

                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allGainersLosers;
    }
}

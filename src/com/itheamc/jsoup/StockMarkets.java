package com.itheamc.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class StockMarkets {
    private static final String INFO_PAGE_URL = "https://merolagani.com/CompanyDetail.aspx?symbol=NBL";

//    This is the main function which is the starting point of the java
    public static void main(String[] args) {
        getCompanyInfo();
    }

    private static void getCompanyInfo() {
        try {
            Document document = Jsoup.connect(INFO_PAGE_URL).get();
            Element body = document.body();
            Elements companyNameElements = body.select(".page-header");
            Element companyName = companyNameElements.get(0);

            Element infoTable = body.getElementById("accordion");
            System.out.println(companyName.text());
            System.out.println(infoTable);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

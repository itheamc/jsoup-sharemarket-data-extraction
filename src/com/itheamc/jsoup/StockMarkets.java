package com.itheamc.jsoup;

import com.itheamc.jsoup.model.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            Elements tableBodies = infoTable.select(".panel ");

            // Sector Title
            Element sectorTitle = tableBodies.get(0).getElementsByTag("td").get(0);
            // Sector Value
            Element sectorValue = tableBodies.get(0).getElementsByTag("tr").get(0);

            // Extracting required data and added to the list
            List<Data> dataList = new ArrayList<>();
            for (int i = 0; i < tableBodies.size(); i++) {
                Element tempElement = tableBodies.get(i).getElementsByTag("tr").get(0);
                String title = tempElement.getElementsByTag("th").text();
                String value = tempElement.getElementsByTag("td").text();
                dataList.add(new Data(i+1, title, value));
            }


            System.out.println(dataList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

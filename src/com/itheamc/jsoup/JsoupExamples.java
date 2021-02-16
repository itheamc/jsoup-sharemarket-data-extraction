package com.itheamc.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupExamples {
    public static final String NAGARIK_BUSINESS_URL = "https://nagariknews.nagariknetwork.com/economy";
    public static final String ABHIYAN_DAILY = "https://www.abhiyandaily.com/abhiyanmarket";
    public static final String IP_ADDRESS = "http://192.168.1.16/cgi-bin/luci/web";
    public static final String flipkart = "https://www.flipkart.com";
    public static final String BLOG_URL = "https://itheamc.blogspot.com/";
    public static final String google_url = "https://www.google.com/";
    public static final String bing_url = "https://www.bing.com/";
    public static final String coinmarketcap = "https://coinmarketcap.com/";

    public static void main(String[] args) {
        getCryptoList();
    }

    // Function to extract post form nagarik news
    private static void extractNagarikNews() {
        try {
            Document document = Jsoup.connect(NAGARIK_BUSINESS_URL).get();
            Element body = document.body();
            Elements elements = body.select(".articles").select(".list-group-item");
            int id = 1;
            for (Element element : elements) {
                System.out.printf("\n(%d) %s", id, element.select("h1").get(0).text());
                System.out.printf("\n\t imageUrl -- %s", element.selectFirst("img").attr("src"));
                System.out.printf("\n\t Summary -- %s\n", element.select("p").get(0).text());
                id += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to extract post form Abhiyan News
    private static void extractAbhiyanNews() {
        try {
            Document document = Jsoup.connect(ABHIYAN_DAILY).get();
            Element body = document.body();
            Elements elements = body.select(".row").select(".card");
            int id = 1;
            for (Element element : elements) {
                if (id > 10) {
                    break;
                }
                System.out.printf("\n(%d) %s", id, element.select("h5").get(0).text());
                System.out.printf("\n\t imageUrl -- %s", element.selectFirst("img").attr("src"));
                System.out.printf("\n\t Summary -- %s", element.select("p").get(1).text());
                System.out.printf("\n\t Link -- %s\n", element.selectFirst("a").attr("href"));
                id += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to extract post form Flipkart.com
    private static void extractFlipkartProducts() {
        try {
            Document document = Jsoup.connect(flipkart).get();
            Element body = document.body();
            Elements elements = body.select("._3FqKqJ").select(".col-12-12");
//            System.out.println(elements);
            int id = 1;
            int tempnum = 1;
            for (Element element : elements) {
                if (id < 6) {
                    id += 1;
                    continue;
                } else if (tempnum > 23) {
                    break;
                }
                System.out.printf("\n(%d) imageUrl -- %s", tempnum, element.selectFirst(".CXW8mj").selectFirst("img").attr("src"));
                id += 1;
                tempnum += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Network ip
    private static void getNetworkSetting() {
        try {
            Document document = Jsoup.connect(IP_ADDRESS).get();
            Element body = document.body();
            Element inputPass = body.getElementById("password");
            Element btn = body.getElementById("btnRtSubmit");
            btn.attr("onclick", "loginHandle()");
            inputPass.appendText("just4mine");
            System.out.println(btn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to extract posts from the blogspot
    private static void extractBlogPosts() {
        try {
            Document document = Jsoup.connect(BLOG_URL).get();
            Element body = document.body();
            Element postSection = body.getElementById("main");
            Elements posts = postSection.select(".col-sm-12");

            int id = 1;
            for (Element post : posts) {
                String title = post.selectFirst(".article-name").selectFirst("a").text();
                String postLink = post.selectFirst(".article-name").selectFirst("a").attr("href");
                String imageUrl = post.selectFirst(".image-wrap").selectFirst("img").attr("src");
                String summary = post.selectFirst(".post-description").selectFirst("p").text();
                System.out.printf("\n(%d) Title -- %s", id, title);
                System.out.printf("\n\t Summary -- %s", summary.replace("@tutorialfinance ", ""));
                System.out.printf("\n\t Post Link -- %s", postLink);
                System.out.printf("\n\t Image Url -- %s\n", imageUrl);

                id += 1;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to extract search result from the Google Search Page
    private static void extractGoogleSearchResult(String search_keyword) {
        String finalUrl = google_url + "search?q=" + search_keyword.replace(" ", "%20");
        System.out.println(finalUrl);
        try {
            Document document = Jsoup.connect(finalUrl).get();
            Element body = document.body();
            Element resultSection = body.getElementById("search");
            Elements results = resultSection.getElementsByClass("g");

            int id = 1;
            for (Element element : results) {
                if (element.getAllElements().hasClass("tF2Cxc")) {
                    String title = element.selectFirst(".tF2Cxc").selectFirst(".yuRUbf").selectFirst("a").selectFirst("h3").selectFirst("span").text();
                    String resultLink = element.selectFirst(".tF2Cxc").selectFirst(".yuRUbf").selectFirst("a").attr("href");
                    String summary = element.selectFirst(".tF2Cxc").selectFirst(".IsZvec").selectFirst(".aCOpRe").select("span").get(1).text();
                    System.out.printf("\n(%d) Title -- %s", id, title);
                    System.out.printf("\n\t Summary -- %s", summary);
                    System.out.printf("\n\t Result Link -- %s\n", resultLink);
                    id += 1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Function to extract search result from the Bing Search Page
    private static void extractBingSearchResult(String search_keyword) {
        String finalUrl = bing_url + "search?q=" + search_keyword.replace(" ", "+") + "&go=Search&qs=ds&form=QBRE";
        System.out.println(finalUrl);
        try {
            Document document = Jsoup.connect(finalUrl).ignoreHttpErrors(true).get();
            Element body = document.body();
            Element mainDiv = body.getElementById("b_content");
            Element section = mainDiv.getElementsByTag("main").get(0);
            Element subSection = section.getElementById("b_results");
            Elements results = subSection.select(".b_algo");

            int id = 1;
            for (Element element : results) {
                if (element.getElementsByClass("b_caption").size() > 0 &&
                        element.selectFirst(".b_caption").selectFirst("p") != null) {
                    String title = element.selectFirst("h2").selectFirst("a").text();
                    String resultLink = element.selectFirst("h2").selectFirst("a").attr("href");
                    String summary = element.selectFirst(".b_caption").selectFirst("p").text();
                    System.out.printf("\n(%d) Title -- %s", id, title);
                    System.out.printf("\n\t Summary -- %s", summary);
                    System.out.printf("\n\t Result Link -- %s\n", resultLink);
                    id += 1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Function to extract Crypto list from the coinmarketcap
    private static void getCryptoList() {
        try {
            Document document = Jsoup.connect(coinmarketcap).get();
            Element body = document.body();
            Element mainDiv = body.getElementsByTag("table").get(0);
            Element section = mainDiv.getElementsByTag("tbody").get(0);
            Elements results = section.select("tr");
            System.out.println("\n Crypto Name\t\tCrypto Price");
            for (Element element : results) {
                if (element.getAllElements().hasClass("iJjGCS")) {
                    String cryptoName = element.getElementsByTag("td").get(2).getElementsByTag("p").get(0).text();
                    String cryptoPrice = element.getElementsByTag("td").get(3).getElementsByClass("price___3rj7O ").select(".cmc-link").get(0).text();

                    System.out.printf("\n %s\t\t\t\t%s", cryptoName, cryptoPrice);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

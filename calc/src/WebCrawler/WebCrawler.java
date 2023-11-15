package WebCrawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawler {
    private String Url;
    private int depthResearch;

    public WebCrawler(String startUrl, int depth) {
        Url = startUrl;
        depthResearch = depth;
    }

    public void Crawl() {
        System.out.println("Crawling: " + Url);
        try {
            crawlPage(Url, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void crawlPage(String url, int depth) throws IOException {
        if (depth < depthResearch) {
            Document document = Jsoup.connect(url).get();

            Elements refs = document.select("a[href]");
            for (Element ref : refs) {
                String link = ref.absUrl("href");

                for (int i = 0; i < depth; i++)
                    System.out.print("\t");
                System.out.println(depth + ": " + link);

                crawlPage(link, depth+1);
            }
        }
    }
}
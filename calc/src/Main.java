import WebCrawler.WebCrawler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String url;
        int depth;
        Scanner scanner = new Scanner(System.in);
        url = scanner.nextLine();
        depth = scanner.nextInt();
        WebCrawler webCrawler = new WebCrawler(url, depth);
        webCrawler.Crawl();

    }
}

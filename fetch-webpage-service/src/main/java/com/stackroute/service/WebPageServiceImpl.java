package com.stackroute.service;

import com.stackroute.model.Search;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WebPageServiceImpl implements WebPageService {
    Search search;

     @Autowired
    public WebPageServiceImpl() throws IOException {

    }

    @Override
    //Method to fetch the whole html source code from the url.
    public String getSourceCodeOfWebPage(String url) throws IOException {
         Document doc = Jsoup.connect(url).get();
            String html = doc.html();
            return html;
        }


        @Override
     public String getTableData(String url) throws IOException{
         org.jsoup.nodes.Document doc = Jsoup.connect(url).get();
         Element elements = doc.select("table[class=infobox vevent]").first();
         String s1=elements.toString();
         s1=s1.replaceAll("<([^<]*)>","%");
         s1=s1.replaceAll("\n","%");
         s1=s1.replaceAll("([% ])\\1+","$1");
         s1=s1.replaceAll("&nbsp;","");
         s1=s1.replaceAll("\\[(.*?)\\]", "");
         s1=s1.replaceAll("\\((.*?)\\)","");
         s1=s1.replaceAll("Theatrical release poster","");
         return s1;
     }




    @Override
    //Method to fetch the data in <p> tags.
    public String getAllPTextsFromBody(String url) throws IOException {

        Document doc = Jsoup.connect(url).get();
        Elements link = doc.select("div p:lt(7)");
        String linkText = link.text();
        String result = " ";
        String[] words=linkText.split("[\n]");
        for(String str:words)
        {
            result =result +"\n" +str;
        }

        return  linkText;
        }


    @Override
//Method to fetch the title of the website.
    public String getTitle(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();

        String st= doc.title();
        return st;

    }

    @Override
    //Method to fetch the body content of the website
    public String getBody(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();

        String st = doc.body().text();
        return st;
    }

    @Override
    //Method to fetch the headings of the website
    public String getHeading(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();

        Elements h1 = doc.select("h1");
        String st = h1.text();
        return st;
    }

    @Override
    //Method to fetch the Image data from the webSite.
    public String getImages(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();

        String result="";
        Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
        for (Element image : images) {
            String src = "src : " + image.attr("src");
            String height = "height : " + image.attr("height");
            String alt= "alt : " + image.attr("alt");
            result = result + src +
                    "\n"+ height+"\n"+alt+"\n";
        }
        return result;
    }

    @Override
    //Method to fetch the form information from the website
    public String getForm(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();

        Elements inputElements = doc.select("input");
        String result="";
        for (Element inputElement : inputElements) {
            String key = inputElement.attr("name");
            String value = inputElement.attr("value");
            result = result+ "Param name: "+key+" \nParam value: "+value;
        }
        return result;
    }

    @Override
    //Method to fetch the <a href> tags data from the website
    public void getLinks(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();

        Elements links = doc.select("a[href]");
        Elements media = doc.select("[src]");

        print("\nMedia: (%d)", media.size());
        for (Element src : media) {
            if (src.tagName().equals("img"))
                print("  %s: <%s>  (%s)",
                        src.tagName(), src.attr("abs:src"),
                        trim(src.attr("alt"), 20));
            else
                print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
        }



        print("\nLinks: (%d)", links.size());
        for (Element link : links) {
            print("  a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
        }
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
    }
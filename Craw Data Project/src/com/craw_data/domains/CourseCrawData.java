package com.craw_data.domains;

import com.craw_data.models.Course;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class CourseCrawData {
    private String link;
    private List<String> rootLinks = new ArrayList<>();

    public CourseCrawData(String link) {
        this.link = link;
    }

    private void getRootLinks() {
        try {
            Document document = Jsoup.connect(link).get();
            Elements elements = document.select(".ubermenu-tab > .ubermenu-target");
            for (Element e : elements) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public List<Course> tryGetCourse() {
        List<Course> rs = new ArrayList<>();

        // TODO: Logic to craw data here
        getRootLinks();

        return rs;
    }
}

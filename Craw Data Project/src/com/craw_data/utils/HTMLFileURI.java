package com.craw_data.utils;

import java.util.ArrayList;
import java.util.List;

public class HTMLFileURI {
    static final String baseUriHtmlListCourse = "html_page/html_list_course/";
    static final String baseUriHtmlCourseContent = "html_page/html_course_content/";

    public static List<String> listCourse = new ArrayList<>();

    static {
        // IT Course Page
        for (int i = 1; i <= 6; i++) {
            listCourse.add(baseUriHtmlListCourse + "it/p" + i + ".html");
        }
        // Design Course Page
        for (int i = 1; i <= 15; i++) {
            listCourse.add(baseUriHtmlListCourse + "design/p" + i + ".html");
        }
        // Marketing Course Page
        for (int i = 1; i <= 5; i++) {
            listCourse.add(baseUriHtmlListCourse + "marketing/p" + i + ".html");
        }
        // Music Course Page
        for (int i = 1; i <= 5; i++) {
            listCourse.add(baseUriHtmlListCourse + "music/p" + i + ".html");
        }
        // Universal Course Page
        for (int i = 1; i <= 3; i++) {
            listCourse.add(baseUriHtmlListCourse + "universal/p" + i + ".html");
        }
    }
}

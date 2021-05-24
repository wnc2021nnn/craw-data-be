package com.craw_data.domains;

import com.craw_data.models.Course;
import com.craw_data.utils.BaseLinks;
import com.craw_data.utils.ElementClassName;
import com.craw_data.utils.HTMLPageURI;
import com.craw_data.utils.ImageChecker;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CourseCrawData {
    private final List<Course> courses = new ArrayList<>();

    public int tryGetCourse() {
        // Clear course before
        courses.clear();

        HTMLPageURI.listCourse.forEach(page -> {
            // Get Document from html page
            File file = new File(page);
            Document doc = null;
            try {
                doc = Jsoup.parse(file, BaseLinks.charSetName, BaseLinks.udemyLink);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Get List Course Element from Document
            assert doc != null;
            Elements courseElements = doc.getElementsByClass(ElementClassName.course);

            // Craw data from course element to Course Model
            courseElements.forEach(element -> {
                // Get data from element
                String title = element.getElementsByClass(ElementClassName.courseTitle).text();
                String avatar = element.getElementsByClass(ElementClassName.courseImage).attr("srcset");
                if (avatar.isEmpty()) avatar = element.getElementsByClass(ElementClassName.courseImage).attr("src");
                if (!ImageChecker.isHTTPSLink(avatar)) return;
                String description = element.getElementsByClass(ElementClassName.courseDescription).text();

                // Add data to new course
                Course newCourse = new Course();
                newCourse.setTitle(title);
                newCourse.setAvatar(avatar);
                newCourse.setDescription(description);
                newCourse.setPrice(new Random().nextFloat() * 10);

                // Add to list result
                courses.add(newCourse);
            });
        });

        return courses.size();
    }

    public void writeToTxtFile() {
        try (PrintWriter printer = new PrintWriter("courses_sql.txt")) {
            // Write Query Syntax
            printer.println(Course.insertQuery);
            // Write Data
            courses.forEach(course -> {
                String courseString = course.toSQLString();
                printer.println("\t" + courseString + ",");
            });
            //
            printer.print(";");
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}

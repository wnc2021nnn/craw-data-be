package com.craw_data.domains;

import com.craw_data.domains.base.BaseCrawData;
import com.craw_data.models.Course;
import com.craw_data.utils.BaseLinks;
import com.craw_data.utils.ElementClassName;
import com.craw_data.utils.ITitleUtils;
import com.craw_data.utils.ImageChecker;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CourseCrawData extends BaseCrawData<Course> implements ITitleUtils {
    @Override
    public int loadFromDisk(List<String> paths) {
        // Clear course before
        items.clear();

        paths.forEach(page -> {
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
                items.add(newCourse);
            });
        });

        return items.size();
    }

    @Override
    public int loadFromDisk(String path) {
        return 0;
    }

    @Override
    public List<String> getAllTitle() {
        List<String> titles = new ArrayList<>();
        for (Course item : items) {
            titles.add(item.getTitle());
        }
        return titles;
    }
}

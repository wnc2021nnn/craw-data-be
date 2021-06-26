package com.craw_data.domains;

import com.craw_data.domains.base.BaseCrawData;
import com.craw_data.models.Chapter;

import java.util.List;

public class ChapterCrawData extends BaseCrawData<Chapter> {
    @Override
    public int loadFromDisk(List<String> paths) {
        return 0;
    }

    @Override
    public int loadFromDisk(String path) {
        return 0;
    }

    public int crawFakeDataFromCourseTitle(List<String> titles, int maxCourseIdNumber) {
        int currentCourseIdNumber = 1;
        int currentChapterForCurrentCourse = 0;
        for (String title : titles) {
            Chapter newChapter = new Chapter();
            newChapter.setTitle(title);
            newChapter.setCourseId(String.format("course_%06d", currentCourseIdNumber));
            items.add(newChapter);
            // craw fake data for 40 course
            currentChapterForCurrentCourse++;
            if (currentChapterForCurrentCourse >= 5) {
                currentCourseIdNumber++;
                currentChapterForCurrentCourse = 0;
            }
            if (currentCourseIdNumber > maxCourseIdNumber) break;
        }
        return items.size();
    }
}

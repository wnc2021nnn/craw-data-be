package com.craw_data.domains;

import com.craw_data.domains.base.BaseCrawData;
import com.craw_data.models.Chapter;
import com.craw_data.models.Lesson;

import java.util.List;

public class LessonCrawData extends BaseCrawData<Lesson> {
    @Override
    public int loadFromDisk(List<String> paths) {
        return 0;
    }

    @Override
    public int loadFromDisk(String path) {
        return 0;
    }

    public int crawFakeDataFromChapter(List<Chapter> chapters) {
        int currentLessonIndex = 1;
        int currentChapterIndex = 0;
        int lessonPerChapter = 5;
        for (int i = 0; i < chapters.size() * lessonPerChapter; i++) {
            Chapter currentChapter = chapters.get(currentChapterIndex);
            Lesson newLesson = new Lesson();
            newLesson.setTitle(currentChapter.getTitle() + " " + currentLessonIndex);
            newLesson.setChapterId(currentChapter.getChapterId());
            newLesson.setIndex(currentLessonIndex);
            newLesson.setVideoUrl("https://www.youtube.com/watch?v=1ukSR1GRtMU&list=PL4cUxeGkcC9jLYyp2Aoh6hcWuxFDX6PBJ");
            //
            currentLessonIndex++;
            if (currentLessonIndex > lessonPerChapter) {
                currentLessonIndex = 1;
                currentChapterIndex++;
            }
            items.add(newLesson);
        }
        return items.size();
    }
}

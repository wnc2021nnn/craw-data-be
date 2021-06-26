import com.craw_data.domains.ChapterCrawData;
import com.craw_data.domains.CourseCrawData;
import com.craw_data.domains.LessonCrawData;
import com.craw_data.domains.TopicCrawData;
import com.craw_data.domains.base.SQLQuery;
import com.craw_data.utils.HTMLFileURI;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Craw Topics
        TopicCrawData topicCrawData = new TopicCrawData();
        int topicCount = topicCrawData.loadFromDisk("input/topics.txt");
        topicCrawData.writeToTxtFile(SQLQuery.insertTopicQuery, "output/topics_sql.txt");
        writeResultReport("Topics", topicCount);

        // Craw Courses
        CourseCrawData courseCrawData = new CourseCrawData();
        int courseCount = courseCrawData.loadFromDisk(HTMLFileURI.listCourse);
        courseCrawData.writeToTxtFile(SQLQuery.insertCourseQuery, "output/courses_sql.txt");
        writeResultReport("Courses", courseCount);

        // Craw Chapter
        List<String> courseTitles = courseCrawData.getAllTitle();
        ChapterCrawData chapterCrawData = new ChapterCrawData();
        int chapterCount = chapterCrawData.crawFakeDataFromCourseTitle(courseTitles, 40);
        chapterCrawData.writeToTxtFile(SQLQuery.insertChapterQuery, "output/chapter_sql.txt");
        writeResultReport("Chapters", chapterCount);

        // Craw Lesson
        LessonCrawData lessonCrawData = new LessonCrawData();
        int lessonCount = lessonCrawData.crawFakeDataFromChapter(chapterCrawData.getItems());
        lessonCrawData.writeToTxtFile(SQLQuery.insertLessonQuery, "output/lesson_sql.txt");
        writeResultReport("Lessons", lessonCount);
    }

    static void writeResultReport(String name, int count) {
        System.out.println("Wrote " + count + " " + name + " To File Success!");
    }
}

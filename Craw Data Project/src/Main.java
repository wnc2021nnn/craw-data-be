import com.craw_data.domains.ChapterCrawData;
import com.craw_data.domains.CourseCrawData;
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
        System.out.println("Wrote " + topicCount + " Topic To File Success!");

        // Craw Courses
        CourseCrawData courseCrawData = new CourseCrawData();
        int courseCount = courseCrawData.loadFromDisk(HTMLFileURI.listCourse);
        courseCrawData.writeToTxtFile(SQLQuery.insertCourseQuery, "output/courses_sql.txt");
        System.out.println("Wrote " + courseCount + " Course To File Success!");

        // Craw Chapter
        List<String> courseTitles = courseCrawData.getAllTitle();
        ChapterCrawData chapterCrawData = new ChapterCrawData();
        int chapterCount = chapterCrawData.crawFakeDataFromCourseTitle(courseTitles, 40);
        chapterCrawData.writeToTxtFile(SQLQuery.insertChapterQuery, "output/chapter_sql.txt");
        System.out.println("Wrote " + chapterCount + " Chapter To File Success!");
    }
}

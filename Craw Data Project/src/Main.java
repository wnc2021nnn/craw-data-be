import com.craw_data.domains.CourseCrawData;
import com.craw_data.models.Course;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Testing
        CourseCrawData courseCrawData = new CourseCrawData();
        int count = courseCrawData.tryGetCourse();
        courseCrawData.writeToTxtFile();
        System.out.println("Wrote " + count + " Course To File Success!");
    }
}

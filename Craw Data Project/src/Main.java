import com.craw_data.domains.CourseCrawData;
import com.craw_data.domains.dao.CourseDAO;

public class Main {

    public static void main(String[] args) {
        //CourseDAO.getAllCourse();

        // Testing
        CourseCrawData courseCrawData = new CourseCrawData("https://memoryzone.com.vn/san-pham/ssd");
        courseCrawData.tryGetCourse();
    }
}

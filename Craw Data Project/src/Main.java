import com.craw_data.domains.CourseCrawData;
import com.craw_data.utils.HTMLFileURI;

public class Main {

    public static void main(String[] args) {
        //Testing
        CourseCrawData courseCrawData = new CourseCrawData();
        int count = courseCrawData.loadFromDisk(HTMLFileURI.listCourse);
        courseCrawData.writeToTxtFile("courses_sql.txt");
        System.out.println("Wrote " + count + " Course To File Success!");
    }
}

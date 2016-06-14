package java8;

import java.util.List;
import java.util.Map;

/**
 * Created by mkose on 13/06/2016.
 */
public interface AcademicRecords {

    String MALE = "male";
    String FEMALE = "female";

    double getHighestScore(List<Student> students);

    Map<String, List<Student>> getStudentGroupsByGender(List<Student> students);
}

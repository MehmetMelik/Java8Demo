package java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by mkose on 13/06/2016.
 */
public class AcademicRecordsLambda implements AcademicRecords {

    @Override
    public double getHighestScore(List<Student> students) {
        return students.stream()
                .filter(s -> s.getGradYear() == 2011)
                .map(Student::getScore)
                .max(Double::compare).get();
    }

    @Override
    public Map<String, List<Student>> getStudentGroupsByGender(List<Student> students) {
        return students.parallelStream().collect(Collectors.groupingBy(Student::getGender));
    }
}

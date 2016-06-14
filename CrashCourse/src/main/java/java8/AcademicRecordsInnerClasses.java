package java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * Created by mkose on 13/06/2016.
 */
public class AcademicRecordsInnerClasses implements AcademicRecords {


    @Override
    public double getHighestScore(List<Student> students) {

        List<Double> scores = students.stream().filter(new Predicate<Student>() {
            public boolean test(Student s) {
                return s.getGradYear() == 2011;
            }
        })
                .map(Student::getScore).collect(Collectors.toList());

        return scores.stream().max(Double::compare).get();
    }

    @Override
    public Map<String, List<Student>> getStudentGroupsByGender(List<Student> students) {
        Map<String, List<Student>> genderMap = new HashMap<>();
        List<Student> studentsMale = students.stream().filter(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getGender().equalsIgnoreCase(AcademicRecords.MALE);
            }
        }).collect(Collectors.toList());
        List<Student> studentsFemale = students.stream().filter(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getGender().equalsIgnoreCase(AcademicRecords.FEMALE);
            }
        }).collect(Collectors.toList());

        genderMap.put(AcademicRecords.FEMALE, studentsFemale);
        genderMap.put(AcademicRecords.MALE, studentsMale);

        return genderMap;
    }
}

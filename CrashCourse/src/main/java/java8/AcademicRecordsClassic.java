package java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mkose on 13/06/2016.
 */
public class AcademicRecordsClassic implements AcademicRecords {
    @Override
    public double getHighestScore(List<Student> students) {
        double highestScore = 0.0;
        for (Student s : students) {
            if (s.getGradYear() == 2011) {
                if (s.getScore() > highestScore)
                    highestScore = s.getScore();
            }
        }
        return highestScore;
    }

    @Override
    public Map<String, List<Student>> getStudentGroupsByGender(List<Student> students) {
        Map<String, List<Student>> genderMap = new HashMap<>();
        List<Student> studentsMale = new ArrayList<>();
        List<Student> studentsFemale = new ArrayList<>();
        for(Student s : students) {
            if (s.getGender().equalsIgnoreCase(AcademicRecords.FEMALE))
                studentsFemale.add(s);
            else
                studentsMale.add(s);
        }
        genderMap.put(AcademicRecords.FEMALE, studentsFemale);
        genderMap.put(AcademicRecords.MALE, studentsMale);

        return genderMap;
    }
}

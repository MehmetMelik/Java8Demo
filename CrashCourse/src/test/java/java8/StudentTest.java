package java8;

import com.google.common.collect.Lists;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by mkose on 13/06/2016.
 */

public class StudentTest {

    List<Student> students = Lists.newArrayList(
            new Student(2011, 3.45d, AcademicRecords.MALE),
            new Student(2011, 3.42d, AcademicRecords.FEMALE),
            new Student(2012, 3.80d, AcademicRecords.MALE),
            new Student(2011, 3.53d, AcademicRecords.FEMALE),
            new Student(2011, 3.35d, AcademicRecords.FEMALE));

    @Test
    public void testHighestScore() {

        AcademicRecords records = new AcademicRecordsClassic();
        Assert.assertEquals(records.getHighestScore(students), 3.53d);

        records = new AcademicRecordsInnerClasses();
        Assert.assertEquals(records.getHighestScore(students), 3.53d);

        records = new AcademicRecordsLambda();
        Assert.assertEquals(records.getHighestScore(students), 3.53d);

    }

    @Test
    public void testStudentGroups() {
        AcademicRecords records = new AcademicRecordsClassic();
        Map<String, List<Student>> studentMap = records.getStudentGroupsByGender(students);
        List<Student> femaleStudents = studentMap.get(AcademicRecords.FEMALE);
        Assert.assertTrue(femaleStudents.size() == 3);

        records = new AcademicRecordsInnerClasses();
        studentMap = records.getStudentGroupsByGender(students);
        femaleStudents = studentMap.get(AcademicRecords.FEMALE);
        Assert.assertTrue(femaleStudents.size() == 3);

        records = new AcademicRecordsLambda();
        studentMap = records.getStudentGroupsByGender(students);
        femaleStudents = studentMap.get(AcademicRecords.FEMALE);
        Assert.assertTrue(femaleStudents.size() == 3);
    }


}

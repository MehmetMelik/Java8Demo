package java8;

/**
 * Created by mkose on 13/06/2016.
 */
public class Student {

    private int gradYear;
    private double score;
    private String gender;

    public Student(int gradYear, double score, String gender) {
        this.gradYear = gradYear;
        this.score = score;
        this.gender = gender;
    }

    public int getGradYear() {
        return gradYear;
    }

    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

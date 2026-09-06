public abstract class Course {
    private String courseCode;
    private String courseName;
    private int creditHours;
    protected double baseFee;

    public Course(String courseCode, String courseName, int creditHours, double baseFee) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.baseFee = baseFee;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public double getBaseFee() {
        return baseFee;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public void setBaseFee(double baseFee) {
        this.baseFee = baseFee;
    }

    public abstract double calculateFee();

       public String toString() {
        return "Course Code: " + courseCode +
               ", Course Name: " + courseName +
               ", Credit Hours: " + creditHours +
               ", Base Fee: " + baseFee;
    }
}
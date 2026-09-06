public class LabCourse extends Course {
    private int labHours;

    public LabCourse(String courseCode, String courseName, int creditHours, double baseFee, int labHours) {
        super(courseCode, courseName, creditHours, baseFee);
        this.labHours = labHours;
    }

    public int getLabHours() {
        return labHours;
    }

    public void setLabHours(int labHours) {
        this.labHours = labHours;
    }

    
    public double calculateFee() {
        return baseFee + (labHours * 50);
    }


    public String toString() {
        return "Lab Course -> " + super.toString() +
               ", Lab Hours: " + labHours +
               ", Total Fee: " + calculateFee();
    }
}
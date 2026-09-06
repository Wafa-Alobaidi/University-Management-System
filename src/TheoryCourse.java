public class TheoryCourse extends Course {
    private boolean hasFinal;

    public TheoryCourse(String courseCode, String courseName, int creditHours, double baseFee, boolean hasFinal) {
        super(courseCode, courseName, creditHours, baseFee);
        this.hasFinal = hasFinal;
    }

    public boolean getisHasFinal() {
        return hasFinal;
    }

    public void setHasFinal(boolean hasFinal) {
        this.hasFinal = hasFinal;
    }

        public double calculateFee() {
        if (hasFinal) {
            return baseFee + 100;
        }
        return baseFee;
    }

        public String toString() {
        return "Theory Course -> " + super.toString() +
               ", Has Final: " + hasFinal +
               ", Total Fee: " + calculateFee();
    }
}
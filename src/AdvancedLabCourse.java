public class AdvancedLabCourse extends LabCourse implements Discount {
    private double equipmentFee;

    public AdvancedLabCourse(String courseCode, String courseName, int creditHours,
                             double baseFee, int labHours, double equipmentFee) {
        super(courseCode, courseName, creditHours, baseFee, labHours);
        this.equipmentFee = equipmentFee;
    }

    public double getEquipmentFee() {
        return equipmentFee;
    }

    public void setEquipmentFee(double equipmentFee) {
        this.equipmentFee = equipmentFee;
    }

    
    public double calculateFee() {
        return super.calculateFee() + equipmentFee;
    }

    
    public double applyDiscount() {
        return calculateFee() * 0.10; // 10% discount
    }

    
    public String toString() {
        return "Advanced Lab Course -> " + super.toString() +
               ", Equipment Fee: " + equipmentFee +
               ", Discount: " + applyDiscount();
    }
}
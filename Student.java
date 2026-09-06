public class Student implements Discount {

   private String fullName;
   private String id;
   private int numCourses;
   private CourseNode headCourse;

   // Constructor
   public Student(String fullName, String id, int numCourses) {
      this.fullName = fullName;
      this.id = id;
      this.numCourses = numCourses;
      headCourse = null;
   }

   // Copy constructor
   public Student(Student other) {
      this.fullName = other.fullName;
      this.id = other.id;
      this.numCourses = other.numCourses;
      this.headCourse = null;

      CourseNode current = other.headCourse;

      while (current != null) {
         this.addCourse(current.getData());
         current = current.getNext();
      }
   }

   // Add course
   public boolean addCourse(Course c) {

      if (searchCourse(c.getCourseCode()) != null) {
         return false;
      }

      if (getRegisteredCoursesCount() >= numCourses) {
         return false;
      }

      CourseNode newNode = new CourseNode(c);

      if (headCourse == null) {
         headCourse = newNode;
      } else {
         CourseNode current = headCourse;

         while (current.getNext() != null) {
            current = current.getNext();
         }

         current.setNext(newNode);
      }

      return true;
   }

   // Remove course by code
   public boolean removeCourse(String code) {

      if (headCourse == null) {
         return false;
      }

      if (headCourse.getData().getCourseCode().equals(code)) {
         headCourse = headCourse.getNext();
         return true;
      }

      CourseNode current = headCourse;

      while (current.getNext() != null) {
         if (current.getNext().getData().getCourseCode().equals(code)) {
            current.setNext(current.getNext().getNext());
            return true;
         }

         current = current.getNext();
      }

      return false;
   }

   // Search for a course
   public Course searchCourse(String code) {

      CourseNode current = headCourse;

      while (current != null) {
         if (current.getData().getCourseCode().equals(code)) {
            return current.getData();
         }

         current = current.getNext();
      }

      return null;
   }

   // Calculate total fees
   public double calcTotalFees() {

      double total = 0;
      CourseNode current = headCourse;

      while (current != null) {
         total += current.getData().calculateFee();
         current = current.getNext();
      }

      return total;
   }

   // Display all courses
   public void displayCourses() {

      if (headCourse == null) {
         System.out.println("No courses registered.");
         return;
      }

      CourseNode current = headCourse;

      while (current != null) {
         System.out.println(current.getData());
         current = current.getNext();
      }
   }

   // Apply discount for eligible courses
   public double applyDiscount() {

      double totalDiscount = 0;
      CourseNode current = headCourse;

      while (current != null) {
         Course c = current.getData();

         if (c instanceof Discount) {
            totalDiscount += ((Discount) c).applyDiscount();
         }

         current = current.getNext();
      }

      return totalDiscount;
   }

   // Get number of registered courses
   public int getRegisteredCoursesCount() {

      int count = 0;
      CourseNode current = headCourse;

      while (current != null) {
         count++;
         current = current.getNext();
      }

      return count;
   }

   // Getter for head node
   public CourseNode getHeadCourse() {
      return headCourse;
   }

   // Getters
   public String getFullName() {
      return fullName;
   }

   public String getId() {
      return id;
   }

   public int getNumCourses() {
      return numCourses;
   }

   // toString method
   public String toString() {
      return "Student Name: " + fullName +
             " ID: " + id +
             " Registered Courses: " + getRegisteredCoursesCount() +
             " Max Courses: " + numCourses;
   }
}
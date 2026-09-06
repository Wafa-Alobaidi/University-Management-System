import java.util.Scanner;

public class TestClass {

   public static CourseNode addAvailableCourse(CourseNode head, Course c) {
      CourseNode newNode = new CourseNode(c);
   
      if (head == null) {
         head = newNode;
      } else {
         CourseNode current = head;
      
         while (current.getNext() != null) {
            current = current.getNext();
         }
      
         current.setNext(newNode);
      }
   
      return head;
   }

   public static int countAvailableCourses(CourseNode head) {
      int count = 0;
      CourseNode current = head;
   
      while (current != null) {
         count++;
         current = current.getNext();
      }
   
      return count;
   }

   public static Course getCourseAt(CourseNode head, int index) {
      int count = 0;
      CourseNode current = head;
   
      while (current != null) {
         if (count == index) {
            return current.getData();
         }
      
         count++;
         current = current.getNext();
      }
   
      return null;
   }

   public static void displayAvailableCourses(CourseNode head) {
      CourseNode current = head;
      int i = 1;
   
      while (current != null) {
         System.out.println(i + ". " + current.getData());
         current = current.getNext();
         i++;
      }
   }

   public static void main(String[] args) throws Exception {
      Scanner input = new Scanner(System.in);
   
      // Create a University object with name KSU and capacity of 100 students
      University uni = new University("KSU", 100);
      
   
      // Create and initialize a linked list of available courses using nodes
      CourseNode availableCourses = null;
   
      availableCourses = addAvailableCourse(availableCourses, new TheoryCourse("CSC101", "Programming 1", 3, 1500, true));
      availableCourses = addAvailableCourse(availableCourses, new TheoryCourse("MATH201", "Discrete Math", 3, 1400, false));
      availableCourses = addAvailableCourse(availableCourses, new LabCourse("CSC102", "Programming Lab", 1, 900, 2));
      availableCourses = addAvailableCourse(availableCourses, new LabCourse("NET205", "Networks Lab", 2, 1000, 3));
      availableCourses = addAvailableCourse(availableCourses, new AdvancedLabCourse("AI301", "AI Advanced Lab", 2, 1200, 3, 250));
      availableCourses = addAvailableCourse(availableCourses, new AdvancedLabCourse("SEC401", "Cybersecurity Advanced Lab", 3, 1300, 4, 300));
   
      int choice;
   
      // Repeat showing the menu until the user chooses 0
      do {
         System.out.println("\n===== University Course Registration System =====");
         System.out.println("1. Add Student");
         System.out.println("2. Display Available Courses");
         System.out.println("3. Register Course for Student");
         System.out.println("4. Display Student Courses");
         System.out.println("5. Calculate Total Fees");
         System.out.println("6. Apply Discount");
         System.out.println("7. Search Student");
         System.out.println("8. Remove Course from Student");
         System.out.println("9. Display All Students");
         System.out.println("10. Remove student");
         System.out.println("11. Save to File");
         System.out.println("12. Read from File");
         System.out.println("0. Exit");
         System.out.print("Enter your choice: ");
         choice = input.nextInt();
         input.nextLine();
      
         switch (choice) {
         
            case 1:
               // Read student information from the user
               
               StudentInputFrame sFrame =
                  new StudentInputFrame(uni);
            
               sFrame.setVisible(true);;
            
                              
               break;
         
            case 2:
               // Display all available courses
               System.out.println("\n===== Available Courses =====");
               displayAvailableCourses(availableCourses);
               break;
         
            case 3:
               System.out.print("Enter Student ID: ");
               String studentId1 = input.nextLine();
            
               Student student1 = uni.searchStudent(studentId1, 0);
            
               if (student1 != null) {
                  System.out.println("\n===== Available Courses =====");
                  displayAvailableCourses(availableCourses);
               
                  System.out.print("Choose course number: ");
                  int courseChoice = input.nextInt();
                  input.nextLine();
               
                  try {
                     if (courseChoice < 1 || courseChoice > countAvailableCourses(availableCourses)) {
                        throw new InvalidCourseChoiceException("Invalid course choice.");
                     }
                  
                     Course selectedCourse = getCourseAt(availableCourses, courseChoice - 1);
                  
                     if (student1.addCourse(selectedCourse)) {
                        System.out.println("Course registered successfully.");
                     } else {
                        System.out.println("Cannot register course.");
                     }
                  
                  } catch (InvalidCourseChoiceException e) {
                     System.out.println(e.getMessage());
                  }
               
               } else {
                  System.out.println("Student not found!");
               }
            
               break;
         
            case 4:
               // Ask for student ID to display their registered courses
               System.out.print("Enter Student ID: ");
               String studentId2 = input.nextLine();
            
               Student student2 = uni.searchStudent(studentId2, 0);
            
               if (student2 != null) {
                  System.out.println("Courses for " + student2.getFullName() + ":");
                  student2.displayCourses();
               } else {
                  System.out.println("Student not found!");
               }
            
               break;
         
            case 5:
               // Ask for student ID to calculate total fees
               System.out.print("Enter Student ID: ");
               String studentId3 = input.nextLine();
            
               Student student3 = uni.searchStudent(studentId3, 0);
            
               if (student3 != null) {
                  double fees = student3.calcTotalFees();
                  System.out.println("Total Fees for " + student3.getFullName() + " = " + fees + " SAR");
               } else {
                  System.out.println("Student not found!");
               }
            
               break;
         
            case 6:
               // Ask for student ID to calculate total discount
               System.out.print("Enter Student ID: ");
               String studentId4 = input.nextLine();
            
               Student student4 = uni.searchStudent(studentId4, 0);
            
               if (student4 != null) {
                  double discount = student4.applyDiscount();
                  System.out.println("Total Discount for " + student4.getFullName() + " = " + discount + " SAR");
               } else {
                  System.out.println("Student not found!");
               }
            
               break;
         
            case 7:
               // Ask for student ID and search recursively
               System.out.print("Enter Student ID to search: ");
               String studentId5 = input.nextLine();
            
               Student student5 = uni.searchStudent(studentId5, 0);
            
               if (student5 != null) {
                  System.out.println("--- Student Found! ---");
                  System.out.println("Name: " + student5.getFullName());
                  System.out.println("ID: " + student5.getId());
                  System.out.println("Max Courses Allowed: " + student5.getNumCourses());
               } else {
                  System.out.println("Student not found in the university records.");
               }
            
               break;
         
            case 8:
               // Ask for student ID to remove a course
               System.out.print("Enter Student ID: ");
               String studentId6 = input.nextLine();
            
               Student student6 = uni.searchStudent(studentId6, 0);
            
               if (student6 != null) {
                  System.out.print("Enter Course Code to remove: ");
                  String code = input.nextLine();
               
                  if (student6.removeCourse(code)) {
                     System.out.println("Course removed successfully.");
                  } else {
                     System.out.println("Course not found.");
                  }
               } else {
                  System.out.println("Student not found!");
               }
            
               break;
         
            case 9:
               // Display all students in the university
               String data = uni.getAllStudentsData();
    DisplayStudentsFrame dFrame = new DisplayStudentsFrame(data);
    dFrame.setVisible(true);
    break;
         
            case 10:
               // Ask for student ID to remove the student
               System.out.print("Enter Student ID to remove: ");
               String studentId7 = input.nextLine();
            
               if (uni.removeStudent(studentId7)) {
                  System.out.println("Student removed successfully.");
               } else {
                  System.out.println("Student not found.");
               }
            
               break;
         
            case 11:
               uni.saveToFile();
               break;
         
            case 12:
               uni.readFromFile();
               break;
         
            case 0:
               // Exit message
               System.out.println("Goodbye.");
               break;
         
            default:
               // Handle invalid menu choice
               System.out.println("Invalid choice.");
         }
      
      } while (choice != 0);
   }
}
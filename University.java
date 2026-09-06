import java.util.*;
import java.io.*;
public class University {

   private String uniName;
   private int numStudents;
   private StudentNode head;

   public University(String uniName, int Size) {
   
      this.uniName = uniName;
      this.head = null;
      numStudents = 0;
   
   }//


   public boolean addStudent(Student s) throws UniversityFullException {
   
      if (numStudents >= 100) { 
         throw new UniversityFullException("Capacity reached!");
      }

      StudentNode newNode = new StudentNode(new Student(s.getFullName(), s.getId(), s.getNumCourses()));
      
      if (head == null) {
         head = newNode;
      } else {
         StudentNode current = head;
         while (current.getNext() != null) {
            current = current.getNext();
         }
         current.setNext(newNode);
      }
      
      numStudents++;
      return true;
   }//

   public Student searchStudent(String id, int index) {
   
      StudentNode current = head;
      while (current != null) {
         if (current.getData().getId().equals(id)) {
            return current.getData();
         }
         current = current.getNext();
      }
      return null;
   }//



   public void displayAllStudents() {
   
      if (head == null) {
        System.out.println("No students enrolled yet.");
        return;
    }
    
    System.out.println("=== University: " + uniName + " ===");
    StudentNode current = head;
    while (current != null) {
        System.out.println(current.getData().toString());
        System.out.println("-----------------------------");
        current = current.getNext();
    }
}         
   public void saveToFile() {
     try {
         PrintWriter writer = new PrintWriter("students.txt");
         StudentNode current = head;
         
         while (current != null) {
            writer.println(current.getData().getFullName());
            writer.println(current.getData().getId());
            writer.println(current.getData().getNumCourses());
            writer.println("-----");
            current = current.getNext();
         }
      
         writer.close();
         System.out.println("Saved to file successfully");
      
      } catch (IOException e) {
         System.out.println("Error writing file");
      }
   }
   public void readFromFile() {
      try {
         Scanner file = new Scanner(new File("students.txt"));
      
         while (file.hasNextLine()) {
            System.out.println(file.nextLine());
         }
      
         file.close();
      
      } catch (IOException e) {
         System.out.println("Error reading file");
      }
   }
   public boolean removeStudent(String id) {
   
      if (head == null) return false;

      if (head.getData().getId().equals(id)) {
         head = head.getNext();
         numStudents--;
         return true;
      }

      StudentNode current = head;
      while (current.getNext() != null) {
         if (current.getNext().getData().getId().equals(id)) {
            current.setNext(current.getNext().getNext());
            numStudents--;
            return true;
         }
         current = current.getNext();
      }
      return false;
   }


public String getAllStudentsData() {
    if (head == null) {
         return "No students enrolled yet.";
      }
      
      String allData = "=== University: " + uniName + " ===\n";
      allData += "Total Students: " + numStudents + "\n";
      allData += "-----------------------------\n\n";
      
      StudentNode current = head;
      while (current != null) {
         allData += current.getData().toString() + "\n";
         allData += "-----------------------------\n";
         current = current.getNext();
      }
      return allData;
   }








}// end class
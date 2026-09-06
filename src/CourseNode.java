public class CourseNode {

   private Course data;
   private CourseNode next;

   public CourseNode(Course data) {
      this.data = data;
      this.next = null;
   }

   public Course getData() {
      return data;
   }

   public void setData(Course data) {
      this.data = data;
   }

   public CourseNode getNext() {
      return next;
   }

   public void setNext(CourseNode next) {
      this.next = next;
   }
}
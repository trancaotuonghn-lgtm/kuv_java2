package chap9;
public class Student
{
   private int idNum;
   private double gpa;
   private String name;
   
   public int getIdNum()
   {
      return idNum;
   }
   public double getGpa()
   {
      return gpa;
   }
   public String getName() {
	   return name;
   }
   public void setIdNum(int num)
   {
      idNum = num;
   }
   public void setGpa(double gradePoint)
   {
      gpa = gradePoint;
   }
   public void setName(String nameStudent) {
	   name = nameStudent;
   }
   
   public String toString() {
	   return "Student's name: "+name+ "ID: " + idNum + "GPA: " + gpa;
   }
}
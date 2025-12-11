package java_interfaces;

public class DemoFlyable {
 public static void main(String[] args) {
     SpaceCraft enterprise = new SpaceCraft();
     Airplane boeing = new Airplane();
     Helicopter apache = new Helicopter();

     System.out.println("Testing Flyable Objects");
     enterprise.fly_obj();
     boeing.fly_obj();
     apache.fly_obj();
 }
}

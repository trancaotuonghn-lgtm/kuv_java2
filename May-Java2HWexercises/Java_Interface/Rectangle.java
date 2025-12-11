package java_interfaces;

public class Rectangle implements Resizable {
 private int width;
 private int height;

 public Rectangle(int w, int h) {
     this.width = w;
     this.height = h;
     System.out.println("Rectangle created: " + this.width + "x" + this.height);
 }
 
 // Implement the interface method
 @Override
 public void resizeWidth(int newWidth) {
     if (newWidth > 0) {
         this.width = newWidth;
         System.out.println("Width resized to: " + this.width);
     } else {
         System.out.println("Resize failed: Width must be positive.");
     }
 }
 
 // Implement the interface method
 @Override
 public void resizeHeight(int newHeight) {
     if (newHeight > 0) {
         this.height = newHeight;
         System.out.println("Height resized to: " + this.height);
     } else {
         System.out.println("Resize failed: Height must be positive.");
     }
 }
 
 // Basic method to view dimensions
 public void viewDimensions() {
     System.out.println("Current Dimensions: " + this.width + " x " + this.height);
 }

 public static void main(String[] args) {
     Rectangle myRect = new Rectangle(50, 100);
     
     System.out.println("\n--- Resizing Object ---");
     
     myRect.resizeWidth(75);
     myRect.resizeHeight(150);
     
     myRect.viewDimensions();
     
     // Attempting an invalid resize
     myRect.resizeWidth(-10);
 }
}

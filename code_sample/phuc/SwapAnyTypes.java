package chap13;
public class SwapAnyTypes 
{
    public static void main(String[] args) 
    {
        swapAndDisplay("Hello", "World");
        swapAndDisplay(10, 20);
    }
    public static <T> void swapAndDisplay(T a, T b) 
    {
        System.out.println("Before swap: " + a + ", " + b);
        T temp = a;
        a = b;
        b = temp;
        System.out.println("After swap: " + a + ", " + b);
        System.out.println();
    }
}
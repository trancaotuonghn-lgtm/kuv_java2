package chap12_ex;
import java.util.*;

public class IndirectRecursionDemo {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = input.nextInt();
        
        methodA(num);
    }

    public static void methodA(int n) {
        if (n > 0) {
            System.out.println("Method A: " + n);
            methodB(n - 1);
        }
    }

    public static void methodB(int n) {
        if (n > 0) {
            System.out.println("Method B: " + n);
            methodA(n - 1);
        }
    }
}

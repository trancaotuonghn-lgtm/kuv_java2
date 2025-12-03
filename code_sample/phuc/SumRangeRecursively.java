package chap12;
import java.util.Scanner;

public class SumRangeRecursively 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int[] nums = new int[20];
        for (int i = 0; i < nums.length; i++) 
        {
            nums[i] = (i + 1) * 2; 
        }
        int start, end;
        System.out.print("Enter starting position (0–19): ");
        start = input.nextInt();
        while (start < 0 || start >= nums.length) 
        {
            System.out.print("Invalid. Enter starting position (0–19): ");
            start = input.nextInt();
        }
        System.out.print("Enter ending position (>= start, <= 19): ");
        end = input.nextInt();
        while (end < start || end >= nums.length) 
        {
            System.out.print("Invalid. Enter ending position: ");
            end = input.nextInt();
        }
        System.out.print("Values in the range: ");
        for (int i = start; i <= end; i++) 
        {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        int sum = sumRange(nums, start, end);
        System.out.println("Sum in the range = " + sum);
    }
    public static int sumRange(int[] a, int start, int end) 
    {
        if (start > end) return 0;
        return a[start] + sumRange(a, start + 1, end);
    }
}
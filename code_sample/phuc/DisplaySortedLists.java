package chap13;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class DisplaySortedLists 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> strList = new ArrayList<>();
        ArrayList<Integer> intList = new ArrayList<>();
        String word;
        System.out.println("Enter words (type 'end' to stop):");
        while (true) 
        {
            word = sc.nextLine();
            if (word.equalsIgnoreCase("end"))
                break;
            strList.add(word);
            Collections.sort(strList);
            display(strList);
        }
        System.out.println("\nEnter integers (type -1 to stop):");
        int num;
        while (true) {
            num = sc.nextInt();
            if (num == -1)
                break;
            intList.add(num);
            Collections.sort(intList);
            display(intList);
        }
    }
    public static <T> void display(ArrayList<T> list) 
    {
        System.out.println("Sorted list: " + list);
    }
}
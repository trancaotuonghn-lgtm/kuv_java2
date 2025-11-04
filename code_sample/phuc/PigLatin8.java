import java.util.Scanner;
public class PigLatin 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = input.nextLine().toLowerCase();
        String pigLatinWord = convertToPigLatin(word);
        System.out.println("Pig Latin: " + pigLatinWord);
    }
    public static String convertToPigLatin(String word) 
        {
        String vowels = "aeiou";
        if (vowels.indexOf(word.charAt(0)) != -1) 
        {
            return word + "ay"; 
        } 
        else if (word.charAt(0) == 'y') 
        {
            return word.substring(1) + "yay";
        } 
        else {
            int index = -1;
            for (int i = 1; i < word.length(); i++) 
                {
                char ch = word.charAt(i);
                if (vowels.indexOf(ch) != -1 || ch == 'y') 
                {
                    index = i;
                    break;
                }
            }

            if (index == -1) 
            {
                return word + "ay";
            } 
            else {
                return word.substring(index) + word.substring(0, index) + "ay";
            }
        }
    }
}


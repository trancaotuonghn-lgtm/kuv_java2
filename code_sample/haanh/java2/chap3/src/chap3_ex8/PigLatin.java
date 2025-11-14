package chap3_ex8;
import java.util.*;

public class PigLatin {
	
//	Check if y is the first word or not
	public static boolean isVowel(char c, int position) {
		if (c == 'y' && position == 0) {
			return false; // 'y' at first => consonant
		}
		return "aeiouy".indexOf(c) != -1;
	} //banana => ananab
	
//	Check each word position if it's vowel or not
	public static int findFirstVowel(String word) {
		for (int i = 0; i < word.length(); i++) {
			char currentChar = word.charAt(i);
			if (isVowel(currentChar, i)) {
				return i; 
			}
		}
		return -1; 
	}
	
//	Pig Latin
	public static String toPigLatin(String word) {
		int firstVowelIndex = findFirstVowel(word);
		
		// if the first word is vowel (aeiouy)
		if (firstVowelIndex == 0) {
			return word + "ay"; 
		} else if (firstVowelIndex > 0) { // "cricket": i is the vowel and it at 3rd
			String consonants = word.substring(0, firstVowelIndex); // from the start to firstVowelIndex -> "cr"
			String remaining = word.substring(firstVowelIndex); // the rest after firstVowelIndex -> "icket"
			return remaining + consonants + "ay"; // "icket + cr + ay = icketcray"
		} 
		// When there aren't any vowel
		else {
			return word + "ay"; 
		}
	}
	
//	Input user
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Pig Latin Converter");
		System.out.print("Enter a word (all lowercase letters): ");
		String inputWord = input.nextLine().toLowerCase(); // change to lowercase if the user forgot

		String pigLatin = toPigLatin(inputWord);
		System.out.println("Original: " + inputWord);
		System.out.println("Pig Latin: " + pigLatin); 
		
		input.close();
	}
}

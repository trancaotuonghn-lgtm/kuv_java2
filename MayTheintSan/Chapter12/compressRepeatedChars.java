//chapter12-part2-ex10
public class compressRepeatedChars {

    public static String compressRepeatedChars(String str) {
        // Start the recursive process with the main string and the starting index 0
        return compressHelper(str, 0);
    }
    
    private static String compressHelper(String str, int index) {
        // if the index is out of bounds, the processing is complete.
        if (index >= str.length()) {
            return "";
        }
        
        //identify the current character and find the extent of its repetition
        char currentChar = str.charAt(index);
        int count = 0;
        int nextIndex = index;
        
        // find how many times the character repeats 
        while (nextIndex < str.length() && str.charAt(nextIndex) == currentChar) {
            count++;
            nextIndex++;
        }
        
        // build the segment: character + count
        String segment = "" + currentChar + count;
        
        // append the segment to the result of compressing the rest of the string (starting at nextIndex)
        return segment + compressHelper(str, nextIndex);
    }

// System.out.println("Compress 'aaabbc': " + compressRepeatedChars("aaabbc")); // Output: a3b2c1
}

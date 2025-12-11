import java.util.Arrays;

public class IdenticalArrays {

    //Ex1: Checks if two arrays of the same type have the same elements in the same order.
     
    public static <T> boolean areArraysIdentical(T[] arr1, T[] arr2) {
        // Check if the lengths are different.
        if (arr1.length != arr2.length) {
            return false;
        }

        // Loop through and compare elements at each index.
        for (int i = 0; i < arr1.length; i++) {
            // Use .equals() to correctly compare objects.
            if (!arr1[i].equals(arr2[i])) {
                return false; 
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Identical Integer arrays
        Integer[] nums1 = {10, 20, 30};
        Integer[] nums2 = {10, 20, 30};
        System.out.println("Array 1: " + Arrays.toString(nums1));
        System.out.println("Array 2: " + Arrays.toString(nums2));
        System.out.println("Are identical? " + areArraysIdentical(nums1, nums2)); // Expected: true

        // Different String arrays
        String[] words1 = {"apple", "banana"};
        String[] words2 = {"apple", "cherry"};
        System.out.println("\nArray 3: " + Arrays.toString(words1));
        System.out.println("Array 4: " + Arrays.toString(words2));
        System.out.println("Are identical? " + areArraysIdentical(words1, words2)); // Expected: false
    }
}

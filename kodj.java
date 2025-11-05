import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    public static List<String> generatePermutations(String str) {
        List<String> result = new ArrayList<>();
        generateHelper(str.toCharArray(), 0, result);
        return result;
    }
    
    private static void generateHelper(char[] chars, int index, List<String> result) {
        if (index == chars.length - 1) {
            result.add(new String(chars));
            return;
        }
        
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            generateHelper(chars, index + 1, result);
            swap(chars, index, i); // backtrack
        }
    }
    
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    
    public static void main(String[] args) {
        String input = "abc";
        List<String> permutations = generatePermutations(input);
        System.out.println("Перестановки строки \"" + input + "\":");
        for (String perm : permutations) {
            System.out.println(perm);
        }
    }
}
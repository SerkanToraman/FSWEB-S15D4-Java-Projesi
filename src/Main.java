import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't node"));

    }

    public static String checkForPalindrome(String text) {
        String cleanedText = text.replaceAll("[.,!?\"]", "");
        String textWithoutGaps = cleanedText.replaceAll("\\s+", "");
        char[] letters = textWithoutGaps.toLowerCase().toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i =0; i<letters.length/2;i++) {
            stack.push(letters[i]);
        }
        int midIndex = (letters.length % 2 == 0) ? letters.length / 2 : letters.length / 2 + 1;
        for (int i = midIndex; i < letters.length; i++) {
            if (letters[i] != stack.pop()) {
                String result = "\""+text + "\""+" is NOT a palindrom";
                return result;
            }
        }

        String result = "\""+text + "\""+" is a palindrom";
        return result;
    }
}
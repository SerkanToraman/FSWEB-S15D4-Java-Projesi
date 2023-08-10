import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't node"));
        System.out.println("-----------------------------------------");
        System.out.println(checkForPalindromeFIFO("abccba"));
        System.out.println(checkForPalindromeFIFO("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindromeFIFO("I did, did I?"));
        System.out.println(checkForPalindromeFIFO("hello"));
        System.out.println(checkForPalindromeFIFO("Don't node"));
        System.out.println("-----------------------------------------");
        System.out.println(convertDecimalToBinary(13));
        System.out.println(convertDecimalToBinary(5));
        System.out.println(convertDecimalToBinary(6));
        System.out.println(convertDecimalToBinary(75));

    }

    public static String checkForPalindrome(String text) {
        String cleanedText = text.replaceAll("[.,'!?\"\\s]", "");
        char[] letters = cleanedText.toLowerCase().toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i =0; i<letters.length/2;i++) {
            stack.push(letters[i]);
        }

        System.out.println("Stack"+stack);
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

    public static String checkForPalindromeFIFO(String text) {
        String cleanedText = text.replaceAll("[.,'!?\"\\s]", "");
        char[] letters = cleanedText.toLowerCase().toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();


        for (int i =0; i<letters.length;i++) {
            stack.push(letters[i]);
            queue.addLast(letters[i]);
        }


        for (int i = 0; i < letters.length; i++) {
            if (queue.removeFirst() != stack.pop()) {
                String result = "\""+text + "\""+" is NOT a palindrom";
                return result;
            }
        }

        // Alternative solution1
        // while(!stack.isEmpty()){
        //            if(!stack.pop().equals(queue.removeFirst())){
        //                return false;
        //            }
        //        }

        //Alternative solution 2
//        if(stack.equals(queue)){
//            System.out.println("EQUAL");
//        } else{
//            System.out.println("NOT EQUAL");
//        }

        String result = "\""+text + "\""+" is a palindrom";
        return result;
    }

    public static String convertDecimalToBinary(int num){
        //5
        //5 % 2 = 1    2 % 2 = 0    1 % 2 = 1
        //5 / 2 = 2    2 / 2 = 1    1 / 2 = 0

        //13
        //13 % 2 = 1   6 % 2 = 0   3 % 2 = 1  1 % 2 = 1
        //13 / 2 = 6   6 / 2 = 3   3 / 2 = 1  1 / 2 = 0

//        final int base = 2;
//        Stack digits = new Stack();
//
//        while(num > 0){
//            //[1, 1, 0, 1]
//            digits.push(num % base);
//            num = num / base;
//        }
//
//        String bits = "";
//        while (!digits.isEmpty()){
//            bits += digits.pop();
//        }
//        digits.toString();
//        return bits;

        StringBuilder binary = new StringBuilder();

        while (num > 0) {
            int remainder = num % 2;
            binary.insert(0, remainder);
            num = num / 2;
        }

        return binary.toString();
    }
}
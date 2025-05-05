public class Strng {

    public static StringBuilder getBackSpaceString(String s) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                answer.append(s.charAt(i));
            } else if (answer.length() > 0) { // Prevent out-of-bounds exception
                answer.deleteCharAt(answer.length() - 1);
            }
        }
        return answer;
    }

    public static boolean compareStrings(String s1, String s2) {
        return s1.equals(s2);
    }

    public static String removeOuterParanthesis(String s) {
        String result = "";
        int balance = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (balance == 0) {
                    start = i;
                }
                balance++;
            } else {
                balance--;
                if (balance == 0) {
                    result += s.substring(start + 1, i);
                }
            }
        }
        return result;
    }

    public static String removeWithString(String s) {
        String result = "";
        int balance = 0, start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (balance == 0)
                    start = i;
                balance++;
            } else {
                balance--;
                if (balance == 0) {
                    result += s.substring(start + 1, i);
                }
            }
        }
        return result;
    }

    public static String removeWithBuilder(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0, start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (balance == 0)
                    start = i;
                balance++;
            } else {
                balance--;
                if (balance == 0) {
                    result.append(s.substring(start + 1, i));
                }
            }
        }
        return result.toString();
    }

    public static String largestOddNumberInString(String s) {
        System.out.println(s.length() - 1);
        for (int i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) - '0') % 2 == 1) {
                return s.substring(0, i + 1);
            }
        }
        return "";
    }

    public static String reverseWords(String s) {
        System.out.println(s.length());
        int start = 0 ;
        int end = 0;
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                start=i;
                result.append(s.substring(i, s.length()));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // StringBuilder s1 = getBackSpaceString("a#b#cd");
        // StringBuilder s2 = getBackSpaceString("a#b#cd");

        // System.out.println("s1 " + s1 + "s2 " + s2);
        // System.out.println(compareStrings(s1.toString(), s2.toString()));

        // String s1 = "(()())(())(()(()))";
        // System.out.println(removeOuterParanthesis(s1));

        // int loops = 10000;
        // String input = "(()())(())(()(()))";

        // long startTime, endTime;

        // // Using plain String
        // startTime = System.nanoTime();
        // String result1 = "";
        // for (int i = 0; i < loops; i++) {
        // result1 = removeWithString(input);
        // }
        // endTime = System.nanoTime();
        // System.out.println("Using String took: " + (endTime - startTime)/1_000_000.0
        // + " ms");

        // // Using StringBuilder
        // startTime = System.nanoTime();
        // String result2 = "";
        // for (int i = 0; i < loops; i++) {
        // result2 = removeWithBuilder(input);
        // }
        // endTime = System.nanoTime();
        // System.out.println("Using StringBuilder took: " + (endTime -
        // startTime)/1_000_000.0 + " ms");

        // string is imutable in java
        // String s = "hello";
        // s = s + " world"; // creates a new string object
        // System.out.println(s); // prints "hello world"
        // StringBuilder sb = new StringBuilder("hello");
        // sb.append(" world"); // modifies the existing object

        // System.out.println(((Object) ('7' - '0')).getClass());
        // System.err.println(((Object)("7")).getClass());

        // System.out.println(largestOddNumberInString("5234"));

        String s = "the sky is blue";
        System.out.println(reverseWords(s));
        

    }
}

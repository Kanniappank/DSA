
import java.util.HashMap;

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
        StringBuilder result = new StringBuilder();
        String[] words = s.split("\\s+");
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0)
                result.append(" ");
        }
        return result.toString();
    }

    public static HashMap comparisonMaps(String s) {
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (hash.containsKey(s.charAt(i))) {
                int value = hash.get(s.charAt(i));
                hash.put(s.charAt(i), value + 1);
            } else {
                hash.put(s.charAt(i), 1);
            }
        }
        System.out.println(hash);
        return hash;
    }

    public static boolean anagram(String s, String t) {
        return comparisonMaps(s).equals(comparisonMaps(t));
    }

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(anagram(s, t));
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

        // String s = " hello world ";
        // System.out.println(reverseWords(s));

        // String s = "the sky is blue";
        // System.out.println("After reversing words");
        // System.out.println(s);
        // s+=' ';
        // Stack<String> st = new Stack<String>();
        // String str="";
        // String ans = "";
        // for(int i=0;i<s.length();i++){
        // if(s.charAt(i)==' '){
        // st.push(str);
        // str="";
        // }
        // else{
        // str+=s.charAt(i);
        // }
        // }
        // System.out.println("Stact "+st+"stack Size "+st.size()+" st peek
        // "+st.peek());
        // while(st.size()!=1){
        // ans+=st.peek()+ " ";
        // st.pop();
        // }
        // ans+=st.peek();
        // System.out.println("after reversions");
        // System.out.println(ans);

    }
}

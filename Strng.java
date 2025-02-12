public class Strng {

    public static StringBuilder getBackSpaceString(String s){
        StringBuilder answer = new StringBuilder(); 
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='#'){
                answer.append(s.charAt(i));
            }
            else if (answer.length() > 0) { // Prevent out-of-bounds exception
                answer.deleteCharAt(answer.length() - 1);
            }
        }
        return answer;
    }
    public static boolean compareStrings(String s1,String s2){
        return s1.equals(s2);
    }
    public static void main(String[] args) {
        StringBuilder s1 = getBackSpaceString("a#b#cd");
        StringBuilder s2 = getBackSpaceString("a#b#cd");

        System.out.println("s1 "+s1+"s2 "+s2);   
        System.out.println(compareStrings(s1.toString(), s2.toString()));     
    }
}

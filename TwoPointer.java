import java.util.Arrays;

public class TwoPointer {
    public static int removeDuplicatesReturnLength(int[] arr){
        int i=0;
        int j=1;
        int len = arr.length;
        while(j<len){
            if(arr[j]!=arr[i]){
                i++;
                arr[i]=arr[j];
            }
            else{
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return i+1;
        
    }
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,2,2,3,3,3,4};
        System.out.println(removeDuplicatesReturnLength(arr));
    }
}

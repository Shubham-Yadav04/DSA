import java.util.Arrays;

public class Array {
    public static int minimumValue(int arr[]) {
        int min = Integer.MAX_VALUE;

        for(int i = 0;i <arr.length; ++i) {
            if (arr[i] <= min) {
                min =arr[i];
            }
        }

        return min;
    }

    public static int maximumValue(int[] arr) {
        int max = Integer.MIN_VALUE;

        for(int var2 = 0; var2 < arr.length; ++var2) {
            if (arr[var2] >= max) {
                max = arr[var2];
            }
        }
        return max;
    }

    public static int secondMaximum(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = 0;

        for(int i = 0; i <arr.length; ++i) {
            if (arr[i] >= first) {
                second = first;
                first =arr[i];
            } else if (arr[i] < first &&arr[i] >= second) {
                second =arr[i];
            }
        }

        return second;
    }



    public static void ZeroAtEnd(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && arr[j] == 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

            }
            if (arr[j] != 0) {
                j++;
            }
        }
    }
public static int missingNumber(int arr[]){

//        method -01
       int newArr[]=new int[arr.length+1];
       for(int i=0;i<arr.length;i++){
           newArr[arr[i]-1]=arr[i];
       }
       for(int i=0;i<newArr.length;i++){
           if(newArr[i]!=i+1){
               return i+1;
           }
       }

//        method-02
       int n=arr.length+1;
       int realSum=n*(n+1)/2;
       int sum=0;
       for(int i=0;i<arr.length;i++){
           sum=sum+arr[i];
       }
       return realSum-sum;
//       return 0;
}
public static boolean isPalindrome(String str){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
}
    public static void main(String[] args) {
            int[] arr = {2,3,4,5};
        ZeroAtEnd(arr);
            System.out.println(Arrays.toString(arr));
        System.out.println(missingNumber(arr));
        String str="racecar";
        System.out.println(isPalindrome(str));
    }

    }

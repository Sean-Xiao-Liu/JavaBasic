package LeetCode;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i > -1 ; i--){
            if (digits[i] != 9){ // if the digit not equals to 9, just plus one
                digits[i] = digits[i] + 1;
                return digits;
            } else { // if the digit equals to 9 , it will become 0 and check the previous index
                digits[i] = 0;
            }
        }
        int[] result = new int[digits.length+1]; // if the array is full of 9, create an new array
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] digits = {8,9,9};
        int[] result = plusOne(digits);
        for (int i : result) System.out.println(i);
    }
}
